/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author juan
 */
class ListaAdyacencia {
    private Nodo cabeza;

    public ListaAdyacencia() {
        this.cabeza = null;
    }

    public void agregar(Parada parada) {
        Nodo nuevoNodo = new Nodo(parada);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    public Nodo getCabeza() {
        return cabeza;
    }
}
