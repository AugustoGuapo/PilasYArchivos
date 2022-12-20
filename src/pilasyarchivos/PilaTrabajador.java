/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilasyarchivos;

import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class PilaTrabajador implements Pila<NodoTrabajador> {
    
    private NodoTrabajador pila;

    public PilaTrabajador() {
        pila = null;
    }

    public NodoTrabajador getPila() {
        return pila;
    }
    
    @Override
    public boolean pilaVacia(){
        return pila == null;
    }

    @Override
    public NodoTrabajador cima(){
        if(pilaVacia()){
            JOptionPane.showMessageDialog(null, "La pila está vacía");
        }
        return pila;
    }

    @Override
    public void apilar(NodoTrabajador t) {
        if(pilaVacia()){ 
            pila = t;
        }else{ 
            if(t.getTrabajador().getTotalSalario() < pila.getTrabajador().getTotalSalario()){    
                t.setSiguiente(pila); 
                pila = t; 
            }else{ 
                NodoTrabajador aux = pila; 
                while(aux.getSiguiente() != null && t.getTrabajador().getTotalSalario() > aux.getSiguiente().getTrabajador().getTotalSalario()){ 
                    aux = aux.getSiguiente(); 
                } 
                t.setSiguiente(aux.getSiguiente()); 
                aux.setSiguiente(t); 
            }
        }
    }
    
    @Override
    public NodoTrabajador desapilar(){
        NodoTrabajador aux;
        if(pilaVacia()){
            JOptionPane.showMessageDialog(null, "La pila esta vacia");
        }
        aux = cima();
        pila = pila.getSiguiente();
        return aux;
    }

    @Override
    public void mostrarPila() {
        NodoTrabajador aux = pila;
        while(aux != null){
            JOptionPane.showMessageDialog(null, aux.toString());
            aux = aux.getSiguiente();
        }
    }
    
    public float calcularPromedio() {
        NodoTrabajador aux = pila;
        float sumatoria = 0;
        int contador = 0;
        while(aux != null) {
            sumatoria += aux.getTrabajador().getTotalSalario();
            contador++;
            aux = aux.getSiguiente();
        }
        return sumatoria/contador;
        
    }
    
    public NodoTrabajador ultimo() {
        NodoTrabajador aux = pila;
        while(aux.getSiguiente() != null) aux = aux.getSiguiente();
        return aux;
    }
    
}
