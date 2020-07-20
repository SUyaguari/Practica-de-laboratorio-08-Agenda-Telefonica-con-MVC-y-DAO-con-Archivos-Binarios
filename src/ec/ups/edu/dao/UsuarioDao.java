/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.dao;

import ec.ups.edu.idao.IUsuarioDao;
import ec.ups.edu.modelo.Usuario;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UsuarioDao implements IUsuarioDao {

  private RandomAccessFile archivo;

    /**
     * Estructura del archivo
     * 
     * private String cedula; | 10 caracteres
     * private String nombre; | 25 caracteres
     * private String apellido; | 25 caracteres
     * private String correo;   |50 caracteres
     * private String contrasena; | 8 caracteres
     * 128 bytes por registro
     */
    public UsuarioDao() {
        
        try{
            archivo = new RandomAccessFile("datos/usuario.dat", "rw");
        }catch(IOException ex){
            System.out.println("Error lectrura escritura");
            ex.printStackTrace();
        }
    }

    @Override
    public void create(Usuario usuario) {
        
        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(usuario.getCedula());
            archivo.writeUTF(usuario.getNombre());
            archivo.writeUTF(usuario.getApellido());
            archivo.writeUTF(usuario.getCorreo());
            archivo.writeUTF(usuario.getContrasena());
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (UsuarioDao:Create)");
            ex.printStackTrace();
        }

    }

    @Override
    public Usuario read(String cedula) {
    
        int salto = 0;
        int registro = 128;
        try{
        while(salto<archivo.length()){
            
            archivo.seek(salto);
            String cedulaArchivo = archivo.readUTF();
            
            if(cedula.equals(cedulaArchivo.trim())){
                Usuario usuario = new Usuario(cedulaArchivo, archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim());
                return usuario;
            }
            
            salto+=registro;
            
        }
        return null;
        }catch(IOException ex){
            System.out.println("Error lectrura escritura (UsuarioDao:Read)");
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Usuario usuario) {
        int salto = 0;
        int registro = 128;
        try {
            
            while (salto<archivo.length()) {
                archivo.seek(salto);
                String cedula = archivo.readUTF();   
                if(cedula.equals(usuario.getCedula())){
                    archivo.seek(salto+12);
                    archivo.writeUTF(usuario.getNombre());
                    archivo.writeUTF(usuario.getApellido());
                    archivo.writeUTF(usuario.getCorreo());
                    archivo.writeUTF(usuario.getContrasena());
                    return true;
                }
                salto+=registro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (UsuarioDao:Update)");
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(Usuario usuario) {
        String cadena="";
        int salto = 0;
        int registro = 128;
        try {
            while(salto<archivo.length()){
                archivo.seek(salto);
                String cedula = archivo.readUTF();
                if(cedula.equals(usuario.getCedula())){
                    archivo.seek(salto);
                    archivo.writeUTF(String.format("%-" + 10 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 25 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 25 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 50 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 8 + "s", cadena));
                }
                salto+=registro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (UsuarioDao:Delite)");
            ex.printStackTrace();

        }
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> lista = new ArrayList<Usuario>();
        int salto = 0;
        int registro = 128;
        try {
            while(salto<archivo.length()){
                archivo.seek(salto);
                String cedula = archivo.readUTF().trim();
                String nombre = archivo.readUTF().trim();
                String apellido = archivo.readUTF().trim();
                String correo = archivo.readUTF().trim();
                String contraseña = archivo.readUTF().trim();
                Usuario usuario = new Usuario(cedula, nombre, apellido, correo, contraseña);
                lista.add(usuario);
                
                salto += registro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (UsuarioDao:Update)");
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public Usuario login(String correo, String contrasena) {
        int salto = 66;
        int registro = 128;
        try{
            while(salto<archivo.length()){
                archivo.seek(salto);
                String correoArchivo = archivo.readUTF();
                String contraseñaArchivo = archivo.readUTF();
                
                if(correo.equals(correoArchivo.trim()) && contrasena.equals(contraseñaArchivo.trim())){
                    salto = salto-66;
                    archivo.seek(salto);
                    Usuario usuario = new Usuario(archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim(), correoArchivo, contraseñaArchivo);
                    return usuario;
                }
                salto+=registro;
            }
        }catch(IOException ex){
            System.out.println("Error lectrura escritura (UsuarioDao:login)");
            ex.printStackTrace();
        }
        return null;
    }

}
