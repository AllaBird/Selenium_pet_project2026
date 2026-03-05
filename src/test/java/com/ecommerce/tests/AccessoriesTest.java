package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.page.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AccessoriesTest extends BaseTest {

    @Test
    public void testAddProductToCard() {
        List<String> productList = new HomePage(getDriver())
                .getHeader().clickAccessoriesOption()
                .clickAddToCard("Anchor Bracelet")
                .getHeader().clickViewCart()
                .getProductList();

        Assert.assertEquals(productList.size(), 1);
        Assert.assertEquals(productList.get(0), "Anchor Bracelet");
    }

    @Test
    public void testChangeQuantityInCard() {
        String quantity = new HomePage(getDriver())
                .getHeader().clickAccessoriesOption()
                .clickAddToCard("Anchor Bracelet")
                .getHeader().clickViewCart()
                .clickIncreaseQuantityByOneArrow()
                .clickUpdateCart()
                .getQuantity();

        Assert.assertEquals(quantity, "2");
    }
}
