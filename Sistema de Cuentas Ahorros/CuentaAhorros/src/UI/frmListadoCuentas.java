/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import SQL.Cuenta;

/**
 *
 * @author Jesus
 */
public class frmListadoCuentas extends javax.swing.JFrame {
    int xMouse, yMouse;

    public frmListadoCuentas() {
        initComponents();
        obtenerListado();
    }

        private void obtenerListado() {
        try {
            Cuenta cuenta = new Cuenta();
            DefaultTableModel modelo = cuenta.listadoGeneral();
            tbObtenerListado.setModel(modelo);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener el listado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundListadoDeCuentas = new javax.swing.JPanel();
        panelCabeceraListado = new javax.swing.JPanel();
        btnSalirListado = new javax.swing.JPanel();
        lblListado = new javax.swing.JLabel();
        pTitulo = new javax.swing.JPanel();
        lblTituloListado = new javax.swing.JLabel();
        lblCuenta = new javax.swing.JLabel();
        cbCuenta = new javax.swing.JComboBox<>();
        lblHasta = new javax.swing.JLabel();
        lblDesde = new javax.swing.JLabel();
        btnObtenerListado = new javax.swing.JPanel();
        lblObtenerListado = new javax.swing.JLabel();
        jTable = new javax.swing.JScrollPane();
        tbObtenerListado = new javax.swing.JTable();
        txtHasta = new javax.swing.JTextField();
        txtDesde = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        backgroundListadoDeCuentas.setBackground(new java.awt.Color(255, 255, 255));
        backgroundListadoDeCuentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCabeceraListado.setBackground(new java.awt.Color(255, 255, 255));
        panelCabeceraListado.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelCabeceraListadoMouseDragged(evt);
            }
        });
        panelCabeceraListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelCabeceraListadoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelCabeceraListadoLayout = new javax.swing.GroupLayout(panelCabeceraListado);
        panelCabeceraListado.setLayout(panelCabeceraListadoLayout);
        panelCabeceraListadoLayout.setHorizontalGroup(
            panelCabeceraListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelCabeceraListadoLayout.setVerticalGroup(
            panelCabeceraListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        backgroundListadoDeCuentas.add(panelCabeceraListado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 669, 30));

        btnSalirListado.setBackground(new java.awt.Color(255, 255, 255));
        btnSalirListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirListadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirListadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirListadoMouseExited(evt);
            }
        });

        lblListado.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblListado.setText("X");

        javax.swing.GroupLayout btnSalirListadoLayout = new javax.swing.GroupLayout(btnSalirListado);
        btnSalirListado.setLayout(btnSalirListadoLayout);
        btnSalirListadoLayout.setHorizontalGroup(
            btnSalirListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSalirListadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblListado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnSalirListadoLayout.setVerticalGroup(
            btnSalirListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblListado, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        backgroundListadoDeCuentas.add(btnSalirListado, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 0, -1, -1));

        pTitulo.setBackground(new java.awt.Color(255, 204, 102));
        pTitulo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblTituloListado.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        lblTituloListado.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloListado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloListado.setText("Listado de Cuentas");

        javax.swing.GroupLayout pTituloLayout = new javax.swing.GroupLayout(pTitulo);
        pTitulo.setLayout(pTituloLayout);
        pTituloLayout.setHorizontalGroup(
            pTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTituloListado)
                .addGap(265, 265, 265))
        );
        pTituloLayout.setVerticalGroup(
            pTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTituloListado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        backgroundListadoDeCuentas.add(pTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 42, 750, -1));

        lblCuenta.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lblCuenta.setText("Cuenta:");
        backgroundListadoDeCuentas.add(lblCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 125, -1, -1));

        cbCuenta.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        cbCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas" }));
        cbCuenta.setBorder(null);
        cbCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backgroundListadoDeCuentas.add(cbCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 153, 350, -1));

        lblHasta.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lblHasta.setText("Hasta:");
        backgroundListadoDeCuentas.add(lblHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, -1, -1));

        lblDesde.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lblDesde.setText("Desde:");
        backgroundListadoDeCuentas.add(lblDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, -1));

        btnObtenerListado.setBackground(new java.awt.Color(255, 204, 102));
        btnObtenerListado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnObtenerListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnObtenerListadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnObtenerListadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnObtenerListadoMouseExited(evt);
            }
        });

        lblObtenerListado.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lblObtenerListado.setForeground(new java.awt.Color(255, 255, 255));
        lblObtenerListado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblObtenerListado.setText("Obtener Listado");

        javax.swing.GroupLayout btnObtenerListadoLayout = new javax.swing.GroupLayout(btnObtenerListado);
        btnObtenerListado.setLayout(btnObtenerListadoLayout);
        btnObtenerListadoLayout.setHorizontalGroup(
            btnObtenerListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnObtenerListadoLayout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addComponent(lblObtenerListado, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
        );
        btnObtenerListadoLayout.setVerticalGroup(
            btnObtenerListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblObtenerListado, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        backgroundListadoDeCuentas.add(btnObtenerListado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 690, 50));

        tbObtenerListado.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        tbObtenerListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Email", "Capital"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable.setViewportView(tbObtenerListado);

        backgroundListadoDeCuentas.add(jTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 690, 160));

        txtHasta.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        backgroundListadoDeCuentas.add(txtHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 140, 30));

        txtDesde.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        backgroundListadoDeCuentas.add(txtDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundListadoDeCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundListadoDeCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirListadoMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnSalirListadoMouseClicked

    private void btnSalirListadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirListadoMouseEntered
        btnSalirListado.setBackground(Color.red);
        lblListado.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnSalirListadoMouseEntered

    private void btnSalirListadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirListadoMouseExited
        btnSalirListado.setBackground(Color.WHITE);
        lblListado.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnSalirListadoMouseExited

    private void btnObtenerListadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObtenerListadoMouseEntered
        btnObtenerListado.setBackground(Color.ORANGE);
    }//GEN-LAST:event_btnObtenerListadoMouseEntered

    private void btnObtenerListadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObtenerListadoMouseExited
        btnObtenerListado.setBackground(new Color (255,204,102));
    }//GEN-LAST:event_btnObtenerListadoMouseExited

    private void panelCabeceraListadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCabeceraListadoMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY(); 
    }//GEN-LAST:event_panelCabeceraListadoMousePressed

    private void panelCabeceraListadoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCabeceraListadoMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);         
    }//GEN-LAST:event_panelCabeceraListadoMouseDragged

    private void btnObtenerListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObtenerListadoMouseClicked
        obtenerListado();
    }//GEN-LAST:event_btnObtenerListadoMouseClicked

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
            java.util.logging.Logger.getLogger(frmListadoCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmListadoCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmListadoCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmListadoCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmListadoCuentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundListadoDeCuentas;
    private javax.swing.JPanel btnObtenerListado;
    private javax.swing.JPanel btnSalirListado;
    private javax.swing.JComboBox<String> cbCuenta;
    private javax.swing.JScrollPane jTable;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblDesde;
    private javax.swing.JLabel lblHasta;
    private javax.swing.JLabel lblListado;
    private javax.swing.JLabel lblObtenerListado;
    private javax.swing.JLabel lblTituloListado;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JPanel panelCabeceraListado;
    private javax.swing.JTable tbObtenerListado;
    private javax.swing.JTextField txtDesde;
    private javax.swing.JTextField txtHasta;
    // End of variables declaration//GEN-END:variables
}
