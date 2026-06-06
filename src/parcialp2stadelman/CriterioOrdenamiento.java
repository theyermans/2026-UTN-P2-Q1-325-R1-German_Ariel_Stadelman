/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package parcialp2stadelman;

/**
 *
 * @author yerman
 */
interface CriterioOrdenamiento {
    /**
     * @param a Primer elemento
     * @param b Segundo elemento
     * @return true si 'a' debe intercambiarse con 'b' para cumplir el orden deseado.
     */
    boolean debeIntercambiar(PasajeBase a, PasajeBase b);
}