/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CargadorDeParadas {
    public static void cargarParadas(Grafo grafo, String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            JsonObject json = JsonParser.parseReader(br).getAsJsonObject();
            JsonArray lineas = json.getAsJsonArray("Metro de Caracas");

            int index = 0; // Inicializa un índice para las paradas

            for (int i = 0; i < lineas.size(); i++) {
                JsonObject lineaJson = lineas.get(i).getAsJsonObject();
                String nombreLinea = lineaJson.keySet().iterator().next();
                JsonArray paradasLinea = lineaJson.getAsJsonArray(nombreLinea);

                for (int j = 0; j < paradasLinea.size(); j++) {
                    String nombreParada;

                    if (paradasLinea.get(j).isJsonObject()) {
                        JsonObject paradaJson = paradasLinea.get(j).getAsJsonObject();
                        nombreParada = paradaJson.keySet().iterator().next(); // Nombre de la parada
                        String paradaConectada = paradaJson.get(nombreParada).getAsString(); // Nombre de la parada conectada

                        // Agregar ambas paradas al grafo
                        grafo.agregarParada(new Parada(nombreParada), index++);
                        grafo.agregarParada(new Parada(paradaConectada), index++);

                        // Conectar las paradas (suponiendo que cada parada conectada está en índices consecutivos)
                        grafo.conectarParadas(index - 2, index - 1); // Conectar las paradas
                    } else {
                        nombreParada = paradasLinea.get(j).getAsString(); // Nombre de la parada
                        grafo.agregarParada(new Parada(nombreParada), index++); // Agregar la parada al grafo
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}