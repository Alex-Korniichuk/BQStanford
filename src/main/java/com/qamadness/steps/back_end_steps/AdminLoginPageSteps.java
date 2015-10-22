package com.qamadness.steps.back_end_steps;

import com.qamadness.pages.back_end.AdminLoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 22.10.15.
 */
public class AdminLoginPageSteps extends ScenarioSteps {

    AdminLoginPage adminLoginPage;

    @Step
    public void open_Page() {
        adminLoginPage.open();
    }

    @Step
    public void enter_Credentials(String email, String password){
        adminLoginPage.enterEmail(email);
        adminLoginPage.enterPassword(password);
    }

    @Step
    public void click_Login_Btn(){
        adminLoginPage.clickLoginBtn();
    }

}
