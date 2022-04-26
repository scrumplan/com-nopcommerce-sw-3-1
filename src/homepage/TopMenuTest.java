package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);


    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//div[@class='header-menu']//li"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(menu)) {
                names.click();
                break;
            }
        }
    }

    @Test
    public void verifyComputer() {
        selectMenu("Computers");
        verifyElements("Error", "Computers", By.xpath("/html[1]/body[1]/div[6]/div[2]/ul[1]/li[1]/a[1]"));
    }

    @Test
    public void verifyElectronics() {
        selectMenu("Electronics");
        verifyElements("Error", "Electronics", By.xpath("/html[1]/body[1]/div[6]/div[2]/ul[1]/li[2]/a[1]"));

    }

    @Test
    public void verifyApparel() {
        selectMenu("Apparel");
        verifyElements("Error", "Apparel", By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));

    }

    @Test
    public void verifyDigitalDownloads() {
        selectMenu("Digital downloads");
        // verifyElements("Error", "Digital downloads", By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']"));
        verifyElements("Error", "Digital downloads", By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]"));

    }

    @Test
    public void verifyBooks() {
        selectMenu("Books");
        verifyElements("Error", "Books", By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]"));

    }

    @Test
    public void verifyJewelry() {
        selectMenu("Jewelry");
        verifyElements("Error", "Jewelry", By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]"));
    }

    @Test
    public void verifyGiftCard() {
        selectMenu("Gift Cards");
        verifyElements("Error", "Gift Cards", By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}