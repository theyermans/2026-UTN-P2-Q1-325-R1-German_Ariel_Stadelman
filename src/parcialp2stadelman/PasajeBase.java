/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialp2stadelman;

/**
 *
 * @author yerman
 */
abstract class PasajeBase  implements Pasaje{
    protected String idPasaje;
    protected  String nombrePasajero;
    protected VehiculoTransporte vehiculo;
    
    public PasajeBase(String idPasaje,String nombrePasajero,VehiculoTransporte vehiculo){
        this.idPasaje = idPasaje;
        this.nombrePasajero = nombrePasajero;
        this.vehiculo = vehiculo;
    }
    
    public String getIdPasaje(){return idPasaje;}
    public String getNombrePasajero(){return nombrePasajero;}
    public VehiculoTransporte getVehiculoTransporte(){return vehiculo;}
    
    public abstract void mostrarDetalleEspecifico();
    
    @Override
    public boolean equals(Object obj){
        if(this== obj)return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        
        PasajeBase other = (PasajeBase) obj;
        return this.idPasaje != null && this.idPasaje.equalsIgnoreCase(other.idPasaje);
    }    
    
    @Override
    public String toString(){
        return "ID: " + idPasaje + 
               " | Nombre: " + nombrePasajero + 
               " | Vehiculo: " + vehiculo.getPatente()+
                " | Tarifa Final: $ : " + String.format("%.2f",calcularCostoFinal());
    }
    
    
}
