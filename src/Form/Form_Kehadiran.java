/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;

import com.github.lgooddatepicker.optionalusertools.DateTimeChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateTimeChangeEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import koneksiDB.koneksi;

/**
 *
 * @author RFox
 */
public class Form_Kehadiran extends javax.swing.JFrame {
private DefaultTableModel model;
String vNm,vwktM,vtglM,vwktP,vtglP;
private static Statement st;
    /**
     * Creates new form Form_Kehadiran
     */
    public Form_Kehadiran() {
        initComponents();
        model = new DefaultTableModel();
       tbl.setModel(model);
        bupdate.setEnabled(false);
        bdelete.setEnabled(false);
        model.addColumn("karyawanID");
        model.addColumn("jam_masuk");
        model.addColumn("jam_pulang");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width)/2,(screenSize.height-frameSize.height)/2);
        Seticon();
        initListener();
        getData();
    }
   
 
    public String idKry;
 
    public String getidKry() {
        return idKry;
    }
    
    
  public void itemTerpilih(){                              
        Data_Search1 DS = new Data_Search1();
        DS.fK = this;
        fidkaryawan.setText(idKry);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jamMasuk = new javax.swing.JPanel();
        fidkaryawan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bsave = new javax.swing.JButton();
        bupdate = new javax.swing.JButton();
        bdelete = new javax.swing.JButton();
        bexit = new javax.swing.JButton();
        breset = new javax.swing.JButton();
        jamMasuk2 = new com.github.lgooddatepicker.components.DateTimePicker();
        jamPulang = new com.github.lgooddatepicker.components.DateTimePicker();
        jLabel2 = new javax.swing.JLabel();
        bSekarangMasuk = new javax.swing.JButton();
        bSekarangPulang = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        fcari = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jamMasuk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("ID Karyawan");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Text preview.gif"))); // NOI18N
        jButton6.setText("Search Karyawan");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setText("Jam Masuk");

        bsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Save.gif"))); // NOI18N
        bsave.setText("Save");
        bsave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bsave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bsave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bsaveMouseClicked(evt);
            }
        });
        bsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsaveActionPerformed(evt);
            }
        });

        bupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Modify.gif"))); // NOI18N
        bupdate.setText("Update");
        bupdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bupdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bupdateActionPerformed(evt);
            }
        });

        bdelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Delete.gif"))); // NOI18N
        bdelete.setText("Delete");
        bdelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bdelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
            }
        });

        bexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Exit.gif"))); // NOI18N
        bexit.setText("Exit");
        bexit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bexit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexitActionPerformed(evt);
            }
        });

        breset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Remove.gif"))); // NOI18N
        breset.setText("Reset");
        breset.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        breset.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        breset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bresetActionPerformed(evt);
            }
        });

        jamPulang.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jamPulangMouseMoved(evt);
            }
        });
        jamPulang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jamPulangFocusLost(evt);
            }
        });

        jLabel2.setText("Jam Pulang");

        bSekarangMasuk.setText("Sekarang");
        bSekarangMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSekarangMasukActionPerformed(evt);
            }
        });

        bSekarangPulang.setText("Sekarang");
        bSekarangPulang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSekarangPulangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jamMasukLayout = new javax.swing.GroupLayout(jamMasuk);
        jamMasuk.setLayout(jamMasukLayout);
        jamMasukLayout.setHorizontalGroup(
            jamMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jamMasukLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jamMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jamMasukLayout.createSequentialGroup()
                        .addComponent(bsave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bupdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(breset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bdelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bexit))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jamMasukLayout.createSequentialGroup()
                        .addGroup(jamMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(38, 38, 38)
                        .addGroup(jamMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jamMasukLayout.createSequentialGroup()
                                .addComponent(fidkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6))
                            .addGroup(jamMasukLayout.createSequentialGroup()
                                .addComponent(jamMasuk2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bSekarangMasuk))
                            .addGroup(jamMasukLayout.createSequentialGroup()
                                .addComponent(jamPulang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bSekarangPulang)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jamMasukLayout.setVerticalGroup(
            jamMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jamMasukLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jamMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fidkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton6))
                .addGap(43, 43, 43)
                .addGroup(jamMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jamMasuk2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSekarangMasuk))
                .addGap(35, 35, 35)
                .addGroup(jamMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jamPulang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(bSekarangPulang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jamMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jamMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bsave, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bupdate, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bdelete)
                        .addComponent(bexit))
                    .addComponent(breset))
                .addGap(14, 14, 14))
        );

        jLabel1.setText("Form Kehadiran");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Text preview.gif"))); // NOI18N
        jButton7.setText("Cari");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fcari, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jamMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jamMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Data_Search1 DS = new Data_Search1();
        DS.fK= this;
        DS.setVisible(true);
        DS.setResizable(false);    
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void bsaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsaveMouseClicked

    }//GEN-LAST:event_bsaveMouseClicked

    private void bsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsaveActionPerformed
                save();
    }//GEN-LAST:event_bsaveActionPerformed

    private void bupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bupdateActionPerformed
        update();
        bsave.setEnabled(true);
        bupdate.setEnabled(false);
bdelete.setEnabled(false);
    }//GEN-LAST:event_bupdateActionPerformed

    private void bdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeleteActionPerformed
         delete();
bsave.setEnabled(true);
     bupdate.setEnabled(false);
        bdelete.setEnabled(false);
    }//GEN-LAST:event_bdeleteActionPerformed

    private void bexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitActionPerformed
        int konf = JOptionPane.showConfirmDialog(null, "Yakin Ingin menutup Form?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if(konf == JOptionPane.YES_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_bexitActionPerformed

    private void bresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bresetActionPerformed
        // TODO add your handling code here:
        fnKosong();
    }//GEN-LAST:event_bresetActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jamPulangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jamPulangFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jamPulangFocusLost

    private void jamPulangMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jamPulangMouseMoved
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jamPulangMouseMoved

    private void bSekarangMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSekarangMasukActionPerformed
        // TODO add your handling code here:
        this.jamMasuk2.setDateTimeStrict(LocalDateTime.now());
    }//GEN-LAST:event_bSekarangMasukActionPerformed

    private void bSekarangPulangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSekarangPulangActionPerformed
        // TODO add your handling code here:
        this.jamPulang.setDateTimeStrict(LocalDateTime.now());
    }//GEN-LAST:event_bSekarangPulangActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
         selectData();
        bsave.setEnabled(false);
        bupdate.setEnabled(true);
        bdelete.setEnabled(true);
    }//GEN-LAST:event_tblMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Form_Kehadiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Kehadiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Kehadiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Kehadiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Kehadiran().setVisible(true);
            }
        });
    }
    
    private void initListener() {
    jamPulang.addDateTimeChangeListener(new DateTimeChangeListener() {
            public void dateOrTimeChanged(DateTimeChangeEvent event) {
                String wkt = jamPulang.getTimePicker().getText();
                String tgl = jamPulang.getDatePicker().getText();
                System.out.println("Tanggal terpilih pulang " + tgl + " " + wkt );
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    
    jamMasuk2.addDateTimeChangeListener(new DateTimeChangeListener() {
            public void dateOrTimeChanged(DateTimeChangeEvent event) {
                String wkt = jamMasuk2.getTimePicker().getText();
                String tgl = jamMasuk2.getDatePicker().getText();
                System.out.println("Tanggal terpilih datang " + tgl + " " + wkt );
//                jamPulang.getDateTimeStrict().toString();
//                jamPulang.setDateTimeStrict(null);
//                jamPulang.setDateTimeStrict(LocalDateTime.parse("2020-02-03T05:03:05"));
            }
        });
    }
    
  
    public void getData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        //String k = (String)ktg.getSelectedItem();
        String cariitem = fcari.getText();
        try{
            st = (Statement) koneksi.getKoneksi().createStatement();
            String sql = "SELECT * FROM kehadiran where karyawanID like '%" + cariitem + "%' order by karyawanID asc";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                Object[] obj = new Object[3];
                obj[0] = res.getString("karyawanID");
                obj[1] = res.getString("jam_masuk");
                obj[2] = res.getString("jam_pulang");
                model.addRow(obj);
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
     public void loadData(){
        vNm = fidkaryawan.getText();
         vwktM = jamMasuk2.getTimePicker().getText();
            vtglM = jamMasuk2.getDatePicker().getText();
                  vwktP = jamPulang.getTimePicker().getText();
                 vtglP = jamPulang.getDatePicker().getText();
    }
    private void save() {
        try{
        String sql = "INSERT INTO kehadiran (karyawanID,jam_masuk,jam_pulang)"
                +" VALUES (?, ?, ?)";
        PreparedStatement prepSql = koneksi.getKoneksi().prepareStatement(sql);
        prepSql.setString(1, fidkaryawan.getText());
        prepSql.setString(2, jamMasuk2.getDateTimeStrict().format(DateTimeFormatter.ISO_DATE_TIME).replace("T", " "));
        prepSql.setString(3, jamPulang.getDateTimeStrict().format(DateTimeFormatter.ISO_DATE_TIME).replace("T", " "));
//        System.out.println(prepSql.toString());
        prepSql.executeUpdate();
        getData();
        fnKosong();
        fidkaryawan.requestFocus();
        
        JOptionPane.showMessageDialog(null, "Data Berhasil DiSimpan!");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Data Gagal DiSimpan!\n" + err.getMessage());
        }
    }
      private void fnKosong() {
        fidkaryawan.setText("");
        fcari.setText("");
        jamPulang.setDateTimeStrict(null);
        jamMasuk2.setDateTimeStrict(null);
    };
      public void selectData(){
        int i = tbl.getSelectedRow();
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Tidak ada data terpilih!");
            return;
        }
        fidkaryawan.setText(""+model.getValueAt(i, 0));
        this.jamMasuk2.setDateTimeStrict(LocalDateTime.now());
        this.jamPulang.setDateTimeStrict(LocalDateTime.now());

          
    }
      public void update(){
        loadData();
        try{
           st = (Statement)koneksi.getKoneksi().createStatement();
           String sql = "update kehadiran set karyawanID='"+vNm+"',"
                   + "jam_masuk='"+jamMasuk2+"',"
                   + "jam_pulang='"+jamPulang+"' where karyawanID='"+vNm+"'";
        PreparedStatement p = (PreparedStatement)koneksi.getKoneksi().prepareStatement(sql);
        p.executeUpdate();
        getData();
        fnKosong();
        fidkaryawan.requestFocus();
        JOptionPane.showMessageDialog(null, "Data Berhasil DiUpdate");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Data Gagal DiUpdate!");
            fnKosong();
        }
    }
      public void delete(){
        loadData();
        int psn = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data ini?","Konfirmasi",
                JOptionPane.OK_CANCEL_OPTION);
        if(psn == JOptionPane.OK_OPTION){
            try{
                st = (Statement) koneksi.getKoneksi().createStatement();
                String sql = "Delete From kehadiran Where karyawanID='"+vNm+"'";
                PreparedStatement p =(PreparedStatement) koneksi.getKoneksi().prepareStatement(sql);
                p.executeUpdate();
                getData();
                fnKosong();
                fidkaryawan.requestFocus();
                JOptionPane.showMessageDialog(null, "Data Berhasil DiHapus");
            }catch(SQLException err){
                JOptionPane.showMessageDialog(null, "Data Gagal DiHapus!");
                fnKosong();
            } 
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSekarangMasuk;
    private javax.swing.JButton bSekarangPulang;
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bexit;
    private javax.swing.JButton breset;
    private javax.swing.JButton bsave;
    private javax.swing.JButton bupdate;
    private javax.swing.JTextField fcari;
    private javax.swing.JTextField fidkaryawan;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel jamMasuk;
    private com.github.lgooddatepicker.components.DateTimePicker jamMasuk2;
    private com.github.lgooddatepicker.components.DateTimePicker jamPulang;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
   private void Seticon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icon/gif/16x16/dktbig.gif")));
    }
}


