/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.metroapp;
import Clases.CargadorDeParadas;
import Clases.Grafo;
import Clases.Parada;

        /**
 *
 * @author Godoy
 */
public class Metroapp {

    public static void main(String[] args) {
        Grafo grafo = new Grafo(3);

        // Crear paradas
        Parada p1 = new Parada("Parada A");
        Parada p2 = new Parada("Parada B");
        Parada p3 = new Parada("Parada C");

        // Agregar paradas al grafo
        grafo.agregarParada(p1, 0);
        grafo.agregarParada(p2, 1);
        grafo.agregarParada(p3, 2);

        // Conectar paradas
        grafo.conectarParadas(0, 1); // Conectar A a B
        grafo.conectarParadas(1, 2); // Conectar B a C

        // Mostrar conexiones
        grafo.mostrarConexiones();
        
        
        Grafo grafo2 = new Grafo(100); // Un tamaño inicial, ajusta según sea necesario

        // Cargar paradas desde el archivo JSON
        String rutaArchivo = "src/main/java/recursos/paradas.json"; // Nombre del archivo
        CargadorDeParadas.cargarParadas(grafo2, rutaArchivo);

        // Agregar conexiones manualmente o implementa la lógica para crear conexiones
        grafo2.conectarParadas(0, 1); // Ejemplo: conectar A a B
        grafo2.conectarParadas(1, 2); // Ejemplo: conectar B a C

        // Mostrar conexiones
        grafo2.mostrarConexiones();
    }
}
