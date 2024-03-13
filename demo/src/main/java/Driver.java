/** Algoritmos y Estructuras de datos -  seccion 30
 * Luis Francisco Padilla Juárez - 23663
 * Gabriel Bran Bolaños - 23590
 * HT6, hashmaps
 * 12-03-2324
 * @return Driver
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Clase principal que contiene el método main para ejecutar el programa de gestión de colecciones de cartas.
 * Este programa permite agregar, mostrar y ordenar cartas en una colección utilizando diferentes tipos de mapas.
 */
public class Driver {

    /**
     * Método principal que ejecuta el programa.
     * @param args Argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        // Se crea una instancia de la fábrica de mapas
        MapFactory mapfact = new MapFactory();

        // Variables para configuración
        boolean run = true; // Controla el bucle principal del programa
        String database = "demo\\src\\main\\java\\cards_desc.txt"; // Ruta del archivo de datos
        String hashmenu = "1. HashMap\n" + 
                          "2. TreeMap\n" +
                          "3. LinkedHashMap"; // Menú para seleccionar el tipo de mapa
        String menu = "Colección de cartas\n" +
                      "1. Agregar una carta a la colección del usuario\n" + 
                      "2. Mostrar el tipo de una carta específica\n" +
                      "3. Mostrar el nombre, tipo y cantidad de cada carta\n" +
                      "4. Mostrar el nombre, tipo y cantidad de cada carta, ordenadas por tipo\n" +
                      "5. Mostrar el nombre y tipo de todas las cartas existentes\n" +
                      "6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo\n" +
                      "7. Salir\n"; // Menú principal
        Scanner scanner = new Scanner(System.in); // Objeto para leer la entrada del usuario

        // Se muestra el menú para seleccionar el tipo de mapa y se obtiene la opción del usuario
        System.out.println(hashmenu);
        System.out.println("Ingrese una opción: ");
        String opcion = scanner.nextLine();
        Map<String, String> map = mapfact.generate(opcion); // Se genera el mapa según la opción seleccionada

        // Lectura del archivo de datos CSV
        try (BufferedReader br = new BufferedReader(new FileReader(database))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|"); // Se utiliza "\\|" para dividir correctamente los datos
                if (data.length >= 2) {
                    map.put(data[0], data[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Bucle principal del programa
        while (run) {
            System.out.println(menu);
            System.out.println("Ingrese una opción: ");
            opcion = scanner.nextLine();

            // Agregar una carta a la colección
            if (opcion.equals("1")) {
                System.out.println("Nombre:");
                String name = scanner.nextLine();
                System.out.println("Tipo:");
                String type = scanner.nextLine();
                map.put(name, type);
            }

            // Mostrar el tipo de una carta específica
            if (opcion.equals("2")) {
                System.out.println("Nombre:");
                String name = scanner.nextLine();
                System.out.println(map.get(name));
            }

            // Mostrar el nombre, tipo y cantidad de cada carta
            if (opcion.equals("3")) {
                System.out.println("Nombre - Tipo - Cantidad");
                Map<String, Integer> countMap = new HashMap<>();
                for (String type : map.values()) {
                    countMap.put(type, countMap.getOrDefault(type, 0) + 1);
                }
                for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
            }

            // Mostrar el nombre, tipo y cantidad de cada carta, ordenadas por tipo
            if (opcion.equals("4")) {
                System.out.println("Nombre - Tipo - Cantidad");
                List<Map.Entry<String, String>> sortedList = new ArrayList<>(map.entrySet());
                sortedList.sort(Comparator.comparing(Map.Entry::getValue));
                for (Map.Entry<String, String> entry : sortedList) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
            }

            // Mostrar el nombre y tipo de todas las cartas existentes
            if (opcion.equals("5") || opcion.equals("6")) {
                System.out.println("Nombre - Tipo");
                List<Map.Entry<String, String>> sortedList = new ArrayList<>(map.entrySet());
                sortedList.sort(Comparator.comparing(Map.Entry::getValue));
                for (Map.Entry<String, String> entry : sortedList) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
            }

            // Salir del programa
            if (opcion.equals("7")) {
                System.out.println("Saliendo del programa...");
                run = false;
            }
        }
    }
}