package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.page.HomePage;
import com.ecommerce.user.User;
import com.ecommerce.user.UserFactory;
import com.ecommerce.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ManTest extends BaseTest {

    private static final String PRODUCT_NAME = "Basic Blue Jeans";

    @Test
    public void testAddProductToCard() {
        List<String> productList = new HomePage(getDriver())
                .getHeader().clickMenOption()
                .clickAddToCard(PRODUCT_NAME)
                .clickViewCart()
                .getProductList();

        Assert.assertEquals(productList.size(), 1);
        Assert.assertEquals(productList.get(0), "Basic Blue Jeans");
    }

    @Test
    public void testPlaceOrderUsingFakerTest() {
        User user = UserFactory.randomUser();

        String confirmation = new HomePage(getDriver())
                .getHeader().clickMenOption()
                .clickAddToCard(PRODUCT_NAME)
                .clickViewCart()
                .clickProceedToCheckout()
                .fillFirstNameField(user.firstName())
                .fillLastNameField(user.lastName())
             //   .fillCountryField("Sweden")
                .fillStreetAddressField(user.address())
                .fillTownField(user.town())
          //      .fillStateField(user.state())
                .fillZipField(user.zipCode())
                .fillEmailAddressField(user.emailAddress())
                .clickPlaceOrder()
                .getConfirmationOrderText();

        Assert.assertEquals(confirmation,  "Thank you. Your order has been received.");


    }

    @Test
    public void testPlaceOrderUsingJsonFileTest() {
        User user = UserUtils.readFromJson("src/test/resources/user.json", User.class);

        String confirmation = new HomePage(getDriver())
                .getHeader().clickMenOption()
                .clickAddToCard(PRODUCT_NAME)
                .clickViewCart()
                .clickProceedToCheckout()
                .fillFirstNameField(user.firstName())
                .fillLastNameField(user.lastName())
                //.fillCountryField("Sweden")
                .fillStreetAddressField(user.address())
                .fillTownField(user.town())
                //      .fillStateField(user.state())
                .fillZipField(user.zipCode())
                .fillEmailAddressField(user.emailAddress())
                .clickPlaceOrder()
                .getConfirmationOrderText();

        Assert.assertEquals(confirmation,  "Thank you. Your order has been received.");
    }
}
