/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.vista;

import ec.ups.edu.controlador.ControladorUsuario;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;

/**
 *
 * @author santi
 */
public class VentanaIniciarSesion extends javax.swing.JInternalFrame {

    private VentanaPrincipal ventanaPrincipal;
    private ControladorUsuario controladorUsuario;

    private Locale localizacion;
    private ResourceBundle mensajes;

    public VentanaIniciarSesion(ControladorUsuario controladorUsuario, VentanaPrincipal ventanaPrincipal) {
        initComponents();

        this.ventanaPrincipal = ventanaPrincipal;
        this.controladorUsuario = controladorUsuario;

        localizacion = new Locale("en", "US");
        mensajes = ResourceBundle.getBundle("ec.ups.edu.idiomas.mensajes", localizacion);
        cambiarIdioma();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelCorreo = new javax.swing.JLabel();
        txtxCorreo = new javax.swing.JTextField();
        LabelContrasena = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        btnInicioSesion = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Iniciar Sesion");

        LabelCorreo.setText("Correo Electronico:");

        LabelContrasena.setText("Contraseña:");

        btnInicioSesion.setText("Iniciar Sesion");
        btnInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioSesionActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(LabelCorreo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(LabelContrasena)))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtxCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btnLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnInicioSesion)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelCorreo)
                            .addComponent(txtxCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelContrasena)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnInicioSesion))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cambiarIdioma() {

        LabelCorreo.setText((mensajes.getString("LabelCorreo")));
        LabelContrasena.setText(mensajes.getString("LabelContrasena"));
        btnInicioSesion.setText(mensajes.getString("btnIniciarSesion"));
        btnLimpiar.setText(mensajes.getString("btnLimpiar"));

    }


    private void btnInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioSesionActionPerformed

        if (controladorUsuario.validarUsuario(txtxCorreo.getText(), txtContrasena.getText())) {

            ventanaPrincipal.getMenu().setVisible(true);
            ventanaPrincipal.getMenuCerrarSesion().setVisible(true);
            ventanaPrincipal.getMenuSalir().setVisible(true);

            ventanaPrincipal.getMenuIniciarSesion().setVisible(false);
            ventanaPrincipal.getMenuRegistrarse().setVisible(false);
            ventanaPrincipal.getMenuGestionar().setVisible(true);

            this.limpiar();
            this.dispose();

            JOptionPane.showMessageDialog(this, "Sesion iniciada");

        } else if (txtxCorreo.getText().isEmpty() || txtContrasena.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Llene todos los campos");

        } else {

            JOptionPane.showMessageDialog(this, "Datos incorrectos");

        }


    }//GEN-LAST:event_btnInicioSesionActionPerformed


    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        limpiar();

    }//GEN-LAST:event_btnLimpiarActionPerformed

    public void limpiar() {

        txtxCorreo.setText("");
        txtContrasena.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelContrasena;
    private javax.swing.JLabel LabelCorreo;
    private javax.swing.JButton btnInicioSesion;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtxCorreo;
    // End of variables declaration//GEN-END:variables

}
