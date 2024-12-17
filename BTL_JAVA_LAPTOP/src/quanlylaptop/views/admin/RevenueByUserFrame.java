package quanlylaptop.views.admin;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import quanlylaptop.Controller.OrderController;
import quanlylaptop.Models.Order;
import quanlylaptop.views.Login;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class RevenueByUserFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	static List<Order> list = new ArrayList();
    DefaultTableModel model = new DefaultTableModel();
    String idUser;
    int money = 0;
    
    public RevenueByUserFrame(java.awt.Frame parent, boolean modal) {
        initComponents();
        model = (DefaultTableModel) tbOrderList.getModel();
        show1();
    }
    
    public RevenueByUserFrame(java.awt.Frame parent, boolean modal, String idEmployeee) {
        initComponents();
        model = (DefaultTableModel) tbOrderList.getModel();
        idUser = idEmployeee;
        show1();
    }

    //Hiển thị dữ liệu vào bảng
    private void show1() {
        list = OrderController.getAllOrderByAccId(Integer.parseInt(idUser));
        for (int i = 0; i < list.size(); i++) {
        	model.addRow(new Object[]{i + 1, list.get(i).getId(),list.get(i).getDate(), list.get(i).getTotalPrice(),list.get(i).getIdAcc()});
            money += list.get(i).getTotalPrice();
            txtSum.setText(String.valueOf(money));
         
        }
    }
     
    @SuppressWarnings("serial")
	private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbOrderList = new javax.swing.JTable();
        txtSum = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblHoachToan = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miNew = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miExit = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DOANH THU NHÂN VIÊN");
//        addWindowListener(new java.awt.event.WindowAdapter() {
//            public void windowOpened(java.awt.event.WindowEvent evt) {
//            	formWindowOpened(evt);
//            }
//        }); 
        
        tbOrderList.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
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

        tbOrderList.setEnabled(false);
        jScrollPane1.setViewportView(tbOrderList);
        if (tbOrderList.getColumnModel().getColumnCount() > 0) {
        	tbOrderList.getColumnModel().getColumn(0).setMinWidth(50);
        	tbOrderList.getColumnModel().getColumn(0).setPreferredWidth(50);
        	tbOrderList.getColumnModel().getColumn(0).setMaxWidth(50);
        	tbOrderList.getColumnModel().getColumn(1).setMinWidth(120);
        	tbOrderList.getColumnModel().getColumn(1).setPreferredWidth(150);
        	tbOrderList.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        txtSum.setFont(new java.awt.Font("Times New Roman", 0, 14));

        jLabel1.setText("Tổng doanh thu");

        jButton2.setText("Quay lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(88, 191, 190));

        lblHoachToan.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblHoachToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlynhadat/views/icons/Actions-view-choose-icon-24.png"))); // NOI18N
        lblHoachToan.setText("Báo cáo doanh thu cá nhân");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHoachToan)
                .addGap(250, 250, 250))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHoachToan, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlynhadat/views/icons/home2.png"))); // NOI18N
        jMenu1.setMnemonic('H');
        jMenu1.setText("Hệ thống");

        miNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlynhadat/views/icons/new.png"))); // NOI18N
        miNew.setMnemonic('N');
        miNew.setText("Trang chủ");
        miNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewActionPerformed(evt);
            }
        });
        jMenu1.add(miNew);
        jMenu1.add(jSeparator1);

        miExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlynhadat/views/icons/logout.png"))); // NOI18N
        miExit.setMnemonic('L');
        miExit.setText("Log out");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        jMenu1.add(miExit);

        jMenuBar1.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlynhadat/views/icons/Person-Male-Light-icon-24.png"))); // NOI18N
        jMenu3.setText("Quản lý tài khoản người dùng");

        jMenuItem2.setText("Danh sách người dùng");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem4.setText("Thêm nhân viên");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlynhadat/views/icons/Actions-view-choose-icon-24.png"))); // NOI18N
        jMenu4.setText("Doanh thu");

        jMenuItem3.setText("Tất cả doanh thu");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(0, 30, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButton2)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(txtSum, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jScrollPane1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 740, GroupLayout.PREFERRED_SIZE))
        			.addGap(30))
        		.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(35)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtSum, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton2))
        			.addGap(44))
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_miExitActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.dispose();
        UsersManagement usersManagement = new UsersManagement();
        usersManagement.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.dispose();
        AddUserFrame addUserFrame = new AddUserFrame();
        addUserFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        UsersManagement usersManagement = new UsersManagement();
        usersManagement.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void miNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewActionPerformed
        this.dispose();
        AdminScreenMain dialog = new AdminScreenMain();
        dialog.setVisible(true);
    }//GEN-LAST:event_miNewActionPerformed
   
    

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RevenueByUserFrame dialog = new RevenueByUserFrame(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblHoachToan;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miNew;
    private javax.swing.JTable tbOrderList;
    private javax.swing.JTextField txtSum;
    // End of variables declaration//GEN-END:variables
}
