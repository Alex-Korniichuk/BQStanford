package com.buyerquest.pages.front_end;

/**
 * Created by alexandrakorniichuk on 20.10.15.
 */
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

@DefaultUrl("https://uat.buyerquest.net/stanford/websso/backdoor")
public class LoginPage extends PageObject {
    @FindBy(id = "email")
    WebElementFacade emailField;

    @FindBy(id="pass")
    private net.serenitybdd.core.pages.WebElementFacade passField;

    @FindBy(id="send2")
    private net.serenitybdd.core.pages.WebElementFacade loginBtn;

    public LoginPage() {
    }

    public void enterEmail (String email){
        emailField.type(email);
    }

    public void enterPassword (String password){
        passField.type(password);
    }

    public void clickLoginBtn (){
        loginBtn.click();
    }
}
