package com.task.automation.core;

import com.task.automation.enums.driverTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

public class driverManager {
    private WebDriver driver;
    private static driverTypes driverType;
    configurationManager configurationManager=new configurationManager();

    public driverManager() {

        driverType=configurationManager.getBrowser();
    }

    public WebDriver getDriver() {

//        System.out.println("****************Driver*************"+configurationManager.properties.getProperty("firefox.driver.path"));
        if(driver == null) driver = createDriver();
        return driver;

    }

    public WebDriver createDriver() {

        switch (driverType) {
            case FIREFOX :
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                firefoxOptions.setAcceptInsecureCerts(true);
//                firefoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                firefoxOptions.addArguments("use-fake-ui-for-media-stream");
                //firefoxOptions.addPreference("permissions.default.microphone", 1);
                //firefoxOptions.addPreference("permissions.default.camera", 1);
                firefoxOptions.addPreference("media.navigator.permission.disabled",true);

                System.setProperty("webdriver.firefox.driver",configurationManager.properties.getProperty("firefox.driver.path"));
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case CHROME :
//                System.setProperty("webdriver.chrome.driver",configurationManager.properties.getProperty("chrome.driver.path"));
                ChromeOptions options = new ChromeOptions();
                options.setAcceptInsecureCerts(true);
//                options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                options.addArguments("use-fake-ui-for-media-stream");
                options.addArguments("test");

                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                break;
            case INTERNETEXPLORER :
                System.setProperty("webdriver.ie.driver",configurationManager.properties.getProperty("ie.driver.path"));
                driver = new InternetExplorerDriver();
                break;

            default:
                System.setProperty("webdriver.chrome.driver",configurationManager.properties.getProperty("chrome.driver.path"));
                driver = new ChromeDriver();
                break;
        }

        return driver;

    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
