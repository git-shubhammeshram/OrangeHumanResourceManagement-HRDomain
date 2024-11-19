package Utility;

import Base.BrowserSetup;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureScreenshot extends BrowserSetup {
    public static void captureScreenshot(String filename) {
        String fileExtension = getFormattedDateFile();
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("D:\\SoftwareTesting\\Projects\\OrangeHumanResourceManagement-HRDomain\\Screenshots\\" + filename + fileExtension + ".png");
        try {
            FileHandler.copy(source, dest);
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to copy");
        }

    }

    public static String getFormattedDateFile() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date();
        return " Screenshot Captured On Dated- " + format.format(date);

    }
}
