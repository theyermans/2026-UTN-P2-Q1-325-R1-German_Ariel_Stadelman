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
class GestorColeccion {
    private ArrayList<PasajeBase> lista;

    public GestorColeccion() {
        this.lista = new ArrayList<>();
    }

    
    public static void mostrarLista(ArrayList<PasajeBase> listaAMostrar, String titulo) {
        System.out.println("\n===== " + titulo + " =====");
        if (listaAMostrar.isEmpty()) {
            System.out.println("Lista vacía.");
            return;
        }
        for (int i = 0; i < listaAMostrar.size(); i++) {
            System.out.println((i + 1) + ". " + listaAMostrar.get(i));
        }
    }
    public boolean agregarElemento(PasajeBase nuevo) {
        if (nuevo == null) return false;
        
        if (existeElemento(nuevo)) {
            System.out.println("Error: Ya existe un registro con el ID " + nuevo.getIdPasaje());
            return false;
        }
        lista.add(nuevo);
        return true;
    }

    public boolean existeElemento(PasajeBase buscado) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(buscado)) {
                return true;
            }
        }
        return false;
    }

    public PasajeBase buscarPorId(String id) {
        for (int i = 0; i < lista.size(); i++) {
            PasajeBase temp = lista.get(i);
            if (temp.getIdPasaje().equalsIgnoreCase(id)) {
                return temp;
            }
        }
        return null;
    }

    public ArrayList<PasajeBase> obtenerTodos() {
        return this.lista;
    }
    
    public double calcularTotalRecaudado(){
        double total = 0.0;
        for (int i = 0; i < lista.size(); i++) {
            total += lista.get(i).calcularCostoFinal();
            
        }
        
        return total;
    }

    /*public void ejecutarActividadGrupal() {
        if (lista.isEmpty()) {
            System.out.println("No hay elementos registrados para realizar la actividad.");
            return;
        }
        System.out.println("\n===== INICIANDO ACTIVIDAD GRUPAL =====");
        for (int i = 0; i < lista.size(); i++) {
            PasajeBase elemento = lista.get(i);
            if (elemento instanceof Pasaje) {
                ((Pasaje) elemento).();
            } else {
                System.out.println("⚠️ [Aviso]: [" + elemento.getNombreComun() + "] no es apto para esta actividad.");
            }
        }
    }*/

    // =========================================================================
    // IMPLEMENTACIÓN DE CRITERIOS USANDO CLASES ANÓNIMAS 
    // =========================================================================

    // Criterio 1: Año Descendente (el elemento menor va hacia atrás)
    public ArrayList<PasajeBase> obtenerOrdenadosPorCostoDesc() {
        return Sorter.ordenar(this.lista, new CriterioOrdenamiento() {
            @Override
            public boolean debeIntercambiar(PasajeBase a, PasajeBase b) {
                // Intercambia si el actual (a) es menor que el siguiente (b) -> orden descendente
                return a.calcularCostoFinal()< b.calcularCostoFinal();
            }
        });
    }

 
    public ArrayList<PasajeBase> obtenerOrdenadosPorNombreAsc() {
        return Sorter.ordenar(this.lista, new CriterioOrdenamiento() {
            @Override
            public boolean debeIntercambiar(PasajeBase a, PasajeBase b) {
                return a.getNombrePasajero().compareToIgnoreCase(b.getNombrePasajero()) >0;
            }
        });
    }
    
    
    
    
}
