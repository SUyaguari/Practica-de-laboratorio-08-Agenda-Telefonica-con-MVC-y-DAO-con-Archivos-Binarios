/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.dao;

import ec.ups.edu.idao.ITelefonoDao;
import ec.ups.edu.modelo.Telefono;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author santi
 */
public class TelefonoDao implements ITelefonoDao{

    private List<Telefono> listaTelefono;
    private int codigo;

    public TelefonoDao() {
    
    listaTelefono = new ArrayList<>();
    codigo = 0;
            
    }
    
    @Override
    public void create(Telefono telefono) {
       
        //va aumentando el codigo en uno en uno cada vez que creo.
        telefono.setCodigo(++codigo);
        listaTelefono.add(telefono);
        
    }

    @Override
    public Telefono read(int codigo) {
     
        for (Telefono telefono : listaTelefono) {
            
            if (telefono.getCodigo() == codigo) {
                
                return telefono;
                
            }
            
        }
        
        return null;
        
    }

    @Override
    public void update(Telefono telefono) {
        
        
        for (int i = 0; i < listaTelefono.size(); i++) {
            
            Telefono tel = listaTelefono.get(i);
            
            if (tel.getCodigo() == telefono.getCodigo()) {
                
                listaTelefono.set(i, telefono);
                        
                break;
                
            }
            
            
        }
        
    }

    @Override
    public void delete(Telefono telefono) {
        
        Iterator <Telefono>it = listaTelefono.iterator();
        
        while(it.hasNext()){
            
            Telefono tel = it.next();
            
            if (tel.getCodigo() == telefono.getCodigo()) {
                
                it.remove();
                
                break;
                
            }
            
        }
        
    }
    
   
    @Override
    public List<Telefono> listarTelefonos() {
       
        return listaTelefono;
        
    }

    @Override
    public int obtenerUltimoCodigo() {
    
        return codigo;
        
    }
    
    
    
}
