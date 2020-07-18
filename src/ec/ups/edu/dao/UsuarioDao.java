/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.dao;

import ec.ups.edu.idao.IUsuarioDao;
import ec.ups.edu.modelo.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UsuarioDao implements IUsuarioDao {

    private List<Usuario> listaUsuario;

    public UsuarioDao() {

        listaUsuario = new ArrayList<>();

    }

    @Override
    public void create(Usuario usuario) {

        listaUsuario.add(usuario);

    }

    @Override
    public Usuario read(String cedula) {
        //inicializacion  condicion incremento o decremento
        for (Usuario usuario : listaUsuario) {

            if (usuario.getCedula().equals(cedula)) {

                return usuario;

            }

        }

        return null;

    }

    @Override
    public void update(Usuario usuario) {

        for (int i = 0; i < listaUsuario.size(); i++) {

            Usuario usu = listaUsuario.get(i);

            if (usu.getCedula().equals(usuario)) {

                listaUsuario.set(i, usuario);

                break;

            }

        }

    }

    @Override
    public void delete(Usuario usuario) {

        Iterator<Usuario> it = listaUsuario.iterator();

        while (it.hasNext()) {

            Usuario usu = it.next();

            if (usu.getCedula().equals(usuario.getCedula())) {

                it.remove();

                break;

            }

        }

    }

    @Override
    public List<Usuario> findAll() {
        return listaUsuario;
    }

    @Override
    public Usuario login(String correo, String contrasena) {

        //el findAll devueleve toda la lista
        for (Usuario usuario1 : findAll()) {

            if (usuario1.getCorreo().equals(correo) && usuario1.getContrasena().equals(contrasena)) {

                return usuario1;

            }

        }

        return null;
    }

}
