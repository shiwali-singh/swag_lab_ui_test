package com.task.automation.myntraTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class dropdownTest extends hoverTest{

    @Test(priority = 3)
    public void selectFabricDropdown() throws InterruptedException {

        driver.findElement(By.xpath("//input[@value=\"Fabric\"]//ancestor::label")).click();
        WebDriverWait waitFor= new WebDriverWait(driver, Duration.ofSeconds(10));
        waitFor.until(ExpectedConditions.
            elementToBeClickable(
              driver.findElement(By.xpath("//input[@value=\"Cotton\"]//ancestor::label")))
            ).click();

        Thread.sleep(3000);
        WebElement slug = driver.findElement(By.cssSelector(".filter-summary-filterList li:nth-child(2) div"));
        Assert.assertEquals(slug.getText(), "Cotton");
    }
}
