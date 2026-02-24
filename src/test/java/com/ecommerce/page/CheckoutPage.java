package com.ecommerce.page;

import com.ecommerce.page.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter first name: {firstName}")
    public CheckoutPage fillFirstNameField(String firstName) {
        getWait2().until(ExpectedConditions.presenceOfElementLocated(By.id("billing_first_name"))).sendKeys(firstName);

        return this;
    }

    @Step("Enter last name: {lastName}")
    public CheckoutPage fillLastNameField(String lastName) {
        getDriver().findElement(By.id("billing_last_name")).sendKeys(lastName);

        return this;
    }

    @Step("Select country: {country}")
    public CheckoutPage fillCountryField(String country) {
        getDriver().findElement(By.id("billing_country")).click();
        getDriver().findElement(By.cssSelector("select2-search__field")).sendKeys(country );

        return this;
    }

    @Step("Enter street address: {address}")
    public CheckoutPage fillStreetAddressField(String address) {
        getDriver().findElement(By.id("billing_address_1")).sendKeys(address);

        return this;
    }

    @Step("Enter town/city: {town}")
    public CheckoutPage fillTownField(String town) {
        getDriver().findElement(By.id("billing_city")).sendKeys(town);

        return this;
    }

    @Step("Select state: {state}")
    public CheckoutPage fillStateField(String state) {
        getDriver().findElement(By.id("select2-billing_state-container")).sendKeys(state);
        getDriver().findElement(By.id("select2-billing_state-container")).sendKeys(state);

        return this;
    }

    @Step("Enter ZIP code: {zip}")
    public CheckoutPage fillZipField(String zip) {
        getDriver().findElement(By.id("billing_postcode")).sendKeys(zip);

        return this;
    }

    @Step("Enter email address: {email}")
    public CheckoutPage fillEmailAddressField(String email) {
        getDriver().findElement(By.id("billing_email")).sendKeys(email);

        return this;
    }

    @Step("Place the order")
    public CheckoutConfirmationPage clickPlaceOrder() {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.id("place_order"))).click();

        return new CheckoutConfirmationPage(getDriver());
    }
}
