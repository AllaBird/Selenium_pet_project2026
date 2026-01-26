package com.ecommerce.page;

import com.ecommerce.page.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage fillFirstNameField(String firstName) {
        getWait2().until(ExpectedConditions.presenceOfElementLocated(By.id("billing_first_name"))).sendKeys(firstName);

        return this;
    }

    public CheckoutPage fillLastNameField(String lastName) {
        getDriver().findElement(By.id("billing_last_name")).sendKeys(lastName);

        return this;
    }

    public CheckoutPage fillCountryField(String country) {
        getDriver().findElement(By.id("billing_country")).click();
        getDriver().findElement(By.cssSelector("select2-search__field")).sendKeys(country );

        return this;
    }

    public CheckoutPage fillStreetAddressField(String address) {
        getDriver().findElement(By.id("billing_address_1")).sendKeys(address);

        return this;

    }public CheckoutPage fillTownField(String town) {
        getDriver().findElement(By.id("billing_city")).sendKeys(town);

        return this;
    }
    public CheckoutPage fillStateField(String state) {
        getDriver().findElement(By.id("select2-billing_state-container")).sendKeys(state);
        getDriver().findElement(By.id("select2-billing_state-container")).sendKeys(state);

        return this;
    }

    public CheckoutPage fillZipField(String zip) {
        getDriver().findElement(By.id("billing_postcode")).sendKeys(zip);

        return this;
    }

    public CheckoutPage fillEmailAddressField(String email) {
        getDriver().findElement(By.id("billing_email")).sendKeys(email);

        return this;
    }

    public CheckoutConfirmationPage clickPlaceOrder() {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.id("place_order"))).click();

        return new CheckoutConfirmationPage(getDriver());
    }

}
