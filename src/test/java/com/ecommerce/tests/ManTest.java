package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.user.User;
import com.ecommerce.user.UserFactory;
import com.ecommerce.utils.UserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ManTest extends BaseTest {

    @Test
    public void testAddMenProductToCard() {
        getWait2().until(ExpectedConditions.elementToBeClickable(By.id("menu-item-1228"))).click();

        getWait2().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@aria-label='Add “Basic Blue Jeans” to your cart']"))).click();
        getWait2().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='View cart']")));

        getWait2().until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//a[@title='View your shopping cart'])[1]"))).click();

        List<String> productList = getDriver().findElements(By.xpath("//td[@data-title='Product']"))
                .stream()
                .map(WebElement::getText)
                .toList();

        Assert.assertEquals(productList.size(), 1);
        Assert.assertEquals(productList.get(0), "Basic Blue Jeans");
    }

    @Test
    public void testPlaceOrderUsingJsonFileTest() {
        User user = UserFactory.randomUser();
        getWait2().until(ExpectedConditions.elementToBeClickable(By.id("menu-item-1228"))).click();

        getWait2().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@aria-label='Add “Basic Blue Jeans” to your cart']"))).click();
        getWait2().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='View cart']")));

        getWait2().until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@title='View your shopping cart'])[1]"))).click();
        getWait2().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Proceed to checkout')]"))).click();

        getWait2().until(ExpectedConditions.presenceOfElementLocated(By.id("billing_first_name"))).sendKeys(user.firstName());

        getDriver().findElement(By.id("billing_last_name")).sendKeys(user.lastName());

        getDriver().findElement(By.id("billing_company"))
                .sendKeys("Sweden");

        getDriver().findElement(By.id("billing_address_1")).sendKeys(user.address());
        getDriver().findElement(By.id("billing_city")).sendKeys(user.town());

        getDriver().findElement(By.id("billing_postcode")).sendKeys(user.zipCode());
        getDriver().findElement(By.id("billing_email")).sendKeys(user.emailAddress());


        getWait5().until(ExpectedConditions.elementToBeClickable(By.id("place_order"))).click();
        getWait5().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'blockOverlay')]")));
        getWait5().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(text(),'Order number:')]")));

        Assert.assertEquals(getDriver().findElement(By.xpath("//p[contains(@class,'woocommerce-notice ')]")).getText(),
                "Thank you. Your order has been received.");
    }

    @Test
    public void testPlaceOrderTestViaJson() {
        User user = UserUtils.readFromJson("src/test/resources/user.json", User.class);

        getWait2().until(ExpectedConditions.elementToBeClickable(By.id("menu-item-1228"))).click();

        getWait2().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@aria-label='Add “Basic Blue Jeans” to your cart']"))).click();
        getWait2().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='View cart']")));

        getWait2().until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@title='View your shopping cart'])[1]"))).click();
        getWait2().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Proceed to checkout')]"))).click();

        getWait2().until(ExpectedConditions.presenceOfElementLocated(By.id("billing_first_name"))).sendKeys(user.firstName());

        getDriver().findElement(By.id("billing_last_name")).sendKeys(user.lastName());

        getDriver().findElement(By.id("billing_company"))
                .sendKeys("Sweden");

        getDriver().findElement(By.id("billing_address_1")).sendKeys(user.address());
        getDriver().findElement(By.id("billing_city")).sendKeys(user.town());

        getDriver().findElement(By.id("billing_postcode")).sendKeys(user.zipCode());
        getDriver().findElement(By.id("billing_email")).sendKeys(user.emailAddress());


        getWait5().until(ExpectedConditions.elementToBeClickable(By.id("place_order"))).click();
        getWait5().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'blockOverlay')]")));
        getWait5().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(text(),'Order number:')]")));

        Assert.assertEquals(getDriver().findElement(By.xpath("//p[contains(@class,'woocommerce-notice ')]")).getText(),
                "Thank you. Your order has been received.");
    }
}
