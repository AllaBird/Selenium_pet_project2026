package com.ecommerce.components;

import com.ecommerce.page.AccessoriesPage;
import com.ecommerce.page.HomePage;
import com.ecommerce.page.MenPage;
import com.ecommerce.page.StorePage;
import com.ecommerce.page.WomenPage;
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


    public MenPage clickMenOption() {
        getWait2().until(ExpectedConditions.elementToBeClickable(By.id("menu-item-1228"))).click();

        return new MenPage(getDriver());
    }

    public WomenPage clickWomenOption() {
        getWait2().until(ExpectedConditions.elementToBeClickable(By.id("menu-item-1230"))).click();

        return new WomenPage(getDriver());
    }

    public AccessoriesPage clickAccessoriesOption() {
        getWait2().until(ExpectedConditions.elementToBeClickable(By.id("menu-item-1230"))).click();

        return new AccessoriesPage(getDriver());
    }

    public StorePage clickStorePage() {
        getDriver().findElement(By.id("menu-item-1227")).click();

        return new StorePage(getDriver());
    }
}
