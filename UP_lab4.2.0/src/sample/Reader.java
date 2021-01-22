package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public String read(String name) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(name));
        StringBuilder stringBuilder = new StringBuilder();
        String string;
        while((string = bufferedReader.readLine()) != null){
            stringBuilder.append(string + '\n');
        }
        return stringBuilder.toString();
    }
}
