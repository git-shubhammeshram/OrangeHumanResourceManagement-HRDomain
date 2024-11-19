package TestCases;

import Base.BrowserSetup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_LoginPageTestCase extends BrowserSetup {

    @BeforeMethod
    public void openBrowser(){
        initialization();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

}
