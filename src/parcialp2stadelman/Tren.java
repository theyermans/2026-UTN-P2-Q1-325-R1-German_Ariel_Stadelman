/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialp2stadelman;

/**
 *
 * @author yerman
 */
class Tren extends VehiculoTransporte   {
    

    public Tren(String patente, int capacidad, String empresa, double costoBaseSeguridad) {
        super(patente, capacidad, empresa, costoBaseSeguridad);
        
    }
         //Getter

    @Override
    public double calcularCostoBase() {
        return costoBaseSeguridad * 1.10;
    }

    @Override
    public String toString() {
        return "Tren " + super.toString() + "costo base "+  String.format("%.2f",calcularCostoBase());
    }
}



