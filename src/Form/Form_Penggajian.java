/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import java.util.Calendar;
import java.util.Locale;
/**
 *
 * @author ramdanirfox
 */
public class Form_Penggajian extends javax.swing.JFrame {
    private DefaultTableModel model;
    String vNm,vTgl,vTglBln,vJbt,vGol, vKryId;
    int vId,vGp,vGl,vT,vP,vGb;
    int vDenda, vLembur, vPotongan, vTunjangan = 0;
    private static Statement st;
    /**
     * Creates new form Penggajian
     */
    public Form_Penggajian() {
        initComponents();
        model = new DefaultTableModel();
        tbl.setModel(model);
        model.addColumn("ID");
        model.addColumn("TglGaji");
        model.addColumn("Nama");
        model.addColumn("Jabatan");
        model.addColumn("Golongan");
        model.addColumn("GajiPokok");
        model.addColumn("GajiLembur");
        model.addColumn("Tunjangan");
        model.addColumn("Potongan");
        model.addColumn("GajiBersih");
        getData();
        upd.setEnabled(false);
        del.setEnabled(false);
        nm.setEditable(false);
        jbt.setEditable(false);
        gol.setEditable(false);
        gl.setEditable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width)/2,(screenSize.height-frameSize.height)/2);
        Seticon();
        isiTanggalGaji();
        tg.getDateEditor().setLocale(Locale.forLanguageTag("id-ID"));
//        addListener();
    }
    public String nmKry, jbtKry, golKry;
    public int lmb;
    public String getnmKry() {
        return nmKry;
    }
    
    private void isiTanggalGaji() {
        Calendar c = Calendar.getInstance();
        if (c.get(Calendar.DATE) < 28) {
            c.add(Calendar.MONTH, -1);
        }
        c.set(Calendar.DATE, 28);
        tg.setDate(c.getTime());
    }
 
    public String getjbtKry() {
        return jbtKry;
    }
 
    public String getgolKry() {
        return golKry;
    }
    public int getLmb(){
        return lmb;
    }
    public void getData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        String k = (String)ktg.getSelectedItem();
        String c = cr.getText();
        try{
            st = (Statement) koneksi.getKoneksi().createStatement();
            String sql = "SELECT * FROM penggajian WHERE "+k+" like '%"+c+"%'";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                Object[] obj = new Object[10];
                obj[0] = res.getString("gajiID");
                obj[1] = res.getString("tgl");
                obj[2] = res.getString("nama");
                obj[3] = res.getString("jabatan");
                obj[4] = res.getString("golongan");
                obj[5] = res.getString("gapok");
                obj[6] = res.getString("gaji_lembur");
                obj[7] = res.getString("tunjangan");
                obj[8] = res.getString("potongan");
                obj[9] = res.getString("gaji_bersih");
                model.addRow(obj);
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    public void loadData(){
        vNm = nm.getText();
        String tampilan ="yyyy-MM-dd" ; 
        SimpleDateFormat fm = new SimpleDateFormat(tampilan); 
        vTgl = tg.getDate() != null ? String.valueOf(fm.format(tg.getDate())) : "";
        vGp = Integer.parseInt(gp.getText());
        vGl = Integer.parseInt(gl.getText());
        vT = Integer.parseInt(tj.getText());
        vP = Integer.parseInt(pt.getText());
        vGb = (vGp+vGl+vT) - vP;
        vJbt = jbt.getText();
        vGol = gol.getText();
    }
    public void save(){
        loadData();
        try{
        st = (Statement)koneksi.getKoneksi().createStatement();
        String sql = "Insert into penggajian (tgl,nama,jabatan,golongan,gapok,gaji_lembur,tunjangan,potongan,gaji_bersih)"
                +" values ('"+vTgl+"','"+vNm+"','"+vJbt+"','"+vGol+"','"+vGp+"','"+vGl+"','"+vT+"','"+vP+"','"+vGb+"')";
            System.out.println(sql);
        PreparedStatement p = (PreparedStatement)koneksi.getKoneksi().prepareStatement(sql);
        p.executeUpdate(sql);
        getData();
        reset();
        nm.requestFocus();
        JOptionPane.showMessageDialog(null, "Data Berhasil DiSimpan!");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Data Gagal DiSimpan! : " + err.getMessage());
            reset();
        }
    }
    public void reset(){
        vId = 0;
        vNm  = "";
        vTgl = "";
        vGp  = 0;
        vGl  = 0;
        vT  = 0;
        vP  = 0;
        vGb  = 0;
        vJbt = "";
        vGol = "";
        nm.setText(null);
        tg.setDate(null);
        jbt.setText(null);
        gol.setText(null);
        gp.setText(null);
        gl.setText(null);
        tj.setText(null);
        pt.setText(null);
    }
    public void selectData(){
        int i = tbl.getSelectedRow();
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Tidak ada data terpilih!");
            return;
        }
        nm.setText(""+model.getValueAt(i, 2));
         try {
            int index = tbl.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(index, 1));
            tg.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Karyawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        jbt.setText(""+model.getValueAt(i, 3));
        gol.setText(""+model.getValueAt(i, 4));
        gp.setText(""+model.getValueAt(i, 5));
        gl.setText(""+model.getValueAt(i, 6));
        tj.setText(""+model.getValueAt(i, 7));
        pt.setText(""+model.getValueAt(i, 8));
        vGb = Integer.valueOf(""+model.getValueAt(i, 9));
        vId = Integer.valueOf(""+model.getValueAt(i, 0));
    }
    public void update(){
        loadData();
        try{
           st = (Statement)koneksi.getKoneksi().createStatement();
           String sql = "update penggajian set tgl = '"+vTgl+"',"
                   + "nama='"+vNm+"',"
                   + "jabatan='"+vJbt+"',"
                   + "golongan='"+vGol+"',"
                   + "gapok='"+vGp+"',"
                   + "gaji_lembur='"+vGl+"',"
                   + "tunjangan='"+vT+"',"
                   + "potongan='"+vP+"',"
                   + "gaji_bersih='"+vGb+"' where gajiID='"+vId+"'";
        PreparedStatement p = (PreparedStatement)koneksi.getKoneksi().prepareStatement(sql);
        p.executeUpdate();
        getData();
        reset();
        nm.requestFocus();
        JOptionPane.showMessageDialog(null, "Data Berhasil DiUpdate");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Data Gagal DiUpdate!");
            reset();
        }
    }
    public void delete(){
        //loadData();
        int psn = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data ini?","Konfirmasi",
                JOptionPane.OK_CANCEL_OPTION);
        if(psn == JOptionPane.OK_OPTION){
            try{
                st = (Statement) koneksi.getKoneksi().createStatement();
                String sql = "Delete From penggajian Where gajiID='"+vId+"'";
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
    }
    
    public void kalkulasiKomponenPenggajian() {
        if (tg.getDate() != null && nmKry != null) {
            String tampilan ="yyyy-MM-dd" ; 
            SimpleDateFormat fm = new SimpleDateFormat(tampilan); 
            vTgl = tg.getDate() != null ? fm.format(tg.getDate()) : fm.format(new Date());
            vLembur = queryLembur();
            vPotongan = queryPotongan();
            vTunjangan = queryTunjangan();

            gl.setText(vLembur + "");
            tj.setText(vTunjangan + "");
            pt.setText((vPotongan + vDenda) + "");
            
            bLembur.setEnabled(true);
            bTunjangan.setEnabled(true);
            bPotongan.setEnabled(true);
            periksaTombol();
            
        }
    }
    
    private void periksaTombol() {
     String gptxt = gp.getText();
        if (!gptxt.equals("") && nmKry != null) {
          try {
              Integer.parseInt(gptxt);
              bKehadiran.setEnabled(true);
          }
          catch (NumberFormatException err) {
            bKehadiran.setEnabled(false);
          }
        }
        else {
          bKehadiran.setEnabled(false);
        }
    }
    
    public void itemTerpilih(){                              
        Data_Search2 DS = new Data_Search2();
        DS.fP = this;
        nm.setText(nmKry);
        jbt.setText(jbtKry);
        gol.setText(golKry);
        gl.setText(String.valueOf(lmb));
        kalkulasiKomponenPenggajian();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nm = new javax.swing.JTextField();
        jbt = new javax.swing.JTextField();
        gol = new javax.swing.JTextField();
        gp = new javax.swing.JTextField();
        gl = new javax.swing.JTextField();
        tj = new javax.swing.JTextField();
        pt = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        del = new javax.swing.JButton();
        upd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        tg = new com.toedter.calendar.JDateChooser();
        jButton6 = new javax.swing.JButton();
        bLembur = new javax.swing.JButton();
        bPotongan = new javax.swing.JButton();
        bTunjangan = new javax.swing.JButton();
        bKehadiran = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cr = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        ktg = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Form Penggajian");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Tanggal Gaji");

        jLabel3.setText("Nama");

        jLabel4.setText("Jabatan");

        jLabel5.setText("Golongan");

        jLabel6.setText("Gaji Pokok");

        jLabel7.setText("Gaji Lembur");

        jLabel8.setText("Tunjangan");

        jLabel9.setText("Potongan");

        gp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gpActionPerformed(evt);
            }
        });
        gp.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                gpPropertyChange(evt);
            }
        });
        gp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gpKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gpKeyReleased(evt);
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

        del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Delete.gif"))); // NOI18N
        del.setText("Hapus");
        del.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        del.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Save.gif"))); // NOI18N
        jButton1.setText("Simpan");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tg.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgPropertyChange(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Text preview.gif"))); // NOI18N
        jButton6.setText("Cari Karyawan");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        bLembur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Text preview.gif"))); // NOI18N
        bLembur.setText("Detail Lembur");
        bLembur.setEnabled(false);
        bLembur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLemburActionPerformed(evt);
            }
        });

        bPotongan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Text preview.gif"))); // NOI18N
        bPotongan.setText("Detail Potongan");
        bPotongan.setEnabled(false);
        bPotongan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPotonganActionPerformed(evt);
            }
        });

        bTunjangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Text preview.gif"))); // NOI18N
        bTunjangan.setText("Detail Tunjangan");
        bTunjangan.setEnabled(false);
        bTunjangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTunjanganActionPerformed(evt);
            }
        });

        bKehadiran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Text preview.gif"))); // NOI18N
        bKehadiran.setText("Periksa Kehadiran");
        bKehadiran.setEnabled(false);
        bKehadiran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bKehadiranActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gol, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(del)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(gp, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addComponent(gl, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tj, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bKehadiran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(28, 28, 28))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bTunjangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bPotongan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bLembur))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(bKehadiran)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jbt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(bTunjangan))
                                .addGap(14, 14, 14)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bPotongan))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1)
                                        .addComponent(del))
                                    .addComponent(upd, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(gol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(gl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bLembur))
                        .addContainerGap())))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/View.gif"))); // NOI18N
        jButton5.setText("Cari");
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        ktg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nama", "jabatan", "gaji_bersih" }));
        ktg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ktgActionPerformed(evt);
            }
        });

        jLabel11.setText("Kategori");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/Refresh.gif"))); // NOI18N
        jButton7.setText("Segarkan");
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ktg, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cr, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ktg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        selectData();
        upd.setEnabled(true);
        del.setEnabled(true);
        jButton1.setEnabled(false);
    }//GEN-LAST:event_tblMouseClicked

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
        int konf = JOptionPane.showConfirmDialog(null, "Yakin Ingin menutup Form?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if(konf == JOptionPane.YES_OPTION){
            this.dispose();
        }  
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        cr.setText(null);
        getData();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        getData();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Data_Search2 DS = new Data_Search2();
        DS.fP = this;
        DS.setVisible(true);
        DS.setResizable(false);
        gp.requestFocus();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void bLemburActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLemburActionPerformed
        Data_Search_Lmb DSL = new Data_Search_Lmb(vTgl, vKryId);
        DSL.fP = this;
        DSL.setVisible(true);
        DSL.setResizable(false);
        tj.requestFocus();
    }//GEN-LAST:event_bLemburActionPerformed

    private void ktgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ktgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ktgActionPerformed

    private void crActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crActionPerformed

    private void bPotonganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPotonganActionPerformed
        // TODO add your handling code here:
        (new Data_Search_Potongan(vTgl, vKryId)).setVisible(true);
    }//GEN-LAST:event_bPotonganActionPerformed

    private void bTunjanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTunjanganActionPerformed
        // TODO add your handling code here:
        (new Data_Search_Tunjangan(vTgl, vKryId)).setVisible(true);
    }//GEN-LAST:event_bTunjanganActionPerformed

    private void bKehadiranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bKehadiranActionPerformed
        // TODO add your handling code here:
        Data_Search_Kehadiran f = (new Data_Search_Kehadiran(tg.getDate(), vKryId, Integer.parseInt(gp.getText())));
        f.fP = this;
        f.setVisible(true);
    }//GEN-LAST:event_bKehadiranActionPerformed

    private void tgPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgPropertyChange
        // TODO add your handling code here:
        kalkulasiKomponenPenggajian();
    }//GEN-LAST:event_tgPropertyChange

    private void gpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gpActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_gpActionPerformed

    private void gpPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_gpPropertyChange
        // TODO add your handling code here:
     
    }//GEN-LAST:event_gpPropertyChange

    private void gpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gpKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_gpKeyTyped

    private void gpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gpKeyReleased
        // TODO add your handling code here:
      periksaTombol();
    }//GEN-LAST:event_gpKeyReleased

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
            java.util.logging.Logger.getLogger(Form_Penggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Penggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Penggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Penggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Penggajian().setVisible(true);
            }
        });
    }
    
    private int queryLembur() {
      try{
            st = (Statement) koneksi.getKoneksi().createStatement();
            String sql = "SELECT date_format(tanggal_lembur, '%Y-%m') AS tglbulan, SUM(total) as total_lembur FROM lembur l WHERE karyawanID = " + vId + 
                    " AND date_format(tanggal_lembur, '%Y-%m') = DATE_FORMAT('"+vTgl+"', '%Y-%m') GROUP BY tglbulan";
            System.out.println(sql);
//            String sql = "SELECT SUM(jumlah) as jum FROM potongan t INNER JOIN karyawan k ON k.karyawanID = t.potonganID  WHERE nama = '" + nmKry + "'";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                Object[] obj = new Object[1];
                obj[0] = res.getString("total_lembur");
//                model.addRow(obj);
                gl.setText(res.getString("total_lembur"));
                return res.getInt("total_lembur");
            }
            return 0;
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
            return 0;
        }
    }
    
//    SELECT date_format(tanggal_lembur, '%Y-%m') AS tglbulan, SUM(total) as total_lembur FROM lembur l WHERE karyawanID = 4 GROUP BY tglbulan
    
    private int queryPotongan() {
        try{
            st = (Statement) koneksi.getKoneksi().createStatement();
            String sql = "SELECT SUM(jumlah) as jum FROM potongan t INNER JOIN karyawan k ON k.karyawanID = t.karyawanID WHERE nama = '" + nmKry + "'" +
                    " AND date_format(tanggal, '%Y-%m') = DATE_FORMAT('"+vTgl+"', '%Y-%m')";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                Object[] obj = new Object[1];
                obj[0] = res.getString("jum");
//                model.addRow(obj);
                pt.setText(res.getString("jum"));
                return res.getInt("jum");
            }
            return 0;
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
            return 0;
        }
    }
    
    private int queryTunjangan() {
        try{
            st = (Statement) koneksi.getKoneksi().createStatement();
            String sql = "SELECT SUM(jumlah) as jum FROM tunjangan t INNER JOIN karyawan k ON k.karyawanID = t.karyawanID WHERE nama = '" + nmKry + "'" +
                    " AND date_format(tanggal, '%Y-%m') = DATE_FORMAT('"+vTgl+"', '%Y-%m')";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                Object[] obj = new Object[1];
                obj[0] = res.getString("jum");
//                model.addRow(obj);
                tj.setText(res.getString("jum"));
                return res.getInt("jum");
            }
            return 0;
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
            return 0;
        }
    }
    
//   private updateTglBln() {
//        vNm = tg.getDate();
//        String tampilan ="yyyy-MM-" ; 
//        SimpleDateFormat fm = new SimpleDateFormat(tampilan); 
//   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bKehadiran;
    private javax.swing.JButton bLembur;
    private javax.swing.JButton bPotongan;
    private javax.swing.JButton bTunjangan;
    private javax.swing.JTextField cr;
    private javax.swing.JButton del;
    private javax.swing.JTextField gl;
    private javax.swing.JTextField gol;
    private javax.swing.JTextField gp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jbt;
    private javax.swing.JComboBox<String> ktg;
    private javax.swing.JTextField nm;
    private javax.swing.JTextField pt;
    private javax.swing.JTable tbl;
    private com.toedter.calendar.JDateChooser tg;
    private javax.swing.JTextField tj;
    private javax.swing.JButton upd;
    // End of variables declaration//GEN-END:variables

   private void Seticon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icon/gif/16x16/dktbig.gif")));
    }
}
