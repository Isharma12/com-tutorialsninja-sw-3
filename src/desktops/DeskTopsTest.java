package desktops;
/**
 * 1. Create class “DesktopsTest”
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Mouse hover on Desktops Tab.and click
 * 1.2 Click on “Show All Desktops”
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 *
 * 2.1 Mouse hover on Currency Dropdown and click
 * 2.2 Mouse hover on £Pound Sterling and click
 * 2.3 Mouse hover on Desktops Tab.
 * 2.4 Click on “Show All Desktops”
 * 2.5 Select Sort By position "Name: A to Z"
 * 2.6 Select product “HP LP3065”
 * 2.7 Verify the Text "HP LP3065"
 * 2.8 Select Delivery Date "2023-11-27"
 * 2.9.Enter Qty "1” using Select class.
 * 2.10 Click on “Add to Cart” button
 * 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
 * 2.12 Click on link “shopping cart” display into success message
 * 2.13 Verify the text "Shopping Cart"
 * 2.14 Verify the Product name "HP LP3065"
 * 2.15 Verify the Delivery Date "2023-11-27"
 * 2.16 Verify the Model "Product21"
 * 2.17 Verify the Todat "£74.73"
 */


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeskTopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
//1.1 Mouse hover on Desktops Tab.and click
        mouseHoverElementAndClick(By.xpath("//a[normalize-space()='Desktops']"));
//1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
//1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.id("input-sort"),"Name (Z - A)");
//1.4 Verify the Product will arrange in Descending order.
        List<WebElement> originalList=driver.findElements(By.xpath("//div[@class='caption']//child::a"));
        List<String> originalProductList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductList.add(product.getText());
        }
        System.out.println("Before Sorting: " + originalProductList);
        List<WebElement> afterSortingList = driver.findElements(By.xpath("//div[@class='caption']//child::a"));
        List<String> afterSortingProduct = new ArrayList<>();
        for (WebElement product1 : afterSortingList) {
            afterSortingProduct.add(product1.getText());
        }
        Collections.sort(afterSortingProduct,Collections.reverseOrder());
        System.out.println("After Sorting: " + afterSortingProduct);
      Assert.assertEquals(originalProductList, afterSortingProduct);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Desktops Tab. and click
        mouseHoverElementAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        //2.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (A - Z)");
        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));
        //2.5 Verify the Text "HP LP3065"
        String actualText = getTextElement(By.xpath("//h1[normalize-space()='HP LP3065']"));
        Assert.assertEquals("Invalid text", "HP LP3065", actualText);
        //2.6 Select Delivery Date "2022-11-30"
        String year = "2022";
        String month = "November";
        String date = "30";

        clickOnElement(By.xpath("//div[@class='input-group date']//button[@type='button']")); //of date textbox
        while (true) {
            String monthYear = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='picker-switch']")).getText(); //of Date and year element title in calender
            String[] a = monthYear.split(" "); //we need different month and year so split
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']"));
            }

        }
         // Select the date
        //Locator for all dates is mentioned
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='datepicker-days']//tbody//tr//td"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }

        //2.7.Enter Qty "1” using Select class.
        driver.findElement(By.id("input-quantity")).clear();
        sendTextToElement(By.id("input-quantity"), "1");
        //2.8 Click on “Add to Cart” button
        clickOnElement(By.id("button-cart"));
         //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Thread.sleep(2000);
        String actualMessage =getTextElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("Invalid message", "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×", actualMessage);
        //2.10 Click on link “shopping cart” display into success message
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[contains(text(),'Shopping Cart')]"));
         //2.11 Verify the text "Shopping Cart"
        Thread.sleep(2000);
        String actualTextTitle =getTextElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        Assert.assertEquals("Invalid text of the title", "Shopping Cart  (1.00kg)", actualTextTitle);
       //2.12 Verify the Product name "HP LP3065"
        String actualProductName =getTextElement(By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]//preceding-sibling::a"));
        Assert.assertEquals("Invalid name", "HP LP3065", actualProductName);
        //2.13 Verify the Delivery Date "2022-11-30"
        String actualDeliveryDate = getTextElement(By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]"));
        Assert.assertEquals("Invalid date", "Delivery Date:2022-11-30", actualDeliveryDate);
        //2.14 Verify the Model "Product21"
        String actualModel = getTextElement(By.xpath("//td[contains(text(),'Product 21')]"));
        Assert.assertEquals("Invalid model", "Product 21", actualModel);
        //2.15 Verify the Todat "£74.73"
        String actualPrice =getTextElement(By.xpath("//div[@class='buttons clearfix']/preceding::td[1]"));
        Assert.assertEquals("Invalid price", "$122.00", actualPrice);

    }

    @After
    public void tearDown(){
       closeBrowser();
}
}


