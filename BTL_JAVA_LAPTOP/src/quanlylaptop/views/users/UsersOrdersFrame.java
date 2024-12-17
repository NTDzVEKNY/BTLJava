package quanlylaptop.views.users;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import quanlylaptop.Controller.LaptopController;
import quanlylaptop.Controller.OrderController;
import quanlylaptop.Models.Laptop;
import quanlylaptop.Models.Order;
import quanlylaptop.Models.Pair;
import quanlylaptop.views.Login;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class UsersOrdersFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	int idUser;
	
	public UsersOrdersFrame() {
        initComponents();
        System.out.println("id = " + idUser);
    }
	
	public UsersOrdersFrame(int idUser) {
		initComponents();
		this.idUser = idUser;
		System.out.println("id = " + idUser);
	}

    @SuppressWarnings({ "serial", "deprecation" })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

    	listInCart = new ArrayList<Laptop>();
    	
        jScrollPane2 = new javax.swing.JScrollPane();
        tbListLaptop = new javax.swing.JTable();
        tbLstLapInOrder = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnQliLaptop = new javax.swing.JButton();
        btnQliOrder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThanhToan = new JButton();
        jblTotalMoney = new JLabel();
        txtTotalMoney = new JTextField();
        btnLS = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ ĐƠN HÀNG LAPTOP");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tbListLaptop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Laptop ID", "Tên laptop", "Tên hãng", "Số lượng", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        tbListLaptop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	tbLaptopListMouseClicked(evt);
            }
        });
        
        jScrollPane2.setViewportView(tbListLaptop);
        if (tbListLaptop.getColumnModel().getColumnCount() > 0) {
            tbListLaptop.getColumnModel().getColumn(0).setMinWidth(50);
            tbListLaptop.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbListLaptop.getColumnModel().getColumn(0).setMaxWidth(50);
        }
        
        tbListLaptop.getColumnModel().getColumn(1).setMinWidth(80);
        tbListLaptop.getColumnModel().getColumn(1).setPreferredWidth(80);
        tbListLaptop.getColumnModel().getColumn(1).setMaxWidth(80);
        
        tbLstLapInOrder = new JTable();
        tbLstLapInOrder.setModel(new javax.swing.table.DefaultTableModel(
        	new Object[][] {

        	},
        	new String[] {
        		"STT", "Laptop ID", "Tên laptop", "Tên hãng", "Giá bán", "Số lượng"
        	}
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
        });
        
        tbLstLapInOrder.getColumnModel().getColumn(0).setMinWidth(50);
        tbLstLapInOrder.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbLstLapInOrder.getColumnModel().getColumn(0).setMaxWidth(50);

        jPanel1.setBackground(new java.awt.Color(88, 191, 190));

        btnQliLaptop.setText("Quản lí laptop");
        btnQliLaptop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnQliLaptopActionPerformed(evt);
            }
        });
        
        btnQliOrder.setText("Quản lí đơn hàng");
        btnQliOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Quản lí đơn hàng");

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 0, 51));
        btnLogout.setText("Đăng xuất");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm vào giỏ hàng");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnThanhToanActionPerformed(evt);
			}
        });
        
        btnLS.setText("Lịch sử đơn hàng");
        btnLS.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnShowOrderHistoryActionPerformed(evt);
			}
        });

        jblTotalMoney.setText("Tổng tiền:");
        txtTotalMoney.disable();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(btnThem)
        			.addGap(100)
        			.addComponent(btnXoa)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnReset)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnThanhToan)
        			.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
        			.addComponent(btnLS)
        			.addGap(45)
        			.addComponent(jblTotalMoney, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtTotalMoney, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnThem)
        				.addComponent(txtTotalMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jblTotalMoney)
        				.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(btnReset)
        				.addComponent(btnThanhToan)
        				.addComponent(btnLS))
        			.addContainerGap())
        );
        jPanel3.setLayout(jPanel3Layout);
        
        jScrlPanelLap = new JScrollPane();
        
        lblCart = new JLabel("Giỏ hàng");
        lblCart.setFont(new Font("Tahoma", Font.PLAIN, 12));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrlPanelLap, GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
        			.addContainerGap())
        		.addComponent(jPanel3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblCart, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(726, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(6)
        			.addComponent(lblCart)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jScrlPanelLap, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        
        jScrlPanelLap.setViewportView(tbLstLapInOrder);
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jPanel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(btnQliLaptop)
        					.addGap(18)
        					.addComponent(btnQliOrder, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
        					.addGap(161)
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
        					.addComponent(btnLogout)))
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnQliLaptop)
        				.addComponent(btnLogout)
        				.addComponent(btnQliOrder)
        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);
        
        lblLapList = new JLabel("Danh sách sản phẩm");
        jLabel5 = new javax.swing.JLabel();
        
                jLabel5.setText("Tìm kiếm theo tên laptop:");
        txtTimKiem = new javax.swing.JTextField();
        
                txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        txtTimKiemActionPerformed(evt);
                    }
                });
                txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        txtTimKiemKeyPressed(evt);
                    }
                });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(lblLapList, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 438, Short.MAX_VALUE)
        			.addComponent(jLabel5)
        			.addGap(18)
        			.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
        			.addGap(70))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblLapList, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(layout.createSequentialGroup()
        						.addGap(3)
        						.addComponent(jLabel5))
        					.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQliLaptopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQliLaptopActionPerformed
    	if (idUser != 0) {
    		this.dispose();
    		UsersFrame dialog = new UsersFrame(idUser);
    		dialog.setVisible(true);
    	}
    }//GEN-LAST:event_btnQliLaptopActionPerformed
    
    private void btnShowOrderHistoryActionPerformed(java.awt.event.ActionEvent evt) {
    	if (idUser != 0) {
    		OrderHistory dialog = new OrderHistory(idUser);
    		dialog.setVisible(true);
    	}
    }
    
    private void tbLaptopListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGDNhaMouseClicked

    }//GEN-LAST:event_tbGDNhaMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
    	listInCart = new ArrayList<Laptop>();
    	UpdateCart();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tbListLaptop.getModel();
        @SuppressWarnings("unchecked")
		Vector<Object> accountVector = (Vector<Object>) tableModel.getDataVector().elementAt(tbListLaptop.getSelectedRow());   
        Laptop laptop = LaptopController.getLaptopById(Integer.parseInt(accountVector.get(1).toString()));
        int quantity = Integer.parseInt(JOptionPane.showInputDialog(new JFrame(), "Nhập số lượng muốn thêm: "));
        
        while (quantity - laptop.getQuantity() > 0) {
        	quantity = Integer.parseInt(JOptionPane.showInputDialog(new JFrame(), "Nhập quá số lượng tồn. Nhập số lượng muốn thêm: "));
        }
        
        boolean isAvail = false;
        for (int i = 0; i < listInCart.size(); i++) {
        	if (listInCart.get(i).getId() == laptop.getId()) {
        		isAvail = true;
        		break;
        	}
        }
        
        if (!isAvail) {
        	laptop.setQuantity(quantity);
        	listInCart.add(laptop);
        } else {
            int already = 0;
            for (int i = 0; i < listInCart.size(); i++) {
            	if (listInCart.get(i).getId() == laptop.getId()) {
            		already = listInCart.get(i).getQuantity();
            		break;
            	}
            }
            
            while (quantity + already - laptop.getQuantity() > 0) {
            	quantity = Integer.parseInt(JOptionPane.showInputDialog(new JFrame(), "Nhập quá số lượng tồn. Nhập số lượng muốn thêm: "));
            }
        	
        	int id = 0;
        	for (int i = 0; i < listInCart.size(); i++) {
            	if (listInCart.get(i).getId() == laptop.getId()) {
            		id = i;
            		break;
            	}
            }
        	listInCart.get(id).setQuantity(listInCart.get(id).getQuantity() + quantity);
        }
        UpdateCart();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
    	DefaultTableModel tableModel = (DefaultTableModel) tbLstLapInOrder.getModel();
        @SuppressWarnings("unchecked")
		Vector<Object> accountVector = (Vector<Object>) tableModel.getDataVector().elementAt(tbLstLapInOrder.getSelectedRow());   
        
        for (int i = 0; i < listInCart.size(); i++) {
        	if (listInCart.get(i).getId() == Integer.parseInt(accountVector.get(1).toString())) {
        		listInCart.remove(i);
        		break;
        	}
        }
        UpdateCart();
    }//GEN-LAST:event_btnXoaActionPerformed
    
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
    	List<Pair<Laptop, Integer>> listPair = new ArrayList<Pair<Laptop, Integer>>();
    	List<Laptop> listAll = LaptopController.getAllLaptop();
    	
    	for (int i = 0; i < listInCart.size(); i++) {
    		Pair<Laptop, Integer> pair = new Pair<Laptop, Integer>(listInCart.get(i), listInCart.get(i).getQuantity());
    		listPair.add(pair);
    		for (int j = 0; j < listAll.size(); j++) {
    			if (listAll.get(j).getId() == listInCart.get(i).getId()) {
    				Laptop lap = listAll.get(j);
    				lap.setQuantity(listAll.get(j).getQuantity() - listInCart.get(i).getQuantity());
    				LaptopController.updateLaptop(lap);
    			}
    		}
    	
    	}
    	
    	Date date = new Date();
    	int total = Integer.parseInt(txtTotalMoney.getText());
    	int idAcc = idUser;
    	
    	Order o = new Order(listPair, date, total, idAcc);
    	
    	OrderController.CreateNewOrder(o);
    	
    	btnResetActionPerformed(evt);
    	formWindowOpened(null);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.dispose();
        Login dialog = new Login();
        dialog.setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    // Hiển thị dữ liệu cho Bảng
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        List<Laptop> laptops = List.copyOf(LaptopController.getAllLaptop());

        DefaultTableModel model = (DefaultTableModel) tbListLaptop.getModel();
        model.setRowCount(0);
        int stt = 0;
        for (int i = 0; i < laptops.size(); i++) {
            Laptop laptop = laptops.get(i);
            stt++;
            model.addRow(new Object[]{stt, laptop.getId(), laptop.getName(), laptop.getManufacturer(), laptop.getQuantity(), laptop.getPrice()});
        }
    }//GEN-LAST:event_formWindowOpened

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed

    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
    	if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if ("".equals(txtTimKiem.getText().trim()) || txtTimKiem == null) {
                DefaultTableModel model = (DefaultTableModel) tbListLaptop.getModel();
                model.setRowCount(0);
                formWindowOpened(null);

            } else {
                try {
                    List<Laptop> laptops = LaptopController.getAllLaptopByName(txtTimKiem.getText());
                    
                    DefaultTableModel model = (DefaultTableModel) tbListLaptop.getModel();
                    model.getDataVector().removeAllElements();
                    model.fireTableDataChanged();
                    for (int i = 0; i < laptops.size(); i++) {
                    	model.addRow(new Object[]{i + 1, laptops.get(i).getId(), laptops.get(i).getName(), laptops.get(i).getManufacturer(), laptops.get(i).getQuantity(), laptops.get(i).getPrice()});
                    }
                } catch (Exception ex) {
                    JOptionPane.showConfirmDialog(null, "Không tìm thấy giao dịch nào", "Tìm kiêm", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    DefaultTableModel model = (DefaultTableModel) tbListLaptop.getModel();
                    model.setRowCount(0);
                    formWindowOpened(null);

                }

            }
        }
    }//GEN-LAST:event_txtTimKiemKeyPressed
    
	private void UpdateCart() {
    	DefaultTableModel model = (DefaultTableModel) tbLstLapInOrder.getModel();
    	model.setRowCount(0);
        int stt = 0;
        for (int i = 0; i < listInCart.size(); i++) {
            Laptop laptop = listInCart.get(i);
            stt++;
            model.addRow(new Object[]{stt, laptop.getId(), laptop.getName(), laptop.getManufacturer(), laptop.getPrice(), laptop.getQuantity()});
        }
        CalTotalMoney();
    }
	
	private void CalTotalMoney() {
		int total = 0;
		for (int i = 0; i < listInCart.size(); i++) {
			total = total + (listInCart.get(i).getPrice() * listInCart.get(i).getQuantity());
		}
		txtTotalMoney.setText(total + "");
	}

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsersFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsersFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsersFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsersFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsersOrdersFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQliLaptop;
    private javax.swing.JButton btnQliOrder;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnLS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbListLaptop;
    private javax.swing.JTable tbLstLapInOrder;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JScrollPane jScrlPanelLap;
    
    private List<Laptop> listInCart;
    private JLabel lblCart;
    private JLabel lblLapList;
    private JLabel jblTotalMoney;
    private JTextField txtTotalMoney;


}
