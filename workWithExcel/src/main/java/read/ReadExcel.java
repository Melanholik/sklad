package read;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ReadExcel {

    public ReadExcel(FileInputStream file) throws IOException, InvalidFormatException {
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int r = 0;
        XSSFRow row = sheet.getRow(r);
        while (row != null) {
            int collum = 0;
            while (row.getCell(collum) != null) {
                System.out.print(row.getCell(collum) + "|");
                collum++;
            }
            row = sheet.getRow(row.getRowNum() + 1);
            System.out.println();
        }
        workbook.close();
    }
}
