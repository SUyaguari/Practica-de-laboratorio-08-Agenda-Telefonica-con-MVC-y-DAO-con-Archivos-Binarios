package ec.ups.edu.modelo;

import java.util.ArrayList;
import java.util.List;

public class Telefono {

    private int codigo;
    private String numero;
    private String tipo;
    private String operadora;
    private Usuario usuario;
    
    
    public Telefono() {
        
    }

    public Telefono(int codigo, String numero, String tipo, String operadora) {
        this.setCodigo(codigo);
        this.setNumero(numero);
        this.setTipo(tipo);
        this.setOperadora(operadora);
        
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = validarEspacios(numero, 25);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = validarEspacios(tipo, 25);
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = validarEspacios(operadora, 25);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

     public String validarEspacios(String cadena, int numero){
        if(cadena.length()==numero){
            return cadena;
        }else{
            if(cadena.length()>numero){
                cadena = cadena.substring(0,numero);
                return cadena;
            }else{
                for (int i = cadena.length(); i < numero; i++) {
                    cadena+=" ";
                }
                return cadena;
            }
        }
    }
     
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefono other = (Telefono) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telefono{" + "codigo=" + codigo + ", numero=" + numero + ", tipo=" + tipo + ", operadora=" + operadora + '}';
    }

}
