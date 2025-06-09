/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import SQL.ConexionDB;
import SQL.Cuenta;
import Utilidades.DecimalDocumentFilter;
import Utilidades.LongitudDocumentFilter;
import Utilidades.SoloLetrasDocumentFilter;
import Utilidades.ValidadorCampos;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




/**
 *
 * @author Kleber
 */
public class frmActualizarCuenta extends javax.swing.JFrame {
    int xMouse, yMouse;
 

    public frmActualizarCuenta() {
        initComponents();

       //Activar las validaciones.
        ((AbstractDocument) this.txtCapitalAct.getDocument()).setDocumentFilter(new DecimalDocumentFilter(10,2));
        ((AbstractDocument) this.txtNombreAct.getDocument()).setDocumentFilter(new SoloLetrasDocumentFilter(20));
        ((AbstractDocument) this.txtApellidoPaternoAct.getDocument()).setDocumentFilter(new SoloLetrasDocumentFilter(20));
        ((AbstractDocument) this.txtApellidoMaternoAct.getDocument()).setDocumentFilter(new SoloLetrasDocumentFilter(20));
        ((AbstractDocument) this.txtEmailAct.getDocument()).setDocumentFilter(new LongitudDocumentFilter(100)); 
        ((AbstractDocument) this.txtId.getDocument()).setDocumentFilter(new DecimalDocumentFilter(10, 2));
    }

    private void reiniciarCampos() {
    
    txtId.setText("");

    txtNombreAct.setText("Ingrese su Nombre:");
    txtNombreAct.setForeground(Color.GRAY);
    
    txtApellidoPaternoAct.setText("Ingrese su Apellido Paterno:");
    txtApellidoPaternoAct.setForeground(Color.GRAY);
    
    txtApellidoMaternoAct.setText("Ingrese su Apellido Materno:");
    txtApellidoMaternoAct.setForeground(Color.GRAY);
    
    txtEmailAct.setText("Ingrese su Correo Electrónico:");
    txtEmailAct.setForeground(Color.GRAY);
    
    txtCapitalAct.setText("Ingrese su Capital:");
    txtCapitalAct.setForeground(Color.GRAY);
   
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frmFondo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPHeader = new javax.swing.JPanel();
        btnExit = new javax.swing.JPanel();
        btnTxtExit = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNombreAct = new javax.swing.JLabel();
        txtCapitalAct = new javax.swing.JTextField();
        spCapitalAct = new javax.swing.JSeparator();
        lblCapitalAct = new javax.swing.JLabel();
        txtNombreAct = new javax.swing.JTextField();
        spNombreAct = new javax.swing.JSeparator();
        lblApellidoPaternoAct = new javax.swing.JLabel();
        spApellidoPaternoAct = new javax.swing.JSeparator();
        txtApellidoPaternoAct = new javax.swing.JTextField();
        lblApellidoMaternoAct = new javax.swing.JLabel();
        txtApellidoMaternoAct = new javax.swing.JTextField();
        spApellidoMaternoAct = new javax.swing.JSeparator();
        lblEmailAct = new javax.swing.JLabel();
        txtEmailAct = new javax.swing.JTextField();
        spEmailAct = new javax.swing.JSeparator();
        btnCancelarAct = new javax.swing.JPanel();
        lblCancelarAct = new javax.swing.JLabel();
        btnActualizarC = new javax.swing.JPanel();
        lblActualizar = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        iblId = new javax.swing.JButton();
        lblIDAct = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        frmFondo.setBackground(new java.awt.Color(255, 255, 255));
        frmFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ChatGPT_Image_5_jun_2025__18_18_51-removebg-preview.png"))); // NOI18N
        frmFondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 150, 150));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KLEBER DELETED ACOUNT");
        frmFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 300, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 204));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mango.jpeg"))); // NOI18N
        frmFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 820));

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );

        frmFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPHeader.setBackground(new java.awt.Color(255, 255, 255));
        jPHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPHeaderMouseDragged(evt);
            }
        });
        jPHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPHeaderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPHeaderMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPHeaderMousePressed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });

        btnTxtExit.setBackground(new java.awt.Color(255, 255, 255));
        btnTxtExit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnTxtExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtExit.setText("X");
        btnTxtExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnExitLayout = new javax.swing.GroupLayout(btnExit);
        btnExit.setLayout(btnExitLayout);
        btnExitLayout.setHorizontalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTxtExit, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        btnExitLayout.setVerticalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTxtExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPHeaderLayout = new javax.swing.GroupLayout(jPHeader);
        jPHeader.setLayout(jPHeaderLayout);
        jPHeaderLayout.setHorizontalGroup(
            jPHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPHeaderLayout.createSequentialGroup()
                .addContainerGap(644, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPHeaderLayout.setVerticalGroup(
            jPHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        frmFondo.add(jPHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 720, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel4.setText("Actualizacion de Cuentas");
        frmFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        lblNombreAct.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblNombreAct.setText("Nombre:");
        frmFondo.add(lblNombreAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        txtCapitalAct.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCapitalAct.setForeground(new java.awt.Color(102, 102, 102));
        txtCapitalAct.setText("Ingrese su Capital:");
        txtCapitalAct.setBorder(null);
        txtCapitalAct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCapitalActMousePressed(evt);
            }
        });
        txtCapitalAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapitalActActionPerformed(evt);
            }
        });
        frmFondo.add(txtCapitalAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, 450, -1));

        spCapitalAct.setBackground(new java.awt.Color(0, 0, 0));
        frmFondo.add(spCapitalAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, 450, 10));

        lblCapitalAct.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblCapitalAct.setText("Capital:");
        frmFondo.add(lblCapitalAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 490, -1, 40));

        txtNombreAct.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtNombreAct.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreAct.setText("Ingrese su Nombre:");
        txtNombreAct.setBorder(null);
        txtNombreAct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreActMousePressed(evt);
            }
        });
        txtNombreAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActActionPerformed(evt);
            }
        });
        frmFondo.add(txtNombreAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 450, -1));

        spNombreAct.setBackground(new java.awt.Color(0, 0, 0));
        frmFondo.add(spNombreAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 450, 10));

        lblApellidoPaternoAct.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblApellidoPaternoAct.setText("Apellido Paterno:");
        frmFondo.add(lblApellidoPaternoAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, -1, 40));

        spApellidoPaternoAct.setBackground(new java.awt.Color(0, 0, 0));
        frmFondo.add(spApellidoPaternoAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 450, 10));

        txtApellidoPaternoAct.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtApellidoPaternoAct.setForeground(new java.awt.Color(102, 102, 102));
        txtApellidoPaternoAct.setText("Ingrese su Apellido Paterno:");
        txtApellidoPaternoAct.setBorder(null);
        txtApellidoPaternoAct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtApellidoPaternoActMousePressed(evt);
            }
        });
        txtApellidoPaternoAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPaternoActActionPerformed(evt);
            }
        });
        frmFondo.add(txtApellidoPaternoAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 450, -1));

        lblApellidoMaternoAct.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblApellidoMaternoAct.setText("Apellido Materno:");
        frmFondo.add(lblApellidoMaternoAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, -1, 40));

        txtApellidoMaternoAct.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtApellidoMaternoAct.setForeground(new java.awt.Color(102, 102, 102));
        txtApellidoMaternoAct.setText("Ingrese su Apellido Materno:");
        txtApellidoMaternoAct.setBorder(null);
        txtApellidoMaternoAct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtApellidoMaternoActMousePressed(evt);
            }
        });
        txtApellidoMaternoAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMaternoActActionPerformed(evt);
            }
        });
        frmFondo.add(txtApellidoMaternoAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 450, -1));

        spApellidoMaternoAct.setBackground(new java.awt.Color(0, 0, 0));
        frmFondo.add(spApellidoMaternoAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 450, 10));

        lblEmailAct.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblEmailAct.setText("Email:");
        frmFondo.add(lblEmailAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, -1, 40));

        txtEmailAct.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtEmailAct.setForeground(new java.awt.Color(102, 102, 102));
        txtEmailAct.setText("Ingrese su Correo Electrónico:");
        txtEmailAct.setBorder(null);
        txtEmailAct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEmailActMousePressed(evt);
            }
        });
        txtEmailAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActActionPerformed(evt);
            }
        });
        frmFondo.add(txtEmailAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 450, -1));

        spEmailAct.setBackground(new java.awt.Color(0, 0, 0));
        frmFondo.add(spEmailAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 450, 10));

        btnCancelarAct.setBackground(new java.awt.Color(255, 186, 21));
        btnCancelarAct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarActMouseClicked(evt);
            }
        });

        lblCancelarAct.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblCancelarAct.setForeground(new java.awt.Color(255, 255, 255));
        lblCancelarAct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCancelarAct.setText("Cancelar");
        lblCancelarAct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btnCancelarActLayout = new javax.swing.GroupLayout(btnCancelarAct);
        btnCancelarAct.setLayout(btnCancelarActLayout);
        btnCancelarActLayout.setHorizontalGroup(
            btnCancelarActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCancelarAct, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        btnCancelarActLayout.setVerticalGroup(
            btnCancelarActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCancelarAct, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        frmFondo.add(btnCancelarAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 680, 130, 50));

        btnActualizarC.setBackground(new java.awt.Color(255, 186, 21));
        btnActualizarC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarCMouseClicked(evt);
            }
        });

        lblActualizar.setBackground(new java.awt.Color(255, 255, 255));
        lblActualizar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblActualizar.setForeground(new java.awt.Color(255, 255, 255));
        lblActualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblActualizar.setText("Actualizar");
        lblActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblActualizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblActualizarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnActualizarCLayout = new javax.swing.GroupLayout(btnActualizarC);
        btnActualizarC.setLayout(btnActualizarCLayout);
        btnActualizarCLayout.setHorizontalGroup(
            btnActualizarCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        btnActualizarCLayout.setVerticalGroup(
            btnActualizarCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        frmFondo.add(btnActualizarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 680, 130, 50));

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        frmFondo.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 270, 30));

        iblId.setBackground(new java.awt.Color(0, 0, 255));
        iblId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        iblId.setForeground(new java.awt.Color(255, 255, 255));
        iblId.setText("Buscar");
        iblId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iblIdActionPerformed(evt);
            }
        });
        frmFondo.add(iblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, -1, -1));

        lblIDAct.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblIDAct.setText("ID:");
        frmFondo.add(lblIDAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 47, 64));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frmFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frmFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCapitalActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapitalActActionPerformed
    }//GEN-LAST:event_txtCapitalActActionPerformed

    private void txtNombreActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActActionPerformed
    }//GEN-LAST:event_txtNombreActActionPerformed

    private void txtApellidoPaternoActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPaternoActActionPerformed
    }//GEN-LAST:event_txtApellidoPaternoActActionPerformed

    private void txtApellidoMaternoActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMaternoActActionPerformed
    }//GEN-LAST:event_txtApellidoMaternoActActionPerformed

    private void txtEmailActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActActionPerformed
    }//GEN-LAST:event_txtEmailActActionPerformed

    private void jPHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPHeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPHeaderMousePressed

    private void jPHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPHeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPHeaderMouseDragged

    private void btnTxtExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtExitMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnTxtExitMouseClicked

    private void jPHeaderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPHeaderMouseEntered
        btnExit.setBackground(Color.RED);
        btnTxtExit.setBackground(Color.WHITE);
    }//GEN-LAST:event_jPHeaderMouseEntered

    private void jPHeaderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPHeaderMouseExited
        btnExit.setBackground(Color.WHITE);
        btnTxtExit.setBackground(Color.BLACK);
    }//GEN-LAST:event_jPHeaderMouseExited

    private void lblActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblActualizarMouseEntered
        btnActualizarC.setBackground(Color.ORANGE);
    }//GEN-LAST:event_lblActualizarMouseEntered

    private void lblActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblActualizarMouseExited
        btnActualizarC.setBackground(new Color(255, 186, 21));
    }//GEN-LAST:event_lblActualizarMouseExited

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(Color.RED);
        btnTxtExit.setBackground(Color.WHITE);
    }//GEN-LAST:event_btnExitMouseExited

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(Color.WHITE);
        btnTxtExit.setBackground(Color.BLACK);
    }//GEN-LAST:event_btnExitMouseEntered

    private void txtNombreActMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreActMousePressed
       if(txtNombreAct.getText().equals("Ingrese su Nombre:")){
        txtNombreAct.setText("");
        txtNombreAct.setForeground(Color.BLACK);
       }
       if(txtApellidoPaternoAct.getText().equals("Ingrese su Apellido Paterno:")){
        txtApellidoPaternoAct.setText("Ingrese su Apellido Paterno:");
        txtApellidoPaternoAct.setForeground(Color.gray);
       }
       if(txtApellidoMaternoAct.getText().equals("Ingrese su Apellido Materno:")){
        txtApellidoMaternoAct.setText("Ingrese su Apellido Materno:");
        txtApellidoMaternoAct.setForeground(Color.gray);
       }
       if(txtEmailAct.getText().equals("Ingrese su Correo Electrónico:")){
        txtEmailAct.setText("Ingrese su Correo Electrónico:");
        txtEmailAct.setForeground(Color.gray);
       }
       if(txtCapitalAct.getText().equals("Ingrese su Capital:")){
        txtCapitalAct.setText("Ingrese su Capital:"); 
        txtCapitalAct.setForeground(Color.gray);
       }    
    }//GEN-LAST:event_txtNombreActMousePressed

    private void txtApellidoPaternoActMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoPaternoActMousePressed
       if(txtNombreAct.getText().equals("Ingrese su Nombre:")){
        txtNombreAct.setText("Ingrese su Nombre:");
        txtNombreAct.setForeground(Color.BLACK);
       }
       if(txtApellidoPaternoAct.getText().equals("Ingrese su Apellido Paterno:")){
        txtApellidoPaternoAct.setText("");
        txtApellidoPaternoAct.setForeground(Color.black);
       }
       if(txtApellidoMaternoAct.getText().equals("Ingrese su Apellido Materno:")){
        txtApellidoMaternoAct.setText("Ingrese su Apellido Materno:");
        txtApellidoMaternoAct.setForeground(Color.gray);
       }
       if(txtEmailAct.getText().equals("Ingrese su Correo Electrónico:")){
        txtEmailAct.setText("Ingrese su Correo Electrónico:");
        txtEmailAct.setForeground(Color.gray);
       }
       if(txtCapitalAct.getText().equals("Ingrese su Capital:")){
        txtCapitalAct.setText("Ingrese su Capital:"); 
        txtCapitalAct.setForeground(Color.gray);
       }   
    }//GEN-LAST:event_txtApellidoPaternoActMousePressed

    private void txtApellidoMaternoActMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoMaternoActMousePressed
       if(txtNombreAct.getText().equals("Ingrese su Nombre:")){
        txtNombreAct.setText("Ingrese su Nombre:");
        txtNombreAct.setForeground(Color.gray);
       }
       if(txtApellidoPaternoAct.getText().equals("Ingrese su Apellido Paterno:")){
        txtApellidoPaternoAct.setText("Ingrese su Apellido Paterno:");
        txtApellidoPaternoAct.setForeground(Color.gray);
       }
       if(txtApellidoMaternoAct.getText().equals("Ingrese su Apellido Materno:")){
        txtApellidoMaternoAct.setText("");
        txtApellidoMaternoAct.setForeground(Color.BLACK);
       }
       if(txtEmailAct.getText().equals("Ingrese su Correo Electrónico:")){
        txtEmailAct.setText("Ingrese su Correo Electrónico:");
        txtEmailAct.setForeground(Color.gray);
       }
       if(txtCapitalAct.getText().equals("Ingrese su Capital:")){
        txtCapitalAct.setText("Ingrese su Capital:"); 
        txtCapitalAct.setForeground(Color.gray);
       }  
    }//GEN-LAST:event_txtApellidoMaternoActMousePressed



    
    private void txtEmailActMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailActMousePressed
       if(txtNombreAct.getText().equals("Ingrese su Nombre:")){
        txtNombreAct.setText("Ingrese su Nombre:");
        txtNombreAct.setForeground(Color.gray);
       }
       if(txtApellidoPaternoAct.getText().equals("Ingrese su Apellido Paterno:")){
        txtApellidoPaternoAct.setText("Ingrese su Apellido Paterno:");
        txtApellidoPaternoAct.setForeground(Color.gray);
       }
       if(txtApellidoMaternoAct.getText().equals("Ingrese su Apellido Materno:")){
        txtApellidoMaternoAct.setText("Ingrese su Apellido Materno:");
        txtApellidoMaternoAct.setForeground(Color.gray);
       }
       if(txtEmailAct.getText().equals("Ingrese su Correo Electrónico:")){
        txtEmailAct.setText("");
        txtEmailAct.setForeground(Color.BLACK);
       }
       if(txtCapitalAct.getText().equals("Ingrese su Capital:")){
        txtCapitalAct.setText("Ingrese su Capital:"); 
        txtCapitalAct.setForeground(Color.gray);
       }
    }//GEN-LAST:event_txtEmailActMousePressed

    private void txtCapitalActMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCapitalActMousePressed
       if(txtNombreAct.getText().equals("Ingrese su Nombre:")){
        txtNombreAct.setText("Ingrese su Nombre:");
        txtNombreAct.setForeground(Color.gray);
       }
       if(txtApellidoPaternoAct.getText().equals("Ingrese su Apellido Paterno:")){
        txtApellidoPaternoAct.setText("Ingrese su Apellido Paterno:");
        txtApellidoPaternoAct.setForeground(Color.gray);
       }
       if(txtApellidoMaternoAct.getText().equals("Ingrese su Apellido Materno:")){
        txtApellidoMaternoAct.setText("Ingrese su Apellido Materno:");
        txtApellidoMaternoAct.setForeground(Color.gray);
       }
       if(txtEmailAct.getText().equals("Ingrese su Correo Electrónico:")){
        txtEmailAct.setText("Ingrese su Correo Electrónico:");
        txtEmailAct.setForeground(Color.gray);
       }
       if(txtCapitalAct.getText().equals("Ingrese su Capital:")){
        txtCapitalAct.setText(""); 
        txtCapitalAct.setForeground(Color.BLACK);
       }    
    }//GEN-LAST:event_txtCapitalActMousePressed



    
    private void lblActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblActualizarMouseClicked
    if(txtNombreAct.getText().trim().isEmpty() || txtNombreAct.getText().equals("Ingrese su Nombre:") ||
       txtApellidoPaternoAct.getText().trim().isEmpty() || txtApellidoPaternoAct.getText().equals("Ingrese su Apellido Paterno:") ||
       txtApellidoMaternoAct.getText().trim().isEmpty() || txtApellidoMaternoAct.getText().equals("Ingrese su Apellido Materno:") ||
       txtEmailAct.getText().trim().isEmpty() || txtEmailAct.getText().equals("Ingrese su Correo Electrónico:") ||
       txtCapitalAct.getText().trim().isEmpty() || txtCapitalAct.getText().equals("Ingrese su Capital:")) {
        
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Actualizar cuenta", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (!ValidadorCampos.esEmailValido(txtEmailAct.getText().trim())) {
       JOptionPane.showMessageDialog(this, "Email inválido.", "Actualizar cuenta", JOptionPane.ERROR_MESSAGE);
       txtEmailAct.requestFocus();
       txtEmailAct.selectAll();
       return;
    }
    double capital;
    try {
        capital = Double.parseDouble(txtCapitalAct.getText().trim());
    } catch(NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "El capital debe ser un número válido.", "Actualizar cuenta", JOptionPane.ERROR_MESSAGE);
        txtCapitalAct.requestFocus();
        txtCapitalAct.selectAll();
        return;
    }
    int idCuenta;
    try {
        idCuenta = Integer.parseInt(txtId.getText().trim());
    } catch(NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "El ID de la cuenta no es válido.", "Actualizar cuenta", JOptionPane.ERROR_MESSAGE);
        txtId.requestFocus();
        txtId.selectAll();
        return;
    }
    Cuenta cuenta = new Cuenta();
    cuenta.setIdCuenta(idCuenta);
    cuenta.setNombre(txtNombreAct.getText().trim());
    cuenta.setApellidoPaterno(txtApellidoPaternoAct.getText().trim());
    cuenta.setApellidoMaterno(txtApellidoMaternoAct.getText().trim());
    cuenta.setEmail(txtEmailAct.getText().trim());
    cuenta.setCapital(capital);
    
    if (cuenta.actualizar()) {
        JOptionPane.showMessageDialog(this, "Cuenta actualizada exitosamente.", "Actualizar cuenta", JOptionPane.INFORMATION_MESSAGE);
        reiniciarCampos(); 
    } else {
        JOptionPane.showMessageDialog(this, "Ocurrió un error al actualizar la cuenta.", "Actualizar cuenta", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_lblActualizarMouseClicked

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
         //
    }//GEN-LAST:event_txtIdActionPerformed

    private void iblIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iblIdActionPerformed
    if (txtId.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID para buscar.", "Buscar cuenta", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int idBusqueda;
    try {
        idBusqueda = Integer.parseInt(txtId.getText().trim());
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "El ID ingresado no es válido.", "Buscar cuenta", JOptionPane.ERROR_MESSAGE);
        txtId.requestFocus();
        txtId.selectAll();
        return;
    }
    Cuenta cuenta = new Cuenta();
    cuenta.setIdCuenta(idBusqueda);

    if (cuenta.buscar()) { // Este método debe asignar los valores a los atributos del objeto.
        txtNombreAct.setText(cuenta.getNombre());
        txtApellidoPaternoAct.setText(cuenta.getApellidoPaterno());
        txtApellidoMaternoAct.setText(cuenta.getApellidoMaterno());
        txtEmailAct.setText(cuenta.getEmail());
        txtCapitalAct.setText(String.valueOf(cuenta.getCapital()));
    } else {
        JOptionPane.showMessageDialog(this, "Cuenta no encontrada.", "Buscar cuenta", JOptionPane.ERROR_MESSAGE);
    }
    
    }//GEN-LAST:event_iblIdActionPerformed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
            this.dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnCancelarActMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarActMouseClicked
        reiniciarCampos();
    }//GEN-LAST:event_btnCancelarActMouseClicked

    private void btnActualizarCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarCMouseClicked
    // 1. Validar que los campos no estén vacíos ni tengan el texto por defecto
    if(txtNombreAct.getText().trim().isEmpty() || txtNombreAct.getText().equals("Ingrese su Nombre:") ||
       txtApellidoPaternoAct.getText().trim().isEmpty() || txtApellidoPaternoAct.getText().equals("Ingrese su Apellido Paterno:") ||
       txtApellidoMaternoAct.getText().trim().isEmpty() || txtApellidoMaternoAct.getText().equals("Ingrese su Apellido Materno:") ||
       txtEmailAct.getText().trim().isEmpty() || txtEmailAct.getText().equals("Ingrese su Correo Electrónico:") ||
       txtCapitalAct.getText().trim().isEmpty() || txtCapitalAct.getText().equals("Ingrese su Capital:")) {
        
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Actualizar cuenta", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // 2. Validar el formato del email
    if (!ValidadorCampos.esEmailValido(txtEmailAct.getText().trim())) {
       JOptionPane.showMessageDialog(this, "Email inválido.", "Actualizar cuenta", JOptionPane.ERROR_MESSAGE);
       txtEmailAct.requestFocus();
       txtEmailAct.selectAll();
       return;
    }
    
    // 3. Convertir el campo de capital a número
    double capital;
    try {
        capital = Double.parseDouble(txtCapitalAct.getText().trim());
    } catch(NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "El capital debe ser un número válido.", "Actualizar cuenta", JOptionPane.ERROR_MESSAGE);
        txtCapitalAct.requestFocus();
        txtCapitalAct.selectAll();
        return;
    }
    
    // 4. Obtener el ID de la cuenta a actualizar (asegúrate de que este campo tenga el valor correcto)
    int idCuenta;
    try {
        idCuenta = Integer.parseInt(txtId.getText().trim());
    } catch(NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "El ID de la cuenta no es válido.", "Actualizar cuenta", JOptionPane.ERROR_MESSAGE);
        txtId.requestFocus();
        txtId.selectAll();
        return;
    }
    
    // 5. Configurar el objeto Cuenta con los datos ingresados
    Cuenta cuenta = new Cuenta();
    cuenta.setIdCuenta(idCuenta);
    cuenta.setNombre(txtNombreAct.getText().trim());
    cuenta.setApellidoPaterno(txtApellidoPaternoAct.getText().trim());
    cuenta.setApellidoMaterno(txtApellidoMaternoAct.getText().trim());
    cuenta.setEmail(txtEmailAct.getText().trim());
    cuenta.setCapital(capital);
    
    // 6. Intentar actualizar la cuenta usando la lógica de negocio en la clase Cuenta
    if (cuenta.actualizar()) {
        JOptionPane.showMessageDialog(this, "Cuenta actualizada exitosamente.", "Actualizar cuenta", JOptionPane.INFORMATION_MESSAGE);
        reiniciarCampos(); // Opcional: limpia los campos tras una actualización exitosa.
    } else {
        JOptionPane.showMessageDialog(this, "Ocurrió un error al actualizar la cuenta.", "Actualizar cuenta", JOptionPane.ERROR_MESSAGE);
    }        
    }//GEN-LAST:event_btnActualizarCMouseClicked

 
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(() -> {
            new frmActualizarCuenta().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnActualizarC;
    private javax.swing.JPanel btnCancelarAct;
    private javax.swing.JPanel btnExit;
    private javax.swing.JLabel btnTxtExit;
    private javax.swing.JPanel frmFondo;
    private javax.swing.JButton iblId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPHeader;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblActualizar;
    private javax.swing.JLabel lblApellidoMaternoAct;
    private javax.swing.JLabel lblApellidoPaternoAct;
    private javax.swing.JLabel lblCancelarAct;
    private javax.swing.JLabel lblCapitalAct;
    private javax.swing.JLabel lblEmailAct;
    private javax.swing.JLabel lblIDAct;
    private javax.swing.JLabel lblNombreAct;
    private javax.swing.JSeparator spApellidoMaternoAct;
    private javax.swing.JSeparator spApellidoPaternoAct;
    private javax.swing.JSeparator spCapitalAct;
    private javax.swing.JSeparator spEmailAct;
    private javax.swing.JSeparator spNombreAct;
    private javax.swing.JTextField txtApellidoMaternoAct;
    private javax.swing.JTextField txtApellidoPaternoAct;
    private javax.swing.JTextField txtCapitalAct;
    private javax.swing.JTextField txtEmailAct;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombreAct;
    // End of variables declaration//GEN-END:variables



}