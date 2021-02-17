package read;


import entity.Client;
import org.apache.commons.math3.analysis.function.Abs;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadExcel {

    public static ArrayList<Client> ReadExcel(FileInputStream file) throws IOException, InvalidFormatException {
        ArrayList<Client> clients = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int r = 0;
        int collumName = 0;
        int collunNumber = 1;
        XSSFRow row = sheet.getRow(r);
        while (row != null) {
            clients.add(new Client(row.getCell(collumName).toString(),(double) row.getCell(collunNumber).getNumericCellValue()));

            row = sheet.getRow(row.getRowNum() + 1);
            System.out.println();
        }
        workbook.close();
        return clients;
    }
}
