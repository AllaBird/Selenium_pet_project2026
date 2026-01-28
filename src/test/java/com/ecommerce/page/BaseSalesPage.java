package com.ecommerce.page;

import com.ecommerce.page.base.BasePage;
import com.ecommerce.trait.HasLeftSideBarTrait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class BaseSalesPage<Self extends BaseSalesPage<Self>> extends BasePage
implements HasLeftSideBarTrait<Self> {

    public BaseSalesPage(WebDriver driver) {
        super(driver);
    }

    public Self clickAddToCard(String productName) {
        getWait2().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@aria-label='Add “%s” to your cart']".formatted(productName)))).click();
        getWait2().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='View cart']")));

        return (Self) this;
    }

    public CartPage clickViewCart() {
        getWait2().until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//a[@title='View your shopping cart'])[1]"))).click();

        return new CartPage(getDriver());
    }

    public List<Double> getDisplayedProductPrices() {

        List<WebElement> prices = getDriver().findElements(
                By.xpath("//span[contains(@class, 'price')]//span[contains(@class, 'amount') and not(ancestor::del)]"));
        List<Double> priceList = new ArrayList<>();

        for (WebElement priceElement : prices) {
            String text = priceElement.getText()
                    .replaceAll("[$,]", "")
                    .trim();
            priceList.add(Double.parseDouble(text));
        }
        return priceList;
    }
}
