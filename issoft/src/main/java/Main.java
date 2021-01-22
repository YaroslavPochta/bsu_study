
import jdk.jshell.execution.Util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main( String[] args ) throws IOException {
        List<String[]> messagesList = Utils.readWholeCSV("src\\main\\resources\\messages.csv");
        List<String[]> usersList = Utils.readWholeCSV("src\\main\\resources\\users.csv");

        Map<Integer, String> users = new HashMap<>();
        for (String[] strings: usersList) {
            users.put(Integer.parseInt(strings[0]), strings[1]);
        }
        List<Message> messages = new ArrayList<Message>();
        for (String[] row : messagesList) {
            messages.add(new Message(row));
        }

        Map<Date, List<Integer>> messageContainer = Utils.getIDsForEveryDate(messages);
        /*Map<Date, Integer> maxMessagesForEveryDay = new TreeMap<>();
        Integer tempDay = 1;
        Integer lastDayOfJune = 30;
        Date tempDate = new Date(2020, 06,tempDay);
        while (tempDay != lastDayOfJune) {
            maxMessagesForEveryDay.put(tempDate, Utils.maxFrequency();
            tempDate.setDate(tempDay);
            tempDay++;
        }
        System.out.println(maxMessagesForEveryDay);
        */

        int maxFrequencyId = Utils.maxFrequency(
                messageContainer.get(new Date(2020, 6,21)));
        System.out.println(users.get(maxFrequencyId));
        File myObj = new File("src\\main\\resources\\text");
        List<Integer> list = new ArrayList<>();
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String[] data = myReader.nextLine().split(",");
            for (String str: data) {
                list.add(Integer.parseInt(str));
            }
        }
        System.out.println(Utils.maxFrequency(list));
    }
}
