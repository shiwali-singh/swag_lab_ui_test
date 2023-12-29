import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static java.lang.Integer.parseInt;

public class launch {

    WebDriver driver = null;

    @BeforeTest
    @Parameters({"browserName", "url", "headless"})
    public void setup(String browserName, String url, Boolean headless) {

        try {
            WebDriver driver = this.initializeBrowser(browserName, headless);
                driver.get(url);
                driver.manage().window().maximize();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException("Failed to set up browser for test execution");
        }
    }
    @Test(priority = 1)
    public void validLoginTest() {
        try {
            login("standard_user", "secret_sauce");
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException("Failed to login in Swag Labs website");
        }
    }

    @Test(priority = 2)
    public void verifyEmptyCart() {
        // Click on the "Cart" button
        try {
            WebElement cartButton = driver.findElement(By.cssSelector(".shopping_cart_link"));
            cartButton.click();

            By totalItems = By.cssSelector(".cart_item_label");
            List<WebElement> totalItemsCount = driver.findElements(totalItems);
            Assert.assertEquals(totalItemsCount.size(), 0);

            // Verify "Continue Shopping" button is enabled
            WebElement continueShoppingButton = driver.findElement(By.cssSelector(".btn_secondary"));
            Assert.assertTrue(continueShoppingButton.isEnabled());

            // Verify "Checkout" button is disabled
            WebElement checkoutButton = driver.findElement(By.cssSelector(".checkout_button"));
            Assert.assertFalse(checkoutButton.isEnabled());
        }
        catch(NoSuchElementException e)
        {
            throw new NoSuchElementException("No such element exist");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void verifyItemsCountInCart() {
        try{
        driver.get("https://www.saucedemo.com/inventory.html");

        WebElement product = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        product.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        addToCartButton.click();

        List<WebElement> productInCart = driver.findElements(By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']"));

        WebElement cartButton = driver.findElement(By.className("shopping_cart_badge"));
        String cartButtonText = cartButton.getText();

        Assert.assertEquals(parseInt(cartButtonText), productInCart.size());
    }
        catch(NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException e)
        {
            throw new NoSuchElementException("Exception occur while executing test case" + e);
        }
        catch (Exception e) {
        e.printStackTrace();
    }

    }



    public void login(String userName, String password)  throws NoSuchElementException {

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    private WebDriver initializeBrowser(String browserName, Boolean headless) {
        try {
            if ("chrome".equalsIgnoreCase(browserName)) {
                ChromeOptions co = new ChromeOptions();
                if (headless) {
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
        } catch (Exception e) {
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
