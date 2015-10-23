package com.buyerquest.pages.front_end;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by alexandrakorniichuk on 20.10.15.
 */
public class ShoppingCartPage extends PageObject {

    @FindBy(xpath="//div[@class='highlighted-component shopping-cart-container']")
    WebElementFacade productsTable;

    @FindBy(xpath = "//a[@title='Clear Cart']")
    WebElementFacade clearCartBtn;

    @FindBy (xpath = "//div[@class='item row']/div[2]/span/a")
    WebElementFacade actualProductName;

    @FindBy (xpath = "//div[@id='main-content']/div/div[1]/div/div/button")
    WebElementFacade proceedToCheckoutBtn;



    public ShoppingCartPage(){
    }

    public void checkIsProductInTheCart (){
        if (productsTable.isPresent() == true){
            System.out.println("Product is in the cart");
        }else{
            Assert.fail("Cart is empty");
        }
    }

    public void clearCart(){
        setImplicitTimeout(60, TimeUnit.SECONDS);
        clearCartBtn.click();
        waitForRenderedElementsToBePresent(By.xpath("html/body/div[@id='emptyCart']/div/div"));
        WebElement containerFrame = getDriver().findElement(By.xpath("html/body/div[@id='emptyCart']/div/div"));
        //getDriver().switchTo().activeElement();
        waitForRenderedElementsToBePresent(By.xpath("html/body/div[@id='emptyCart']/div/div/form/div[3]/button[@type='submit']"));
        WebElement confirmBtn = getDriver().findElement(By.xpath("html/body/div[@id='emptyCart']/div/div/form/div[3]/button[@type='submit']"));
        confirmBtn.click();
        waitForRenderedElementsToBePresent(By.className("empty-cart-content"));
        resetImplicitTimeout();

    }

    public void checkProductName (String expectedProductName){
        if(expectedProductName.equalsIgnoreCase(actualProductName.getText()) == true){
            System.out.println("Correct Product is added to the shopping cart");
        }else {
            Assert.fail("Incorrect product is added to cart");
        }
    }

    public void clickProceedToCheckoutBtn (){
        proceedToCheckoutBtn.click();
    }

}

