package com.ecommerce.page;

import com.ecommerce.page.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public MenPage clickMenOption(){
        getWait2().until(ExpectedConditions.elementToBeClickable(By.id("menu-item-1228"))).click();

        return new MenPage(getDriver());
    }
}
