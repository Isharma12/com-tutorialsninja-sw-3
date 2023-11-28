package laptopsandnotebooks;
/**
 * Create the class LaptopsAndNotebooksTest
 * Write the following test
 * 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
 * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
 * 1.2 Click on “Show All Laptops & Notebooks”
 * 1.3 Select Sort By "Price (High > Low)"
 * 1.4 Verify the Product price will arrange in High to Low order.
 * 2. Test name verifyThatUserPlaceOrderSuccessfully()
 * 2.1 Mouse hover on Laptops & Notebooks Tab and click
 * 2.2 Click on “Show All Laptops & Notebooks”
 * 2.3 Select Sort By "Price (High > Low)"
 * 2.4 Select Product “MacBook”
 * 2.5 Verify the text “MacBook”
 * 2.6 Click on ‘Add To Cart’ button
 * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
 * 2.8 Click on link “shopping cart” display into success message
 * 2.9 Verify the text "Shopping Cart"
 * 2.10 Verify the Product name "MacBook"
 * 2.11 Change Quantity "2"
 * 2.12 Click on “Update” Tab
 * 2.13 Verify the message “Success: You have modified your shopping cart!”
 * 2.14 Verify the Total £737.45
 * 2.15 Click on “Checkout” button
 * 2.16 Verify the text “Checkout”
 * 2.17 Verify the Text “New Customer”
 *
 * 2.18 Click on “Guest Checkout” radio button
 * 2.19 Click on “Continue” tab
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “Continue” Button
 * 2.22 Add Comments About your order into text area
 * 2.23 Check the Terms & Conditions check box
 * 2.24 Click on “Continue” button
 * 2.25 Verify the message “Warning: Payment method required!”
 *
 * ● Create package myaccounts
 * 1. Create the class MyAccountsTest
 * 1.1 create method with name "selectMyAccountOptions" it has one parameter name
 * "option" of type string
 * 1.2 This method should click on the options whatever name is passed as parameter.
 * (Hint: Handle List of Element and Select options)
 *
 * Write the following test
 * 1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
 *
 * 1.1 Clickr on My Account Link.
 * 1.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Register”
 * 1.3 Verify the text “Register Account”.
 *
 * 2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
 *
 * 2.1 Clickr on My Account Link.
 * 2.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Login”
 * 2.3 Verify the text “Returning Customer”.
 *
 * 3. Test name verifyThatUserRegisterAccountSuccessfully()
 *
 * 3.1 Clickr on My Account Link.
 * 3.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Register”
 * 3.3 Enter First Name
 * 3.4 Enter Last Name
 * 3.5 Enter Email
 * 3.6 Enter Telephone
 * 3.7 Enter Password
 * 3.8 Enter Password Confirm
 * 3.9 Select Subscribe Yes radio button
 * 3.10 Click on Privacy Policy check box
 * 3.11 Click on Continue button
 * 3.12 Verify the message “Your Account Has Been Created!”
 * 3.13 Click on Continue button
 *
 * 3.14 Clickr on My Account Link.
 * 3.15 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Logout”
 * 3.16 Verify the text “Account Logout”
 * 3.17 Click on Continue button
 *
 * 4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
 *
 * 4.1 Clickr on My Account Link.
 * 4.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Login”
 * 4.3 Enter Email address
 * 4.4 Enter Last Name
 * 4.5 Enter Password
 * 4.6 Click on Login button
 * 4.7 Verify text “My Account”
 * 4.8 Clickr on My Account Link.
 * 4.9 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Logout”
 * 4.10 Verify the text “Account Logout”
 * 4.11 Click on Continue button
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
//1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
//1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
//1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
//1.4 Verify the Product price will arrange in High to Low order
        List<WebElement> productPrices = driver.findElements(By.xpath("//div[@class='row']//p//span"));
        for (WebElement productPrice : productPrices) {
            String actualPrice = productPrice.getText();
            Assert.assertEquals("Invalid text", "");

        }
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
//2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
//2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
//2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
//2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[contains(text(),'MacBook Pro')]"));
//2.5 Verify the text “MacBook”
        String actualText = getTextElement(By.xpath("//h1[contains(text(),'MacBook Pro')]"));
        Assert.assertEquals("Invalid text", "MacBook Pro", actualText);
//2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.id("button-cart"));
//2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String actualMessage = getTextElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("Invalid message", "Success: You have added MacBook Pro to your shopping cart!\n" +
                "×", actualMessage);
//2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
//2.9 Verify the text "Shopping Cart"
        String actualTextTitle = getTextElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        Assert.assertEquals("Invalid text of the title", "Shopping Cart  (0.00kg)", actualTextTitle);
//2.10 Verify the Product name "MacBook"
        String actualProductName = getTextElement(By.xpath("//small[contains(text(),'Reward Points: 800')]//preceding-sibling::a"));
        Assert.assertEquals("Invalid name", "MacBook Pro", actualProductName);
//2.11 Change Quantity "2"
        ;
        driver.findElement(By.xpath("//div[@class='input-group btn-block']/child::input")).clear();
        sendTextToElement(By.xpath("//div[@class='input-group btn-block']/child::input"), "2");
//2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//button[@type='submit']"));
//2.13 Verify the message “Success: You have modified your shopping cart!”
        String actualModificationMsg = getTextElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("Invalid modification message", "Success: You have modified your shopping cart!\n" +
                "×", actualModificationMsg);
//2.14 Verify the Total £737.45
        String actualPrice = getTextElement(By.xpath("//td[contains(text(),'$2,000.00')]//following-sibling::td"));
        Assert.assertEquals("Invalid price", "$4,000.00", actualPrice);
//2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
//2.16 Verify the text “Checkout”
        String checkoutText = getTextElement(By.xpath("//h1[text()='Checkout']"));
        Assert.assertEquals("Invalid text", "Checkout", checkoutText);
//2.17 Verify the Text “New Customer”

        String actualNewCustomerTitle = getTextElement(By.xpath("//div[@class='col-sm-6']/parent::div/child::div[1]/h2"));
        Assert.assertEquals("Invalid text", "New Customer", actualNewCustomerTitle);
//2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
//2.19 Click on “Continue” tab
        clickOnElement(By.id("button-account"));
//2.20 Fill the mandatory fields
        sendTextToElement(By.id("input-payment-firstname"), "Raj");
        sendTextToElement(By.id("input-payment-lastname"), "Johar");
        sendTextToElement(By.id("input-payment-email"), "rajaa25johar@gmail.com");
        sendTextToElement(By.id("input-payment-telephone"), "07435626624");
        sendTextToElement(By.id("input-payment-address-1"), "13, Happy Residency");
        sendTextToElement(By.id("input-payment-city"), "Ahmedabad");
        sendTextToElement(By.id("input-payment-postcode"), "393002");
        selectByVisibleTextFromDropDown(By.id("input-payment-country"), "India");
        selectByVisibleTextFromDropDown(By.id("input-payment-zone"), "Gujarat");
//2.21 Click on “Continue” Button
        clickOnElement(By.id("button-guest"));
//2.22 Add Comments About your order into text area
        clickOnElement(By.xpath("//textarea[@name='comment']"));
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "Please deliver it at the reception at delivery counter");
//2.23 Check the Terms & Conditions check box
        clickOnElement(By.id("button-shipping-method"));
        clickOnElement(By.xpath("//a[@class='agree']/following-sibling::input[1]"));
//2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
//2.25 Verify the message “Warning: Payment method required!”
        clickOnElement(By.id("button-confirm"));
        clickOnElement(By.xpath("//a[text()='Continue']"));
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}



