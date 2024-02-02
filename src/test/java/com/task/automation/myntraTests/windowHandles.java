//package myntraTests;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WindowType;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//
//import java.awt.*;
//import java.awt.event.KeyEvent;
//
//public class windowHandles {
//
//    public static void main(String[] args) throws AWTException {
//
//        WebDriver driver = new ChromeDriver();//Browser
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//w1
//
//        String parentWindowId = driver.getWindowHandle();
//
//        //sel 4.x
//        driver.switchTo().newWindow(WindowType.WINDOW);
//
//        driver.get("https://www.google.com");
//        System.out.println(driver.getTitle());
//
//        driver.close();
//
//        driver.switchTo().window(parentWindowId);
//        System.out.println(driver.getTitle());
//
//        driver.quit();
//        Actions builder = new Actions(driver);
//
//        Robot robo = new Robot();
//        robo.keyPress(KeyEvent.VK_CAPS_LOCK);
//        robo.keyPress(KeyEvent.VK_CONTROL);
//        robo.keyPress(KeyEvent.VK_S);
//        robo.keyRelease(KeyEvent.VK_CONTROL);
//        robo.keyRelease(KeyEvent.VK_S);
//
//
//        //WebElement on which drag and drop operation needs to be performed
//        WebElement fromElement = driver.findElement(By Locator of fromElement);
//
////WebElement to which the above object is dropped
//        WebElement toElement = driver.findElement(By Locator of toElement);
//
////Creating object of Actions class to build composite actions
//        Actions builder = new Actions(driver);
//
////Building a drag and drop action
//        Action dragAndDrop = builder.clickAndHold(fromElement)
//                .moveToElement(toElement)
//                .release(toElement)
//                .build();
//
////Performing the drag and drop action
//        dragAndDrop.perform();
//    }
//}
