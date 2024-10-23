/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author juan
 */
public class Grafo {
    private ListaAdyacencia[] listaConexiones;
    private Parada[] paradas;
    private int numeroDeParadas;

    public Grafo(int numeroDeParadas) {
        this.numeroDeParadas = numeroDeParadas;
        listaConexiones = new ListaAdyacencia[numeroDeParadas];
        for (int i = 0; i < numeroDeParadas; i++) {
            listaConexiones[i] = new ListaAdyacencia();
        }
        paradas = new Parada[numeroDeParadas]; // Para almacenar paradas
    }

    public void agregarParada(Parada nuevaParada, int index) {
        if (index < numeroDeParadas) {
            paradas[index] = nuevaParada;
        }
    }

    public void conectarParadas(int index1, int index2) {
        if (index1 < numeroDeParadas && index2 < numeroDeParadas) {
            listaConexiones[index1].agregar(paradas[index2]); // Conectar paradas
        }
    }

    public void mostrarConexiones() {
        for (int i = 0; i < numeroDeParadas; i++) {
            System.out.print("Parada " + paradas[i].getNombre() + " esta conectada a: ");
            Nodo nodoActual = listaConexiones[i].getCabeza();
            while (nodoActual != null) {
                System.out.print(nodoActual.parada.getNombre() + " ");
                nodoActual = nodoActual.siguiente;
            }
            System.out.println();
        }
    }
}