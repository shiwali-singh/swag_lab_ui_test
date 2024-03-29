package com.task.automation.util;

import java.io.File;
        import java.util.Calendar;
        import java.util.Date;
        import java.util.List;
        import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import org.testng.IReporter;
        import org.testng.IResultMap;
        import org.testng.ISuite;
        import org.testng.ISuiteResult;
        import org.testng.ITestContext;
        import org.testng.ITestResult;
        import org.testng.xml.XmlSuite;

        import com.relevantcodes.extentreports.ExtentTest;
        import com.relevantcodes.extentreports.LogStatus;

public class extendReport  {
    //    public static ExtentReports extentreport = null;
//    public static ExtentTest extentlog;
//
//    public static void initialize(String path) {
//        if (extentreport == null) {
//            //object for extentreport
//            extentreport = new ExtentReports(path, true);
//            extentreport.addSystemInfo("Host Name", System.getProperty("user.name"));
//            extentreport.addSystemInfo("Environment", "API Testing");
//            extentreport.loadConfig(new File(System.getProperty("user.dir") + "/resources/extent-config.xml"));
//        }
//    }
//
//    public static void setinstanceNull() {
//        extentreport = null;
//    }
//
//    // Display response time and status code in Extent report
////	public static void ExtentReport_logs(Response resp) {
////		ExtentReportInfoLog("Response time is " + String.valueOf(resp.getTime()) + "ms");
////		ExtentReportInfoLog("Response of API is " + String.valueOf(resp.getStatusCode()));
////	}
//
//    // log in extent report
//    public static void ExtentReportInfoLog(String message) {
//
//        extentlog.log(LogStatus.INFO, message);
//
//    }
//
//    public static void ExtentReportErrorLog(String message) {
//        extentlog.log(LogStatus.ERROR, message);
//    }
//}
    private ExtentReports extent;
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                               String outputDirectory) {
        extent = new ExtentReports(outputDirectory + File.separator
                + "swagLabs.html", true);

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();

                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }

        extent.flush();
        extent.close();
    }

    private void buildTestNodes(IResultMap tests, LogStatus status) {
        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.startTest(result.getMethod().getMethodName());

                test.setStartedTime(getTime(result.getStartMillis()));
                test.setEndedTime(getTime(result.getEndMillis()));

                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase()
                            + "ed");
                }

                extent.endTest(test);
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}