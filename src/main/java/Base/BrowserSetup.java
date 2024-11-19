package Base;

import Utility.ExtentReporter;
import Utility.ReadFileData;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BrowserSetup {
    public static ExtentReports reports = ExtentReporter.getExtentReporter();
    public static ExtentTest logger;

    public static WebDriver driver;

    public void initialization(){

            try {
                String browser = ReadFileData.getConfigPropertiesFileData("BrowserName");
                String url = ReadFileData.getConfigPropertiesFileData("BuildUrl");

                switch (browser) {
                    case "Chrome":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--disable-popup-blocking");
                        options.addArguments("--disable-notifications");
                        driver = new ChromeDriver(options);
                        break;

                    case "Edge":
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;

                    case "Firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;

                    case "Opera":
                        WebDriverManager.operadriver().setup();
                        /*driver = new OperaDriver();*/
                        break;

                    case "Safari":
                        WebDriverManager.safaridriver().setup();
                        driver = new SafariDriver();
                        break;

                    default:
                        throw new IllegalArgumentException("Unsupported Browser: " + browser);
                }

                driver.get(url);
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
            }
            catch (Exception e) {
                throw new RuntimeException("An error occurred during browser setup: " + e.getMessage(), e);
            }
    }
}
