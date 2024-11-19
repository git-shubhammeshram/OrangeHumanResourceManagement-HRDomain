package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporter {

    public static ExtentReports reports;

    public static ExtentReports getExtentReporter(){
        if(reports == null){
            String fileName = getFormattedDate();
            ExtentHtmlReporter reporter = new ExtentHtmlReporter("D:\\SoftwareTesting\\Projects\\OrangeHumanResourceManagement-HRDomain\\ExtentReport\\"+fileName+".html");

            reports = new ExtentReports();
            reports.attachReporter(reporter);

            /* SetSystemInformation */
            reports.setSystemInfo("OS", "Windows");
            reports.setSystemInfo("ENVIRONMENT", "Development");
            reports.setSystemInfo("BUILD NUMBER", "0.0.1Snapshots");
            reports.setSystemInfo("BROWSER", "Chrome");

            /* Configure report settings */
            reporter.config().setDocumentTitle("UI Automation");
            reporter.config().setReportName("UI Test Report");
        }
        return reports;
    }

    private static String getFormattedDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date();
        return "Extent Report Dated - " + format.format(date);
    }
}
