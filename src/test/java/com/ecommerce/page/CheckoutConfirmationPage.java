package com.ecommerce.page;

import com.ecommerce.page.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutConfirmationPage extends BasePage {

    public CheckoutConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationOrderText() {
        getWait5().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(text(),'Order number:')]")));

        return getDriver().findElement(By.xpath("//p[contains(@class,'woocommerce-notice ')]")).getText();
    }
}
