package com.qamadness.pages.front_end;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by alexandrakorniichuk on 20.10.15.
 */
public class ShopBySupplierPage extends PageObject {

    @FindBy(id = "supplierList")
    WebElementFacade suppliersList;

    @FindBy (xpath = "//div[@id='product-listing-container']/div[1]/div/div[@class='product-name name-container']/a")
    WebElementFacade productName;

    @FindBy (xpath = "//div[@class='product-price']/span/span")
    WebElementFacade productPrice;

    @FindBy(css = "#bq-ui-1")
    WebElementFacade addToCartBtn;

    @FindBy (css = "#page-filter-label")
    WebElementFacade filterLink;

    @FindBy (xpath = ".//*[@id='page-filter-list']/div/div[2]/div/a")
    WebElementFacade priceFilter;

    @FindBy (id = "solrbridge-price-to")
    WebElementFacade maxPriceField;

    @FindBy (id = "solrbridge-price-from")
    WebElementFacade minPriceField;

    @FindBy (css = ".btn.btn-link.view-more")
    WebElementFacade updateLink;

    @FindBy (css = ".label-remove.btn-remove")
    WebElementFacade removeFilterLinks;

    public ShopBySupplierPage(){}

    public void openSupplierPageWithProducts (){
        setImplicitTimeout(60, TimeUnit.SECONDS);
        int suppliersQty = getDriver().findElements(By.xpath("//ul[@id='supplierList']/li")).size();
        for (int i=1; i<=suppliersQty; i++){
            waitForRenderedElementsToBePresent(By.xpath("//ul[@id='supplierList']/li[" + i + "]/div/div/a"));
            getDriver().findElement(By.xpath("//ul[@id='supplierList']/li["+i+"]/div/div/a")).click();
            if(getDriver().findElements(By.xpath("//div[@class='product-item']")).size()>2){
                System.out.print("Category has products");
                break;
            }else{
                getDriver().navigate().back();
            }
        }
    }

    public void addProductsToComparison(){
        setImplicitTimeout(50, TimeUnit.SECONDS);
        for (int i=1; i<=2; i++){
            waitForRenderedElementsToBePresent(By.xpath("//*[@id='product-listing-container']/div["+i+"]/div/div[2]/div[1]/div/a"));
            waitForRenderedElementsToBePresent(By.xpath("//*[@id='product-listing-container']/div[" + i + "]/div/div[2]/div[1]/div/a"));
            WebElement compareLink = getDriver().findElement(By.xpath("//*[@id='product-listing-container']/div["+i+"]/div/div[2]/div[1]/div/a"));
            compareLink.click();
        }
    }

    public void goToComparisonPage (){
        setImplicitTimeout(60, TimeUnit.SECONDS);
        waitForRenderedElementsToBePresent(By.cssSelector(".compare-link-action")).withTimeoutOf(60, TimeUnit.SECONDS);
        WebElement linkToComparePage = getDriver().findElement(By.cssSelector(".compare-link-action"));
        linkToComparePage.click();
    }

    public void openProductDetailsPage(){
        productName.click();
    }

    public String getCurrency (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-price']/span/span")));
        String price = productPrice.getText();
        String currency = price.substring(0,1);
        System.out.print("Currency is: "+currency);
        return currency;
    }

    public void addProductToCart (){
        addToCartBtn.click();
    }

    public void filterProductsByPrice (String minPrice, String maxPrice){
        //Expand filters list
        filterLink.click();
        //Check is Price block collapsed and if it is collapsed click it
        String tabState = priceFilter.getAttribute("class");
        System.out.println(tabState);
        if (tabState.equalsIgnoreCase("filter-header collapsed")){priceFilter.click();}
        //Enter min price
        minPriceField.type(minPrice);
        //Enter max price
        maxPriceField.type(maxPrice);
        //Click Update link to use filtration
        updateLink.click();
        //Wait till remove filters links appear and products are filtered
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(removeFilterLinks));
    }

    public void findSupplierWithProductsThatHavePriceLowerThan (String maxPrice){
        setImplicitTimeout(60, TimeUnit.SECONDS);
        int suppliersQty = getDriver().findElements(By.xpath("//ul[@id='supplierList']/li")).size();
        for (int i=1; i<=suppliersQty; i++){
            waitForRenderedElementsToBePresent(By.xpath("//ul[@id='supplierList']/li[" + i + "]/div/div/a"));
            getDriver().findElement(By.xpath("//ul[@id='supplierList']/li["+i+"]/div/div/a")).click();
                if(getDriver().findElements(By.xpath("//div[@class='product-item']")).size()>2){
                    this.filterProductsByPrice("0", maxPrice);
                    if(getDriver().findElements(By.xpath("//div[@class='product-item']")).size()>2){
                    System.out.print("Category has products with price lower then" + maxPrice);
                    break;
                    }else{getDriver().navigate().back();}
                }else{
                getDriver().navigate().back();}
        }
    }

}


