package com.buyerquest.steps.front_end_steps;

import com.buyerquest.pages.front_end.PendingRequestsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 21.10.15.
 */
public class PendingRequestsPageSteps extends ScenarioSteps {

    PendingRequestsPage pendingRequestsPage;

    @Step
    public void search_Request_By_ID (String requestID){
        pendingRequestsPage.searchRequestByID(requestID);
    }

    @Step
    public void check_Search_Results (String expectedID){
        pendingRequestsPage.checkSearchResult(expectedID);
    }

    @Step
    public void open_Request_Details_Page (){
        pendingRequestsPage.clickRequestIDLink();
    }
}

