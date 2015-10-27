package com.buyerquest.pages.front_end;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends PageObject {

    @FindBy(xpath="//*[@class='log-out-link']")
    WebElementFacade logoutLink;

    @FindBy (xpath = "//button[@class='lines-button sb-toggle-left']")
    WebElementFacade mainMenuBtn;

    @FindBy (xpath = ".//li[@class='shop-by-supplier no-sub highlight']/a")
    WebElementFacade shopBySupplierLink;

    @FindBy (xpath = "//li[@class='no-sub highlight']/a")
    WebElementFacade quickOrderLink;

    @FindBy (xpath = "//li[@class='my-account-nav']/a")
    WebElementFacade myAccountLink;

    @FindBy (xpath = "//ul[@id='nav-my-account']/li[5]/a")
    WebElementFacade orderTemplatesLink;

    @FindBy (xpath = "//ul[@id='nav-level-one']/li[2]/a")
    WebElementFacade productsAnServicesTab;

    @FindBy (css = ".dropdown.mini-cart-link>a")
    WebElementFacade miniShoppingCartLink;

    @FindBy (xpath = "//ul[@id='nav-level-one']/li[4]/a")
    WebElementFacade myAccountTab;

    @FindBy (xpath = "//ul[@id='nav-my-account']/li[1]/a")
    WebElementFacade profileInfoLink;

    @FindBy (xpath = "//ul[@id='nav-my-account']/li[10]/a")
    WebElementFacade collaborativeCartsLink;

    @FindBy (xpath = "//ul[@id='nav-my-account']/li[8]/a")
    WebElementFacade myReviewsLink;

    @FindBy(xpath = "//*[@id='nav-my-account']/li[9]/a")
    WebElementFacade myTagsLink;

    @FindBy (xpath = "//ul[@id='nav-level-one']/li[3]/a")
    WebElementFacade myDocumentsTab;

    @FindBy (xpath = "//*[@id='nav-collapse-top-1']/li[1]/a")
    WebElementFacade requestsTab;

    @FindBy (xpath = ".//*[@id='nav-collapse-sl-12']/li[1]/a")
    WebElementFacade pendingRequestsLink;

    @FindBy (xpath = "//a[@aria-controls='nav-welcome-switch']")
    WebElementFacade selectDifferentUserTab;

    @FindBy (xpath = ".//ul[@id='nav-welcome-switch']/li/div/a")
    WebElementFacade choseUserDropDown;

    @FindBy (css = ".select2-input.select2-focused")
    WebElementFacade searchUserField;

    @FindBy (xpath = ".//div[@id='select2-drop']/ul/li[2]/div/span")
    WebElementFacade userSearchResult;

    @FindBy (xpath = ".//div[@class='customer-account-info']/div/small/strong")
    WebElementFacade actingUserLabel;

    @FindBy (xpath = ".//*[@id='nav-collapse-top-1']/li[2]/a")
    WebElementFacade approvalsTab;

    @FindBy (xpath = ".//*[@id='nav-collapse-sl-13']/li[1]/a")
    WebElementFacade approveRequestLink;

    @FindBy (xpath = "//div[@id='topbar']/ul[1]/li[2]/a/span[1]")
    WebElementFacade searchButton;

    @FindBy (css = "#search_marketplace")
    WebElementFacade searchField;

    @FindBy (css = ".btn.btn-primary.search-btn")
    WebElementFacade hiddenSearchButton;

    @FindBy (css = "#bq-ui-1")
    WebElementFacade addToCartBtn;

    @FindBy (css = ".cart-empty")
    WebElementFacade emptyShoppingCartMsg;

    public HomePage() {}

    public void checkIsUserLoggedIn (){
        if ((logoutLink.isPresent())==true) {
            System.out.println("User is logged in");
        }
        else {
            System.out.print("User isn't logged in");
            System.exit(0);
        }
    }

    public void clickMainMenuBtn(){
        mainMenuBtn.waitUntilClickable().click();
    }

    public void clickShopBySupplierLink (){
        shopBySupplierLink.click();
    }

    public void  clickQuickOrderLink (){
        quickOrderLink.click();
    }

    public void clickOrderTemplatesLink(){
        myAccountLink.click();
        orderTemplatesLink.click();
    }

    public void expandProductsAndServicesTab (){
        String tabState = productsAnServicesTab.getAttribute("class");
        System.out.println(tabState);
        if (tabState.equalsIgnoreCase("collapsed")){
            productsAnServicesTab.click();
        }

    }

    public void openShoppingCart (){
        miniShoppingCartLink.click();
        WebDriverWait wait = new WebDriverWait(getDriver(),60);
        WebElement openShoppingCartBtn = wait.until(ExpectedConditions.elementToBeClickable(net.serenitybdd.core.annotations.findby.By.xpath("//a[@class='btn btn-primary btn-sm']")));
        openShoppingCartBtn.click();
    }

    public void expandMyAccountTab (){
        String tabState = myAccountTab.getAttribute("class");
        System.out.println(tabState);
        if (tabState.equalsIgnoreCase("collapsed") == true){
            myAccountTab.click();
        }
    }

    public void clickProfileInfoLink (){
        profileInfoLink.click();
    }

    public void clickLogoutLink (){
        logoutLink.click();
    }

    public void clickCollaborativeCartsLink (){
        collaborativeCartsLink.click();
    }

    public void clickMyReviewsLink (){
        myReviewsLink.click();
    }

    public void clickMyTagsLink() {myTagsLink.click();}

    public void expandMyDocumentsTab (){
        String tabState = myDocumentsTab.getAttribute("class");
        System.out.println(tabState);
        if (tabState.equalsIgnoreCase("collapsed") == true){
            myDocumentsTab.click();
        }
    }

    public void expandRequestsTab (){
        String tabState = requestsTab.getAttribute("class");
        System.out.println(tabState);
        if (tabState.equalsIgnoreCase("collapsed") == true){
            requestsTab.click();
        }
    }

    public void clickPendingRequestsLink (){
        pendingRequestsLink.click();
    }

    public void expandSelectDifferentUserTab (){
        String tabState = selectDifferentUserTab.getAttribute("class");
        System.out.println(tabState);
        if (tabState.equalsIgnoreCase("collapsed")){
            selectDifferentUserTab.click();
        }

    }

    public void selectDifferentUser (String userName){
        choseUserDropDown.click();
        searchUserField.type(userName);
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.textToBePresentInElement(userSearchResult, userName));
        userSearchResult.click();
    }

    public void checkActingUser (String userName){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.textToBePresentInElement(actingUserLabel, userName));
    }

    public void expandApprovalsTab (){
        String tabState = approvalsTab.getAttribute("class");
        System.out.println(tabState);
        if (tabState.equalsIgnoreCase("collapsed")){
            approvalsTab.click();
        }
    }

    public void clickApproveARequestLink (){
        approveRequestLink.click();
    }

    public Boolean searchProductBySKU (String SKU){
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.type(SKU);
        hiddenSearchButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".search-bar-refine-container")));
        if (addToCartBtn.isVisible()){
            System.out.print("Product was found by SKU: "+SKU);
            return true;
        } else {
            System.out.print("Product wasn't found by SKU: "+SKU);
            return false;
        }
    }

    public Boolean checkIsShoppingCartEmpty (){
        miniShoppingCartLink.click();
        if (emptyShoppingCartMsg.isVisible()){
            System.out.println ("Shopping cart is empty");
            return true;
        } else {
            System.out.println ("Shopping cart isn't empty");
            miniShoppingCartLink.click();
            return false;
        }
    }



}

