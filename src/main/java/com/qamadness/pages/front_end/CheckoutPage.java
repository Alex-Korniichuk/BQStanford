package com.qamadness.pages.front_end;

import groovy.transform.ToString;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by alexandrakorniichuk on 20.10.15.
 */
public class CheckoutPage extends PageObject {

/* ======================================== Objects for General Information tab ===================================== */

    @FindBy(id = "order_name")
    WebElementFacade titleField;

    @FindBy (id = "reason_to_buy")
    WebElementFacade reasonToBuyTextArea;

    @FindBy (xpath = "//input[@type='file']")
    WebElementFacade uploadFileInput;

    @FindBy (xpath = "//td[@class='attachment-file-link']")
    WebElementFacade attachedFile;

    @FindBy (xpath = "//table[@class='attachment-block-table table table-striped']/tbody/tr/td[4]/a")
    WebElementFacade deleteFileLink;

    @FindBy (xpath = "//button[@name='next']")
    WebElementFacade continueToShippingAndAccountingBtn;


/* ======================================= Objects for Shipping & Accounting tab ==================================== */

    @FindBy (xpath = "//div[@id='s2id_location-header']/a")
    WebElementFacade shippingAddressDropDown;

    @FindBy (xpath = "//div[@id='select2-drop']/ul/li[1]/div/address")
    WebElementFacade addressOption;

    @FindBy (xpath = "//div[@class='accounting-container']/div[3]/div/div/dl/dd[5]/ul/li[1]/a")
    WebElementFacade accountingEditLink;

    @FindBy (xpath = "//div[@class='accounting-form']/div[1]/div/a")
    WebElementFacade projectDropDown;

    @FindBy (xpath = "//div[@class='accounting-form']/div[2]/div/a")
    WebElementFacade taskDropDown;

    @FindBy (xpath = "//div[@class='accounting-form']/div[3]/div/a")
    WebElementFacade awardDropDown;

    @FindBy (xpath = "//div[@class='accounting-form']/div[4]/div/a")
    WebElementFacade expenditureDropDown;

    @FindBy (xpath = ".//*[@id='select2-drop']/div/input")
    WebElementFacade accountingSearchField;

    @FindBy (xpath = ".//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']/div")
    WebElementFacade accountingSearchResult;

    @FindBy (xpath = ".//div[@class='accounting-form']/div[6]/a[1]")
    WebElementFacade saveChangesBtn;

    @FindBy (xpath = "//div[@class='shipping']/div[2]/div[1]/div/span")
    WebElementFacade neededByCalendarBtn;

    @FindBy (xpath = "//div[@id='shipping-buttons-container']/div/button[2]")
    WebElementFacade continueToApprovalChainBtn;

/* =========================================== Objects for Approval Chain tab ======================================= */

    @FindBy (xpath = "//a[@data-action='watcherAdd']")
    WebElementFacade addWatcherBtn;

    @FindBy (css = "#people_search_key")
    WebElementFacade searchField;

    @FindBy (css = "#person_undefined")
    WebElementFacade searchResult;

    @FindBy (xpath = "//div[@class='watcher-delete-wrap']")
    WebElementFacade removeWatcherLink;

    @FindBy (xpath = "//ul[@class='watcher-list']/li")
    WebElementFacade firstWatcher;

    @FindBy (xpath = "//div[@class='approver-edit']/h3/a")
    WebElementFacade editApprovalChainLink;

    @FindBy (xpath = "//div[@class='chain']/div[2]/a")
    WebElementFacade addApprovalBtn;

    @FindBy (css = ".chain-node.chain-node-first")
    WebElementFacade firstApprover;

    @FindBy (xpath = "//div[@id='approvers-buttons-container']/div/button[2]")
    WebElementFacade continueToReviewBtn;


/* =============================================== Objects for Review tab =========================================== */

    @FindBy (xpath = "//div[@id='review-buttons-container']/div/div/button[2]")
    WebElementFacade submitOrderBtn;


/* ============================================== Objects for Success Page ========================================== */

    @FindBy (id = "name")
    WebElementFacade orderTemplateNameField;

    @FindBy (id = "btn-request-submit")
    WebElementFacade saveOrderTemplateBtn;

    @FindBy (xpath = "//div[@id='main-content']/div[2]/div[1]/p[2]/a")
    WebElementFacade requestLink;


    public CheckoutPage (){}

/* ======================================== Methods for General Information tab ===================================== */

    public void uploadFile () {
        setImplicitTimeout(120, TimeUnit.SECONDS);
        ((JavascriptExecutor) getDriver()).executeScript("document.getElementsByName('upload_files').item(0).style.opacity = '100';");
        //uploadFileInput.sendKeys("/Users/alexandrakorniichuk/IdeaProjects/BQ4P2P/src/test/resources/QuickOrderProducts.csv"); - use this method if upload method doesn't work
        upload("QuickOrderProducts.csv").to(uploadFileInput);
        resetImplicitTimeout();
    }

    public void checkThatFileUploaded (){
        waitForRenderedElementsToBePresent(By.xpath("//td[@class='attachment-file-link']"));
        if(attachedFile.isDisplayed() == true){
            System.out.println("File is uploaded");
        } else {
            Assert.fail("File isn't uploaded");
        }
    }

    public void removeFile (){
        waitFor(deleteFileLink);
        deleteFileLink.click();
    }

    public void enterOrderTitle (String title){
        titleField.type(title);
    }

    public void enterReasonToBuy (String reason){
        reasonToBuyTextArea.type(reason);
    }

    public void clickContinueToShippingBtn (){
        continueToShippingAndAccountingBtn.click();
    }


/* ======================================= Methods for Shipping & Accounting tab ==================================== */

    public void waitForShippingStep (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='checkout-step-shipping']")));
    }

    public void selectAddress (){
        shippingAddressDropDown.click();
        addressOption.click();

    }

    public void clickContinueToApprovalBtn (){
        continueToApprovalChainBtn.click();
    }

    public void clickAccountingEditLink (){
        accountingEditLink.click();
    }

    public void enterAccountingProject (String projectCode){
        projectDropDown.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(accountingSearchField));
        accountingSearchField.type(projectCode);
        wait.until(ExpectedConditions.textToBePresentInElement(accountingSearchResult, projectCode));
        accountingSearchResult.click();
    }

    public void enterAccountingTask (String taskCode){
        taskDropDown.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(accountingSearchField));
        accountingSearchField.type(taskCode);
        wait.until(ExpectedConditions.textToBePresentInElement(accountingSearchResult, taskCode));
        accountingSearchResult.click();
    }

    public void enterAccountingAward (String awardCode){
        awardDropDown.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(accountingSearchField));
        accountingSearchField.type(awardCode);
        wait.until(ExpectedConditions.textToBePresentInElement(accountingSearchResult, awardCode));
        accountingSearchResult.click();
    }

    public void enterAccountingExpenditure (String expenditureCode){
        expenditureDropDown.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(accountingSearchField));
        accountingSearchField.type(expenditureCode);
        wait.until(ExpectedConditions.textToBePresentInElement(accountingSearchResult, expenditureCode));
        accountingSearchResult.click();
    }

    public void clickSaveChangesButton (){
        saveChangesBtn.click();
    }

    public void selectNeededByDate (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(neededByCalendarBtn));
        neededByCalendarBtn.click();
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Calendar cal = Calendar.getInstance();
        int currentDate = Integer.parseInt(dateFormat.format(cal.getTime()));
        if (currentDate <= 27){
            int neededByDate = currentDate+2;
            String neededByDateStr = Integer.toString(neededByDate);
            System.out.println(neededByDateStr);
            getDriver().findElement(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td[@class='day' and contains(text(), '" + neededByDateStr + "')]")).click();
        } else {
            getDriver().findElement(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td[@class='new day' and contains(text(), '1')]")).click();
        }

    }



/* =========================================== Methods for Approval Chain tab ======================================= */

    public void waitForApprovalStep (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='checkout-step-approvers']")));
    }

    public void clickAddWatcherBtn (){
        addWatcherBtn.click();
    }

    public void searchForPerson (){
        waitFor(searchField);
        searchField.type("Tester");
    }

    public void selectPerson (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#person_undefined")));
        searchResult.click();
    }

    public void checkThatWatcherIsAdded (){
        waitFor(firstWatcher);
        if(firstWatcher.isDisplayed() == true){
            System.out.println ("Watcher is added");
        } else{
            Assert.fail("Watcher isn't added");
        }
    }

    public void clickEditChainLink (){
        editApprovalChainLink.click();
    }

    public void clickAddApprovalBtn (){
        addApprovalBtn.click();
    }


    public void checkThatApproverIsAdded (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".chain-node.chain-node-first")));
        if (firstApprover.isDisplayed() == true){
            System.out.println("First Approver is added");
        } else {
            Assert.fail("Approver wasn't added");
        }

    }

    public void clickContinueToReviewBtn (){
        continueToReviewBtn.click();
    }

/* =============================================== Methods for Review tab =========================================== */

    public void waitForReviewStep (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='checkout-step-review']")));
    }

    public void clickSubmitBtn (){
        submitOrderBtn.click();
    }

/* ============================================== Methods for Success Page ========================================== */

    public void waitForSuccessPage (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main-content']/div[1]/div/h1")));
    }

    public void enterNewOrderTemplateName (){
        orderTemplateNameField.type("Test Order Template");
    }

    public void clickSaveOrderTemplateBtn (){
        saveOrderTemplateBtn.click();
    }

    public String getRequestID (){
        String requestID = requestLink.getText();
        return requestID;
    }


}

