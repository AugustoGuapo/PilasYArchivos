/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilasyarchivos;

/**
 *
 * @author pc
 */
public class NodoTrabajador {
    
    private Trabajador trabajador;
    private NodoTrabajador siguiente;

    public NodoTrabajador() {}
    public NodoTrabajador(Trabajador t) {
        trabajador = t;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public NodoTrabajador getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoTrabajador siguiente) {
        this.siguiente = siguiente;
    }
    
    @Override
    public String toString(){
        return trabajador.toString();
    }
}
