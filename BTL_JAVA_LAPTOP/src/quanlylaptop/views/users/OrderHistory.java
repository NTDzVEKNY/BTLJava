package quanlylaptop.views.users;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import quanlylaptop.Controller.OrderController;
import quanlylaptop.Models.Laptop;
import quanlylaptop.Models.Order;
import quanlylaptop.Models.Pair;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

public class OrderHistory extends JFrame {

	private static final long serialVersionUID = 1L;

	private int idUser = 2;
	
	public OrderHistory(int idUser) {
		this.idUser = idUser;
		initComponents();
	}

	public OrderHistory() {
		initComponents();
	}
	
	@SuppressWarnings("serial")
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 726, 256);
		contentPane.add(scrollPane);
		
		tbOrderList = new JTable();
		scrollPane.setViewportView(tbOrderList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 276, 726, 202);
		contentPane.add(scrollPane_1);
		
		tbDetails = new JTable();
		scrollPane_1.setViewportView(tbDetails);
		
		JButton btnBack = new JButton("Quay lại");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBack.setBounds(326, 488, 112, 32);
		contentPane.add(btnBack);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LỊCH SƯ ĐƠN HÀNG");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
		
		tbOrderList.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "STT", "Order ID", "Ngày đặt hàng", "Tổng tiền", "Mã nhân viên"
	            }
	        ) {
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
		
		tbOrderList.getColumnModel().getColumn(0).setMinWidth(50);
		tbOrderList.getColumnModel().getColumn(0).setPreferredWidth(50);
		tbOrderList.getColumnModel().getColumn(0).setMaxWidth(50);
		
		tbDetails.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "STT", "Laptop ID", "Tên laptop", "Tên hãng", "Giá bán", "Số lượng"
	            }
	        ) {
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
		
		tbDetails.getColumnModel().getColumn(0).setMinWidth(50);
		tbDetails.getColumnModel().getColumn(0).setPreferredWidth(50);
		tbDetails.getColumnModel().getColumn(0).setMaxWidth(50);
		
		tbOrderList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	tbOrderListMouseClicked(evt);
            }
        });
		
		btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnBackActionPerformed(evt);
            }
        });
	}
	
	private void tbOrderListMouseClicked(java.awt.event.MouseEvent evt) {
		DefaultTableModel tableModel = (DefaultTableModel) tbOrderList.getModel();
        @SuppressWarnings("unchecked")
		Vector<Object> accountVector = (Vector<Object>) tableModel.getDataVector().elementAt(tbOrderList.getSelectedRow());

        Order order = OrderController.getOrderById(Integer.parseInt(accountVector.get(1).toString()));

        List<Pair<Laptop, Integer>> listPair = order.getList();
        
        DefaultTableModel model = (DefaultTableModel) tbDetails.getModel();
    	model.setRowCount(0);
        
    	for (int i = 0; i < listPair.size(); i++) {
    		Pair<Laptop, Integer> pair = listPair.get(i);
    		model.addRow(new Object[]{i + 1, pair.getKey().getId(), pair.getKey().getName(), pair.getKey().getManufacturer(), pair.getKey().getPrice(), pair.getValue()});
    	}
	}
	
	private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
		if (idUser != 0) {
			this.dispose();
		}
	}
	
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        List<Order> orders = List.copyOf(OrderController.getAllOrderByAccId(idUser));
        DefaultTableModel model = (DefaultTableModel) tbOrderList.getModel();
        for (int i = 0; i < orders.size(); i++) {
            Order o = orders.get(i);
            
            model.addRow(new Object[]{i + 1, o.getId(), o.getDate(), o.getTotalPrice(), o.getIdAcc()});
        }
    }//GEN-LAST:event_formWindowOpened
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderHistory frame = new OrderHistory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//private properties
	private JPanel contentPane;
	private JTable tbOrderList;
	private JTable tbDetails;

}
