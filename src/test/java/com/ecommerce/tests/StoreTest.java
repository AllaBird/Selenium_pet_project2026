package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.page.HomePage;
import com.ecommerce.page.MenPage;
import com.ecommerce.page.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class StoreTest extends BaseTest {

    @Test
    public void testFilterPrice() {
        StorePage storePage = new HomePage(getDriver())
                .getHeader().clickStorePage()
                .getLeftSideBar().moveRightSlider(-50)
                .getLeftSideBar().applyPriceFilter();

        double minFilter = storePage
                .getLeftSideBar().getMinFilterValue();
        double maxFilter = storePage
                .getLeftSideBar().getMaxFilterValue();

        List<Double> prices = storePage
                .getDisplayedProductPrices();

        for (double price : prices) {
            Assert.assertTrue(
                    price >= minFilter && price <= maxFilter,
                    "Price out of range: " + price
            );
        }
    }

    @Test
    public void testBrowseByCategories() {
        MenPage manPage = new HomePage(getDriver())
                .getHeader().clickStorePage()
                .getLeftSideBar().selectCategory("mens-jeans", new MenPage(getDriver()));

        Assert.assertEquals(manPage.getTitle(), "Men's Jeans");
        Assert.assertTrue(manPage.getProductNameList().stream()
                .allMatch(p -> p.toLowerCase().contains("jeans")));
    }
}
