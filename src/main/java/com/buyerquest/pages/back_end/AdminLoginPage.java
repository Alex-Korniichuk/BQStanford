package com.buyerquest.pages.back_end;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alexandrakorniichuk on 22.10.15.
 */
@DefaultUrl("https://uadmin.buyerquest.net/stanford/index.php/control/")
public class AdminLoginPage extends PageObject {

    @FindBy(id = "username")
    WebElementFacade usernameField;

    @FindBy(id="login")
    WebElementFacade passField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElementFacade loginBtn;

    public AdminLoginPage() {}

    public void enterEmail (String email){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        usernameField.type(email);
    }

    public void enterPassword (String password){
        passField.type(password);
    }

    public void clickLoginBtn (){
        loginBtn.click();
    }

}
