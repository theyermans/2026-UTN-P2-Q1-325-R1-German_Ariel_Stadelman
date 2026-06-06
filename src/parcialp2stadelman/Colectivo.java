/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialp2stadelman;

/**
 *
 * @author yerman
 */
class Colectivo extends VehiculoTransporte {
   

    public Colectivo(String patente, int capacidad, String empresa, double costoBaseSeguridad) {
        super(patente, capacidad, empresa, costoBaseSeguridad);
        
    }

    @Override
    public double calcularCostoBase() {
        return costoBaseSeguridad * 1.0;
    }



    @Override
    public String toString() {
        return " | Colectivo "+ super.toString() + calcularCostoBase();
    }
}