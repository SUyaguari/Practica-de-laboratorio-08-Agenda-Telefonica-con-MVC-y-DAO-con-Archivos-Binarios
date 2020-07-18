/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.vista;

import ec.ups.edu.controlador.ControladorTelefono;
import ec.ups.edu.controlador.ControladorUsuario;
import ec.ups.edu.modelo.Telefono;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentanaGestionTelefono extends javax.swing.JInternalFrame {

    private ControladorUsuario controladorUsuario;
    private ControladorTelefono controladorTelefono;
    private List<String> operadoras;

    DefaultTableModel modelo;

    private Locale localizacion;
    private ResourceBundle mensajes;

    public VentanaGestionTelefono(ControladorUsuario controladorUsuario, ControladorTelefono controladorTelefono) {

        initComponents();

        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Tipo");
        modelo.addColumn("Numero");
        modelo.addColumn("Operadora");
        this.tblTelefonos.setModel(modelo);

        this.controladorUsuario = controladorUsuario;
        this.controladorTelefono = controladorTelefono;
        cargarDatosOperadoras();
        cmbOperadora();

        localizacion = new Locale("en", "US");
        mensajes = ResourceBundle.getBundle("ec.ups.edu.idiomas.mensajes", localizacion);
        cambiarIdioma();

    }

    public void cambiarIdioma() {

        LabelCodigo.setText(mensajes.getString("LabelCodigo"));
        LabelTipo.setText(mensajes.getString("LabelTipo"));
        LabelNumero.setText(mensajes.getString("LabelNumero"));
        LabelOperadora.setText(mensajes.getString("LabelOperadora"));
        btnActualizar.setText(mensajes.getString("btnActualizar"));
        btnAgregar.setText(mensajes.getString("btnAgregar"));
        btnEliminar.setText(mensajes.getString("btnEliminar"));
        btnCancelar.setText(mensajes.getString("btnCancelar"));
    }

    public void cargarDatosOperadoras() {

        operadoras = new ArrayList<>();
        operadoras.add("--Seleccione una opcion--");
        operadoras.add("Movistar");
        operadoras.add("Claro");
        operadoras.add("Cnt");
        operadoras.add("Tuenti");
        operadoras.add("Etapa");
       

    }

    public void caragarSiguienteCodigo() {

        txtCodigo.setText(String.valueOf(controladorTelefono.obtenerSiguienteCodigo()));

    }

    public void cmbOperadora() {

        DefaultComboBoxModel modelo = (DefaultComboBoxModel) cmbOperadora.getModel();

        for (String operadora : operadoras) {

            modelo.addElement(operadora);

        }

    }

    public void cargarTelefonostblTelefonos() {

        DefaultTableModel modelo = (DefaultTableModel) tblTelefonos.getModel();
        //numero de filas es igual a 0 elimino todo lo que existe
        modelo.setRowCount(0);
        for (Telefono telefono : controladorUsuario.listarTelefonos()) {
            Object[] rowData = {telefono.getCodigo(), telefono.getTipo(), telefono.getNumero(), telefono.getOperadora()};
            modelo.addRow(rowData);

        }
        tblTelefonos.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        LabelCodigo = new javax.swing.JLabel();
        LabelTipo = new javax.swing.JLabel();
        LabelNumero = new javax.swing.JLabel();
        LabelOperadora = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNumero = new javax.swing.JFormattedTextField();
        cmbOperadora = new javax.swing.JComboBox<>();
        cmbTipo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTelefonos = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setTitle("Gestionar telefonos");
        setToolTipText("");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        LabelCodigo.setText("Codigo:");

        LabelTipo.setText("Tipo:");

        LabelNumero.setText("Numero:");

        LabelOperadora.setText("Operadora");

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCodigo.setText("0");

        txtNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        txtNumero.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione una opcion--", "Casa", "Movil", "Fax", "Localizador" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        tblTelefonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTelefonos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTelefonosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTelefonos);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addComponent(LabelOperadora)
                            .addGap(86, 86, 86)
                            .addComponent(cmbOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(56, 56, 56)
                                    .addComponent(LabelNumero))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(69, 69, 69)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LabelTipo)
                                        .addComponent(LabelCodigo))))
                            .addGap(92, 92, 92)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCodigo)
                                .addComponent(cmbTipo, 0, 220, Short.MAX_VALUE)
                                .addComponent(txtNumero))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTipo)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelOperadora)
                    .addComponent(cmbOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnActualizar)
                    .addComponent(btnCancelar)
                    .addComponent(btnEliminar))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        if (txtCodigo.getText().isEmpty() || txtNumero.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Llene todos los campos");

        } else {

            controladorUsuario.agregarTelefon(Integer.parseInt(txtCodigo.getText()),
                    txtNumero.getText(), cmbTipo.getSelectedItem() + "", cmbOperadora.getSelectedItem().toString());
            cargarTelefonostblTelefonos();
            limpiar();

        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed

        try {

            String item = (String) cmbTipo.getSelectedItem();
            if (item.equals("Casa")) {

                txtNumero.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(+593)#-####-###")
                        ));
            } else if (item.equals("Movil")) {

                txtNumero.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(+593)#-####-###")
                        ));

            } else if (item.equals("Fax")) {

                txtNumero.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(+593)#-####-###")
                        ));

            } else if (item.equals("Localizador")) {

                txtNumero.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(+593)#-####-###")
                        ));

            }

        } catch (java.text.ParseException e) {

            //Se utliza para impirmir el registro del stack donde se ha inciado la excepcion
            e.printStackTrace();

        }


    }//GEN-LAST:event_cmbTipoActionPerformed

    private void tblTelefonosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTelefonosMouseClicked

        int filaIndex = tblTelefonos.getSelectedRow();

        if (filaIndex >= 0) {

            activarEdicion();

            //desactgivamos al boton de agregar
            btnAgregar.setEnabled(false);

            int codigo = (int) tblTelefonos.getValueAt(filaIndex, 0);
            String tipo = tblTelefonos.getValueAt(filaIndex, 1).toString();
            String numero = tblTelefonos.getValueAt(filaIndex, 2).toString();
            String operadora = tblTelefonos.getValueAt(filaIndex, 3).toString();

            txtCodigo.setText(String.valueOf(codigo));
            cmbTipo.setSelectedItem(tipo);
            txtNumero.setValue(numero);
            cmbOperadora.setSelectedItem(operadora);

        }
    }//GEN-LAST:event_tblTelefonosMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        controladorUsuario.actualizarTelefono(Integer.valueOf(txtCodigo.getText()), cmbTipo.getSelectedItem().toString(),
                txtNumero.getText(), cmbOperadora.getSelectedItem().toString());

        cargarTelefonostblTelefonos();

        limpiar();

    }//GEN-LAST:event_btnActualizarActionPerformed

    public void activarEdicion() {

        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }

    public void desactivarEdicion() {

        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }


    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int respuesta = JOptionPane.showConfirmDialog(this, "Esta seguro que deseas eliminar el telefono?");

        if (respuesta == JOptionPane.YES_OPTION) {

            controladorUsuario.eliminarTelefono(Integer.valueOf(txtCodigo.getText()));
            cargarTelefonostblTelefonos();
            limpiar();
            desactivarEdicion();
            btnAgregar.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Telefono eliminado exitosamente");

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

        caragarSiguienteCodigo();
        cargarTelefonostblTelefonos();
        desactivarEdicion();

    }//GEN-LAST:event_formInternalFrameActivated

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        btnAgregar.setEnabled(true);
        limpiar();

    }//GEN-LAST:event_btnCancelarActionPerformed

    public void cargarSiguienteCodig() {

        txtCodigo.setText(String.valueOf(controladorTelefono.obtenerSiguienteCodigo()));

    }

    public void limpiar() {

        txtCodigo.setText("");
        txtNumero.setValue("");
        cmbOperadora.setSelectedIndex(0);
        cmbTipo.setSelectedIndex(0);
        cargarSiguienteCodig();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCodigo;
    private javax.swing.JLabel LabelNumero;
    private javax.swing.JLabel LabelOperadora;
    private javax.swing.JLabel LabelTipo;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cmbOperadora;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblTelefonos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
