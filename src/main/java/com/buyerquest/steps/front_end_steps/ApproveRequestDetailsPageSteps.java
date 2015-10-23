package com.buyerquest.steps.front_end_steps;

import com.buyerquest.pages.front_end.ApproveRequestDetailsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 22.10.15.
 */
public class ApproveRequestDetailsPageSteps extends ScenarioSteps {

    ApproveRequestDetailsPage approveRequestDetailsPage;

    @Step
    public void approve_Request (){
        approveRequestDetailsPage.clickApproveRequestBtn();
        approveRequestDetailsPage.clickConfirmApproveRequestBtn();
    }
}
