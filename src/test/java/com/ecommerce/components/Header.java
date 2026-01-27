package com.ecommerce.components;

import com.ecommerce.page.HomePage;
import com.ecommerce.page.MenPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends BaseComponent {

    public Header(WebDriver driver) {
        super(driver);
    }

    public HomePage clickLogo() {
        getDriver().findElement(By.cssSelector(".site-title")).click();

        return new HomePage(getDriver());
    }


    public MenPage clickMenOption(){
        getWait2().until(ExpectedConditions.elementToBeClickable(By.id("menu-item-1228"))).click();

        return new MenPage(getDriver());
    }
}
