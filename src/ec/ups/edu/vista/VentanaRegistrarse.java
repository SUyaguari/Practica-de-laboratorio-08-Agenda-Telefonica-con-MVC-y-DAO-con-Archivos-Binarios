package ec.ups.edu.vista;

import ec.ups.edu.controlador.ControladorUsuario;
import ec.ups.edu.modelo.Usuario;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class VentanaRegistrarse extends javax.swing.JInternalFrame {

    private ControladorUsuario controladorUsuario;

    private Locale localizacion;
    private ResourceBundle mensajes;

    public VentanaRegistrarse(ControladorUsuario controladorUsuario) {
        initComponents();
        this.controladorUsuario = controladorUsuario;

        localizacion = new Locale("en", "US");
        mensajes = ResourceBundle.getBundle("ec.ups.edu.idiomas.mensajes", localizacion);
        cambiarIdioma();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelCedula = new javax.swing.JLabel();
        LabelNombre = new javax.swing.JLabel();
        LabelApellido = new javax.swing.JLabel();
        LabelCorreo = new javax.swing.JLabel();
        LabelContrasena = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtxXorreo = new javax.swing.JTextField();
        btnRegistrarse = new javax.swing.JButton();
        txtcontras = new javax.swing.JPasswordField();
        btnLimpiar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Registrarse");

        LabelCedula.setText("Cedula");

        LabelNombre.setText("Nombre");

        LabelApellido.setText("Apellido");

        LabelCorreo.setText("Correo");

        LabelContrasena.setText("Contrasena");

        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrarse)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelCedula)
                            .addComponent(LabelNombre)
                            .addComponent(LabelApellido)
                            .addComponent(LabelCorreo)
                            .addComponent(LabelContrasena))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(txtxXorreo)
                            .addComponent(txtCedula)
                            .addComponent(txtcontras)
                            .addComponent(txtApellido))))
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCorreo)
                    .addComponent(txtxXorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelContrasena)
                    .addComponent(txtcontras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarse)
                    .addComponent(btnLimpiar))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed

        if (txtCedula.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtxXorreo.getText().isEmpty()
                || txtcontras.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Llene todos los campos");

        } else {

            controladorUsuario.registrarUsuario(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), txtxXorreo.getText(), txtcontras.getText());

            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente");

            limpiar();

            this.dispose();

        }
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        limpiar();

    }//GEN-LAST:event_btnLimpiarActionPerformed

    public void cambiarIdioma(){
        
        LabelCedula.setText(mensajes.getString("LabelCedula"));
        LabelNombre.setText(mensajes.getString("LabelNombre"));
        LabelApellido.setText(mensajes.getString("LabelApellido"));
        LabelCorreo.setText(mensajes.getString("LabelCorreo"));
        LabelContrasena.setText(mensajes.getString("LabelContrasena"));
        btnRegistrarse.setText(mensajes.getString("btnRegistrarse"));
        btnLimpiar.setText(mensajes.getString("btnLimpiar"));
    
    }
    
    public void limpiar() {

        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtxXorreo.setText("");
        txtcontras.setText("");

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelApellido;
    private javax.swing.JLabel LabelCedula;
    private javax.swing.JLabel LabelContrasena;
    private javax.swing.JLabel LabelCorreo;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtcontras;
    private javax.swing.JTextField txtxXorreo;
    // End of variables declaration//GEN-END:variables
}
