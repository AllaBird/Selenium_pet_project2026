package com.ecommerce.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;

public class TestUtils {

    public static void iteratePagesAndCheck(WebDriver driver, Consumer<WebElement> checker) {

        By products = By.cssSelector("li.product");
        By nextBtn = By.cssSelector("a.next.page-numbers");

        while (true) {

            List<WebElement> currentProducts = driver.findElements(products);

            for (WebElement product : currentProducts) {
                checker.accept(product);
            }

            List<WebElement> nextButtons = driver.findElements(nextBtn);
            if (nextButtons.isEmpty()) {
                break;
            }

            nextButtons.get(0).click();

            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.stalenessOf(currentProducts.get(0)));
        }
    }
}
