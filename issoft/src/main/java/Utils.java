import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Utils {

    public static List<String[]> readWholeCSV( String path ) throws IOException {
        CSVReader reader = new CSVReader(
                new FileReader(path), ',', '"', 1);
        List<String[]> rows = reader.readAll();
        return rows;
    }

    public static Map<Date, List<Integer>> getIDsForEveryDate( List<Message> messages ) {
        Map<Date, List<Integer>> messageContainer = new HashMap<Date, List<Integer>>();
        for (Message message : messages) {
            if (!messageContainer.containsKey(message.getDate())) {
                messageContainer.put(message.getDate(), new ArrayList<Integer>());
            }
            messageContainer.get(message.getDate()).add(message.getIdFrom());
            messageContainer.get(message.getDate()).add(message.getIdTo());
        }
        return messageContainer;
    }


    public static Integer maxFrequency( List<Integer> list) {
        int result = list.get(0);
        int maxCount = 1;
        int currentCount = 1;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1)))
                currentCount++;
            else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    result = list.get(i - 1);
                }
                currentCount = 1;
            }
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            result = list.get(list.size() - 1);
        }
        return result;
    }
}
