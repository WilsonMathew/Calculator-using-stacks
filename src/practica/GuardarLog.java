/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

/**
 *
 * @author Gaspar Wilson Laynez Mateo
 */
public class GuardarLog {
    
    private String dato;
    private String operacion;
    private String estadoPila;

    public GuardarLog(String dato, String operacion, String estadoPila){
        this.dato = dato;
        this.operacion = operacion;
        this.estadoPila = estadoPila;
    }
    /**
     * @return the dato
     */
    public String getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(String dato) {
        this.dato = dato;
    }

    /**
     * @return the operacion
     */
    public String getOperacion() {
        return operacion;
    }

    /**
     * @param operacion the operacion to set
     */
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    /**
     * @return the estadoPila
     */
    public String getEstadoPila() {
        return estadoPila;
    }

    /**
     * @param estadoPila the estadoPila to set
     */
    public void setEstadoPila(String estadoPila) {
        this.estadoPila = estadoPila;
    }

}
