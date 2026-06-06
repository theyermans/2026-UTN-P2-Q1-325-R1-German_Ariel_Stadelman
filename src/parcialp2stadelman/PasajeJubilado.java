/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialp2stadelman;

/**
 *
 * @author yerman
 */
class PasajeJubilado extends PasajeBase{
        public PasajeJubilado(String idPasaje,String nombrePasajero,VehiculoTransporte vehiculo){
       super(idPasaje,nombrePasajero,vehiculo);

     }
     @Override
     public double calcularCostoFinal(){
         return vehiculo.calcularCostoBase()*0.25;
     }
     @Override
     public void mostrarDetalleEspecifico(){
         System.out.println(" Categoria pasaje Jubilado  paga 25% tarifa");
     }
      
    
}
