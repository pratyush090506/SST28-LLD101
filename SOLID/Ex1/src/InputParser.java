import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Single responsibility: parse raw key=value; input into structured ParsedRegistration.
 */
public class InputParser {

    public ParsedRegistration parse(String raw) {
        Map<String, String> kv = new LinkedHashMap<>();
        if (raw != null) {
            String[] parts = raw.split(";");
            for (String p : parts) {
                String[] t = p.split("=", 2);
                if (t.length == 2) kv.put(t[0].trim(), t[1].trim());
            }
        }
        return new ParsedRegistration(
            kv.getOrDefault("name", ""),
            kv.getOrDefault("email", ""),
            kv.getOrDefault("phone", ""),
            kv.getOrDefault("program", "")
        );
    }
}
