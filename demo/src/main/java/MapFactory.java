/** Algoritmos y Estructuras de datos -  seccion 30
 * Luis Francisco Padilla Juárez - 23663
 * Gabriel Bran Bolaños - 23590
 * HT6, hashmaps
 * 12-03-2324
 * @return MapFactory
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Fábrica para generar diferentes tipos de mapas según el tipo especificado.
 */
public class MapFactory {

    /**
     * Genera un mapa según el tipo especificado.
     * @param type El tipo de mapa a generar (1: HashMap, 2: TreeMap, 3: LinkedHashMap).
     * @return Un mapa del tipo especificado.
     */
    public Map<String, String> generate(String type) {
        if (type.equals("1")) {
            return new HashMap<>();
        }
        if (type.equals("2")) {
            return new TreeMap<>();
        }
        if (type.equals("3")) {
            return new LinkedHashMap<>();
        }
        // Si el tipo no coincide con ninguno de los especificados, se devuelve un HashMap por defecto
        return new HashMap<>();
    }
}
