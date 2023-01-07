package clarusway.pages;

import clarusway.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SauceDemoLoginPage {

    //initElements methodu Page class ı initialize etmek için kullanılır
    public  SauceDemoLoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    // @FindBy annotasyonu elementleri locate ederken kullandigimiz ve initElements methodu ile
    // elementlerin bulunmasini saglayan bir anotasyondur

    @FindBy(id="user-name")
    public WebElement txtUsername;

    @FindBy(id="password")
    public WebElement txtPassword;

    @FindBy(id="login-button")
    public WebElement btnLogin;

    @FindAll(
            {
            @FindBy(id="user-name"),
            @FindBy(id="password"),
            @FindBy(id="login-button")

    }
    )
    public List<WebElement> inputElements;
}
