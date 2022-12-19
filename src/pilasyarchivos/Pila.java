/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilasyarchivos;

/**
 *
 * @author pc
 */
public interface Pila <T>{
    
    public boolean pilaVacia();
    public NodoTrabajador cima ();
    public void apilar(NodoTrabajador t);
    public NodoTrabajador desapilar();
    public void mostrarPila();
    
    
}
