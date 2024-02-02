package com.task.automation.swagLabsTest;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import com.task.automation.core.baseTestClass;
import java.util.List;

import static java.lang.Integer.parseInt;

public class loginTests extends baseTestClass {
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



    private void login(String userName, String password)  throws NoSuchElementException {

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
    }


}
