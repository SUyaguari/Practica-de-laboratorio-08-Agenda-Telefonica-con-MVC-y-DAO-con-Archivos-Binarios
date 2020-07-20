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
import java.util.ArrayList;
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

    public boolean actualizarUsuario(Usuario usuario) {
        boolean cent = usuarioDao.update(usuario);
        return cent;
    }

    public boolean eliminarUsuario(String cedula) {
        usuario = usuarioDao.read(cedula);
        
        if(usuario!=null){
            usuarioDao.delete(usuario);
            return true;
        }else{
            return false;
        }
    }

    public Usuario devolverUsuario() {
        return usuario;
    }

    
    public boolean validarUsuario(String correo, String contrasena) {

        usuario = usuarioDao.login(correo, contrasena);
        if (usuario != null) {

            return true;

        } else {

            return false;

        }

    }
    
    public List<Usuario> listarUsuarios(){
        List<Usuario> lisa = new ArrayList<Usuario>();
        lisa = usuarioDao.findAll();
        return lisa;
    }
    
    public void agregarTelefono(int codigo, String numero, String tipo, String operadora){
        telefono = new Telefono(codigo, numero, tipo, operadora);
        telefono.setUsuario(usuario);
        telefonoDao.create(telefono);
    }
    
     public void imprimirTelefonos() {
        List<Telefono> telefonos;
        telefonos = telefonoDao.listarTelefonos();

        for (Telefono tele : telefonos) {
            System.out.println(tele.toString());
        }
    }
     
     public void actualizarTelefono(int codigo, String numero, String tipo, String operadora) {

        telefono = new Telefono(codigo, numero, tipo, operadora);
        telefonoDao.update(telefono);
        
    }

    public String buscarTelefono(int codigo) {
        telefono = telefonoDao.read(codigo);
        if (telefono != null) {
            //usuario.buscar(telefono);
            return telefono.toString();
        } else {
            return "";
        }

    }

    public void eliminarTelefono(int codigo){
        telefono = telefonoDao.read(codigo);
        if(telefono!=null){
            telefonoDao.delete(telefono);
        }
    }
    public List<Telefono> listarTelefonosUsuario() {
        String id = usuario.getCedula().trim();

        return telefonoDao.telefonosUsuario(id);
    }
}
