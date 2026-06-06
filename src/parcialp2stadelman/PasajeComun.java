/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialp2stadelman;

/**
 *
 * @author yerman
 */
 class PasajeComun extends  PasajeBase{
     public PasajeComun(String idPasaje,String nombrePasajero,VehiculoTransporte vehiculo){
             super(idPasaje,nombrePasajero,vehiculo);
         
     }
     @Override
     public double calcularCostoFinal(){
         return vehiculo.calcularCostoBase();
     }
     @Override
     public void mostrarDetalleEspecifico(){
         System.out.println(" Categoria pasaje comun paga 100% tarifa");
     }
             
             
    
}
