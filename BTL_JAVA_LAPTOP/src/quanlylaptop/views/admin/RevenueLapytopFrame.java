package quanlylaptop.views.admin;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import quanlylaptop.Controller.AccountController;
import quanlylaptop.Controller.OrderController;
import quanlylaptop.Models.Order;
import quanlylaptop.views.Login;


public class RevenueLapytopFrame extends JFrame {

	private static final long serialVersionUID = 1L;
    @SuppressWarnings({ "unchecked", "rawtypes" })
	static List<Order> list = new ArrayList();
    DefaultTableModel model = new DefaultTableModel();
    int money = 0;

    public RevenueLapytopFrame(java.awt.Frame parent, boolean modal) {
        initComponents();
        model = (DefaultTableModel) tbOrderList.getModel();
        show1();
        addYear();
    }

    //Hiển thị dữ liệu vào bảng
    private void show1() {
        cbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
        cbYear.setSelectedIndex(0);
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        list = OrderController.getAllOrders();
        model.setRowCount(0);
        money = 0;
        //SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
        for (int i = 0; i < list.size(); i++) {
            String a = AccountController.getAccountByID(list.get(i).getIdAcc()).getFullname();
            model.addRow(new Object[]{i + 1, list.get(i).getId(), list.get(i).getDate(), list.get(i).getTotalPrice(),a, list.get(i).getIdAcc()});
            money += list.get(i).getTotalPrice();
            txtSum.setText(String.valueOf(money));
        }
    	
    }

    private void addYear(String year) {
        int dem = 0;
        for (int i = 0; i < cbYear.getItemCount(); i++) {
            if (!cbYear.getItemAt(i).equalsIgnoreCase(year)) {
                dem++;
            }
        }
        if (dem == cbYear.getItemCount()) {
            cbYear.addItem(year);
        }
    }

    //lấy ra các năm trong CSDL để thêm vào combobox Year
    private void addYear() {
//        cbYear.addItem(" ");
        list = OrderController.getAllOrders();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
        for (int i = 0; i < list.size(); i++) {
            addYear(sdf1.format(list.get(i).getDate()));
        }
    }

    @SuppressWarnings("serial")
	private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbOrderList = new javax.swing.JTable();
        cbMonth = new javax.swing.JComboBox<>();
        cbYear = new javax.swing.JComboBox<>();
        txtSum = new javax.swing.JTextField();
        lblMonth = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbStatusCaps = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        lbTime = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BÁO CÁO DOANH THU");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tbOrderList.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbOrderList.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "STT", "Order ID", "Ngày đặt hàng", "Tổng tiền","Tên nhân viên", "Mã nhân viên"
	            }
	        ) {
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false, false, false
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
        	tbOrderList.getColumnModel().getColumn(1).setMinWidth(100);
        	tbOrderList.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbOrderList.getColumnModel().getColumn(1).setMaxWidth(100);
            tbOrderList.getColumnModel().getColumn(5).setMinWidth(80);
        	tbOrderList.getColumnModel().getColumn(5).setPreferredWidth(80);
        	tbOrderList.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        cbMonth.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "   ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HienThiDLTheoThang(evt);
            }
        });

        cbYear.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HienThiDLTheoNam(evt);
            }
        });

        txtSum.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSumActionPerformed(evt);
            }
        });

        lblMonth.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblMonth.setText("Tháng:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Năm:");

        jButton1.setText("Tất cả");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tổng doanh thu");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        lbStatusCaps.setText("CAPS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTime)
                .addGap(48, 48, 48)
                .addComponent(lbDate)
                .addGap(29, 29, 29)
                .addComponent(lbStatusCaps)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lbStatusCaps, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(88, 191, 190));

        lblHoachToan.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblHoachToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlynhadat/views/icons/Actions-view-choose-icon-24.png"))); // NOI18N
        lblHoachToan.setText("Báo cáo doanh thu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHoachToan, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
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

        miNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlynhadat/views/icons/new.png"))); // NOI18N
        miNew.setMnemonic('N');
        miNew.setText("Trang chủ");
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
        jMenuItem3.setEnabled(false);
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(29, 29, 29)
                        .addComponent(lblMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSum, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMonth)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSum, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     //Hiển thị danh sách theo tháng ngày năm
    private void HienThiDLTheoThang(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HienThiDLTheoThang
        String month = (String) cbMonth.getSelectedItem();
        String year = (String) cbYear.getSelectedItem();
        System.out.println(cbMonth.getSelectedItem() + " - " + cbMonth.getItemCount());
        System.out.println("Month = " + month + ", Year = " + year);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (year.trim().compareTo("") == 0) {
            cbYear.setSelectedIndex(1);
            year = (String) cbYear.getSelectedItem();
            System.out.println("Month = " + month + ", Year = " + year);
        }

        if (month.trim().compareTo("") == 0) {
            list = OrderController.getAllOrderByYear(year);
        } else {
            list = OrderController.getAllOrderByMonthYear(year, month);
        }
        model.setRowCount(0);
        money = 0;
        if (list.size() == 0) {
            money = 0;
            txtSum.setText("0");
            return;
        } else {
        for (int i = 0; i < list.size(); i++) {
            String a = AccountController.getAccountByID(list.get(i).getIdAcc()).getFullname();
            model.addRow(new Object[]{i + 1, list.get(i).getId(), sdf.format(list.get(i).getDate()), list.get(i).getTotalPrice(),a, list.get(i).getIdAcc()});
            money += list.get(i).getTotalPrice();
            txtSum.setText(String.valueOf(money));
            }    
        }
    }//GEN-LAST:event_HienThiDLTheoThang

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        show1();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void HienThiDLTheoNam(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HienThiDLTheoNam
        String month = (String) cbMonth.getSelectedItem();
        String year = (String) cbYear.getSelectedItem();
        System.out.println("Month = " + month + ", Year = " + year);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (month.trim().compareTo("") == 0) {
            list = OrderController.getAllOrderByYear(year);
        } else {
            list = OrderController.getAllOrderByMonthYear(year, month);
        }
        model.setRowCount(0);
        money = 0;
        int dem = 0;
            for (int i = 0; i < list.size(); i++) {
            	   dem++;
                String a = AccountController.getAccountByID(list.get(i).getIdAcc()).getFullname();
                model.addRow(new Object[]{i + 1, list.get(i).getId(), sdf.format(list.get(i).getDate()), list.get(i).getTotalPrice(),a, list.get(i).getIdAcc()});
                money += list.get(i).getTotalPrice();
                txtSum.setText(String.valueOf(money));
            }    
        if (dem == 0) {
            money = 0;
            txtSum.setText("0");
        }
    }//GEN-LAST:event_HienThiDLTheoNam


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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        isCapsOn = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
        lbStatusCaps.setEnabled(isCapsOn);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm:ss");

        Calendar calendar = Calendar.getInstance();
        Date currentTime = calendar.getTime();
        lbDate.setText(simpleDateFormat.format(currentTime));
        lbTime.setText(simpleTimeFormat.format(currentTime));

        timerNow = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar calendar = Calendar.getInstance();
                Date currentTime = calendar.getTime();
                lbTime.setText(simpleTimeFormat.format(currentTime));
            }
        });
        timerNow.start();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    	
    }//GEN-LAST:event_formWindowClosed

    private void txtSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSumActionPerformed

    }//GEN-LAST:event_txtSumActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RevenueLapytopFrame dialog = new RevenueLapytopFrame(new javax.swing.JFrame(), true);
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

    private boolean isCapsOn;
    private Timer timerNow;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbMonth;
    private javax.swing.JComboBox<String> cbYear;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbStatusCaps;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lblHoachToan;
    private javax.swing.JLabel lblMonth;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miNew;
    private javax.swing.JTable tbOrderList;
    private javax.swing.JTextField txtSum;
    // End of variables declaration//GEN-END:variables
}