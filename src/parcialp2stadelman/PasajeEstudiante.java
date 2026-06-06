/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialp2stadelman;

/**
 *
 * @author yerman
 */
 class PasajeEstudiante extends  PasajeBase{
    public PasajeEstudiante(String idPasaje,String nombrePasajero,VehiculoTransporte vehiculo){
       super(idPasaje,nombrePasajero,vehiculo);
         
     }
     @Override
     public double calcularCostoFinal(){
         return vehiculo.calcularCostoBase()*0.5;
     }
     @Override
     public void mostrarDetalleEspecifico(){
         System.out.println(" Categoria pasaje estudiante paga 50% tarifa");
     }
        
    
}
