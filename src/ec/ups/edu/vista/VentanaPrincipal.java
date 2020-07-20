/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.vista;

import ec.ups.edu.controlador.ControladorTelefono;
import ec.ups.edu.controlador.ControladorUsuario;
import ec.ups.edu.dao.TelefonoDao;
import ec.ups.edu.dao.UsuarioDao;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author santi
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    UsuarioDao usuarioDao;
    TelefonoDao telefonoDao;
    
    ControladorUsuario controladorUsuario;
    ControladorTelefono controladorTelefono;
    
    VentanaIniciarSesion ventanaIniciarSesion;
    VentanaRegistrarse ventanaRegistrars;
    VentanaGestionTelefono ventanaGestion;
    VentanaBuscarUsuario ventanaBuscarUsuario;
    VentanaGestionUsuario ventanaGestionUsuario;
    
    private ResourceBundle mensajes;
    private Locale localizacion;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        menuGestion.setVisible(false);
        menuCerrarSesion.setVisible(false);
        //DAO

        usuarioDao = new UsuarioDao();
        telefonoDao = new TelefonoDao();
        //Controladores
        controladorUsuario = new ControladorUsuario(usuarioDao, telefonoDao);
        controladorTelefono = new ControladorTelefono(telefonoDao);
        //Ventanas
        ventanaIniciarSesion = new VentanaIniciarSesion(controladorUsuario, this);
        ventanaRegistrars = new VentanaRegistrarse(controladorUsuario);
        ventanaGestion = new VentanaGestionTelefono(controladorUsuario, controladorTelefono);
        ventanaBuscarUsuario = new VentanaBuscarUsuario(controladorUsuario, controladorTelefono);
        ventanaGestionUsuario = new VentanaGestionUsuario(controladorUsuario);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        menuIniciarSesion = new javax.swing.JMenuItem();
        menuRegistrarse = new javax.swing.JMenuItem();
        menuListarTelefono = new javax.swing.JMenuItem();
        menuCerrarSesion = new javax.swing.JMenuItem();
        menuSalirse = new javax.swing.JMenuItem();
        menuGestion = new javax.swing.JMenu();
        menuTelefonoss = new javax.swing.JMenuItem();
        menuUsuario = new javax.swing.JMenuItem();
        menuIdioma = new javax.swing.JMenu();
        menuItemEspanol = new javax.swing.JMenuItem();
        menuItemIngles = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(new java.awt.Color(51, 0, 255));
        desktopPane.setForeground(new java.awt.Color(51, 51, 255));

        menuInicio.setMnemonic('f');
        menuInicio.setText("Inicio");

        menuIniciarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        menuIniciarSesion.setMnemonic('o');
        menuIniciarSesion.setText("Iniciar Sesion");
        menuIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIniciarSesionActionPerformed(evt);
            }
        });
        menuInicio.add(menuIniciarSesion);

        menuRegistrarse.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        menuRegistrarse.setMnemonic('s');
        menuRegistrarse.setText("Registrarse");
        menuRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegistrarseActionPerformed(evt);
            }
        });
        menuInicio.add(menuRegistrarse);

        menuListarTelefono.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        menuListarTelefono.setText("Listar Telefono");
        menuListarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListarTelefonoActionPerformed(evt);
            }
        });
        menuInicio.add(menuListarTelefono);

        menuCerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_MASK));
        menuCerrarSesion.setText("Cerrar Sesion");
        menuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCerrarSesionActionPerformed(evt);
            }
        });
        menuInicio.add(menuCerrarSesion);

        menuSalirse.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        menuSalirse.setMnemonic('x');
        menuSalirse.setText("Salir");
        menuSalirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirseActionPerformed(evt);
            }
        });
        menuInicio.add(menuSalirse);

        menuBar.add(menuInicio);

        menuGestion.setText("Gestion");

        menuTelefonoss.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        menuTelefonoss.setText("Telefonos");
        menuTelefonoss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTelefonossActionPerformed(evt);
            }
        });
        menuGestion.add(menuTelefonoss);

        menuUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        menuUsuario.setText("Usuario");
        menuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuarioActionPerformed(evt);
            }
        });
        menuGestion.add(menuUsuario);

        menuBar.add(menuGestion);

        menuIdioma.setText(" Idioma");

        menuItemEspanol.setText("Español");
        menuItemEspanol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEspanolActionPerformed(evt);
            }
        });
        menuIdioma.add(menuItemEspanol);

        menuItemIngles.setText(" Ingles");
        menuItemIngles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemInglesActionPerformed(evt);
            }
        });
        menuIdioma.add(menuItemIngles);

        menuBar.add(menuIdioma);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cambiarIdioma() {

        menuInicio.setText(mensajes.getString("menuInicio"));
        menuGestion.setText(mensajes.getString("menuGestion"));
        menuIdioma.setText(mensajes.getString("menuIdioma"));
        menuTelefonoss.setText(mensajes.getString("menuTelefonoss"));
        menuUsuario.setText(mensajes.getString("menuUsuario"));
        menuIniciarSesion.setText(mensajes.getString("menuIniciarSesion"));
        menuRegistrarse.setText(mensajes.getString("menuRegistrarse"));
        menuListarTelefono.setText(mensajes.getString("menuListarTelefonos"));
        menuSalirse.setText(mensajes.getString("menuSalirse"));
        menuCerrarSesion.setText(mensajes.getString("menuCerrrarSesion"));
    }

    private void menuSalirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirseActionPerformed

    private void menuRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegistrarseActionPerformed

        if (!ventanaRegistrars.isVisible()) {
            desktopPane.add(ventanaRegistrars);
            ventanaRegistrars.setVisible(true);

        }
    }//GEN-LAST:event_menuRegistrarseActionPerformed

    private void menuIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIniciarSesionActionPerformed

        if (!ventanaIniciarSesion.isVisible()) {
            desktopPane.add(ventanaIniciarSesion);
            ventanaIniciarSesion.setVisible(true);

        }

    }//GEN-LAST:event_menuIniciarSesionActionPerformed

    private void menuTelefonossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTelefonossActionPerformed

        if (!ventanaGestion.isVisible()) {
            desktopPane.add(ventanaGestion);
            ventanaGestion.setVisible(true);

        }

    }//GEN-LAST:event_menuTelefonossActionPerformed

    private void menuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarSesionActionPerformed

        menuGestion.setVisible(false);
        menuCerrarSesion.setVisible(false);
        menuIniciarSesion.setVisible(true);
        menuRegistrarse.setVisible(true);
    }//GEN-LAST:event_menuCerrarSesionActionPerformed

    private void menuListarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListarTelefonoActionPerformed

        if (!ventanaBuscarUsuario.isVisible()) {
            desktopPane.add(ventanaBuscarUsuario);
            ventanaBuscarUsuario.setVisible(true);

        }

    }//GEN-LAST:event_menuListarTelefonoActionPerformed

    private void menuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuarioActionPerformed

        if (!ventanaGestionUsuario.isVisible()) {
            desktopPane.add(ventanaGestionUsuario);
            ventanaGestionUsuario.setVisible(true);

        }
    }//GEN-LAST:event_menuUsuarioActionPerformed

    private void menuItemEspanolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEspanolActionPerformed

        localizacion = new Locale("es", "EC");
        mensajes = ResourceBundle.getBundle("ec.ups.edu.idiomas.mensajes", localizacion);
        cambiarIdioma();

    }//GEN-LAST:event_menuItemEspanolActionPerformed

    private void menuItemInglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInglesActionPerformed

        localizacion = new Locale("en", "US");
        mensajes = ResourceBundle.getBundle("ec.ups.edu.idiomas.mensajes", localizacion);
        cambiarIdioma();


    }//GEN-LAST:event_menuItemInglesActionPerformed

    public JMenu getMenu() {

        return menuInicio;

    }

    public JMenuItem getMenuIniciarSesion() {

        return menuIniciarSesion;

    }

    public JMenuItem getMenuRegistrarse() {

        return menuRegistrarse;
    }

    public JMenuItem getMenuCerrarSesion() {

        return menuCerrarSesion;

    }

    public JMenu getMenuGestionar() {

        return menuGestion;

    }

    public JMenuItem getMenuSalir() {

        return menuSalirse;

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuCerrarSesion;
    private javax.swing.JMenu menuGestion;
    private javax.swing.JMenu menuIdioma;
    private javax.swing.JMenuItem menuIniciarSesion;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenuItem menuItemEspanol;
    private javax.swing.JMenuItem menuItemIngles;
    private javax.swing.JMenuItem menuListarTelefono;
    private javax.swing.JMenuItem menuRegistrarse;
    private javax.swing.JMenuItem menuSalirse;
    private javax.swing.JMenuItem menuTelefonoss;
    private javax.swing.JMenuItem menuUsuario;
    // End of variables declaration//GEN-END:variables

}
