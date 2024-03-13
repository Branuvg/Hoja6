/** Algoritmos y Estructuras de datos -  seccion 30
 * Luis Francisco Padilla Juárez - 23663
 * Gabrein Bran Bolaños - 23590
 * HT6, hashmaps
 * 12-03-2324
 * @return Driver
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.sound.midi.Soundbank;


public class Driver {

    public static void main(String[] args) {
        MapFactory mapfact = new MapFactory();

        //variables de setteo
        boolean run = true;
        String database = "cards_desc.txt";
        String hashmenu = "1. HashMap\n" + 
        "2. TreeMap"+"\n"+
        "3. LinkedHashMap";
        String menu = "Coleccion de cartas"+"\n"+
        "1. Agregar una carta a la colección del usuario\n" + 
        "2. Mostrar el tipo de una carta específica"+"\n"+
        "3. Mostrar el nombre, tipo y cantidad de cada carta"+"\n"+
        "4. Mostrar el nombre, tipo y cantidad de cada carta, ordenadas por tipo"+"\n"+
        "5. Mostrar el nombre y tipo de todas las cartas existentes"+"\n"+
        "6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo"+"\n"+
        "7. Salir"+"\n";
        Scanner scanner = new Scanner(System.in);


        System.out.println(hashmenu);
            System.out.println("Ingrese una opcion: ");
            String opcion = scanner.nextLine();
            Map<String, String> map = mapfact.generate(opcion);

        //lector csv
        try (BufferedReader br = new BufferedReader(new FileReader(database))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("|");
                if (data.length >= 2) {
                    map.put(data[0], data[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        while (run == true){
            System.out.println(menu);
            System.out.println("Ingrese una opcion: ");
            opcion = scanner.nextLine();

            if(opcion.equals("1")){
                System.out.println("Nombre:");
                String name = scanner.nextLine();
                System.out.println("Tipo:");
                String type = scanner.nextLine();
                map.put(name, type);
            }
            if(opcion.equals("2")){
                System.out.println("Nombre:");
                String name = scanner.nextLine();
                System.out.println(map.get(name));

            }
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

            if(opcion.equals("4")){
                System.out.println("Nombre - Tipo - Cantidad");
                List<Map.Entry<String, String>> sortedList = new ArrayList<>(map.entrySet());
                sortedList.sort(Comparator.comparing(Map.Entry::getValue));
                for (Map.Entry<String, String> entry : sortedList) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }

            }
            if(opcion.equals("5")){
                System.out.println("Nombre - Tipo");
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
            }
            if(opcion.equals("6")){
                System.out.println("Nombre - Tipo");
                List<Map.Entry<String, String>> sortedList = new ArrayList<>(map.entrySet());
                sortedList.sort(Comparator.comparing(Map.Entry::getValue));
                for (Map.Entry<String, String> entry : sortedList) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
            }
            if(opcion.equals("7")){
                System.out.println("Saliendo del programa...");
                run = false;
            }
            
            
            //guardar datos para mas tarde
            try (FileWriter writer = new FileWriter(database)) {
                writer.write("name|type\n");
    
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    writer.write(entry.getKey() + "|" + entry.getValue() + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Ocurrió un error al guardar en " + database + "\n");
            }
           
        }
        }
    }

