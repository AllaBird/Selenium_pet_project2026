package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.page.HomePage;
import com.ecommerce.page.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class StoreTest extends BaseTest {

    @Test
    public void testFilterPrice() {
       StorePage storePage = new HomePage(getDriver())
                .getHeader().clickStorePage()
                .moveRightSlider(-50)
                .applyPriceFilter();

        double minFilter = storePage
                .getMinFilterValue();
        double maxFilter = storePage
                .getMaxFilterValue();

        List<Double> prices = storePage
                .getDisplayedProductPrices();

        for (double price : prices) {
            Assert.assertTrue(
                    price >= minFilter && price <= maxFilter,
                    "Price out of range: " + price
            );
        }
    }
}
