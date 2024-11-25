package quanlylaptop.Controller;

import static quanlylaptop.Connect.ConnectDB.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import quanlylaptop.Connect.ConnectDB;
import quanlylaptop.Models.Laptop;
import quanlylaptop.Models.Order;
import quanlylaptop.Models.Pair;

public class OrderController {

	public static List<Order> getAllOrders() {
		List<Order> list = new ArrayList<Order>();
		
		try {
            Connection conn = ConnectDB.getConnection();
            String sql = "SELECT * FROM ORDERS;";
            Statement stmt = conn.createStatement();
            ResultSet p = stmt.executeQuery(sql);
            
            while (p.next()) {
            	List<Pair<Laptop, Integer>> listLapHash = fetchOrderDetails(conn, p.getInt(1));
            	Order o = new Order(
            			p.getInt(1),
            			listLapHash,
            			p.getDate(2),
            			p.getInt(3),
            			p.getInt(4)
            	);
            	list.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return list;
	}
	
	public static Order getOrderById(int idOrder) {		
		for (int i = 0; i < getAllOrders().size(); i++) {
			if (getAllOrders().get(i).getId() == idOrder) {
				return getAllOrders().get(i);
			}
		}
		return null;
	}
	
	public static List<Order> getAllOrderByAccId(int idAcc) {
		List<Order> list = new ArrayList<Order>();
		
		getAllOrders().forEach(o -> {
			if (o.getIdAcc() == idAcc) {
				list.add(o);
			}
		});
		
		return list;
	}
	
	public static boolean CreateNewOrder(Order order) {
	    String sqlOrders = "INSERT INTO ORDERS (order_date, total_price, id_account) VALUES (?,?,?)";
	    String sqlOrderDetails = "INSERT INTO ORDER_DETAILS (order_id, laptop_id, quantity) VALUES (?, ?, ?)";
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Connection conn = getConnection();
	    
	    try {
	        conn.setAutoCommit(false); // Bật chế độ transaction
	        
	        // Thêm vào bảng ORDERS
	        try (PreparedStatement pOrders = conn.prepareStatement(sqlOrders, Statement.RETURN_GENERATED_KEYS)) {
	            pOrders.setString(1, sdf.format(order.getDate()));
	            pOrders.setInt(2, order.getTotalPrice());
	            pOrders.setInt(3, order.getIdAcc());
	            
	            int affectedRows = pOrders.executeUpdate();
	            if (affectedRows == 0) {
	                throw new SQLException("Insert into ORDERS failed, no rows affected.");
	            }
	            
	            // Lấy id của order vừa thêm vào ORDERS
	            try (ResultSet generatedKeys = pOrders.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    order.setId(generatedKeys.getInt(1));
	                } else {
	                    throw new SQLException("Insert into ORDERS failed, no ID obtained.");
	                }
	            }
	        }
	        
	        // Thêm vào bảng ORDER_DETAILS
	        try (PreparedStatement pOrderDetails = conn.prepareStatement(sqlOrderDetails)) {
	            for (Pair<Laptop, Integer> pair : order.getList()) {
	                pOrderDetails.setInt(1, order.getId());
	                pOrderDetails.setInt(2, pair.getKey().getId());
	                pOrderDetails.setInt(3, pair.getValue());
	                pOrderDetails.addBatch(); // Thêm vào batch để thực thi nhiều lần
	            }
	            
	            int[] batchResult = pOrderDetails.executeBatch(); // Thực thi batch
	            
	            // Kiểm tra kết quả của từng câu lệnh trong batch
	            for (int result : batchResult) {
	                if (result == PreparedStatement.EXECUTE_FAILED) {
	                    throw new SQLException("Insert into ORDER_DETAILS failed.");
	                }
	            }
	        }
	        
	        // Commit transaction
	        conn.commit();
	        
	        conn.close();
	        System.out.println("Create new order success!");
	        return true;
	        
	    } catch (SQLException e) {
	        // Rollback transaction nếu có lỗi
	        System.out.println("Transaction rollback: " + e.getMessage());
	        try {
	            conn.rollback();
	        } catch (SQLException rollbackException) {
	            System.out.println("Rollback failed: " + rollbackException.getMessage());
	        }
	        return false;
	    }
	}
	
	public static boolean updateOrder(Order order) {
        String sql = "UPDATE ORDERS SET order_date = ?, total_price = ?, id_account = ?";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Connection conn = ConnectDB.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);

            p.setString(1, sdf.format(order.getDate()));
            p.setInt(2, order.getTotalPrice());
            p.setInt(3, order.getIdAcc());
            p.execute();
            
            p = conn.prepareStatement("DELETE FROM ORDER_DETAILS WHERE order_id = '" + order.getId() + "';");
            p.execute();
            
            for (int i = 0; i < order.getList().size(); i++) {
            	p = conn.prepareStatement("INSERT INTO ORDER_DETAILS (order_id, laptop_id, quantity) VALUES (?, ?, ?)");
            	try {
    				p.setInt(1, order.getId());
    				p.setInt(2, order.getList().get(i).getKey().getId());
    				p.setInt(3, order.getList().get(i).getValue());
    				p.executeUpdate();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
            }

            p.close();
            conn.close();
            System.out.println("Update account success!");
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
	
	public static boolean deleteOrder(int idOrder) {
        String sqlDeleteUser = "DELETE FROM ORDERS WHERE id='" + idOrder + "';";
        try {

            Connection conn = ConnectDB.getConnection();
            PreparedStatement p = conn.prepareStatement(sqlDeleteUser);
            
            p = conn.prepareStatement("DELETE FROM ORDER_DETAILS WHERE order_id = '" + idOrder + "';");
            p.executeUpdate();
            
            p.close();
            conn.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
	
	public static List<Order> getAllOrderByYear(String year) {
        @SuppressWarnings({ "unchecked", "rawtypes" })
		List<Order> list = new ArrayList();

        try {
            Connection conn = ConnectDB.getConnection();
            String sql = "SELECT * FROM ORDERS where  YEAR(order_date)='" + year + "' ORDER BY FORMAT(order_date, 'yyyy/MM/dd') DESC, id, total_price, id_account";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Date day = rs.getDate("order_date");
                Date myday = null;
                if (day != null) {
                    myday = new Date(day.getTime());
                    Order trs = new Order(rs.getInt("id"), myday, rs.getInt("total_price"),rs.getInt("id_account"));
                    list.add(trs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public static List<Order> getAllOrderByMonthYear(String year, String month) {
        @SuppressWarnings({ "rawtypes", "unchecked" })
		List<Order> list = new ArrayList();

        try {
            Connection conn = ConnectDB.getConnection();
            String sqlHome = "SELECT * FROM ORDERS where YEAR(order_date)='" + year + "' and Month(order_date)='" + month + "'ORDER BY FORMAT(order_date, 'yyyy/MM/dd') DESC, id, total_price, id_account";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sqlHome);
            while (rs.next()) {
                Date day = rs.getDate("order_date");
                Date myday = null;
                if (day != null) {
                    myday = new Date(day.getTime());
                    Order trs = new Order(rs.getInt("id"), myday, rs.getInt("total_price"),rs.getInt("id_account"));
                    list.add(trs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	
	//private methods
	private static List<Pair<Laptop, Integer>> fetchOrderDetails(Connection conn, int idOrder) {
		List<Pair<Laptop, Integer>> list = new ArrayList<Pair<Laptop, Integer>>();
		
		try {
            String sql = "SELECT * FROM ORDER_DETAILS WHERE order_id = '" + idOrder + "';";
            Statement stmt = conn.createStatement();
            ResultSet p = stmt.executeQuery(sql);
            
            while (p.next()) {
            	Laptop lap = LaptopController.getLaptopById(p.getInt(2));
            	Pair<Laptop, Integer> lapPair = new Pair<Laptop, Integer>(lap, p.getInt(3));
            	list.add(lapPair);
            }
            
            p.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return list;
	}
	
}
