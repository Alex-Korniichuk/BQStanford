package com.buyerquest.steps.back_end_steps;

import com.buyerquest.pages.back_end.AdminLoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.Dimension;

/**
 * Created by alexandrakorniichuk on 22.10.15.
 */
public class AdminLoginPageSteps extends ScenarioSteps {

    AdminLoginPage adminLoginPage;

    @Step
    public void open_Page() {
        adminLoginPage.open();
        getDriver().navigate().refresh();
        getDriver().manage().window().setSize(new Dimension(1200, 1200));
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
