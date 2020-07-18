package ec.ups.edu.controlador;

import ec.ups.edu.dao.TelefonoDao;
import ec.ups.edu.dao.UsuarioDao;
import ec.ups.edu.idao.ITelefonoDao;
import ec.ups.edu.idao.IUsuarioDao;
import ec.ups.edu.modelo.Telefono;
import ec.ups.edu.modelo.Usuario;
import ec.ups.edu.vista.VentanaIniciarSesion;
import ec.ups.edu.vista.VentanaPrincipal;
import ec.ups.edu.vista.VentanaRegistrarse;
import java.util.List;

public class ControladorUsuario {

    VentanaPrincipal ventanaPrincipal;
    VentanaIniciarSesion ventanaIniciar;
    VentanaRegistrarse ventanaRegistrarse;
    IUsuarioDao usuarioDao;
    ITelefonoDao telefonoDao;
    Usuario usuario;
    Telefono telefono;

    //Pasamos parametros parapoder instanciar el la ventana
    public ControladorUsuario(UsuarioDao usuarioDao, TelefonoDao telefonoDao) {

        this.usuarioDao = usuarioDao;
        this.telefonoDao = telefonoDao;
    }

    public void registrarUsuario(String cedula, String nombre, String apellido, String correo, String contrasena) {

        usuario = new Usuario(cedula, nombre, apellido, correo, contrasena);
        usuarioDao.create(usuario);

    }

    public Usuario buscarUsuarioCedula(String cedula) {

        usuario = usuarioDao.read(cedula);

        return usuario;

    }

    public void actualizar() {

    }

    public void eliminar() {

    }

    public void agregarTelefon(int codigo, String numero, String tipo, String operadora) {

        telefono = new Telefono(codigo, numero, tipo, operadora);
        //Se crea en el dao del telefono
        telefonoDao.create(telefono);
        //ingreso el telefono dentro del usuario
        usuario.ingresoTelefono(telefono);
        //se actualiza con el usuario que le acabo de agregar
        usuarioDao.update(usuario);
    }

    public void actualizarTelefono(int codigo, String numero, String tipo, String operadora) {

        telefono = new Telefono(codigo, numero, tipo, operadora);
        telefonoDao.update(telefono);

        usuario.actualizarTelefono(telefono);
        usuarioDao.update(usuario);

    }

    public void actualizarUsuario(String nombre, String apellido, String cedula, String correo,
            String password) {
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setCorreo(correo);
        usuario.setContrasena(password);
        usuario.setCedula(cedula);
        
        usuarioDao.update(usuario);
       
    }

    
     public Usuario devolverUsuario() {
        return usuario;
    }

    public List<Telefono> listarTelefonos() {

        return usuario.getListaTelefono();

    }

    public void eliminarTelefono(int codigo) {

        telefono = telefonoDao.read(codigo);

        if (telefono != null) {

            telefonoDao.delete(telefono);
            usuario.elimarTelefono(telefono);
            usuarioDao.update(usuario);
            telefono = null;

        }

    }

    public boolean validarUsuario(String correo, String contrasena) {

        usuario = usuarioDao.login(correo, contrasena);
        if (usuario != null) {

            return true;

        } else {

            return false;

        }

    }
}
