package com.qamadness.steps;

import com.qamadness.pages.front_end.ShopBySupplierPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by alexandrakorniichuk on 20.10.15.
 */
public class ShopBySupplierPageSteps extends ScenarioSteps {

    ShopBySupplierPage shopBySupplierPage;

    @Step
    public void open_Supplier_Page_With_Products(){
        shopBySupplierPage.openSupplierPageWithProducts();
    }

    @Step
    public void add_Products_To_Comparison(){
        shopBySupplierPage.addProductsToComparison();
    }

    @Step
    public void go_To_Comparison_Page(){
        shopBySupplierPage.goToComparisonPage();
    }

    @Step
    public void open_Product_Details_Page (){
        shopBySupplierPage.openProductDetailsPage();
    }
    @Step
    public String get_Product_Currency (){
        return shopBySupplierPage.getCurrency();
    }

    @Step
    public void add_Product_To_Cart (){ shopBySupplierPage.addProductToCart();}

    @Step
    public void find_supplier_with_products_that_have_price_lower_than (String maxPrice){
        shopBySupplierPage.findSupplierWithProductsThatHavePriceLowerThan(maxPrice);
    }
}

