package quanlylaptop.Controller;

import static quanlylaptop.Connect.ConnectDB.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import quanlylaptop.Connect.ConnectDB;
import quanlylaptop.Models.Laptop;

public class LaptopController {

	public static List<Laptop> getAllLaptop() {
		List<Laptop> list = new ArrayList<Laptop>();
		
		try {
            Connection conn = ConnectDB.getConnection();
            String sql = "SELECT * FROM LAPTOP;";
            Statement stmt = conn.createStatement();
            ResultSet p = stmt.executeQuery(sql);
            while (p.next()) {
                Laptop lap = new Laptop(
                		p.getInt(1),
                		p.getString(2),
                		p.getString(3),
                		p.getInt(4),
                		p.getInt(5)
                );

                list.add(lap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return list;
	}
	
	public static List<Laptop> getAllLaptopByName(String name) {
		List<Laptop> list = new ArrayList<Laptop>();
		String sql = "select * from LAPTOP where name LIKE '%" + name + "%'";
		
		name.trim();
		while (name.indexOf("  ") != -1) {
			name = name.replace("  ", " ");
		}
		name.toLowerCase();
		
		try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet p = stmt.executeQuery(sql);
            while (p.next()) {
                Laptop lap = new Laptop(
                		p.getInt(1),
                		p.getString(2),
                		p.getString(3),
                		p.getInt(4),
                		p.getInt(5)
                );

                list.add(lap);
            }
        } catch (SQLException e) {
            System.out.println("Error get all account: " + e.getMessage());
        }
		
		return list;
	}
	
	public static Laptop getLaptopById(int idLaptop) {
		Laptop lap = null;
		String sql = "select * from LAPTOP where id = '" + idLaptop + "';";
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet p = stmt.executeQuery(sql);
            if (p.next()) {
                lap = new Laptop(
                		p.getInt(1),
                		p.getString(2),
                		p.getString(3),
                		p.getInt(4),
                		p.getInt(5)
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lap;
	}
	
	public static boolean CreateNewLaptop(Laptop laptop) {
		String sql = "INSERT INTO LAPTOP (name, manufacturer, quantity, price) VALUES (?,?,?,?)";
        try {
            Connection conn = getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, laptop.getName());
            p.setString(2, laptop.getManufacturer());
            p.setInt(3, laptop.getQuantity());
            p.setInt(4, laptop.getPrice());
            p.execute();
            p.close();
            conn.close();
            System.out.println("Create new account success!");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
	}
	
	public static boolean updateLaptop(Laptop laptop) {
        String sql = "UPDATE LAPTOP SET name = ?, manufacturer = ?, quantity = ?, price = ? WHERE id = ?";
        try {

            Connection conn = ConnectDB.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);

            p.setString(1, laptop.getName());
            p.setString(2, laptop.getManufacturer());
            p.setInt(3, laptop.getQuantity());
            p.setInt(4, laptop.getPrice());
            p.setInt(5, laptop.getId());
            p.executeUpdate();
            p.close();
            conn.close();
            System.out.println("Update account success!");
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
	
	public static boolean deleteLaptop(int idLaptop) {
        String sqlDeleteUser = "DELETE FROM LAPTOP WHERE id = '" + idLaptop + "';";
        try {

            Connection conn = ConnectDB.getConnection();
            PreparedStatement p = conn.prepareStatement(sqlDeleteUser);
            
            p.execute();
            p.close();
            conn.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
	
}
