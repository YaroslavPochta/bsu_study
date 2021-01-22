package print;

import exceptions.FileException;
import model.Component;
import org.apache.logging.log4j.core.appender.rolling.FileExtension;

import javax.annotation.processing.FilerException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputText {
    public String restoreText( Component text ){
        return text.toString();
    }
}
