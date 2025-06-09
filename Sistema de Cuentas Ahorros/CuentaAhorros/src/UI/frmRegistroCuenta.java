/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Utilidades.DecimalDocumentFilter;
import Utilidades.LongitudDocumentFilter;
import Utilidades.SoloLetrasDocumentFilter;
import Utilidades.ValidadorCampos;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

import SQL.Cuenta;

/**
 *
 * @author Jesus
 */
public class frmRegistroCuenta extends javax.swing.JFrame {
    int xMouse, yMouse;
 
    public frmRegistroCuenta() {
        initComponents();
       //Activar las validaciones.
        ((AbstractDocument) this.txtCapital.getDocument()).setDocumentFilter(new DecimalDocumentFilter(10,2));
        ((AbstractDocument) this.txtNombre.getDocument()).setDocumentFilter(new SoloLetrasDocumentFilter(20));
        ((AbstractDocument) this.txtApellidoPaterno.getDocument()).setDocumentFilter(new SoloLetrasDocumentFilter(20));
        ((AbstractDocument) this.txtApellidoMaterno.getDocument()).setDocumentFilter(new SoloLetrasDocumentFilter(20));
        ((AbstractDocument) this.txtEmail.getDocument()).setDocumentFilter(new LongitudDocumentFilter(100)); 
    }

    private void reiniciarCampos() {
        txtNombre.setText("Ingrese su Nombre:");
        txtNombre.setForeground(Color.GRAY);
        
        txtApellidoPaterno.setText("Ingrese su Apellido Paterno:");
        txtApellidoPaterno.setForeground(Color.GRAY);
        
        txtApellidoMaterno.setText("Ingrese su Apellido Materno:");
        txtApellidoMaterno.setForeground(Color.GRAY);
        
        txtEmail.setText("Ingrese su Correo Electrónico:");
        txtEmail.setForeground(Color.GRAY);
        
        txtCapital.setText("Ingrese su Capital:");
        txtCapital.setForeground(Color.GRAY);
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
        lblNombre = new javax.swing.JLabel();
        txtCapital = new javax.swing.JTextField();
        spCapital = new javax.swing.JSeparator();
        lblCapital = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        spNombre = new javax.swing.JSeparator();
        lblApellidoPaterno = new javax.swing.JLabel();
        spApellidoPaterno1 = new javax.swing.JSeparator();
        txtApellidoPaterno = new javax.swing.JTextField();
        lblApellidoMaterno = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        spApellidoMaterno1 = new javax.swing.JSeparator();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        spEmail1 = new javax.swing.JSeparator();
        btnCancelar = new javax.swing.JPanel();
        lblCancelar = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JPanel();
        lblGuardar = new javax.swing.JLabel();

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtExitMouseExited(evt);
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
                .addGap(0, 734, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPHeaderLayout.setVerticalGroup(
            jPHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        frmFondo.add(jPHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 40));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 48)); // NOI18N
        jLabel4.setText("REGISTRO CUENTA");
        frmFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, -1));

        lblNombre.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblNombre.setText("Nombre:");
        frmFondo.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        txtCapital.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCapital.setForeground(new java.awt.Color(102, 102, 102));
        txtCapital.setText("Ingrese su Capital:");
        txtCapital.setBorder(null);
        txtCapital.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCapitalMousePressed(evt);
            }
        });
        txtCapital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapitalActionPerformed(evt);
            }
        });
        frmFondo.add(txtCapital, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, 450, -1));

        spCapital.setBackground(new java.awt.Color(0, 0, 0));
        frmFondo.add(spCapital, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, 450, 10));

        lblCapital.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblCapital.setText("Capital:");
        frmFondo.add(lblCapital, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 490, -1, 40));

        txtNombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(102, 102, 102));
        txtNombre.setText("Ingrese su Nombre:");
        txtNombre.setBorder(null);
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreMousePressed(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        frmFondo.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 450, -1));

        spNombre.setBackground(new java.awt.Color(0, 0, 0));
        frmFondo.add(spNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 450, 10));

        lblApellidoPaterno.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblApellidoPaterno.setText("Apellido Paterno:");
        frmFondo.add(lblApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, -1, 40));

        spApellidoPaterno1.setBackground(new java.awt.Color(0, 0, 0));
        frmFondo.add(spApellidoPaterno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 450, 10));

        txtApellidoPaterno.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtApellidoPaterno.setForeground(new java.awt.Color(102, 102, 102));
        txtApellidoPaterno.setText("Ingrese su Apellido Paterno:");
        txtApellidoPaterno.setBorder(null);
        txtApellidoPaterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtApellidoPaternoMousePressed(evt);
            }
        });
        txtApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPaternoActionPerformed(evt);
            }
        });
        frmFondo.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 450, -1));

        lblApellidoMaterno.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblApellidoMaterno.setText("Apellido Materno:");
        frmFondo.add(lblApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, -1, 40));

        txtApellidoMaterno.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtApellidoMaterno.setForeground(new java.awt.Color(102, 102, 102));
        txtApellidoMaterno.setText("Ingrese su Apellido Materno:");
        txtApellidoMaterno.setBorder(null);
        txtApellidoMaterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtApellidoMaternoMousePressed(evt);
            }
        });
        txtApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMaternoActionPerformed(evt);
            }
        });
        frmFondo.add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 450, -1));

        spApellidoMaterno1.setBackground(new java.awt.Color(0, 0, 0));
        frmFondo.add(spApellidoMaterno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 450, 10));

        lblEmail.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblEmail.setText("Email:");
        frmFondo.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, -1, 40));

        txtEmail.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(102, 102, 102));
        txtEmail.setText("Ingrese su Correo Electrónico:");
        txtEmail.setBorder(null);
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEmailMousePressed(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        frmFondo.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 450, -1));

        spEmail1.setBackground(new java.awt.Color(0, 0, 0));
        frmFondo.add(spEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 450, 10));

        btnCancelar.setBackground(new java.awt.Color(255, 186, 21));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        lblCancelar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblCancelar.setForeground(new java.awt.Color(255, 255, 255));
        lblCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCancelar.setText("Cancelar");
        lblCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btnCancelarLayout = new javax.swing.GroupLayout(btnCancelar);
        btnCancelar.setLayout(btnCancelarLayout);
        btnCancelarLayout.setHorizontalGroup(
            btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        btnCancelarLayout.setVerticalGroup(
            btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        frmFondo.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 680, 130, 50));

        btnGuardar.setBackground(new java.awt.Color(255, 186, 21));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        lblGuardar.setBackground(new java.awt.Color(255, 255, 255));
        lblGuardar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblGuardar.setForeground(new java.awt.Color(255, 255, 255));
        lblGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGuardar.setText("GUARDAR");
        lblGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGuardarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnGuardarLayout = new javax.swing.GroupLayout(btnGuardar);
        btnGuardar.setLayout(btnGuardarLayout);
        btnGuardarLayout.setHorizontalGroup(
            btnGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        btnGuardarLayout.setVerticalGroup(
            btnGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        frmFondo.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 680, 130, 50));

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

    private void txtCapitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapitalActionPerformed
    }//GEN-LAST:event_txtCapitalActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPaternoActionPerformed
    }//GEN-LAST:event_txtApellidoPaternoActionPerformed

    private void txtApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMaternoActionPerformed
    }//GEN-LAST:event_txtApellidoMaternoActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
    }//GEN-LAST:event_txtEmailActionPerformed

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

    }//GEN-LAST:event_jPHeaderMouseEntered

    private void jPHeaderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPHeaderMouseExited

    }//GEN-LAST:event_jPHeaderMouseExited

    private void lblGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarMouseEntered
        btnGuardar.setBackground(Color.ORANGE);
    }//GEN-LAST:event_lblGuardarMouseEntered

    private void lblGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarMouseExited
        btnGuardar.setBackground(new Color(255, 186, 21));
    }//GEN-LAST:event_lblGuardarMouseExited

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(Color.RED);
        btnTxtExit.setBackground(Color.WHITE);
    }//GEN-LAST:event_btnExitMouseExited

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(Color.WHITE);
        btnTxtExit.setBackground(Color.BLACK);
    }//GEN-LAST:event_btnExitMouseEntered

    private void txtNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMousePressed
       if(txtNombre.getText().equals("Ingrese su Nombre:")){
        txtNombre.setText("");
        txtNombre.setForeground(Color.BLACK);
       }
       if(txtApellidoPaterno.getText().equals("Ingrese su Apellido Paterno:")){
        txtApellidoPaterno.setText("Ingrese su Apellido Paterno:");
        txtApellidoPaterno.setForeground(Color.gray);
       }
       if(txtApellidoMaterno.getText().equals("Ingrese su Apellido Materno:")){
        txtApellidoMaterno.setText("Ingrese su Apellido Materno:");
        txtApellidoMaterno.setForeground(Color.gray);
       }
       if(txtEmail.getText().equals("Ingrese su Correo Electrónico:")){
        txtEmail.setText("Ingrese su Correo Electrónico:");
        txtEmail.setForeground(Color.gray);
       }
       if(txtCapital.getText().equals("Ingrese su Capital:")){
        txtCapital.setText("Ingrese su Capital:"); 
        txtCapital.setForeground(Color.gray);
       }    
    }//GEN-LAST:event_txtNombreMousePressed

    private void txtApellidoPaternoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoPaternoMousePressed
       if(txtNombre.getText().equals("Ingrese su Nombre:")){
        txtNombre.setText("Ingrese su Nombre:");
        txtNombre.setForeground(Color.BLACK);
       }
       if(txtApellidoPaterno.getText().equals("Ingrese su Apellido Paterno:")){
        txtApellidoPaterno.setText("");
        txtApellidoPaterno.setForeground(Color.black);
       }
       if(txtApellidoMaterno.getText().equals("Ingrese su Apellido Materno:")){
        txtApellidoMaterno.setText("Ingrese su Apellido Materno:");
        txtApellidoMaterno.setForeground(Color.gray);
       }
       if(txtEmail.getText().equals("Ingrese su Correo Electrónico:")){
        txtEmail.setText("Ingrese su Correo Electrónico:");
        txtEmail.setForeground(Color.gray);
       }
       if(txtCapital.getText().equals("Ingrese su Capital:")){
        txtCapital.setText("Ingrese su Capital:"); 
        txtCapital.setForeground(Color.gray);
       }   
    }//GEN-LAST:event_txtApellidoPaternoMousePressed

    private void txtApellidoMaternoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoMaternoMousePressed
       if(txtNombre.getText().equals("Ingrese su Nombre:")){
        txtNombre.setText("Ingrese su Nombre:");
        txtNombre.setForeground(Color.gray);
       }
       if(txtApellidoPaterno.getText().equals("Ingrese su Apellido Paterno:")){
        txtApellidoPaterno.setText("Ingrese su Apellido Paterno:");
        txtApellidoPaterno.setForeground(Color.gray);
       }
       if(txtApellidoMaterno.getText().equals("Ingrese su Apellido Materno:")){
        txtApellidoMaterno.setText("");
        txtApellidoMaterno.setForeground(Color.BLACK);
       }
       if(txtEmail.getText().equals("Ingrese su Correo Electrónico:")){
        txtEmail.setText("Ingrese su Correo Electrónico:");
        txtEmail.setForeground(Color.gray);
       }
       if(txtCapital.getText().equals("Ingrese su Capital:")){
        txtCapital.setText("Ingrese su Capital:"); 
        txtCapital.setForeground(Color.gray);
       }  
    }//GEN-LAST:event_txtApellidoMaternoMousePressed

    private void txtEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMousePressed
       if(txtNombre.getText().equals("Ingrese su Nombre:")){
        txtNombre.setText("Ingrese su Nombre:");
        txtNombre.setForeground(Color.gray);
       }
       if(txtApellidoPaterno.getText().equals("Ingrese su Apellido Paterno:")){
        txtApellidoPaterno.setText("Ingrese su Apellido Paterno:");
        txtApellidoPaterno.setForeground(Color.gray);
       }
       if(txtApellidoMaterno.getText().equals("Ingrese su Apellido Materno:")){
        txtApellidoMaterno.setText("Ingrese su Apellido Materno:");
        txtApellidoMaterno.setForeground(Color.gray);
       }
       if(txtEmail.getText().equals("Ingrese su Correo Electrónico:")){
        txtEmail.setText("");
        txtEmail.setForeground(Color.BLACK);
       }
       if(txtCapital.getText().equals("Ingrese su Capital:")){
        txtCapital.setText("Ingrese su Capital:"); 
        txtCapital.setForeground(Color.gray);
       }
    }//GEN-LAST:event_txtEmailMousePressed

    private void txtCapitalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCapitalMousePressed
       if(txtNombre.getText().equals("Ingrese su Nombre:")){
        txtNombre.setText("Ingrese su Nombre:");
        txtNombre.setForeground(Color.gray);
       }
       if(txtApellidoPaterno.getText().equals("Ingrese su Apellido Paterno:")){
        txtApellidoPaterno.setText("Ingrese su Apellido Paterno:");
        txtApellidoPaterno.setForeground(Color.gray);
       }
       if(txtApellidoMaterno.getText().equals("Ingrese su Apellido Materno:")){
        txtApellidoMaterno.setText("Ingrese su Apellido Materno:");
        txtApellidoMaterno.setForeground(Color.gray);
       }
       if(txtEmail.getText().equals("Ingrese su Correo Electrónico:")){
        txtEmail.setText("Ingrese su Correo Electrónico:");
        txtEmail.setForeground(Color.gray);
       }
       if(txtCapital.getText().equals("Ingrese su Capital:")){
        txtCapital.setText(""); 
        txtCapital.setForeground(Color.BLACK);
       }    
    }//GEN-LAST:event_txtCapitalMousePressed

    private void lblGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarMouseClicked
              // Validaciones y lógica de guardado...
        if(!ValidadorCampos.esEmailValido(txtEmail.getText().trim())){
            JOptionPane.showMessageDialog(this, "Email inválido.", "Registro de cuentas", JOptionPane.ERROR_MESSAGE);
            txtEmail.requestFocus();
            txtEmail.selectAll();
            return;
        }

        // Conversión de capital
        double capital;
        try {
            capital = Double.parseDouble(txtCapital.getText().trim());
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El capital debe ser un número válido.", "Registro de cuentas", JOptionPane.ERROR_MESSAGE);
            txtCapital.requestFocus();
            txtCapital.selectAll();
            return;
        }
        
        // Crear e inicializar la cuenta
        Cuenta cuenta = new Cuenta();
        cuenta.setNombre(txtNombre.getText().trim());
        cuenta.setApellidoPaterno(txtApellidoPaterno.getText().trim());
        cuenta.setApellidoMaterno(txtApellidoMaterno.getText().trim());
        cuenta.setEmail(txtEmail.getText().trim());
        cuenta.setCapital(capital);
        
        // Intentamos insertar la cuenta
        if (cuenta.insertar()) {
            JOptionPane.showMessageDialog(this, "Cuenta registrada exitosamente.", "Registro de cuentas", JOptionPane.INFORMATION_MESSAGE);
            reiniciarCampos();  // Llamamos al método para reiniciar los campos
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar la cuenta.", "Registro de cuentas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lblGuardarMouseClicked

    private void btnTxtExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtExitMouseEntered
        btnTxtExit.setBackground(Color.WHITE);
        btnTxtExit.setBackground(Color.BLACK);   
    }//GEN-LAST:event_btnTxtExitMouseEntered

    private void btnTxtExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtExitMouseExited
        btnTxtExit.setBackground(Color.RED);
        btnTxtExit.setBackground(Color.WHITE);    
    }//GEN-LAST:event_btnTxtExitMouseExited

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
              // Validaciones y lógica de guardado...
        if(!ValidadorCampos.esEmailValido(txtEmail.getText().trim())){
            JOptionPane.showMessageDialog(this, "Email inválido.", "Registro de cuentas", JOptionPane.ERROR_MESSAGE);
            txtEmail.requestFocus();
            txtEmail.selectAll();
            return;
        }

        // Conversión de capital
        double capital;
        try {
            capital = Double.parseDouble(txtCapital.getText().trim());
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El capital debe ser un número válido.", "Registro de cuentas", JOptionPane.ERROR_MESSAGE);
            txtCapital.requestFocus();
            txtCapital.selectAll();
            return;
        }
        
        // Crear e inicializar la cuenta
        Cuenta cuenta = new Cuenta();
        cuenta.setNombre(txtNombre.getText().trim());
        cuenta.setApellidoPaterno(txtApellidoPaterno.getText().trim());
        cuenta.setApellidoMaterno(txtApellidoMaterno.getText().trim());
        cuenta.setEmail(txtEmail.getText().trim());
        cuenta.setCapital(capital);
        
        // Intentamos insertar la cuenta
        if (cuenta.insertar()) {
            JOptionPane.showMessageDialog(this, "Cuenta registrada exitosamente.", "Registro de cuentas", JOptionPane.INFORMATION_MESSAGE);
            reiniciarCampos();  // Llamamos al método para reiniciar los campos
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar la cuenta.", "Registro de cuentas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        reiniciarCampos();
    }//GEN-LAST:event_btnCancelarMouseClicked

 
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegistroCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnCancelar;
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel btnGuardar;
    private javax.swing.JLabel btnTxtExit;
    private javax.swing.JPanel frmFondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPHeader;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JLabel lblCapital;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JSeparator spApellidoMaterno1;
    private javax.swing.JSeparator spApellidoPaterno1;
    private javax.swing.JSeparator spCapital;
    private javax.swing.JSeparator spEmail1;
    private javax.swing.JSeparator spNombre;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCapital;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
