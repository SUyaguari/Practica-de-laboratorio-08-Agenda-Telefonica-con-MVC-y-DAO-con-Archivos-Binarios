/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.idao;

import ec.ups.edu.modelo.Usuario;
import java.util.List;

/**
 *
 * @author santi
 */
public interface IUsuarioDao {
    
    public void create(Usuario usuario);
    public Usuario read(String cedula);
    public boolean update (Usuario usuario);
    public void delete(Usuario usuario);
    public List<Usuario>findAll();
    public  Usuario login(String correo,String contrasena);

    
    
    
}
