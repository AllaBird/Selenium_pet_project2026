package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StoreTest extends BaseTest {

    @Test
    public void testFilterPrice() throws InterruptedException {
        getDriver().findElement(By.id("menu-item-1227")).click();

        WebElement slider = getDriver().findElement(
                By.xpath("(//div[contains(@class,'price_slider')]//span[contains(@class,'ui-slider-handle')])[2]"));
        new Actions(getDriver())
                .clickAndHold(slider)
                .moveByOffset(-50, 0)
                .release()
                .perform();

        double minFilter = Double.parseDouble(getDriver().findElement(By.id("min_price")).getAttribute("value"));
        double maxFilter = Double.parseDouble(getDriver().findElement(By.id("max_price")).getAttribute("value"));
        System.out.println(maxFilter);
        System.out.println(minFilter);


        getDriver().findElement(By.xpath("//div[@class='price_slider_wrapper']//button[@type='submit']")).click();

        Thread.sleep(2000);

        TestUtils.iteratePagesAndCheck(getDriver(), product -> {

            WebElement priceEl = product.findElement(
                    By.xpath(".//span[contains(@class,'amount') and not(ancestor::del)]")
            );

            double price = Double.parseDouble(
                    priceEl.getText().replaceAll("[$,]", "")
            );

            Assert.assertTrue(price >= minFilter && price <= maxFilter);
        });

    }
}
