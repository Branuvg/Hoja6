/** Algoritmos y Estructuras de datos -  seccion 30
 * Luis Francisco Padilla Juárez - 23663
 * Gabrein Bran Bolaños - 23590
 * HT6, hashmaps
 * 12-03-2324
 * @return MapFactory
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapFactory {

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
        return new HashMap<>();
    }
}

