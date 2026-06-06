/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialp2stadelman;

/**
 *
 * @author yerman
 */
/*class Subte extends VehiculoTransporte  {
    private boolean atributoEspecificoC;
    
    public Subte(String idUnico, String nombreComun, int capacidad, int anio, boolean atributoEspecificoC){
        super(idUnico, nombreComun, capacidad, anio);
        this.atributoEspecificoC = atributoEspecificoC;  
    }
    public boolean  getAtributoEspecificoC (){return atributoEspecificoC;}
    
    @Override
    public void calcularCostoBase(){
        System.out.println("Tipo Clase C:  dato"+ atributoEspecificoC);
    }
    
    
    
    @Override
    public String toString(){
        return super.toString() + "Clase C atributo: "+ atributoEspecificoC;
    }
    
}*/
class Subte extends VehiculoTransporte {
    

    public Subte(String patente, int capacidad, String empresa, double costoBaseSeguridad) {
        super(patente, capacidad, empresa, costoBaseSeguridad);
        
    }

    @Override
    public double calcularCostoBase() {
        return costoBaseSeguridad * 0.95;
    }

    @Override
    public String toString() {
        return "Subte" + super.toString() + "costo base "+  String.format("%.2f",calcularCostoBase());
    }
 }
    

