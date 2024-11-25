package Utility;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFileData {

    public static String getConfigPropertiesFileData(String value) throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("D:\\SoftwareTesting\\Projects\\OrangeHumanResourceManagement-HRDomain\\src\\main\\resources\\TestData\\config.properties");
        properties.load(file);
        return properties.getProperty(value);
    }


    public static String readExcelFileData(int row, int cell) throws IOException {
        FileInputStream file = new FileInputStream("D:\\SoftwareTesting\\Projects\\OrangeHumanResourceManagement-HRDomain\\src\\main\\resources\\TestData\\orangehrmdoc.xlsx");
        Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet1");
        return sheet.getRow(row).getCell(cell).getStringCellValue();
    }
}
