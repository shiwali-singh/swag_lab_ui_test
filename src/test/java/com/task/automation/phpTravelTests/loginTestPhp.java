package com.task.automation.phpTravelTests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.task.automation.core.baseTestClass;

import java.time.Duration;
import java.util.Set;

public class loginTestPhp  extends baseTestClass {

    @Test
    public void loginTest(){
        login("d","fg");
    }
    private void login(String userName, String password)  throws NoSuchElementException {

            driver.findElement(
                By.xpath("//a[@href='https://phptravels.org']"))
                    .click();
        String parentWindowHandle = driver.getWindowHandle();

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles + " windows");
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        WebElement usernameField = driver.findElement(By.id("inputEmail"));
        WebElement passwordField = driver.findElement(By.id("inputPassword"));
        WebElement loginButton = driver.findElement(By.id("login"));

        usernameField.sendKeys(userName);
        passwordField.sendKeys(password);
        try{
            Thread.sleep(2457);
        }
        catch (InterruptedException e)
        {
            System.out.println(e);
        }
        WebDriverWait waitfor = new WebDriverWait(driver, Duration.ofMillis(12345) );

        waitfor.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#recaptcha-anchor")));
        WebElement captchaButton = driver.findElement(By.id("recaptcha-anchor"));

        captchaButton.click();
        loginButton.click();
    }

}

