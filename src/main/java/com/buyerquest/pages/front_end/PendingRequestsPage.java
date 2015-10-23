package com.buyerquest.pages.front_end;

/**
 * Created by alexandrakorniichuk on 21.10.15.
 */

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PendingRequestsPage extends PageObject{

    @FindBy (id = "search_purchase_requests_grid")
    WebElementFacade searchRequestField;

    @FindBy (css = "button.btn.btn-search")
    WebElementFacade searchBtn;

    @FindBy (xpath = "//table[@id='purchase_requests_grid_table']/tbody/tr/td[1]/a")
    WebElementFacade requestIDLink;

    public PendingRequestsPage (){}

    public void searchRequestByID (String requestID){
        searchRequestField.type(requestID);
        searchBtn.click();
    }

    public void checkSearchResult (String expectedRequestID){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-block>span")));
        String actualRequestID = requestIDLink.getText();
        if (actualRequestID.equalsIgnoreCase(expectedRequestID)){
            System.out.println ("Correct search result. Order is found");
        } else {
            Assert.fail("Incorrect search result. Order wasn't found");
        }
    }

    public void clickRequestIDLink (){
        requestIDLink.click();
    }
}
