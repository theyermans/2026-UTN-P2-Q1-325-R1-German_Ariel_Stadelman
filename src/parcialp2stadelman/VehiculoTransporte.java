/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialp2stadelman;

/**
 *
 * El sistema debe permitir gestionar los diferentes tipos de vehículos de transporte (colectivo,
tren, subte) y sus respectivos viajes. Cada viaje incluye información sobre el vehículo, el
pasajero, el tipo de pasaje (común, estudiante, jubilado), y el costo final.
 */
abstract class VehiculoTransporte {
    protected String patente;
    protected int capacidad;
    protected String empresa;
    protected double costoBaseSeguridad;
    public VehiculoTransporte(String patente, int capacidad, String empresa, double costoBaseSeguridad){
            this.patente = patente;
            this.capacidad = capacidad;
            this.empresa = empresa;
            this.costoBaseSeguridad = costoBaseSeguridad;        
    }
    //Getters
    public String getPatente(){return patente;}
    public int getCapacidad(){return capacidad;}
    public String getEmpresa(){return empresa;}
    public double getCostoBaseSeguridad(){return costoBaseSeguridad;}
    
    public abstract double calcularCostoBase();
    
    /*@Override
    public boolean equals(Object obj){
        if(this== obj)return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        
        VehiculoTransporte other = (VehiculoTransporte) obj;
        return this.idUnico != null && this.idUnico.equalsIgnoreCase(other.idUnico);
    }    */
    
    @Override
    public String toString(){
        return"Patente: "+ patente+" -- Empresa: " + empresa + "-- Capacidad: "+ capacidad;
    }
     

    
}
