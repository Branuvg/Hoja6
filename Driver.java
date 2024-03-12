import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Driver {

    public static void main(String[] args) {
        ArrayList<Card> cards = new ArrayList<Card>();

        //variables de setteo
        boolean run = true;
        String database = "cards_desc.txt";
        String menu = "Aerolinea XD"+"\n"+
        "1. Crear ususario\n" + 
        "2. iniciar sesion"+"\n"+
        "3. Salir";
        Scanner scanner = new Scanner(System.in);

        //lector csv
        try (BufferedReader br = new BufferedReader(new FileReader(database))) {
            String encabezado = br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split("|");
                
                // Extraer los valores del CSV
                String name = valores[0];
                String type = valores[1];
                
                
                
            }
        } catch (IOException e) {
            e.printStackTrace();

        while (run == true){

        }
        //guardar datos para mas tarde
               try (FileWriter writer = new FileWriter(database)) {
               
                   writer.write("name,type\n");
                   
                   for (int i = 0; i <cards.size(); i++) {
                       writer.write(
                       cards.get(i).getName()+ ","+
                       cards.get(i).getType()+ ","+
                       "\n" );
               } 
               }catch (IOException e) {
                   e.printStackTrace();
                   System.out.println("Ocurrio un error al guardar en " + database +"\n");
               }
        }    
        
        }
    }
