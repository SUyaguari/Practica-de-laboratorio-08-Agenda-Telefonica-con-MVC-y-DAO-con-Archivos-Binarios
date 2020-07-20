package ec.ups.edu.controlador;

import ec.ups.edu.dao.TelefonoDao;
import ec.ups.edu.idao.ITelefonoDao;
import ec.ups.edu.modelo.Telefono;
import java.util.List;

public class ControladorTelefono {
    
    ITelefonoDao telefonoDao;
    Telefono telefono;

    public ControladorTelefono(TelefonoDao telefonoDao) {
        this.telefonoDao = telefonoDao;
    }
    
    public void RegistrarTelefono(Telefono telefono){
        telefonoDao.create(telefono);
    }
    
    public Telefono buscarTelefono(int codigo){
        telefono = telefonoDao.read(codigo);
        return telefono;
    }
    
    public boolean actualizarTelefono(){
        boolean cent = telefonoDao.update(telefono);
        return cent;
    }
    
    public boolean eliminarUsuario(int codigo) {
        telefono = telefonoDao.read(codigo);
        
        if(telefono!=null){
            telefonoDao.delete(telefono);
            return true;
        }else{
            return false;
        }
    }
    
    public List<Telefono> listaTelefono(){
        
      return telefonoDao.listarTelefonos();
        
    }
    
    public int obtenerSiguienteCodigo(){
        
        int codigo = telefonoDao.obtenerUltimoCodigo();
        return ++codigo;
        
    }
    
  

    
}
