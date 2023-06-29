package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void closeDown() {
        // closeBrowser();
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {

        //Click on ‘Sale’ Menu tab
        driver.findElement(By.xpath("//a[@id='ui-id-8']")).click();

        //Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category
        driver.findElement(By.xpath("//a[text()='Jackets']")).click();

        //Verify the text ‘Jackets’ is displayed
        String expectedText = "Jackets";
        String actualText = driver.findElement(By.xpath("//h1[@id='page-title-heading']")).getText();
        Assert.assertEquals(expectedText, actualText);

        // print the name of all items into console.

        List <WebElement> totalItem=driver.findElements(By.xpath("//strong[@class ='product name product-item-name']"));

        for (int i = 1; i <= totalItem.size(); i++) {
            // Printing all product name
            System.out.println(driver.findElement(By.xpath("(//a[@class='product-item-link'])[" + i + "]")).getText());
        }

        // count the Total Item Displayed on Page and
        System.out.println(totalItem.size());


    }
}
