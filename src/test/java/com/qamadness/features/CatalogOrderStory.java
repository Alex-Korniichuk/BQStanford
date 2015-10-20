package com.qamadness.features;

import com.qamadness.steps.*;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by alexandrakorniichuk on 20.10.15.
 */
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/TestingData.csv")
public class CatalogOrderStory {

    private String email;
    private String password;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public HomePageSteps homePageSteps;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public ShopBySupplierPageSteps shopBySupplierPageSteps;

    @Steps
    public ShoppingCartPageSteps shoppingCartPageSteps;

    @Steps
    public CheckoutPageSteps checkoutPageSteps;

    @Before
    public void loginToSite(){
        loginSteps.open_Page();
        loginSteps.enter_Credentials(email,password);
        loginSteps.click_Login_Btn();
        homePageSteps.check_Is_User_Logged_In();
    }

    @Issue("AUT-58")
    @Test
    public void unit_price_of_item_less_than_5000_Req_total_does_not_matter (){
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.expand_Product_And_Services_Tab();
        homePageSteps.click_Shop_By_Supplier_Link();
        shopBySupplierPageSteps.find_supplier_with_products_that_have_price_lower_than("5000");
        shopBySupplierPageSteps.add_Product_To_Cart();
        homePageSteps.open_Shopping_Cart();
        shoppingCartPageSteps.check_Is_Product_In_The_Cart();
        shoppingCartPageSteps.click_Proceed_To_Checkout_Button();
        checkoutPageSteps.enter_Order_Title("Robot test order");
        checkoutPageSteps.enter_Reason_To_Buy("Test reason to buy");
        checkoutPageSteps.continue_To_Shipping_And_Accounting();
        checkoutPageSteps.wait_Till_Shipping_Step_Is_Uploaded();
        checkoutPageSteps.click_Accounting_Edit_Link();
        checkoutPageSteps.enter_Accounting_Project("1095250");
    }
}
