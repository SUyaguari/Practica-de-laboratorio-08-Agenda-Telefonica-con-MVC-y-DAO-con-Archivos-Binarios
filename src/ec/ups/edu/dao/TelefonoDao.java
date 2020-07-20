/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.dao;

import ec.ups.edu.idao.ITelefonoDao;
import ec.ups.edu.modelo.Telefono;
import ec.ups.edu.modelo.Usuario;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author santi
 */
public class TelefonoDao implements ITelefonoDao {

    private int codigo;
    private int tamañoRegistro;
    private UsuarioDao usuarioDao;
    private RandomAccessFile archivo;

    /**
     * Estructura del archivo
     *
     * private int codigo; | 4 bytes
     * private String numero; | 25 bytes 
     * private String tipo; | 25 bytes 
     * private String operadora; | 25 bytes 
     * private Usuario usuario; i
     * dentificador | 10 bytes
     *
     * Tamaño de registro 99 bytes
     */
    public TelefonoDao() {
        try {
            archivo = new RandomAccessFile("datos/telefono.dat", "rw");
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura");
            ex.printStackTrace();
        }
        codigo = 0;
        tamañoRegistro = 97;
        usuarioDao = new UsuarioDao();

    }

    @Override
    public void create(Telefono telefono) {
        try {
            archivo.seek(archivo.length());
            archivo.writeInt(telefono.getCodigo());
            archivo.writeUTF(telefono.getNumero());
            archivo.writeUTF(telefono.getTipo());
            archivo.writeUTF(telefono.getOperadora());
            archivo.writeUTF(telefono.getUsuario().getCedula());
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (TelefonoDao:Create)");
            ex.printStackTrace();
        }

    }

    @Override
    public Telefono read(int codigo) {

        try {
            int salto = 0;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoArchivo = archivo.readInt();
                if (codigo == codigoArchivo) {
                    Telefono telefono = new Telefono(codigo, archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim());
                    Usuario usuario = usuarioDao.read(archivo.readUTF().trim());
                    telefono.setUsuario(usuario);
                    return telefono;
                }
                salto += tamañoRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (TelefonoDao:Read)");
            ex.printStackTrace();
        }

        return null;

    }

    @Override
    public boolean update(Telefono telefono) {

        int salto = 0;
        try {

            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigo = archivo.readInt();
                if (codigo == telefono.getCodigo()) {
                    archivo.writeUTF(telefono.getNumero());
                    archivo.writeUTF(telefono.getTipo());
                    archivo.writeUTF(telefono.getOperadora());
                    return true;
                }
                salto += tamañoRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (UsuarioDao:Update)");
            ex.printStackTrace();
        }
        return false;

    }

    @Override
    public void delete(Telefono telefono) {
        String cadena = "";
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigo = archivo.readInt();
                if (codigo == telefono.getCodigo()) {
                    archivo.seek(salto);
                    archivo.writeUTF(String.format("%-" + 4 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 25 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 25 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 25 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 10 + "s", cadena));
                }
                salto += tamañoRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (UsuarioDao:Delite)");
            ex.printStackTrace();

        }
    }

    @Override
    public List<Telefono> listarTelefonos() {

        List<Telefono> lista = new ArrayList<Telefono>();
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigo = archivo.readInt();
                String numero = archivo.readUTF().trim();
                String tipo = archivo.readUTF().trim();
                String operadora = archivo.readUTF().trim();
                String usuario = archivo.readUTF().trim();
                Telefono telefono = new Telefono(codigo, numero, tipo, operadora);
                Usuario u = usuarioDao.read(usuario);
                telefono.setUsuario(u);
                lista.add(telefono);

                salto += tamañoRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (TelefonoDao:ListarTelefonos)");
            ex.printStackTrace();
        }
        return lista;

    }

    @Override
    public List<Telefono> telefonosUsuario(String id) {
        List<Telefono> teles = new ArrayList<>();

        try {
            int salto = 85;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                try{
                    String aux = archivo.readUTF().trim();
                    System.out.println(aux);
                    if (aux.equals(id.trim())) {

                        archivo.seek(salto - 85);
                        int valor = archivo.readInt();
                        if (valor > 0) {
                            Telefono tele = new Telefono(valor, archivo.readUTF().trim(),
                                    archivo.readUTF().trim(), archivo.readUTF().trim());
                            teles.add(tele);
                        }

                    }
                }catch(EOFException ex){
                    System.out.println("Error lectrura escritura (TelefonoDao:telefonosUsuario)");
                    ex.printStackTrace();
                }
                
                salto += tamañoRegistro;
            }
            return teles;
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (TelefonoDao:telefonosUsuario)");
            ex.printStackTrace();
        }

        return teles;
    }

    @Override
    public int obtenerUltimoCodigo() {

        try {
            if (archivo.length() > 0) {
                codigo = (int) (archivo.length()/tamañoRegistro);
            }
        } catch (IOException ex) {
            System.out.println("Error lectrura escritura (TelefonoDao:obtenerUltimoCodigo)");
            ex.printStackTrace();
        }
        return codigo;

    }
}
