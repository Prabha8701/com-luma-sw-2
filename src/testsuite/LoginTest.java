package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void closeDown() {
        // closeBrowser();
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Prime.prize21@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Prime12345");

        driver.findElement(By.xpath("//span[text()='Sign In']")).click();

        String expectedText="Welcome, Prime Prize!";
        String actualText=driver.findElement(By.xpath("//span[text()='Welcome, Prime Prize!']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void verifyTheErrorMessageWithInvalidCredentials(){
        driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Prime.prize21456@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Prime12345");

        driver.findElement(By.xpath("//span[text()='Sign In']")).click();

        String expectedText="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualText=driver.findElement(By.xpath("//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void userShouldLogOutSuccessfully(){
        driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Prime.prize21@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Prime12345");

        driver.findElement(By.xpath("//span[text()='Sign In']")).click();

        String expectedText="Welcome, Prime Prize!";
        String actualText=driver.findElement(By.xpath("//span[text()='Welcome, Prime Prize!']")).getText();
        Assert.assertEquals(expectedText,actualText);

        driver.findElement(By.xpath("//button[@class='action switch']")).click();

        driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        String expectedText2="You are signed out";
        String actualText2=driver.findElement(By.xpath("//span[@data-ui-id='page-title-wrapper']")).getText();
        Assert.assertEquals(expectedText2,actualText2);


    }
}
