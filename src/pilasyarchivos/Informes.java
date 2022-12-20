/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilasyarchivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Augusto
 */
public class Informes {
    private File archivo;
    
    public Informes(){};
    
    public static void informeMaximos(Pila p, float salarioBuscado) throws IOException {
        FileWriter fw = new FileWriter("TRABAJADORESMAX.txt");
        NodoTrabajador aux = p.cima();
        if(aux.getTrabajador().getTotalSalario() < salarioBuscado) fw.write("NO SE ENCONTRÓ NINGÚN TRABAJADOR CON ESE SALARIO");
        else {
            while(aux != null && aux.getTrabajador().getTotalSalario() > salarioBuscado ) {
                Trabajador trabajadorTemp = aux.getTrabajador();
                fw.write(trabajadorTemp.getNombre());
                fw.write(String.valueOf(trabajadorTemp.getTotalSalario()));
                fw.write("\n");
                aux = aux.getSiguiente();
            }
            fw.close();
        }
        JOptionPane.showMessageDialog(null, "Archivo completado");
    }
    
    public static void informeMinimos(Pila p, float salarioBuscado) throws IOException {
        FileWriter fw = new FileWriter("TRABAJADORESMIN.txt");
        NodoTrabajador aux = p.cima();
        while(aux != null) {
            if(aux.getTrabajador().getTotalSalario() > salarioBuscado) aux = aux.getSiguiente();
            else {
                fw.write(aux.getTrabajador().getNombre());
                fw.write(String.valueOf(aux.getTrabajador().getTotalSalario()));
                fw.write("\n");
            }
        }
        fw.close();
    }
    
    public static void informacionGeneral(PilaTrabajador p) throws IOException {
        FileWriter fw = new FileWriter("Información.txt");
        if(p.pilaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay trabajadores registrados");
            fw.close();
            return;
        }
        else {
            Trabajador alto = p.cima().getTrabajador();
            Trabajador bajo = p.ultimo().getTrabajador();
            fw.write(String.format("""
                                   Promedio de salario %.2f
                                   Salario m\u00e1s alto
                                   Nombre: %s
                                   Salario: %.2f
                                   Salario m\u00e1s bajo
                                   Nombre: %s
                                   Salario: %.2f""",p.calcularPromedio(), alto.getNombre(), 
                    alto.getTotalSalario(), bajo.getNombre(), bajo.getTotalSalario()));
        }
        fw.close();
    }
 }
