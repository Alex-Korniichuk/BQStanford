package com.qamadness.pages.back_end;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by alexandrakorniichuk on 22.10.15.
 */
public class REQMethodReportPage extends PageObject {

    @FindBy (id = "buyerquestReqreportGrid_filter_message")
    WebElementFacade messageField;

    @FindBy (xpath = ".//*[@id='buyerquestReqreportGrid_table']/tbody/tr[1]/td[4]/a")
    WebElementFacade showDataink;

    @FindBy (xpath = "//td[@class='filter-actions a-right']/button[1]")
    WebElementFacade resetFilterBtn;

    public REQMethodReportPage(){}

    public void searchRequestByID(String expectedID){
        getDriver().navigate().refresh();
        resetFilterBtn.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-mask")));
        messageField.type(expectedID);
        messageField.sendKeys(Keys.ENTER);
    }

    public void clickShowDataLink(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-mask")));
        showDataink.click();
        String elementID = getDriver().findElement(By.xpath(".//*[@id='buyerquestReqreportGrid_table']/tbody/tr[1]/td[4]/div")).getAttribute("id");
        System.out.println(elementID);
        String script = "document.getElementById('" + elementID + "').style.display = 'block';";
    }
}
