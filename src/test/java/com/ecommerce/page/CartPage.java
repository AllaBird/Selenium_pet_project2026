package com.ecommerce.page;

import com.ecommerce.page.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @Step("Click 'Proceed to checkout'")
    public CheckoutPage clickProceedToCheckout() {
        getWait2().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Proceed to checkout')]"))).click();

        return new CheckoutPage(getDriver());
    }

    @Step("Increase product quantity by one using arrow key")
    public CartPage clickIncreaseQuantityByOneArrow() {
        WebElement input = getWait5().until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='number']")));
        input.sendKeys(Keys.ARROW_UP);

        return this;
    }

    @Step("Click 'Update cart' button and wait for update to complete")
    public CartPage clickUpdateCart() {
        getWait2().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='update_cart']"))).click();
        getWait5().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//div[@class='blockUI blockOverlay'])[1]")));

        return this;
    }

    public String getQuantity() {
        return getDriver().findElement(By.cssSelector("input[type='number']")).getAttribute("value");
    }
}
