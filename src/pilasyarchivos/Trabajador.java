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

    
    public Trabajador(String nombre, int horasTrabajadas, float vrHoraTrabajada) {
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
        this.vrHoraTrabajada = vrHoraTrabajada;
        this.totalSalario = calcularSalario(horasTrabajadas, vrHoraTrabajada);
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the horasTrabajadas
     */
    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    /**
     * @param horasTrabajadas the horasTrabajadas to set
     */
    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    /**
     * @return the vrHoraTrabajada
     */
    public float getVrHoraTrabajada() {
        return vrHoraTrabajada;
    }

    /**
     * @param vrHoraTrabajada the vrHoraTrabajada to set
     */
    public void setVrHoraTrabajada(float vrHoraTrabajada) {
        this.vrHoraTrabajada = vrHoraTrabajada;
    }

    /**
     * @return the totalSalario
     */
    public float getTotalSalario() {
        return totalSalario;
    }

    /**
     * @param totalSalario the totalSalario to set
     */
    public void setTotalSalario(float totalSalario) {
        this.totalSalario = totalSalario;
    }
    
    private float calcularSalario(int horas, float salarioPorHora) {
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
        return salida;
    }
    
    

    @Override
    public String toString() {
        return String.format("Nombre: %s\n Horas trabajadas: %d\n Salario por hora: %.2f\n Salario total: %.2f", getNombre(), getHorasTrabajadas(), getVrHoraTrabajada(), getTotalSalario());
    }
    
}
