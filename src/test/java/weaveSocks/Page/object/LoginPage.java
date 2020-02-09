package weaveSocks.Page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void openLoginPage(){
        WebElement loginBtn = driver.findElement(By.id("login"));
        loginBtn.click();
    }

    

}
