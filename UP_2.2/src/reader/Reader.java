package reader;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sample.Country;

import java.io.*;

public class Reader {
    public void read(File file, ObservableList<Country> countryObservableList) {
        try {
            Workbook workbook = new XSSFWorkbook(file);

            for (Row row : workbook.getSheetAt(0)) {
                Image image = new Image(getCellText(row.getCell(0)));
                ImageView imageView = new ImageView(image);
                countryObservableList.add(new Country(imageView,
                        getCellText(row.getCell(1)),
                        Double.parseDouble(getCellText(row.getCell(2)))));
            }

        } catch (FileNotFoundException e) {
            alert("You haven't chose some file!");
        } catch (IOException e) {

        } catch (InvalidFormatException| IllegalArgumentException e) {
             alert("You haven't chose some file!");
        }
    }

    public static void alert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    public static String getCellText(Cell cell){

        switch (cell.getCellType()) {
            case STRING:
                return cell.getRichStringCellValue().getString();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return Double.toString(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula().toString();
            case BLANK:
                return "";
            case ERROR:
                break;
            default:
                System.out.println();
        }

        return null;
    }
}
