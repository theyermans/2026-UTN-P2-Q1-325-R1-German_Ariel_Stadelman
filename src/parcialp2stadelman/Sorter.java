/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialp2stadelman;

import java.util.ArrayList;

/**
 *
 * @author yerman
 */
class Sorter {
    private Sorter() {}

    /**
     * Algoritmo de Burbuja UNICO. 
     * Ordena cualquier lista de ElementoBase según el criterio dado.
     */
    public static ArrayList<PasajeBase> ordenar(ArrayList<PasajeBase> listaOriginal, CriterioOrdenamiento criterio) {
        ArrayList<PasajeBase> copia = new ArrayList<>(listaOriginal);
        int n = copia.size();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Delegamos la decisión de intercambio a la interfaz de criterio
                if (criterio.debeIntercambiar(copia.get(j), copia.get(j + 1))) {
                    PasajeBase temp = copia.get(j);
                    copia.set(j, copia.get(j + 1));
                    copia.set(j + 1, temp);
                }
            }
        }
        return copia;
    }
}
