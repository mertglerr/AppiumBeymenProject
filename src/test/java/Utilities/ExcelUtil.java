package Utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtil {

  private static   String filePath="C:\\Users\\mg_me\\OneDrive\\Masaüstü\\selenium kursu\\" +
          "AppiumBeymenProject\\src\\test\\java\\data\\keywords.xlsx";

    public static String getCellData(int rowNum, int colNum) {
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);
            return sheet.getRow(rowNum).getCell(colNum).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
