package com.buyerquest.steps.front_end_steps;

import com.buyerquest.pages.front_end.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 20.10.15.
 */
public class HomePageSteps extends ScenarioSteps {

    HomePage homePage;

    @Step
    public void click_Main_Menu_Btn(){
        homePage.clickMainMenuBtn();
    }

    @Step
    public void click_Shop_By_Supplier_Link(){
        homePage.clickShopBySupplierLink();
    }

    @Step
    public void check_Is_User_Logged_In(){
        homePage.checkIsUserLoggedIn();
    }

    @Step
    public void open_My_Order_Templates_Page (){
        homePage.clickOrderTemplatesLink();
    }

    @Step
    public void expand_Product_And_Services_Tab (){
        homePage.expandProductsAndServicesTab();
    }

    @Step
    public void click_Quick_Order_Link (){
        homePage.clickQuickOrderLink();
    }

    @Step
    public void open_Shopping_Cart(){
        homePage.openShoppingCart();
    }

    @Step
    public void expand_My_Account_Tab (){
        homePage.expandMyAccountTab();
    }

    @Step
    public void open_Profile_Information_Page (){
        homePage.clickProfileInfoLink();
    }

    @Step
    public void logout (){
        homePage.clickLogoutLink();
    }

    @Step
    public void open_Collaborative_Carts_Page (){
        homePage.clickCollaborativeCartsLink();
    }

    @Step
    public void  open_My_Reviews_Page (){
        homePage.clickMyReviewsLink();
    }

    @Step
    public void open_My_Tags_Page (){homePage.clickMyTagsLink();}

    @Step
    public void expand_My_Documents_Tab (){
        homePage.expandMyDocumentsTab();
    }

    @Step
    public void expand_Requests_Tab (){
        homePage.expandRequestsTab();
    }

    @Step
    public void open_Pending_Requests_Page (){
        homePage.clickPendingRequestsLink();
    }

    @Step
    public void expand_Select_Different_User_Block (){
        homePage.expandSelectDifferentUserTab();
    }

    @Step
    public void select_Different_User (String userName){
        homePage.selectDifferentUser(userName);
    }

    @Step
    public void check_Acting_User (String userName){
        homePage.checkActingUser(userName);
    }

    @Step
    public void expand_Approvals_Block (){
        homePage.expandApprovalsTab();
    }

    @Step
    public void open_Approve_a_Request_Page (){
        homePage.clickApproveARequestLink();
    }


}
