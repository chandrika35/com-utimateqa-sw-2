package testsuite;

import basefactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void serUo() {

        openBrowser(baseUrl);
    }

    @Test
    public void VerifyUserShouldNavigateLoginPageSuccessfully() {
        //find login link and click on login link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        String expectedMessage = "Welcome Back!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Not redirected to signIn page", expectedMessage,actualMessage);


    }
    @Test
    public void verifyTheErrorMessageWithInvalidCredentials(){
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("sitaram123@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("sitaram123");
        WebElement signInBtn = driver.findElement(By.xpath("//button[@type='submit']"));
    signInBtn.click();
String expectedMessage = "Invalid email or password.";
WebElement actualTextElement = driver.findElement(By.xpath(("//li[@class='form-error__list-item']")));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);
    }
    @After
    public void tearDown(){
closeBrowser();
    }
}