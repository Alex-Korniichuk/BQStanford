package com.buyerquest.steps.front_end_steps;

import com.buyerquest.pages.front_end.QuickOrderPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 20.10.15.
 */
public class QuickOrderPageSteps extends ScenarioSteps {

    QuickOrderPage quickOrderPage;

    @Step
    public void upload_File (){
        quickOrderPage.uploadFile();
    }
}
