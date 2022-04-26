package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void textVerified() throws InterruptedException {
        mouseHover(By.xpath("/html[1]/body[1]/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        verifyElements("error", "Cell phones", By.xpath("//h1[contains(text(),'Cell phones')]"));

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        mouseHover(By.xpath("/html[1]/body[1]/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        verifyElements("error", "Cell phones", By.xpath("//h1[contains(text(),'Cell phones')]"));
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        verifyElements("error", "Nokia Lumia 1020", By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        verifyElements("error", "$349.00", By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[6]/div[1]/span[1]"));
        sendKeyToElement(By.id("product_enteredQuantity_20"), Keys.BACK_SPACE + "2");
        clickOnElement(By.id("add-to-cart-button-20"));
        verifyElements("error", "The product has been added to your shopping cart", By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        verifyElements("error", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);
        verifyElements("error", "(2)", By.xpath("//span[contains(text(),'(2)')]"));
        verifyElements("error", "$698.00", By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.id("checkout"));
        verifyElements("error", "Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        verifyElements("error", "Register", By.xpath("//h1[contains(text(),'Register')]"));
        sendTextToElement(By.id("FirstName"), "Lalita");
        sendTextToElement(By.id("LastName"), "Desai");
        sendTextToElement(By.id("Email"), "Lalita123546=@gmail.com");
        sendTextToElement(By.id("Password"), "Lalita123");
        sendTextToElement(By.id("ConfirmPassword"), "Lalita123");
        clickOnElement(By.id("register-button"));
        verifyElements("error", "Your registration completed", By.xpath("//div[contains(text(),'Your registration completed')]"));
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));
        verifyElements("error", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendKeyToElement(By.id("BillingNewAddress_City"), "London");
        sendKeyToElement(By.id("BillingNewAddress_Address1"), "81 London street");
        sendKeyToElement(By.id("BillingNewAddress_ZipPostalCode"), "81u1h");
        sendKeyToElement(By.id("BillingNewAddress_PhoneNumber"), "+4478657488448");
        clickOnElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        clickOnElement(By.id("shippingoption_2"));
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Visa");
        sendTextToElement(By.id("CardholderName"), "Sonali Patel");
        sendTextToElement(By.id("CardNumber"), "5356 6548 1418 5420");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "11");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2022");
        sendTextToElement(By.id("CardCode"), "123");
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        verifyElements("error", "Payment Method:", By.xpath("//span[contains(text(),'Payment Method:')]"));
        verifyElements("error", "Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"));
        verifyElements("error", "Shipping Method:", By.xpath("//span[contains(text(),'Shipping Method:')]"));
        verifyElements("error", "2nd Day Air", By.xpath("//span[contains(.,'2nd Day Air')]"));
        verifyElements("error", "$698.00", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        verifyElements("error", "Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));
        verifyElements("error", "Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        verifyElements("error", "Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://demo.nopcommerce.com/");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
