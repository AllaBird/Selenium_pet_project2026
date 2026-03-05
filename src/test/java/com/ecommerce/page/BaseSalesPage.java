package com.ecommerce.page;

import com.ecommerce.page.base.BasePage;
import com.ecommerce.trait.HasLeftSideBarTrait;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BaseSalesPage<Self extends BaseSalesPage<Self>> extends BasePage
implements HasLeftSideBarTrait<Self> {

    public BaseSalesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Add product '{productName}' to cart")
    public Self clickAddToCard(String productName) {
        getWait2().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@aria-label='Add “%s” to your cart']".formatted(productName)))).click();
        getWait2().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='View cart']")));

        return (Self) this;
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

    public List<String> getProductNameList() {
        getWait5().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li//h2")));

        return getDriver().findElements(By.xpath("//li//h2")).stream()
                .map(WebElement::getText)
                .toList();
    }

    @Step("Sort products by price: Low to High")
    public Self selectSortByPriceLowToHigh() {
        WebElement selectElement = getDriver().findElement(By.cssSelector(".orderby"));
        Select select = new Select(selectElement);
        select.selectByVisibleText("Sort by price: low to high");

        return (Self) this;
    }

    @Step("Sort products by price: High to Low")
    public Self selectSortByPriceHighToLow() {
        WebElement selectElement = getDriver().findElement(By.cssSelector(".orderby"));

        Select select = new Select(selectElement);
        select.selectByVisibleText("Sort by price: high to low");

        return (Self) this;
    }

    public String getTitle() {
       return getWait5().until(ExpectedConditions.visibilityOf(
               getDriver().findElement(By.xpath("//h1")))).getText();
     }
}
