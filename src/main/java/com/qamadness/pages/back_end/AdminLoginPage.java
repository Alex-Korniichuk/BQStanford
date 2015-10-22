package com.qamadness.pages.back_end;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by alexandrakorniichuk on 22.10.15.
 */
@DefaultUrl("https://uadmin.buyerquest.net/stanford/control")
public class AdminLoginPage extends PageObject {

    @FindBy(id = "username")
    WebElementFacade usernameField;

    @FindBy(id="login")
    private net.serenitybdd.core.pages.WebElementFacade passField;

    @FindBy(xpath = "//input[@type='submit']")
    private net.serenitybdd.core.pages.WebElementFacade loginBtn;

    public AdminLoginPage() {}

    public void enterEmail (String email){
        usernameField.type(email);
    }

    public void enterPassword (String password){
        passField.type(password);
    }

    public void clickLoginBtn (){
        loginBtn.click();
    }

}
