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
    
    public void RegistrarTelefono(){
        
    }
    
    public void verTelefono(){
        
    }
    public void actualizar(){
        
    }
    
    public void eliminar(){
        
    }
    
    public void verClientes(){
        
        
    }
    public List<Telefono> listaTelefono(){
        
      return telefonoDao.listarTelefonos();
        
    }
    
    public int obtenerSiguienteCodigo(){
        
        int codigo = telefonoDao.obtenerUltimoCodigo();
        
        //decuelve el codigo incrementado en uno
        return ++codigo;
        
    }
    
  

    
}
