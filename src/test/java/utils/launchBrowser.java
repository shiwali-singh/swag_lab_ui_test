package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class launchBrowser {

    protected WebDriver driver = null;
    @BeforeTest
        @Parameters({"browserName", "url", "headless"})
        public void setup(String browserName, String url, Boolean headless) {

            try {
                WebDriver driver = this.initializeBrowser(browserName, headless);
//                driver.manage().window().maximize();
                driver.get(url);

            }
            catch (Exception e)
            {
                e.printStackTrace();
                throw new RuntimeException("Failed to set up browser for test execution");
            }
        }

        protected WebDriver initializeBrowser(String browserName, Boolean headless) throws WebDriverException {
            try {
                if ("chrome".equalsIgnoreCase(browserName)) {
                    final ChromeOptions co = new ChromeOptions();
                    co.addArguments("--disable-notifications");
//                    co.getBrowserName("Windows for test");
//                    System.out.println( "Version is : "+ co.getBrowserVersion("112.0"));

                    co.addArguments("--start-maximized");
                    if (headless) {
                        co.setAcceptInsecureCerts(false);
                        co.addArguments("--headless=new");

                    }
                    driver = new ChromeDriver(co);
                }
                else if ("firefox".equalsIgnoreCase(browserName)) {
                    driver = new FirefoxDriver();
                }
                else if ("edge".equalsIgnoreCase(browserName)) {
                    driver = new EdgeDriver();
                }
                else {
                    System.out.println("Please pass the right browser type");
                }
            } catch (WebDriverException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize the WebDriver.", e);
            }
            return driver;
        }

        @AfterTest
        public void tearDown() {
            driver.quit();
        }

    }


