package com.ecommerce.page;

import com.ecommerce.page.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class StorePage extends BasePage {

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public StorePage moveRightSlider(int offsetX) {
        WebElement rightSlider = getDriver().findElement(
                By.xpath("(//div[contains(@class,'price_slider')]//span[contains(@class,'ui-slider-handle')])[2]"));


        new Actions(getDriver())
                .clickAndHold(rightSlider)
                .moveByOffset(offsetX, 0)
                .release()
                .perform();

        return this;
    }

    public double getMinFilterValue() {
        return Double.parseDouble(
                getDriver().findElement(By.id("min_price")).getAttribute("value"));
    }

    public double getMaxFilterValue() {
        return Double.parseDouble(
                getDriver().findElement(By.id("max_price")).getAttribute("value"));
    }

    public StorePage applyPriceFilter() {
        getDriver().findElement(By.xpath("//div[@class='price_slider_wrapper']//button[@type='submit']")).click();

        getWait5().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//span[contains(@class, 'price')]//span[contains(@class, 'amount') and not(ancestor::del)]")
        ));

        return this;
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


