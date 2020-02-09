package weaveSocks;

import weaveSocks.configuration.Configuration;
import weaveSocks.configuration.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import weaveSocks.Page.object.OwnersPage;


public class TestBase {

    private static final String BASE_URL = Configuration.getInstance().baseUrl();

    public WebDriver driver;
//    protected PetClinicNavigation navigation;
//
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver();
//        navigation = new PetClinicNavigation(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

//
//    protected OwnersPage goToOwnersPage() {
//        goToUrl(BASE_URL + "/owners", "Owners");
//        return new OwnersPage(driver);
//    }

    protected void goToHomePage() {
        goToUrl(BASE_URL + "/index.html", "\n" +
                "        WeaveSocks\n" +
                "    ");
    }

    protected void goToCategoryPage() {
        goToUrl(BASE_URL + "/category.html", "\n" +
                "        WeaveSocks\n" +
                "    ");
    }

    protected WebDriverWait waitFor() {
        return new WebDriverWait(driver, 4);
    }

    private void goToUrl(String url, String title) {
        driver.get(url);
        waitFor().withMessage(title+ " page is not open!")
                .until(ExpectedConditions.textToBe(By.xpath("//h2"), title));
    }

}
