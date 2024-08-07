/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;
import java.sql.*;
import koneksiDB.koneksi;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import penggajian_karyawan.Penggajian_Karyawan;

/**
 *
 * @author RFox
 */
public class Form_Cuti extends javax.swing.JFrame {
javax.swing.Timer pewaktu;
private DefaultTableModel model;
 String vcutiID,vkaryawanID,vAlasan,vTglCuti,vTglMasuk,vNama;
 Date snapshotCuti, snapshotMasuk;
 Boolean isListening = true;
 int sisaCuti = 12;
   
  private static Statement st;
    /**
     * Creates new form Form_Cuti
     */
    public Form_Cuti() {
        initComponents();
        model = new DefaultTableModel();
        tbl.setModel(model);
        upd.setEnabled(false);
        del.setEnabled(false);
        model.addColumn("cutiID");
        model.addColumn("karyawanID");
        model.addColumn("alasan");
        model.addColumn("tgl_cuti");
        model.addColumn("tgl_masuk");
        model.addColumn("nama");
        Seticon();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        isiKaryawan();
        perbaruiID();
        getData();
        tgl_cuti.getDateEditor().setLocale(Locale.forLanguageTag("id-ID"));
        tgl_masuk.getDateEditor().setLocale(Locale.forLanguageTag("id-ID"));
    }
    public String idKry;
 
    public String getidKry() {
        return idKry;
    }
    
    public void getData(){
        sisaCuti = 12;
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        String cariitem = cr.getText();
        try{
            st = (Statement) koneksi.getKoneksi().createStatement();
            
            String sql = "SELECT COUNT(tgl_cuti) AS hasil FROM (\n" +
                "WITH RECURSIVE DateRange AS (\n" +
                "    SELECT CONCAT(YEAR(now()), '-01-01') AS date" +
                "    UNION ALL\n" +
                "    SELECT DATE_ADD(date, INTERVAL 1 DAY)\n" +
                "    FROM DateRange\n" +
                "    WHERE date < DATE_SUB(CONCAT(YEAR(now())+1, '-01-01'), INTERVAL 1 DAY)\n" +
                ")\n" +
                "SELECT date, dayname(date) AS namahari, c.tgl_cuti , c.tgl_masuk FROM DateRange\n" +
                "LEFT JOIN (SELECT * FROM cuti WHERE karyawanID = "+idKry+") c ON date BETWEEN c.tgl_cuti AND DATE_SUB(c.tgl_masuk, INTERVAL 1 DAY)\n" +
                "WHERE date != '2025-01-01' ORDER BY date ASC\n" +
                ") sbc\n" +
                "WHERE namahari NOT IN ('Sunday', 'Saturday')";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                sisaCuti -= res.getInt("hasil");
            }
            System.out.println("Sisa cuti " + sisaCuti);
            cekTanggalTabrakan();
            iSisaCuti.setText(sisaCuti + "");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        
        try{
            st = (Statement) koneksi.getKoneksi().createStatement();
            String sql = "SELECT cutiID, k.karyawanID, alasan, tgl_cuti, tgl_masuk, k.nama FROM cuti c LEFT JOIN karyawan k ON c.karyawanID = k.karyawanID where k.karyawanID = " + idKry + " AND "+
                    " ( cutiID like '%" + cariitem + "%' or alasan like '%" + cariitem + "%' or tgl_cuti like '%"+cariitem+"%' or tgl_masuk like '%"+cariitem+"%' ) order by cutiID asc";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                Object[] obj = new Object[6];
                obj[0] = res.getString("cutiID");
                obj[1] = res.getString("karyawanID");
                obj[2] = res.getString("alasan");
                obj[3] = res.getString("tgl_cuti");
                obj[4] = res.getString("tgl_masuk");
                obj[5] = res.getString("nama");
                model.addRow(obj);
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    private int hitungHariKerja(String mulai, String selesai) {
        String sql = "WITH RECURSIVE DateRange AS ( " +
        "SELECT '"+mulai+"' AS date " +
        "UNION ALL " +
        "SELECT DATE_ADD(date, INTERVAL 1 DAY) " +
        "FROM DateRange " +
        "WHERE date < '"+selesai+"' " +
        ") "+
        "SELECT " +
        "COUNT(dayname(date)) AS hasil " +
        "FROM DateRange WHERE dayname(date) NOT IN ('Saturday', 'Sunday') AND YEAR(date) = YEAR(now()) AND date != '"+selesai+"'";
        int jml = Integer.parseInt(querySatu(sql));
        return jml;
    }
    
    private String querySatu(String query) {
       try {
            st = (Statement) koneksi.getKoneksi().createStatement();
            String sql = query;
            ResultSet res = st.executeQuery(sql);
            Object[] obj = new Object[1];
            while(res.next()){
                obj[0] = res.getString("hasil");
            }
            return obj[0] == null ? "" : (String)obj[0];
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
            return "";
        }
    }
    
    public void loadData(){
        vcutiID = txtcuti.getText();
        vkaryawanID = nm.getText();
        vAlasan = txtalasan.getText();
        String tampilan ="yyyy-MM-dd" ; 
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        vTglCuti = String.valueOf(fm.format(tgl_cuti.getDate()));
        vTglMasuk = String.valueOf(fm.format(tgl_masuk.getDate()));
    }
    public void save(){
        loadData();
        try{
        st = (Statement)koneksi.getKoneksi().createStatement();
        String sql = "Insert into cuti(cutiID,karyawanID,alasan,tgl_cuti,tgl_masuk)"
                +"values('"+vcutiID+"','"+vkaryawanID+"','"+vAlasan+"','"+vTglCuti+"','"+vTglMasuk+"')";
        PreparedStatement p = (PreparedStatement)koneksi.getKoneksi().prepareStatement(sql);
        p.executeUpdate(sql);
        getData();
        reset();
        nm.requestFocus();
        JOptionPane.showMessageDialog(null, "Data Berhasil DiSimpan!");
        perbaruiID();
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Data Gagal DiSimpan!");
            reset();
        }
    }
    public void reset(){
        vcutiID = "";
        vkaryawanID  = "";
        vAlasan = "";
        vTglCuti  = "";
        vTglMasuk  = "";
        nm.setText(null);
        txtcuti.setText(null);
        txtalasan.setText(null);
        tgl_cuti.setDate(null);
        tgl_masuk.setDate(null);
         cr.setText("");
         perbaruiID();
         isiKaryawan();
    }
    public void selectData(){
        int i = tbl.getSelectedRow();
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Tidak ada data terpilih!");
            return;
        }
        nm.setText(""+model.getValueAt(i, 1));
         txtcuti.setText(""+model.getValueAt(i, 0));
        txtalasan.setText(""+model.getValueAt(i, 2));
         try {
            isListening = false;
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(i, 3));
            tgl_cuti.setDate(date);
            snapshotCuti = new Date(date.getTime());
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(i, 4));
            tgl_masuk.setDate(date1);
            snapshotMasuk = new Date(date1.getTime());
            isListening = true;
        } catch (ParseException ex) {
            Logger.getLogger(Form_Karyawan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update(){
        loadData();
        try{
           st = (Statement)koneksi.getKoneksi().createStatement();
           String sql = "update cuti set karyawanID='"+vkaryawanID+"',"
                   + "alasan='"+vAlasan+"',"
                   + "tgl_cuti='"+vTglCuti+"',"
                   + "tgl_masuk='"+vTglMasuk+"' where cutiID='"+vcutiID+"'";
        PreparedStatement p = (PreparedStatement)koneksi.getKoneksi().prepareStatement(sql);
        System.out.println("SQL " + sql);
        p.executeUpdate();
        getData();
        reset();
        nm.requestFocus();
        perbaruiID();
        JOptionPane.showMessageDialog(null, "Data Berhasil DiUpdate");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Data Gagal DiUpdate!");
            reset();
        }
    }
    public void delete(){
//        loadData();
        vcutiID = txtcuti.getText();
        int psn = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data ini?","Konfirmasi",
                JOptionPane.OK_CANCEL_OPTION);
        if(psn == JOptionPane.OK_OPTION){
            try{
                st = (Statement) koneksi.getKoneksi().createStatement();
                String sql = "Delete From cuti Where cutiID='"+vcutiID+"'";
                System.out.println(sql);
                PreparedStatement p =(PreparedStatement) koneksi.getKoneksi().prepareStatement(sql);
                p.executeUpdate();
                getData();
                reset();
                nm.requestFocus();
                JOptionPane.showMessageDialog(null, "Data Berhasil DiHapus");
            }catch(SQLException err){
                JOptionPane.showMessageDialog(null, "Data Gagal DiHapus!");
                reset();
            } 
        }
        perbaruiID();
    }
    
  public void itemTerpilih(){                              
        Data_Search3 DS = new Data_Search3();
        DS.fC = this;
        nm.setText(idKry);
        nama.setText(vNama);
    }
  
  private void isiKaryawan() {
    idKry = Penggajian_Karyawan.getUserId();
    vkaryawanID = idKry;
    nm.setText(idKry);
    nama.setText(Penggajian_Karyawan.getDisplayName());
    vNama = Penggajian_Karyawan.getDisplayName();
   }
  
  private void perbaruiID() {
        try{
          st = (Statement) koneksi.getKoneksi().createStatement();
          String sql = "SELECT CONCAT('C-', LPAD(MAX(CAST(replace(cutiID, 'C-', '') AS INT) + 1), 4, '0')) AS AUTO_INCREMENT FROM cuti";
          ResultSet res = st.executeQuery(sql);
          while(res.next()){
              Object[] obj = new Object[1];
              obj[0] = res.getString("AUTO_INCREMENT");
              String idBaru = (String)obj[0];
              if (idBaru == null) {
                  txtcuti.setText("C-0001");
                  vcutiID = "C-0001";
              }
              else {
                txtcuti.setText(idBaru);
                vcutiID = idBaru;
              }
              
          }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
  }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtcuti = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nm = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tgl_cuti = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        upd = new javax.swing.JButton();
        del = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        breset = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tgl_masuk = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtalasan = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        lSisaCuti = new javax.swing.JLabel();
        iSisaCuti = new javax.swing.JTextField();
        lSisaCuti1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        cr = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Form Cuti");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtcuti.setEditable(false);

        jLabel2.setText("Kode Cuti");

        nm.setEditable(false);

        jLabel3.setText("ID Karyawan");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Text preview.gif"))); // NOI18N
        jButton6.setText("Search Karyawan");
        jButton6.setPreferredSize(new java.awt.Dimension(0, 0));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel4.setText("Alasan");

        jLabel5.setText("Tanggal Cuti");

        tgl_cuti.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_cutiPropertyChange(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Save.gif"))); // NOI18N
        jButton1.setText("Simpan");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        upd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Modify.gif"))); // NOI18N
        upd.setText("Perbarui");
        upd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        upd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        upd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updActionPerformed(evt);
            }
        });

        del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Delete.gif"))); // NOI18N
        del.setText("Hapus");
        del.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        del.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Exit.gif"))); // NOI18N
        jButton4.setText("Tutup");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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

        jLabel7.setText("Tanggal Masuk");

        tgl_masuk.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_masukPropertyChange(evt);
            }
        });

        txtalasan.setColumns(20);
        txtalasan.setRows(5);
        jScrollPane2.setViewportView(txtalasan);

        jLabel6.setText("Nama Karyawan");

        nama.setEditable(false);

        lSisaCuti.setText("Sisa Cuti");

        iSisaCuti.setEditable(false);
        iSisaCuti.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lSisaCuti1.setText("Hari");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(upd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(breset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(del)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(50, 50, 50)
                                        .addComponent(txtcuti, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(tgl_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(iSisaCuti, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lSisaCuti1)))))))
                        .addContainerGap(213, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lSisaCuti)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(33, 33, 33)
                                .addComponent(tgl_cuti, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcuti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lSisaCuti)
                    .addComponent(iSisaCuti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lSisaCuti1))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tgl_cuti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(tgl_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(upd, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(del)
                        .addComponent(jButton4))
                    .addComponent(breset))
                .addGap(14, 14, 14))
        );

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cr, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(260, 260, 260))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Data_Search3 DS = new Data_Search3();
           DS.fC = this;
        DS.setVisible(true);
        DS.setResizable(false);
        //        gp.requestFocus();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           save();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void updActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updActionPerformed
        update();
        jButton1.setEnabled(true);
        upd.setEnabled(false);
        del.setEnabled(false); 
    }//GEN-LAST:event_updActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        delete();
        jButton1.setEnabled(true);
        upd.setEnabled(false);
        del.setEnabled(false);
    }//GEN-LAST:event_delActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int konf = JOptionPane.showConfirmDialog(null, "Yakin Ingin menutup Form?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (konf == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void bresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bresetActionPerformed
       reset();
    }//GEN-LAST:event_bresetActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       getData();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        selectData();
        upd.setEnabled(true);
        del.setEnabled(true);
        jButton1.setEnabled(false);
    }//GEN-LAST:event_tblMouseClicked

    private void tgl_cutiPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_cutiPropertyChange
        // TODO add your handling code here:
//        if (tgl_cuti.getDate() != null && tgl_masuk.getDate() != null) { tgl_masuk.setDate(null); }
        if (isListening) {
            rekamTelatPilihanTanggal("awal");
            cekTanggalTabrakan();
        }
    }//GEN-LAST:event_tgl_cutiPropertyChange

    private void tgl_masukPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_masukPropertyChange
        // TODO add your handling code here:
        if (isListening) {
            rekamTelatPilihanTanggal("akhir");
            cekTanggalTabrakan();
        }
        
    }//GEN-LAST:event_tgl_masukPropertyChange
    
    private void rekamTelatPilihanTanggal(String bagian) {
        Date stDate = tgl_cuti.getDate();
        Date edDate = tgl_masuk.getDate();
        final long stMillis = stDate != null ? stDate.getTime() : 0;
        final long edMillis = edDate != null ? edDate.getTime() : 0;
        System.out.println("Date Before " + snapshotCuti + " - " + snapshotMasuk); 
        isListening = false;
        if (pewaktu != null && pewaktu.isRunning()) {pewaktu.stop();}
        pewaktu = new javax.swing.Timer(500, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (snapshotMasuk != null && snapshotCuti != null) {
                    if (bagian.equals("akhir")) {
                        tgl_cuti.setDate(null);
                        snapshotCuti = null;
                    }
                    if (bagian.equals("awal")) {
                        tgl_masuk.setDate(null);
                        snapshotMasuk = null;
                    }
                    cekTanggalTabrakan();
                    System.out.println("MELUPAKAN...");
                }
                else {
                    snapshotCuti = stDate != null ? new Date(stMillis) : null;
                    snapshotMasuk = edDate != null ? new Date(edMillis) : null;
                }
                isListening = true;
                pewaktu.stop();
            }
        });
        pewaktu.start();
    }
    
    private void cekTanggalTabrakan() {
        String tampilan ="yyyy-MM-dd" ; 
        SimpleDateFormat fm = new SimpleDateFormat(tampilan); 
        Calendar dtcNow = Calendar.getInstance();
        dtcNow.add(Calendar.DATE, 7);
        Instant dtcNowInstant = dtcNow.toInstant();
        Date dtNow = Date.from(dtcNowInstant);
        long dtNowMillis = dtcNowInstant.toEpochMilli();
        Date sd = tgl_cuti.getDate();
        Date ed = tgl_masuk.getDate();
        System.out.println("Sd " + sd);
        System.out.println("Ed " + ed);
        if (sd == null && ed == null) {
            tgl_cuti.setMinSelectableDate(dtNow);
            tgl_cuti.setMaxSelectableDate(null);
            tgl_masuk.setMinSelectableDate(dtNow);
        }
        else if (sd != null && ed == null) {
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(tgl_cuti.getDate().getTime());
            c.add(Calendar.DATE, 1);
            
            int cnt = 0;
            int i = 0;
            Calendar cl = Calendar.getInstance();
            cl.setTimeInMillis(sd.getTime());
            while (cnt < sisaCuti) {
                cl.add(Calendar.DATE, (1));
                int dayId = cl.get(Calendar.DAY_OF_WEEK);
                if (dayId != Calendar.SUNDAY && dayId != Calendar.SATURDAY) {
                    cnt++;
                }
                i++;
            }
//            cl.add(Calendar.DATE, -1);
            if (cl.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) { cl.add(Calendar.DATE, -2); }
            
            Calendar cs;
            cs = cl;
            
            tgl_masuk.setMaxSelectableDate(Date.from(cs.toInstant()));
            tgl_masuk.setMinSelectableDate(Date.from(c.toInstant()));
        }
        else if (sd == null && ed != null) {
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(ed.getTime());
            c.add(Calendar.DATE, -1);
            
            int cnt = 0;
            int i = 0;
            Calendar cl = Calendar.getInstance();
            cl.setTimeInMillis(ed.getTime());
            while (cnt < sisaCuti) {
                cl.add(Calendar.DATE, -(1));
                int dayId = cl.get(Calendar.DAY_OF_WEEK);
                if (dayId != Calendar.SUNDAY && dayId != Calendar.SATURDAY) {
                    cnt++;
                }
                i++;
            }
//            cl.add(Calendar.DATE, 1);
            if (cl.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) { cl.add(Calendar.DATE, 2); }
            
            Calendar cs;
            if (cl.getTimeInMillis() > dtNowMillis) { cs = cl; } else { cs = Calendar.getInstance(); cs.setTimeInMillis(dtNowMillis); }
            
            tgl_cuti.setMaxSelectableDate(Date.from(c.toInstant()));
            tgl_cuti.setMinSelectableDate(Date.from(cs.toInstant()));
        }
        else {
            tgl_cuti.setMinSelectableDate(dtNow);
            tgl_masuk.setMinSelectableDate(dtNow);
            tgl_cuti.setMaxSelectableDate(null);
            tgl_masuk.setMaxSelectableDate(null);
            System.out.println("No-op, harapannya dipanggil setelah dinullkan parsial oleh rekamTelatTanggal");
       }
    }
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
            java.util.logging.Logger.getLogger(Form_Cuti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Cuti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Cuti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Cuti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Cuti().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton breset;
    private javax.swing.JTextField cr;
    private javax.swing.JButton del;
    private javax.swing.JTextField iSisaCuti;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lSisaCuti;
    private javax.swing.JLabel lSisaCuti1;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nm;
    private javax.swing.JTable tbl;
    private com.toedter.calendar.JDateChooser tgl_cuti;
    private com.toedter.calendar.JDateChooser tgl_masuk;
    private javax.swing.JTextArea txtalasan;
    private javax.swing.JTextField txtcuti;
    private javax.swing.JButton upd;
    // End of variables declaration//GEN-END:variables

    private void Seticon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icon/gif/16x16/dktbig.gif")));
    }

}
