package clarusway.tests;

import clarusway.pages.SauceDemoHomePage;
import clarusway.pages.SauceDemoLoginPage;
import clarusway.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Day02_C02_PageClass {
    /*
    Navigate to https://www.saucedemo.com/
    Enter the user name as standard_user
    Enter the password as secret_sauce
    Click on login button.
- Choose price low to high with soft Assert.
- Verify item prices are sorted from low to high with hard Assert.
     */

    @Test
    public void test(){

        Driver.getDriver().get("https://www.saucedemo.com/");
        //Enter the user name as standard_user

        //Login sayfasında yapılan aksiyonlar
        SauceDemoLoginPage loginPage=new SauceDemoLoginPage();

        loginPage.txtUsername.sendKeys("standard_user");

        loginPage.txtPassword.sendKeys("secret_sauce");

        loginPage.btnLogin.click();


        //Burada homepage e gecis yaptigimizdan dolayi homepage classimizdan bir obje uretiriz
        SauceDemoHomePage homePage = new SauceDemoHomePage();

        Select select = new Select(homePage.filterDropdown);
        select.selectByValue("lohi");

        Assert.assertTrue(select.getFirstSelectedOption().getText().contains("low to high"));

        Driver.closeDriver();


    }
}
