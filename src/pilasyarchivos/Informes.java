/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilasyarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        boolean existe = false;
        while(aux != null) {
            if(aux.getTrabajador().getTotalSalario() < salarioBuscado) aux = aux.getSiguiente();
            else {
                fw.write(aux.getTrabajador().getNombre()+"\n");
                fw.write(String.valueOf(aux.getTrabajador().getTotalSalario()));
                fw.write("\n");
                aux = aux.getSiguiente();
                existe = true;
            }
        }
        String mensaje = existe ? "Archivo completado" : "No existen salarios por encima del valor ingresado";
JOptionPane.showMessageDialog(null, mensaje);
        fw.close();
    }
    
    public static void informeMinimos(Pila p, float salarioBuscado) throws IOException {
        FileWriter fw = new FileWriter("TRABAJADORESMIN.txt");
        NodoTrabajador aux = p.cima();
        boolean existe = false;
        while(aux != null) {
            if(aux.getTrabajador().getTotalSalario() > salarioBuscado) aux = aux.getSiguiente();
            else {
                fw.write(aux.getTrabajador().getNombre()+"\n");
                fw.write(String.valueOf(aux.getTrabajador().getTotalSalario()));
                fw.write("\n");
                aux = aux.getSiguiente();
                existe = true;
            }
        }
        String mensaje = existe ? "Archivo completado" : "No existen salarios por debajo del valor ingresado";
JOptionPane.showMessageDialog(null, mensaje);
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
            Trabajador bajo = p.cima().getTrabajador();
            Trabajador alto = p.ultimo().getTrabajador();
            fw.write(String.format("""
                                   Promedio de salario: %.2f
                                   SALARIO MÁS ALTO:
                                   Nombre: %s
                                   Salario: %.2f
                                   SALARIO MÁS BAJO:
                                   Nombre: %s
                                   Salario: %.2f""",p.calcularPromedio(), alto.getNombre(), 
                    alto.getTotalSalario(), bajo.getNombre(), bajo.getTotalSalario()));
        }
        JOptionPane.showMessageDialog(null, "Archivo completado");
        fw.close();
    }
    
    public static String leerArchivo(String direccion) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(direccion);
        BufferedReader br = new BufferedReader(fr);
        String salida = "";
        String linea = br.readLine();
        while(linea != null) {
            salida+=linea + "\n";
            linea = br.readLine();
        }
        return salida;
    }
 }
