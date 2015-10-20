package com.qamadness.pages.front_end;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by alexandrakorniichuk on 20.10.15.
 */
public class QuickOrderPage extends PageObject {

    @FindBy (xpath = "//div[@id='sku_file-upload-box']")
    WebElementFacade addFileInput;

    @FindBy (xpath = "//div[@class='pull-right']/button")
    WebElementFacade uploadButton;

    public QuickOrderPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile() {
        setImplicitTimeout(120, TimeUnit.SECONDS);
        ((JavascriptExecutor) getDriver()).executeScript("document.getElementById('customer_sku_csv').style.opacity = '100';");
        WebElement fileInput = getDriver().findElement(By.id("customer_sku_csv"));
        //fileInput.sendKeys("/Users/alexandrakorniichuk/IdeaProjects/BQ4P2P/src/test/resources/QuickOrderProducts.csv"); - use this method if upload method doesn't work
        upload("QuickOrderProducts.csv").to(fileInput);
        WebElement uploadBtn = getDriver().findElement(By.xpath("//button[@title='Upload File']"));
        waitForRenderedElementsToBePresent(By.xpath("//a[@class='action-cancel']"));
        WebElement cancelLink = getDriver().findElement(By.xpath("//a[@class='action-cancel']"));

        if(cancelLink.isDisplayed()==true){
            uploadBtn.click();}
    }
}
