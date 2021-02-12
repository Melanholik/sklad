import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import read.ReadExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        File file = new File("C:\\Lihuta V.V\\Java\\Primer.xlsx");
        FileInputStream inputStream  = new FileInputStream(file);
        ReadExcel readExcel = new ReadExcel(inputStream);
        inputStream.close();
    }
}
