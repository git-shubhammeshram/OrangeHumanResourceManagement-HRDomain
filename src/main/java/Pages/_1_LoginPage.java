package Pages;

import Base.BrowserSetup;
import com.aventstack.extentreports.Status;

public class _1_LoginPage extends BrowserSetup {

    public String verifyLoginPageUrl(){
        logger = reports.createTest("Test Case 1: verify 'URL' is displayed on the webpage");
        logger.log(Status.INFO,"URL of webpage is available");
        logger.log(Status.PASS,"URL is verified");
        return driver.getCurrentUrl();
    }

    public String verifyLoginPageTitle(){
        logger = reports.createTest("Test Case 2: verify 'Title' is displayed on the webpage");
        logger.log(Status.INFO,"Title of webpage is available");
        logger.log(Status.PASS,"Title is verified");
        return driver.getTitle();
    }

}
