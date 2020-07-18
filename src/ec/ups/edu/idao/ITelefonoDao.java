/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.idao;

import ec.ups.edu.modelo.Telefono;
import java.util.List;

/**
 *
 * @author santi
 */
public interface ITelefonoDao {
    
    //Crud
    public void create(Telefono telefono);
    public Telefono read(int codigo);
    public void update (Telefono telefono);
    public void delete(Telefono telefono);
    public List<Telefono> listarTelefonos();
    //Obtenemos el codigo
    public int obtenerUltimoCodigo();
    
    
}
