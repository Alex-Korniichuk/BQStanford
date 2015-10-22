package com.qamadness.steps.front_end_steps;

import com.qamadness.pages.front_end.ShoppingCartPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 20.10.15.
 */
public class ShoppingCartPageSteps extends ScenarioSteps {

    ShoppingCartPage shoppingCartPage;

    @Step
    public void check_Is_Product_In_The_Cart(){
        shoppingCartPage.checkIsProductInTheCart();
    }

    @Step
    public void check_That_Correct_Product_In_The_Cart (String expectedProduct){
        shoppingCartPage.checkProductName(expectedProduct);
    }

    @Step
    public void clear_Cart (){
        shoppingCartPage.clearCart();
    }

    @Step
    public void go_To_Previous_Page (){
        getDriver().navigate().back();
    }

    @Step
    public void click_Proceed_To_Checkout_Button(){
        shoppingCartPage.clickProceedToCheckoutBtn();
    }

}
