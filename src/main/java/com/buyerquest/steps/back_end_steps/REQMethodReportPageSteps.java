package com.buyerquest.steps.back_end_steps;

import com.buyerquest.pages.back_end.REQMethodReportPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 22.10.15.
 */
public class REQMethodReportPageSteps extends ScenarioSteps {

    REQMethodReportPage reqMethodReportPage;

    @Step
    public void findRequest (String expectedID){
        reqMethodReportPage.searchRequestByID(expectedID);
    }

    @Step
    public void clickShowDataLink (String expectedID) throws InterruptedException{
        reqMethodReportPage.clickShowDataLink(expectedID);
    }

    @Step
    public void displayData (){
        reqMethodReportPage.displayData();
    }

}
