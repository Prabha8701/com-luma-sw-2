package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void closeDown() {
        // closeBrowser();
    }

    @Test
    public void verifyThatSignInPageDisplay() {

        //click on the ‘Create an Account’ link
        driver.findElement(By.xpath("//a[text()='Create an Account']")).click();

        //Verify the text ‘Create New Customer Account’
        String expectedText = "Create New Customer Account";
        String actualText = driver.findElement(By.xpath("//span[text()='Create New Customer Account']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {

        //click on the ‘Create an Account’ link
        driver.findElement(By.xpath("//a[text()='Create an Account']")).click();

        // Enter First name, lastname
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Prime");
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Prize");

        // click on Sign up for newsletter
        driver.findElement(By.xpath("//input[@title='Sign Up for Newsletter']")).click();

        // enter email, password and confirm password
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("Prime.prize213@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Prime12345");
        driver.findElement(By.xpath("//input[@id='password-confirmation']")).sendKeys("Prime12345");


        // click on create account button
        driver.findElement(By.xpath("//button[@title='Create an Account']")).click();

        //verify the text
        String expectedText="Thank you for registering with Main Website Store.";
        String actualText=driver.findElement(By.xpath("//div[@data-ui-id='message-success']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
}
