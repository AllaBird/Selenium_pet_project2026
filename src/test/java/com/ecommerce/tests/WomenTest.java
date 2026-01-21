package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WomenTest extends BaseTest {

    @Test
    public void testAddWomenProductToCard() {
        getDriver().findElement(By.id("menu-item-1229")).click();

        getWait2().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@aria-label='Add “Anchor Bracelet” to your cart']"))).click();
        getWait2().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='View cart']")));

        getWait2().until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//a[@title='View your shopping cart'])[1]"))).click();

        List<String> productList = getDriver().findElements(By.xpath("//td[@data-title='Product']"))
                .stream()
                .map(WebElement::getText)
                .toList();

        Assert.assertEquals(productList.size(), 1);
        Assert.assertEquals(productList.get(0), "Anchor Bracelet");
    }
}
