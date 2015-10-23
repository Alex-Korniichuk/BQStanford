package com.buyerquest.steps.front_end_steps;

import com.buyerquest.pages.front_end.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 20.10.15.
 */
public class LoginSteps extends ScenarioSteps {

    LoginPage frontEndLoginPage;

    @Step
    public void open_Page() {
        frontEndLoginPage.open();
    }

    @Step
    public void enter_Credentials(String email, String password){
        frontEndLoginPage.enterEmail(email);
        frontEndLoginPage.enterPassword(password);
    }

    @Step
    public void click_Login_Btn(){
        frontEndLoginPage.clickLoginBtn();
    }


}
