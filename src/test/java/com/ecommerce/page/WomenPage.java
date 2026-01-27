package com.ecommerce.page;

import com.ecommerce.page.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WomenPage extends BasePage {

    public WomenPage(WebDriver driver) {
        super(driver);
    }

    public WomenPage clickAddToCard(String productName) {
        getWait2().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@aria-label='Add “%s” to your cart']".formatted(productName)))).click();
        getWait2().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='View cart']")));

        return this;
    }

    public CartPage clickViewCart() {
        getWait2().until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//a[@title='View your shopping cart'])[1]"))).click();

        return new CartPage(getDriver());
    }
}
