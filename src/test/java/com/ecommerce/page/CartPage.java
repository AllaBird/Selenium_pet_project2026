package com.ecommerce.page;

import com.ecommerce.page.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductList() {
       return getDriver().findElements(By.xpath("//td[@data-title='Product']"))
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public CheckoutPage clickProceedToCheckout() {
        getWait2().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Proceed to checkout')]"))).click();

        return new CheckoutPage(getDriver());
    }
}
