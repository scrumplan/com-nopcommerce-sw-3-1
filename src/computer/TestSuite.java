package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArangeInAlphaBalticOrder() {
        clickOnElement(By.xpath("//a[@href='/computers']"));
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));
        selectByVisibleTextFromDropDown(By.name("products-orderby"), "Name: Z to A");
        verifyElements("error", "Name: Z to A", By.xpath("//option[contains(text(),'Name: Z to A')]"));
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        clickOnElement(By.xpath("//a[@href='/computers']"));
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));
        selectByVisibleTextFromDropDown(By.name("products-orderby"), "Name: A to Z");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@type='button' and  @class='button-2 product-box-add-to-cart-button']"));
        verifyElements("messged not displayed", "Build your own computer", By.xpath("//h1[contains(text(),'Build your own computer')]"));
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");
        clickOnElement(By.id("product_attribute_3_7"));
        clickOnElement(By.id("product_attribute_4_9"));
        Thread.sleep(2000);
        // clickOnElement(By.id("product_attribute_5_10"));
        clickOnElement(By.id("product_attribute_5_12"));
        Thread.sleep(2000);
        verifyElements("error", "$1,475.00", By.id("price-value-1"));
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        verifyElements("error", "The product has been added to your shopping cart", By.xpath("//p[@class='content']"));
        clickOnElement(By.xpath("//span[@title='Close']"));
        mouseHover(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        Thread.sleep(2000);
        verifyElements("error", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);
        WebElement Quality = driver.findElement(By.xpath("//td[@class=\"quantity\"]/child::input"));
        Quality.clear();
        Quality.sendKeys("2");
        Thread.sleep(2000);
        clickOnElement(By.id("updatecart"));
        verifyElements("error", "$2,950.00", By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));
        verifyElements("error", "Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        sendKeyToElement(By.id("BillingNewAddress_FirstName"), "Lalita");
        sendKeyToElement(By.id("BillingNewAddress_LastName"), "Desai");
        sendKeyToElement(By.id("BillingNewAddress_Email"), "Lalita1234=@gmail.com");
        sendKeyToElement(By.id("BillingNewAddress_Company"), "comma");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendKeyToElement(By.id("BillingNewAddress_City"), "London");
        sendKeyToElement(By.id("BillingNewAddress_Address1"), "81 London street");
        sendKeyToElement(By.id("BillingNewAddress_ZipPostalCode"), "81u1h");
        sendKeyToElement(By.id("BillingNewAddress_PhoneNumber"), "+4478657488448");
        clickOnElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        clickOnElement(By.id("shippingoption_1"));
        clickOnElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        Thread.sleep(2000);
        clickOnElement(By.id("paymentmethod_1"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Master card");
        sendTextToElement(By.id("CardholderName"), "Miss Lalita Desai");
        sendTextToElement(By.id("CardNumber"), "5356 6548 1418 5420");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "12");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2025");
        sendTextToElement(By.id("CardCode"), "567");
        clickOnElement(By.xpath("(//button[@class='button-1 payment-info-next-step-button'])[1]"));
        verifyElements("error", "Payment Method:", By.xpath("//span[contains(text(),'Payment Method:')]"));
        verifyElements("error", "Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"));
        verifyElements("error", "Shipping Method:", By.xpath("//span[contains(text(),'Shipping Method:')]"));
        verifyElements("error", "Next Day Air", By.xpath("//span[contains(text(),'Next Day Air')]"));
        verifyElements("error", "$2,950.00", By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        verifyElements("error", "Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));
        verifyElements("error", "Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        verifyElements("error", "Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"));

    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
