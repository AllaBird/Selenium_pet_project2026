package com.ecommerce.components;

import com.ecommerce.page.BaseSalesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeftSideBar<T extends BaseSalesPage> extends BaseComponent {

    private final T parentPage;

    public LeftSideBar(T parentPage) {
        super(parentPage.getDriver());
        this.parentPage = parentPage;
    }

    public T moveRightSlider(int offsetX) {
        WebElement rightSlider = getDriver().findElement(
                By.xpath("(//div[contains(@class,'price_slider')]//span[contains(@class,'ui-slider-handle')])[2]"));

        new Actions(getDriver())
                .clickAndHold(rightSlider)
                .moveByOffset(offsetX, 0)
                .release()
                .perform();

        return parentPage;
    }

    public double getMinFilterValue() {
        return Double.parseDouble(
                getDriver().findElement(By.id("min_price")).getAttribute("value"));
    }

    public double getMaxFilterValue() {
        return Double.parseDouble(
                getDriver().findElement(By.id("max_price")).getAttribute("value"));
    }

    public T applyPriceFilter() {
        getDriver().findElement(By.xpath("//div[@class='price_slider_wrapper']//button[@type='submit']")).click();

        getWait5().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//span[contains(@class, 'price')]//span[contains(@class, 'amount') and not(ancestor::del)]")
        ));

        return parentPage;
    }

}
