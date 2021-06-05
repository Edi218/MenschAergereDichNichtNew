import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<String, String> dict = new HashMap<>();
        dict.put("Hello", "Hallo");
        dict.put("World", "Welt");
        dict.put("Morning", "Morgen");

        System.out.println(dict.get("World"));

        dict.put("World", "Globus");
        System.out.println(dict.get("World"));

        for (Map.Entry entry: dict.entrySet()) {
            System.out.println("Key:"  + entry.getKey());
            System.out.println("Value:"  + entry.getValue());
        }

        for (String key: dict.keySet()) {
            System.out.println("Key:"  + key);
            System.out.println("Value:"  + dict.get(key));
        }

        for (String value: dict.values()) {
            System.out.println("Value:"  + value);
        }

        dict.entrySet().forEach(entry -> {
            System.out.println("Key:"  + entry.getKey());
            System.out.println("Value:"  + entry.getValue());
        });
    }
}
