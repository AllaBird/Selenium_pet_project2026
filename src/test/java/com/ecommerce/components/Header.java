package com.ecommerce.components;

import com.ecommerce.page.AccessoriesPage;
import com.ecommerce.page.HomePage;
import com.ecommerce.page.MenPage;
import com.ecommerce.page.StorePage;
import com.ecommerce.page.WomenPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends BaseComponent {

    public Header(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to home page by clicking the logo")
    public HomePage clickLogo() {
        getDriver().findElement(By.cssSelector(".site-title")).click();

        return new HomePage(getDriver());
    }


    @Step("Navigate to Men's category")
    public MenPage clickMenOption() {
        getWait2().until(ExpectedConditions.elementToBeClickable(By.id("menu-item-1228"))).click();

        return new MenPage(getDriver());
    }

    @Step("Navigate to Women's category")
    public WomenPage clickWomenOption() {
        getWait2().until(ExpectedConditions.elementToBeClickable(By.id("menu-item-1230"))).click();

        return new WomenPage(getDriver());
    }

    @Step("Navigate to Accessories's category")
    public AccessoriesPage clickAccessoriesOption() {
        getWait2().until(ExpectedConditions.elementToBeClickable(By.id("menu-item-1230"))).click();

        return new AccessoriesPage(getDriver());
    }

    @Step("Navigate to Store's category")
    public StorePage clickStorePage() {
        getDriver().findElement(By.id("menu-item-1227")).click();

        return new StorePage(getDriver());
    }
}
