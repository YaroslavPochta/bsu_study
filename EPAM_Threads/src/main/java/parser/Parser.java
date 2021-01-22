package parser;

import validator.ParserValidator;
import java.util.*;

public class Parser {
    private final ParserValidator validator = new ParserValidator();
    private final List<Map.Entry<String, Integer>> lots = new ArrayList<>();
    private final List<Map.Entry<String, Integer>> clients = new ArrayList<>();

    public Map.Entry<List<Map.Entry<String, Integer>>, List<Map.Entry<String, Integer>>> parse( List<String> arrayListStrings ) {
        int i = 0;
        while (!arrayListStrings.get(i).equals("lots:")) {
            if (validator.validate(arrayListStrings.get(i))) {
                StringTokenizer stringTokenizer = new StringTokenizer(arrayListStrings.get(i), " ");
                clients.add(new HashMap.SimpleEntry<>(stringTokenizer.nextToken(), Integer.parseInt(stringTokenizer.nextToken())));
            }
            i++;
        }

        i++;
        while (i != arrayListStrings.size()) {
            if (validator.validate(arrayListStrings.get(i))) {
                StringTokenizer stringTokenizer = new StringTokenizer(arrayListStrings.get(i), " ");
                lots.add(new HashMap.SimpleEntry<>(stringTokenizer.nextToken(), Integer.parseInt(stringTokenizer.nextToken())));
            }
            i++;
        }
        return new HashMap.SimpleEntry<>(clients, lots);
    }
}