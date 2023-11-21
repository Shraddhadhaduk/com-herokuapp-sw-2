package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
    //find out username field and type username
        driver.findElement(By.name("username")).sendKeys("tomsmith");

    //find out password field and type password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

    //find out login button and click on it
       driver.findElement(By.className("radius")).click();

    //Verify text
    String expectedText = "Secure Area";
    String actualText = driver.findElement(By.xpath("//h2[normalize-space()='Secure Area']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        //find out username field and type username
        driver.findElement(By.name("username")).sendKeys("tomsmith1");

        //find out password field and type password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        //find out login button and click on it
        driver.findElement(By.className("radius")).click();

        //verify text
        String expectedText = "Your username is invalid!\n×";
        String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //find out username field and type username
        driver.findElement(By.name("username")).sendKeys("tomsmith");

        //find out password field and type password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        //find out login button and click on it
        driver.findElement(By.className("radius")).click();

        //verify text
        String expectedText = "Your password is invalid!\n×";
        String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }


}
