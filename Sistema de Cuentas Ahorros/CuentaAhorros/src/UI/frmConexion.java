/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import java.awt.Color;

import javax.swing.JOptionPane;

import SQL.ConexionDB;

/**
 *
 * @author Jesus
 */
public class frmConexion extends javax.swing.JFrame {
    int xMouse, yMouse;

    // Instancia de conexión
    private ConexionDB conexionDB;

    public frmConexion() {
        initComponents();
        // Inicializamos la conexión a la base de datos
        conexionDB = new ConexionDB();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundConexion = new javax.swing.JPanel();
        cabezaConexion = new javax.swing.JPanel();
        btnConexion = new javax.swing.JPanel();
        lblSalirConexion = new javax.swing.JLabel();
        btnDesconectar = new javax.swing.JPanel();
        lblDesconectar = new javax.swing.JLabel();
        btnConectar = new javax.swing.JPanel();
        lblConectar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        backgroundConexion.setBackground(new java.awt.Color(255, 255, 255));
        backgroundConexion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cabezaConexion.setBackground(new java.awt.Color(255, 255, 255));
        cabezaConexion.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                cabezaConexionMouseDragged(evt);
            }
        });
        cabezaConexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cabezaConexionMousePressed(evt);
            }
        });

        btnConexion.setBackground(new java.awt.Color(255, 255, 255));
        btnConexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConexionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConexionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConexionMouseExited(evt);
            }
        });

        lblSalirConexion.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblSalirConexion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalirConexion.setText("X");

        javax.swing.GroupLayout btnConexionLayout = new javax.swing.GroupLayout(btnConexion);
        btnConexion.setLayout(btnConexionLayout);
        btnConexionLayout.setHorizontalGroup(
            btnConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSalirConexion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );
        btnConexionLayout.setVerticalGroup(
            btnConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSalirConexion, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout cabezaConexionLayout = new javax.swing.GroupLayout(cabezaConexion);
        cabezaConexion.setLayout(cabezaConexionLayout);
        cabezaConexionLayout.setHorizontalGroup(
            cabezaConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cabezaConexionLayout.createSequentialGroup()
                .addGap(0, 351, Short.MAX_VALUE)
                .addComponent(btnConexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        cabezaConexionLayout.setVerticalGroup(
            cabezaConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cabezaConexionLayout.createSequentialGroup()
                .addComponent(btnConexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        backgroundConexion.add(cabezaConexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 40));

        btnDesconectar.setBackground(new java.awt.Color(0, 204, 255));
        btnDesconectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDesconectarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDesconectarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDesconectarMouseExited(evt);
            }
        });

        lblDesconectar.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        lblDesconectar.setForeground(new java.awt.Color(255, 255, 255));
        lblDesconectar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesconectar.setText("Desconectar");

        javax.swing.GroupLayout btnDesconectarLayout = new javax.swing.GroupLayout(btnDesconectar);
        btnDesconectar.setLayout(btnDesconectarLayout);
        btnDesconectarLayout.setHorizontalGroup(
            btnDesconectarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDesconectar, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        btnDesconectarLayout.setVerticalGroup(
            btnDesconectarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDesconectar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        backgroundConexion.add(btnDesconectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 140, 50));

        btnConectar.setBackground(new java.awt.Color(0, 204, 255));
        btnConectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConectarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConectarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConectarMouseExited(evt);
            }
        });

        lblConectar.setBackground(new java.awt.Color(255, 255, 255));
        lblConectar.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        lblConectar.setForeground(new java.awt.Color(255, 255, 255));
        lblConectar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConectar.setText("Conectar");

        javax.swing.GroupLayout btnConectarLayout = new javax.swing.GroupLayout(btnConectar);
        btnConectar.setLayout(btnConectarLayout);
        btnConectarLayout.setHorizontalGroup(
            btnConectarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblConectar, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        btnConectarLayout.setVerticalGroup(
            btnConectarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblConectar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        backgroundConexion.add(btnConectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 140, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundConexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundConexion, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConexionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConexionMouseEntered
        btnConexion.setBackground(Color.RED);
        lblSalirConexion.setForeground(Color.WHITE);        
    }//GEN-LAST:event_btnConexionMouseEntered

    private void btnConexionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConexionMouseExited
        btnConexion.setBackground(Color.WHITE);
        lblSalirConexion.setForeground(Color.BLACK);        
    }//GEN-LAST:event_btnConexionMouseExited

    private void btnConexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConexionMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnConexionMouseClicked

    private void btnConectarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConectarMouseEntered
        btnConectar.setBackground(Color.BLUE);
    }//GEN-LAST:event_btnConectarMouseEntered

    private void btnConectarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConectarMouseExited
        btnConectar.setBackground(new Color(0,204,255));
    }//GEN-LAST:event_btnConectarMouseExited

    private void btnDesconectarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDesconectarMouseEntered
        btnDesconectar.setBackground(Color.BLUE);
    }//GEN-LAST:event_btnDesconectarMouseEntered

    private void btnDesconectarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDesconectarMouseExited
        btnDesconectar.setBackground(new Color(0,204,255));
    }//GEN-LAST:event_btnDesconectarMouseExited

    private void cabezaConexionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cabezaConexionMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();         
    }//GEN-LAST:event_cabezaConexionMousePressed

    private void cabezaConexionMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cabezaConexionMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);          
    }//GEN-LAST:event_cabezaConexionMouseDragged

    private void btnDesconectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDesconectarMouseClicked
        conexionDB.desconectar();
        JOptionPane.showMessageDialog(this, "Desconectado de la base de datos.");
    }//GEN-LAST:event_btnDesconectarMouseClicked

    private void btnConectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConectarMouseClicked
        conexionDB.conectar();
        JOptionPane.showMessageDialog(this, "Conectando a la Base De Datos.");
    }//GEN-LAST:event_btnConectarMouseClicked

    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundConexion;
    private javax.swing.JPanel btnConectar;
    private javax.swing.JPanel btnConexion;
    private javax.swing.JPanel btnDesconectar;
    private javax.swing.JPanel cabezaConexion;
    private javax.swing.JLabel lblConectar;
    private javax.swing.JLabel lblDesconectar;
    private javax.swing.JLabel lblSalirConexion;
    // End of variables declaration//GEN-END:variables
}
