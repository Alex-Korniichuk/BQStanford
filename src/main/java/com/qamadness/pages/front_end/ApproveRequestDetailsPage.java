package com.qamadness.pages.front_end;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alexandrakorniichuk on 22.10.15.
 */
public class ApproveRequestDetailsPage extends PageObject {

    @FindBy (css = ".btn.btn-success.validate-approve-view-page")
    WebElementFacade approveBtn;

    @FindBy (xpath = "/html/body/div[6]/div/div/form/div[3]/button[2]")
    WebElementFacade confirmApproveRequest;

    public ApproveRequestDetailsPage(){}

    public void clickApproveRequestBtn (){
        approveBtn.click();
    }

    public void clickConfirmApproveRequestBtn (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(confirmApproveRequest));
        confirmApproveRequest.click();
    }
}
