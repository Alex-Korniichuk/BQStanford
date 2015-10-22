package com.qamadness.pages.back_end;

import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alexandrakorniichuk on 22.10.15.
 */
public class DashboardPage extends PageObject {

    @FindBy (xpath = "//a[@class='link-logout']")
    WebElementFacade logOutLink;

    @FindBy (css = ".menu-tab-text")
    WebElementFacade showMenuBtn;

    @FindBy (xpath = ".//*[@id='nav']/li[16]/a")
    WebElementFacade systemMenuBlock;

    @FindBy (xpath = ".//*[@id='dropdown_bq_31']/li[2]/a/span")
    WebElementFacade reqMethodReportLink;

    public DashboardPage (){}

    public void checkThatAdminLoggedIn (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(logOutLink));
        if ((logOutLink.isPresent())==true) {
            System.out.println("Admin is logged in");
        }
        else {
            Assert.fail("Admin isn't logged in");
        }
    }

    public void clickShowMenuBtn(){
        showMenuBtn.click();
    }

    public void expandSystemMenuBlock (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(systemMenuBlock));
        String tabState = systemMenuBlock.getAttribute("class");
        System.out.println(tabState);
        if (tabState.equalsIgnoreCase("collapsed") == true){
            systemMenuBlock.click();
        }
    }

    public void clickREQMethodReportLink (){ reqMethodReportLink.click(); }






}
