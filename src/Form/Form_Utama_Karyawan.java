/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ramdanirfox
 */
public class Form_Utama_Karyawan extends javax.swing.JFrame {

    /**
     * Creates new form Form_Utama
     */
    public Form_Utama_Karyawan() {
        initComponents();
        Seticon();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width)/2,(screenSize.height-frameSize.height)/2);
        updateInfo();
    }
        MouseListener ml = new MouseAdapter(){
    public void mouseEntered(java.awt.event.MouseEvent evt)
    {            
        Component c = evt.getComponent();                   
        c.setBackground(new Color(255, 64, 64));
    }                                      

    public void mouseExited(java.awt.event.MouseEvent evt)
    {                                      
        Component c = evt.getComponent();
        c.setBackground(new Color(241, 241, 241));
    }
    
};
        MouseListener ml2 = new MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            Component c = evt.getComponent();
            c.setBackground(new Color(127, 255, 212));
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            Component c = evt.getComponent();
            c.setBackground(new Color(241, 241, 241));
        }

    };
            MouseListener ml3 = new MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            Component c = evt.getComponent();
            c.setBackground(new Color(198, 226, 255));
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            Component c = evt.getComponent();
            c.setBackground(new Color(241, 241, 241));
        }

    };
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lapSlipGaji = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        mUtama = new javax.swing.JMenuBar();
        mData = new javax.swing.JMenu();
        dKaryawan = new javax.swing.JMenuItem();
        dLembur = new javax.swing.JMenuItem();
        dPenggajian = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        mLaporan = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        lKaryawan = new javax.swing.JMenuItem();
        lPenggajian = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Menu Utama");
        setBackground(new java.awt.Color(9, 150, 212));
        setLocation(new java.awt.Point(160, 30));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 300));

        jPanel3.setBackground(new java.awt.Color(9, 150, 212));

        jPanel1.setBackground(new java.awt.Color(48, 167, 220));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/icons8-overtime-30.png"))); // NOI18N
        jButton3.setText("Form Lembur");
        jButton3.setToolTipText("Masuk");
        jButton3.setAutoscrolls(true);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setHideActionText(true);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setMaximumSize(new java.awt.Dimension(72, 23));
        jButton3.setName(""); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/icons8-leave-30.png"))); // NOI18N
        jButton5.setText("Form Cuti");
        jButton5.setToolTipText("Masuk");
        jButton5.setAutoscrolls(true);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setHideActionText(true);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setMaximumSize(new java.awt.Dimension(72, 23));
        jButton5.setName(""); // NOI18N
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/icons8-attendance-30.png"))); // NOI18N
        jButton1.setText("Form Absensi");
        jButton1.setToolTipText("Masuk");
        jButton1.setAutoscrolls(true);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHideActionText(true);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setMaximumSize(new java.awt.Dimension(72, 23));
        jButton1.setName(""); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(48, 167, 220));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Laporan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        lapSlipGaji.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lapSlipGaji.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/icons8-print-30.png"))); // NOI18N
        lapSlipGaji.setText("Cetak Slip Gaji");
        lapSlipGaji.setToolTipText("Masuk");
        lapSlipGaji.setAutoscrolls(true);
        lapSlipGaji.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lapSlipGaji.setHideActionText(true);
        lapSlipGaji.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lapSlipGaji.setMaximumSize(new java.awt.Dimension(72, 23));
        lapSlipGaji.setName(""); // NOI18N
        lapSlipGaji.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lapSlipGajiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lapSlipGajiMouseExited(evt);
            }
        });
        lapSlipGaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lapSlipGajiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(lapSlipGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lapSlipGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Selamat Datang");

        user.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        user.setForeground(new java.awt.Color(204, 255, 255));
        user.setText("User");
        user.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton8.setForeground(new java.awt.Color(51, 51, 0));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gif/16x16/icons8-logout-35.png"))); // NOI18N
        jButton8.setText("LOGOUT");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setFocusPainted(false);
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(350, 350, 350))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(user)
                        .addGap(411, 411, 411))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(user)
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(31, 31, 31))
        );

        jLabel1.setText("jLabel1");

        mData.setText("DATA");
        mData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mDataMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mDataMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mDataMouseExited(evt);
            }
        });

        dKaryawan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        dKaryawan.setText("Data Karyawan");
        dKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dKaryawanMouseClicked(evt);
            }
        });
        dKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dKaryawanActionPerformed(evt);
            }
        });
        mData.add(dKaryawan);

        dLembur.setText("Data Lembur");
        dLembur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dLemburMouseClicked(evt);
            }
        });
        dLembur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dLemburActionPerformed(evt);
            }
        });
        mData.add(dLembur);

        dPenggajian.setText("Data Penggajian");
        dPenggajian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dPenggajianMouseClicked(evt);
            }
        });
        dPenggajian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dPenggajianActionPerformed(evt);
            }
        });
        mData.add(dPenggajian);

        jMenuItem1.setText("Data Absensi");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mData.add(jMenuItem1);

        jMenuItem2.setText("Data Cuti");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mData.add(jMenuItem2);

        jMenuItem3.setText("Data Potongan");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mData.add(jMenuItem3);

        jMenuItem4.setText("Data Tunjangan");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mData.add(jMenuItem4);

        mUtama.add(mData);

        mLaporan.setText("LAPORAN");
        mLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mLaporanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mLaporanMouseExited(evt);
            }
        });

        jMenuItem8.setText("Cetak Slip Gaji");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        mLaporan.add(jMenuItem8);

        lKaryawan.setText("Laporan Karyawan");
        lKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lKaryawanActionPerformed(evt);
            }
        });
        mLaporan.add(lKaryawan);

        lPenggajian.setText("Laporan Penggajian");
        lPenggajian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lPenggajianActionPerformed(evt);
            }
        });
        mLaporan.add(lPenggajian);

        jMenuItem5.setText("Laporan Lembur");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        mLaporan.add(jMenuItem5);

        jMenuItem6.setText("Laporan Cuti");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mLaporan.add(jMenuItem6);

        jMenuItem7.setText("Laporan Absen");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        mLaporan.add(jMenuItem7);

        mUtama.add(mLaporan);

        setJMenuBar(mUtama);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dKaryawanActionPerformed
        new Form_Karyawan().setVisible(true);
    }//GEN-LAST:event_dKaryawanActionPerformed

    private void dLemburActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dLemburActionPerformed
        new Form_Lembur().setVisible(true);
    }//GEN-LAST:event_dLemburActionPerformed

    private void dPenggajianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dPenggajianActionPerformed
        new Form_Penggajian().setVisible(true);
    }//GEN-LAST:event_dPenggajianActionPerformed

    private void mDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mDataMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mDataMouseClicked

    private void dKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dKaryawanMouseClicked

    }//GEN-LAST:event_dKaryawanMouseClicked

    private void dLemburMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dLemburMouseClicked

    }//GEN-LAST:event_dLemburMouseClicked

    private void dPenggajianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dPenggajianMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dPenggajianMouseClicked

    private void lKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lKaryawanActionPerformed
        new Lap_Karyawan().setVisible(true);
    }//GEN-LAST:event_lKaryawanActionPerformed

    private void lPenggajianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lPenggajianActionPerformed
        new Lap_Penggajian().setVisible(true);
    }//GEN-LAST:event_lPenggajianActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Form_Kehadiran().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new Form_Lembur().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new Form_Cuti().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       new Form_Tunjangan().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      new Form_Kehadiran().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
      new Form_Cuti().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         new Form_Potongan().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void lapSlipGajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lapSlipGajiActionPerformed
        // TODO add your handling code here:
        new Lap_SlipGaji().setVisible(true);
    }//GEN-LAST:event_lapSlipGajiActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       int i = JOptionPane.showConfirmDialog(null, "Apakah anda yakin Keluar?","Konfrmasi",JOptionPane.YES_NO_OPTION);
       
        if(i==JOptionPane.YES_OPTION){
            this.dispose();
            new Form_Login().setVisible(true); 
             
        }
            
  
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
      jButton8.addMouseListener( ml );
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
        jButton8.addMouseListener( ml );
    }//GEN-LAST:event_jButton8MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
      jButton1.addMouseListener(ml3);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
      jButton1.addMouseListener(ml3);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
       jButton3.addMouseListener(ml3);
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        jButton3.addMouseListener(ml3);
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        jButton5.addMouseListener(ml3);
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
       jButton5.addMouseListener(ml3);
    }//GEN-LAST:event_jButton5MouseExited

    private void lapSlipGajiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lapSlipGajiMouseEntered
        lapSlipGaji.addMouseListener(ml3);
    }//GEN-LAST:event_lapSlipGajiMouseEntered

    private void lapSlipGajiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lapSlipGajiMouseExited
      lapSlipGaji.addMouseListener(ml3);
    }//GEN-LAST:event_lapSlipGajiMouseExited

    private void mDataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mDataMouseEntered
       mData.addMouseListener(ml3);
    }//GEN-LAST:event_mDataMouseEntered

    private void mDataMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mDataMouseExited
        mData.addMouseListener(ml3);
    }//GEN-LAST:event_mDataMouseExited

    private void mLaporanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mLaporanMouseEntered
     mLaporan.addMouseListener(ml3);
    }//GEN-LAST:event_mLaporanMouseEntered

    private void mLaporanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mLaporanMouseExited
   mLaporan.addMouseListener(ml3);
    }//GEN-LAST:event_mLaporanMouseExited

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        new Lap_Lembur().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        new Lap_Cuti().setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        new Lap_Kehadiran().setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
                new Lap_SlipGaji().setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Utama_Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Utama_Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Utama_Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Utama_Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Utama_Karyawan().setVisible(true);
            }
        });
    }
    
    private void updateInfo() {
        user.setText(penggajian_karyawan.Penggajian_Karyawan.getUsername());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem dKaryawan;
    private javax.swing.JMenuItem dLembur;
    private javax.swing.JMenuItem dPenggajian;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenuItem lKaryawan;
    private javax.swing.JMenuItem lPenggajian;
    private javax.swing.JButton lapSlipGaji;
    private javax.swing.JMenu mData;
    private javax.swing.JMenu mLaporan;
    private javax.swing.JMenuBar mUtama;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables

    private void Seticon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icon/gif/16x16/dktbig.gif")));
    }
}