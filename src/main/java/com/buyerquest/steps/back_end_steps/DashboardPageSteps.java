package com.buyerquest.steps.back_end_steps;

import com.buyerquest.pages.back_end.DashboardPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 22.10.15.
 */
public class DashboardPageSteps extends ScenarioSteps {

    DashboardPage dashboardPage;

    @Step
    public void check_That_Admin_Logged_In (){
        dashboardPage.checkThatAdminLoggedIn();
    }

    @Step
    public void click_Show_Menu_Button (){
        dashboardPage.clickShowMenuBtn();
    }

    @Step
    public void expand_System_Menu_Block (){
        dashboardPage.expandSystemMenuBlock();
    }

    @Step
    public void open_REQ_Method_Report_Page (){
        dashboardPage.clickREQMethodReportLink();
    }

    @Step
    public void logout_From_Admin (){
        dashboardPage.logOutFromAdmin();
    }

}
