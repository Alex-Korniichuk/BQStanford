package com.qamadness.steps.front_end_steps;


import com.qamadness.pages.front_end.RequestsToApprovePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 21.10.15.
 */
public class RequestsToApprovePageSteps extends ScenarioSteps {

    RequestsToApprovePage requestsToApprovePage;

    @Step
    public void search_Request_By_ID (String requestID){
        requestsToApprovePage.searchRequestByID(requestID);
    }

    @Step
    public void check_Search_Results (String expectedID){
        requestsToApprovePage.checkSearchResult(expectedID);
    }

    @Step
    public void open_Request_Details_Page (){
        requestsToApprovePage.clickRequestIDLink();
    }
}