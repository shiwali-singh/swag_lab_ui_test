package com.task.automation.core;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.Date;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.LogStatus;
import com.task.automation.util.*;


public class baseTestClass {

        static Date now = new Date();
        public static String TimeStamp = now.toString().replace(":", "-");
        public static WebDriver driver;
        driverManager driverManager = new driverManager();
        public static String baseurl="";
        //protected static Logging log;

//        @Parameters({ "ReportName", "FlowType" })
//        @BeforeSuite(alwaysRun = true)
//        public void config(@Optional("Optional name Automation ") String reportname, @Optional("Automation Report") String flow)
//                throws IOException {
//
//            extendReport.initialize(System.getProperty("user.dir")+"/results/"+ TimeStamp+" WEGUI_Report.html");
//            // Log path
//            //	utils.Logging.setLogPath("LocusApi_logs.log");
//
//            // create logging instance
//            //	log = Logging.getInstance();
//
//        }
        @BeforeTest
        public void beforeTest() {
            driver = driverManager.getDriver();
        }

        @BeforeMethod
        public void beforeMethod() {
            driver.manage().deleteAllCookies();
            System.out.printf("Test case", "*********************************************************************");
        }

//        @AfterMethod
//        public void afterMethod(ITestResult result) {
//
//			/*if (result.getStatus() == ITestResult.SUCCESS) {
//				System.out.println(result.getMethod().getMethodName()+" :Passed");
//			}
//			else if (result.getStatus() == ITestResult.FAILURE) {
//				System.out.println(result.getMethod().getMethodName()+" :Failed");
//			}
//			else if (result.getStatus() == ITestResult.SKIP) {
//				System.out.println(result.getMethod().getMethodName()+" :Skipped");
//			}
//			*/
//            //Reporter.log("<a href=\"" + "screenshotfile" +"\" target=\"_blank\">View Screenshot</a><br>");
//            if (result.getStatus() == ITestResult.SUCCESS) {
//                extendReport.extentlog.log(LogStatus.PASS, "Test case: " + result.getName()+" is passed " );
//
//            } else if (result.getStatus() == ITestResult.FAILURE) {
//                extendReport.extentlog.log(LogStatus.FAIL, "Test case: " + result.getName() + " is failed");
//                extendReport.extentlog.log(LogStatus.FAIL, "Test case is failed " + result.getThrowable());
//            } else if (result.getStatus() == ITestResult.SKIP) {
//                extendReport.extentlog.log(LogStatus.SKIP, "Test case is Skiped " );
//            }
//            extendReport.extentreport.endTest(extendReport.extentlog);
//            //--------------
//            String methodName=StringUtil.createRandomString(result.getMethod().getMethodName());
//            System.out.println("METHOD........"+methodName);
//            ScreenshotUtility.captureScreenshot(driver,methodName);
//            Reporter.setCurrentTestResult(result);
//
//        }

        @AfterTest
        public void afterTest() {
            driverManager.quitDriver();
        }

        @AfterSuite(alwaysRun = true)
        public void endReport() {
            //ExtentReport.extentreport.flush();
//            extendReport.extentreport.close();
//            System.out.println("Close ExtentReport");
//            //Email.sendEmail();

        }

}

//    protected WebDriver driver = null;
//    @BeforeTest
//        @Parameters({"browserName", "url", "headless"})
//        public void setup(String browserName, String url, Boolean headless) {
//
//            try {
//                WebDriver driver = this.initializeBrowser(browserName, headless);
////                driver.manage().window().maximize();
//                driver.get(url);
//
//            }
//            catch (Exception e)
//            {
//                e.printStackTrace();
//                throw new RuntimeException("Failed to set up browser for test execution");
//            }
//        }
//// method has webdriver as return type because it's going to provide implementation of my browser driver eg chrome IE firefox
//        public WebDriver initializeBrowser(String browserName, Boolean headless) throws WebDriverException {
//            try {
//                if ("chrome".equalsIgnoreCase(browserName)) {
//                    final ChromeOptions co = new ChromeOptions();
//                    co.addArguments("--disable-notifications");
////                    co.getBrowserName("Windows for test");
////                    System.out.println( "Version is : "+ co.getBrowserVersion("112.0"));
//
//                    co.addArguments("--start-maximized");
//                    if (headless) {
//                        co.setAcceptInsecureCerts(false);
//                        co.addArguments("--headless=new");
//
//                    }
//                    driver = new ChromeDriver(co);
//                }
//                else if ("firefox".equalsIgnoreCase(browserName)) {
//                    driver = new FirefoxDriver();
//                }
//                else if ("edge".equalsIgnoreCase(browserName)) {
//                    driver = new EdgeDriver();
//                }
//                else {
//                    System.out.println("Please pass the right browser type");
//                }
//            } catch (WebDriverException e) {
//                e.printStackTrace();
//                throw new RuntimeException("Failed to initialize the WebDriver.", e);
//            }
//            return driver;
//        }
//
//        @AfterTest
//        public void tearDown() {
//            driver.quit();
//        }



