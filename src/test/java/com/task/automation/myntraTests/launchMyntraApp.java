package com.task.automation.myntraTests;

import com.task.automation.core.baseTestClass;
import com.task.automation.util.getJSONData;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class launchMyntraApp extends baseTestClass {
//    WebDriver driver;
    WebDriverWait wait;
    @Test
    public void launchPage() {

        driver.get("https://www.myntra.com/");        //driver.get("http://test$_@gmail.com:test123@localhost:3001/signin");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //waitForPageToLoad(logo);
    }

    public static String getData(String input) throws ParseException, IOException {
        String brandName;
        return brandName = (String) getJSONData.getJsonData().get(input);
    }
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
