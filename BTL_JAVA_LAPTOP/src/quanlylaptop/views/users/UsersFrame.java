package quanlylaptop.views.users;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import quanlylaptop.Controller.LaptopController;
import quanlylaptop.Models.Laptop;
import quanlylaptop.views.Login;

import javax.swing.GroupLayout.Alignment;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class UsersFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	int idUser;
	
    public UsersFrame() {
        initComponents();
        System.out.println("id = " + idUser);
    }
    
    public UsersFrame(int idUser) {
    	initComponents();
    	this.idUser = idUser;
    	System.out.println("id = " + idUser);
    }
    
    public int getIdUser() {
    	return idUser;
	}

    @SuppressWarnings({ "serial" })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbListLaptop = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnQliLaptop = new javax.swing.JButton();
        btnQliOrder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jblLapID = new javax.swing.JLabel();
        jblQuantity = new javax.swing.JLabel();
        jblLapName = new javax.swing.JLabel();
        jblManuName = new javax.swing.JLabel();
        txtLaptopID = new javax.swing.JTextField();
        txtLapName = new javax.swing.JTextField();
        txtManuName = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jblPrice = new javax.swing.JLabel();

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
        
        tbListLaptop.getColumnModel().getColumn(4).setMinWidth(100);
        tbListLaptop.getColumnModel().getColumn(4).setPreferredWidth(100);
        tbListLaptop.getColumnModel().getColumn(4).setMaxWidth(100);

        jPanel1.setBackground(new java.awt.Color(88, 191, 190));

        btnQliLaptop.setText("Quản lí laptop");
        btnQliLaptop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            }
        });
        
        btnQliOrder.setText("Quản lí đơn hàng");
        btnQliOrder.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnQliOrderActionPerformed(evt);
			}
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Quản lí laptop");

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

        jblLapID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jblLapID.setText("Laptop ID:");

        jblQuantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jblQuantity.setText("Số lượng:");

        jblLapName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jblLapName.setText("Tên laptop");

        jblManuName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jblManuName.setText("Tên hãng:");

        txtLaptopID.setEnabled(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm mới");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel5.setText("Tìm kiếm theo tên laptop:");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnReset)
                .addGap(18, 18, 18)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jblPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jblPrice.setText("Giá bán:");
        
        txtQuantity = new JTextField();
        
        txtPrice = new JTextField();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        		.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(32)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jblManuName)
        						.addComponent(jblLapName))
        					.addGap(58)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(txtLapName, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtManuName, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jblLapID)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(txtLaptopID, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)))
        			.addGap(77)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jblQuantity)
        				.addComponent(jblPrice))
        			.addGap(53)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtQuantity, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
        			.addGap(77))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jblLapID)
        				.addComponent(txtLaptopID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jblQuantity)
        				.addComponent(txtQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(20)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jblLapName)
        				.addComponent(txtLapName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jblPrice)
        				.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtManuName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jblManuName))
        			.addGap(9)
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(btnQliLaptop)
        					.addGap(18)
        					.addComponent(btnQliOrder, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
        					.addGap(178)
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
        					.addComponent(btnLogout))
        				.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
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
        			.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQliOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQliOrderActionPerformed
    	if (idUser != 0) {
    		this.dispose();
    		UsersOrdersFrame dialog = new UsersOrdersFrame(idUser);
    		dialog.setVisible(true);
    	}
    }//GEN-LAST:event_btnQliOrderActionPerformed
    
    private void tbLaptopListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGDNhaMouseClicked
        DefaultTableModel tableModel = (DefaultTableModel) tbListLaptop.getModel();
        @SuppressWarnings("unchecked")
		Vector<Object> accountVector = (Vector<Object>) tableModel.getDataVector().elementAt(tbListLaptop.getSelectedRow());

        Laptop laptop = LaptopController.getLaptopById(Integer.parseInt(accountVector.get(1).toString()));

        txtLaptopID.setText(laptop.getId() + "");
        txtLapName.setText(laptop.getName() + "");
        txtManuName.setText(laptop.getManufacturer() + "");
        txtQuantity.setText(laptop.getQuantity() + "");
        txtPrice.setText(laptop.getPrice() + "");
    }//GEN-LAST:event_tbGDNhaMouseClicked
    
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtLaptopID.setText("");
        txtLapName.setText("");
        txtManuName.setText("");
        txtQuantity.setText("");
        txtPrice.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        if (txtLaptopID.getText().trim().compareTo("") != 0) {
            JOptionPane.showConfirmDialog(null, " Bạn phải nhập mới", "Lỗi thêm laptop id", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            btnResetActionPerformed(null);
            return;
        }
        if (txtLapName.getText().trim().compareTo("") == 0) {
            JOptionPane.showConfirmDialog(null, "Tên laptop không được để trống", "Lỗi thêm mới", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtManuName.getText().trim().compareTo("") == 0) {
            JOptionPane.showConfirmDialog(null, "Tên hãng không được để trống", "Lỗi thêm mới", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String name = txtLapName.getText();
        String manu = txtManuName.getText();
        int quantity = Integer.parseInt(txtQuantity.getText());
        int price = Integer.parseInt(txtPrice.getText());

        Laptop l = new Laptop(name, manu, quantity, price);

        if (!LaptopController.CreateNewLaptop(l)) {
            JOptionPane.showConfirmDialog(null, "Tạo laptop mới thất bại", "Lỗi thêm mới", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showConfirmDialog(null, "Tạo laptop mới thành công", "Thêm mới", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        DefaultTableModel model = (DefaultTableModel) tbListLaptop.getModel();
        model.setRowCount(0);
        formWindowOpened(null);
        btnResetActionPerformed(null);

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (txtLaptopID.getText().trim().compareTo("") == 0) {
            JOptionPane.showConfirmDialog(null, " Bạn phải chọn một laptop để sửa", "Lỗi sửa laptop", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtLapName.getText().trim().compareTo("") == 0) {
            JOptionPane.showConfirmDialog(null, "Tên laptop không được để trống", "Lỗi sửa laptop", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtManuName.getText().trim().compareTo("") == 0) {
            JOptionPane.showConfirmDialog(null, "Tên hãng không được để trống", "Lỗi sửa laptop", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String name = txtLapName.getText();
        String manu = txtManuName.getText();
        int quantity = Integer.parseInt(txtQuantity.getText());
        int price = Integer.parseInt(txtPrice.getText());

        int idLaptop = Integer.parseInt(txtLaptopID.getText());

        Laptop l = new Laptop(idLaptop, name, manu, quantity, price);

        int responseConfirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn sửa không?", "Sửa laptop", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (responseConfirm == JOptionPane.YES_OPTION) {
            if (!LaptopController.updateLaptop(l)) {
                JOptionPane.showConfirmDialog(null, "Sửa laptop thất bại", "Lỗi sửa laptop thất bại", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showConfirmDialog(null, "Sửa laptop thành công", "Lỗi sửa laptop", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            DefaultTableModel model = (DefaultTableModel) tbListLaptop.getModel();
            model.setRowCount(0);
            formWindowOpened(null);
        }
        btnResetActionPerformed(null);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
    	if (txtLaptopID.getText().trim().compareTo("") == 0) {
            JOptionPane.showConfirmDialog(null, "Bạn phải chọn một laptop để xoá", "Xóa laptop", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int responseConfirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá? ", "Xoá laptop", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (responseConfirm == JOptionPane.YES_OPTION) {
            if (!LaptopController.deleteLaptop(Integer.parseInt(txtLaptopID.getText()))) {
                JOptionPane.showConfirmDialog(null, "Xoá gio dich nhà thất bại", " Lỗi xoá gio dich nhà", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showConfirmDialog(null, "Xoá gio dich nhà thành công ", "Xoá giao dịch", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            DefaultTableModel model = (DefaultTableModel) tbListLaptop.getModel();
            model.setRowCount(0);
            formWindowOpened(null);
        }
        btnResetActionPerformed(null);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.dispose();
        Login dialog = new Login();
        dialog.setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    // Hiển thị dữ liệu cho Bảng
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        List<Laptop> laptops = List.copyOf(LaptopController.getAllLaptop());

        DefaultTableModel model = (DefaultTableModel) tbListLaptop.getModel();
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
                new UsersFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQliLaptop;
    private javax.swing.JButton btnQliOrder;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jblLapID;
    private javax.swing.JLabel jblQuantity;
    private javax.swing.JLabel jblLapName;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jblManuName;
    private javax.swing.JLabel jblPrice;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbListLaptop;
    private javax.swing.JTextField txtManuName;
    private javax.swing.JTextField txtLapName;
    private javax.swing.JTextField txtLaptopID;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
