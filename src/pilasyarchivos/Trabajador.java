/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilasyarchivos;

/**
 *
 * @author Augusto
 */
public class Trabajador {
    private String nombre;
    private int horasTrabajadas;
    private float vrHoraTrabajada;
    private float totalSalario;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public float getVrHoraTrabajada() {
        return vrHoraTrabajada;
    }

    public void setVrHoraTrabajada(float vrHoraTrabajada) {
        this.vrHoraTrabajada = vrHoraTrabajada;
    }

    public float getTotalSalario() {
        return totalSalario;
    }

    public void setTotalSalario(float totalSalario) {
        this.totalSalario = totalSalario;
    }
    
    public void calcularSalario(int horas, float salarioPorHora) {
        float salida;
        if(horas >48) {
            salida = (40*salarioPorHora) + (8*(salarioPorHora*2)) + ((horas-48)*(salarioPorHora*3));
        }
        
        else if (horas > 40) {
            salida = (40*salarioPorHora) + (horas-40*(salarioPorHora*2));
        } 
        
        else {
            salida = horas*salarioPorHora;
        }
        totalSalario = salida;
    }
    
}
