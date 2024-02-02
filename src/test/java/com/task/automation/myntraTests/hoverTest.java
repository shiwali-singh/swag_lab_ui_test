package com.task.automation.myntraTests;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class hoverTest extends launchMyntraApp {

    protected String shoppingSections = "Men T-Shirts";

    @Test(priority = 1)
    public void navigateToMenTShirt() {

        Actions action = new Actions(driver);

//        WebElement mensDropdown = driver.findElement(By.xpath("//a[@data-group=\"men\"]"));
        WebElement mensDropdown = driver.findElement(By.cssSelector("a[href=\"/shop/men\"]"));
        action.moveToElement(mensDropdown).perform();
//        Action act = action.moveToElement("");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement mensSubMenu = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-group=\"men\"]//a[text()=\"T-Shirts\"]"))));
        action.moveToElement(mensSubMenu).click().build().perform();

        WebElement header = driver.findElement(By.xpath("//h1[@class='title-title']"));

        Assert.assertEquals(header.getText(), shoppingSections);

    }

    public void searchForBrand() throws NoSuchElementException, ParseException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("div.filter-search-filterSearchBox"))));
        searchIcon.click();
        WebElement searchBox = driver.findElement(By.cssSelector("input.filter-search-inputBox"));
        searchBox.sendKeys(getData("brandName"));
    }
    @Test(priority = 2)
    public void selectCheckBox(){
        try {
            searchForBrand();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement checkBox = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@value=\"Tommy Hilfiger\"]//ancestor::label//div[@class=\"common-checkboxIndicator\"]"))));

            if (!checkBox.isSelected()) {
                checkBox.click();
            }

            Thread.sleep(Duration.ofSeconds(2));
            WebElement slug = driver.findElement(By.cssSelector("div.filter-summary-filter"));
            System.out.println();
            Assert.assertEquals(slug.getText(), getData("brandName"));
        }
        catch (NoSuchElementException | ElementNotInteractableException e){
            e.printStackTrace();
            throw new RuntimeException("Cant do what you are trying to do " + e);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
