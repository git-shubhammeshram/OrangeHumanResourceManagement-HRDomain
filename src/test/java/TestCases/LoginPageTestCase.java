package TestCases;

import Base.BrowserSetup;
import Pages._1_LoginPage;
import Utility.CaptureScreenshot;
import Utility.ReadFileData;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTestCase extends BrowserSetup {

    _1_LoginPage loginPage;

    @BeforeMethod
    public void openBrowser(){
        initialization();
        loginPage = new _1_LoginPage();
    }

    @Test
    public void verifyLoginPageUrlTest() throws IOException {
        String expResult = ReadFileData.readExcelFileData(2,0);
        String actResult = loginPage.verifyLoginPageUrl();
        Assert.assertEquals(expResult, actResult);
        Reporter.log(" 'URL' is showing login page "+ actResult);
    }

    @Test
    public void verifyLoginPageTitle() throws IOException {
        String expResult = ReadFileData.readExcelFileData(2,1);
        String actResult = loginPage.verifyLoginPageTitle();
        Assert.assertEquals(expResult, actResult);
        Reporter.log("Title is shown login page "+ actResult);
    }



    @AfterMethod
    public void closeBrowser(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
            CaptureScreenshot.captureScreenshot(result.getName());

        reports.flush();
        driver.close();
    }

}
