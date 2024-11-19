package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFileData {

    public static String getConfigPropertiesFileData(String value) throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("D:\\SoftwareTesting\\Projects\\OrangeHumanResourceManagement-HRDomain\\src\\main\\resources\\TestData\\config.properties");
        properties.load(inputStream);
        return properties.getProperty(value);
    }
}
