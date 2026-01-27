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
                .clickViewCart()
                .getProductList();

        Assert.assertEquals(productList.size(), 1);
        Assert.assertEquals(productList.get(0), "Anchor Bracelet");
    }
}
