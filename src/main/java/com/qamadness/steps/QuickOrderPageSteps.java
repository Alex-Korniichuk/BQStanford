package com.qamadness.steps;

import com.qamadness.pages.front_end.QuickOrderPage;
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
