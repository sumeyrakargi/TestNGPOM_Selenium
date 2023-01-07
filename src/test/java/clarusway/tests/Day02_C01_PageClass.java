package clarusway.tests;

import clarusway.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day02_C01_PageClass {
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
        WebElement username=Driver.getDriver().findElement(By.id("user-name"));
        username.sendKeys("standard_user"+ Keys.ENTER);
        // Enter the password as secret_sauce
        WebElement password=Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("secret_sauce"+ Keys.ENTER);
       //Click on login button.
        WebElement loginbutton=Driver.getDriver().findElement(By.id("login-button"));
        loginbutton.click();
        //Choose price low to high with soft Assert.
        Select dropdown=new Select(Driver.getDriver().findElement(By.tagName("select")));
        dropdown.selectByValue("lohi");

        List<WebElement>itemPrices=Driver.getDriver().findElements(By.className("inventory_item_price"));

       /* List<Double> listPrices = new ArrayList<>();
        for (int i = 0; i <itemPrices.size()-1 ; i++) {

            listPrices.add(Double.valueOf(itemPrices.get(i).getText().substring(1)));*/


        itemPrices.forEach(x->x.getText());
        //Verify item prices are sorted from low to high with hard Assert.
        List<Double>urunFiyat=itemPrices.stream().map(x->x.getText().substring(1))
                .map(x->Double.parseDouble(x)).collect(Collectors.toList());

        for (int i = 0; i < urunFiyat.size()-1; i++) {
            Assert.assertTrue(urunFiyat.get(i)<=urunFiyat.get(i+1));

        }Driver.closeDriver();


    }
}
