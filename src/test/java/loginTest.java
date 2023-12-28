import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class loginTest extends launch{
    @Test(priority = 1)
    public void lockedUserLoginTest() {
        login("locked_out_user", "secret_sauce");
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertTrue(errorElement.isDisplayed());
        Assert.assertEquals(errorElement.getText(), "Epic sadface: Sorry, this user has been locked out.");
    }


}
