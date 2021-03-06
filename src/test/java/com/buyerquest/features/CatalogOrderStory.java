package com.buyerquest.features;

import com.buyerquest.steps.back_end_steps.AdminLoginPageSteps;
import com.buyerquest.steps.back_end_steps.DashboardPageSteps;
import com.buyerquest.steps.back_end_steps.REQMethodReportPageSteps;
import com.buyerquest.steps.front_end_steps.*;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by alexandrakorniichuk on 20.10.15.
 */
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/TestingData.csv")
public class CatalogOrderStory  {

    private String email;
    private String password;
    private String adminLogin;
    private  String adminPassword;


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public HomePageSteps homePageSteps;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public ShopBySupplierPageSteps shopBySupplierPageSteps;

    @Steps
    public ShoppingCartPageSteps shoppingCartPageSteps;

    @Steps
    public CheckoutPageSteps checkoutPageSteps;

    @Steps
    public RequestsToApprovePageSteps requestsToApprovePageSteps;

    @Steps
    public ApproveRequestDetailsPageSteps approveRequestDetailsPageSteps;

    @Steps
    public AdminLoginPageSteps adminLoginPageSteps;

    @Steps
    public DashboardPageSteps dashboardPageSteps;

    @Steps
    public REQMethodReportPageSteps reqMethodReportPageSteps;

    @Before
    public void loginToSite(){
        loginSteps.open_Page();
        loginSteps.enter_Credentials(email,password);
        loginSteps.click_Login_Btn();
        homePageSteps.check_Is_User_Logged_In();
        if (homePageSteps.check_Is_Shopping_Cart_Empty() == false){
            homePageSteps.open_Shopping_Cart();
            shoppingCartPageSteps.clear_Cart();
        }
    }

    @Issue("AUT-58")
    @Test
    public void unit_price_of_item_less_than_5000_Req_total_does_not_matter () throws InterruptedException{
        if (homePageSteps.search_Product_By_SKU("101123") == true) {
            shopBySupplierPageSteps.add_Product_To_Cart();
        } else {
            homePageSteps.click_Main_Menu_Btn();
            homePageSteps.expand_Product_And_Services_Tab();
            homePageSteps.click_Shop_By_Supplier_Link();
            shopBySupplierPageSteps.find_supplier_with_products_that_have_price_lower_than("5000");
            shopBySupplierPageSteps.add_Product_To_Cart();
        }
        homePageSteps.open_Shopping_Cart();
        shoppingCartPageSteps.check_Is_Product_In_The_Cart();
        shoppingCartPageSteps.click_Proceed_To_Checkout_Button();
        checkoutPageSteps.enter_Order_Title("Robot test order");
        checkoutPageSteps.enter_Reason_To_Buy("Test reason to buy");
        checkoutPageSteps.continue_To_Shipping_And_Accounting();
        checkoutPageSteps.wait_Till_Shipping_Step_Is_Uploaded();
        checkoutPageSteps.click_Accounting_Edit_Link();
        checkoutPageSteps.enter_Accounting_Project("1095250");
        checkoutPageSteps.enter_Accounting_Task("205");
        checkoutPageSteps.enter_Accounting_Award("AABPU");
        checkoutPageSteps.enter_Accounting_Expenditure("55230");
        checkoutPageSteps.save_Accounting_Changes();
        checkoutPageSteps.select_Needed_By_Day();
        checkoutPageSteps.continue_To_Approval_Chain();
        checkoutPageSteps.wait_Till_Approval_Chain_Step_Is_Uploaded();
        List<String> approversNames = checkoutPageSteps.get_Approvers_Names();
        int approversQty = approversNames.size();
        System.out.println("Approvers qty: " + approversQty);
        checkoutPageSteps.continue_To_Review();
        checkoutPageSteps.wait_Till_Review_Step_Is_Uploaded();
        checkoutPageSteps.submit_Order();
        checkoutPageSteps.wait_Till_Success_Page_Is_Uploaded();
        String expectedID = checkoutPageSteps.get_Request_ID();
        for (int i=0; i<approversQty; i++){
            homePageSteps.click_Main_Menu_Btn();
            homePageSteps.expand_Select_Different_User_Block();
            homePageSteps.select_Different_User(approversNames.get(i));
            homePageSteps.click_Main_Menu_Btn();
            homePageSteps.check_Acting_User(approversNames.get(i));
            homePageSteps.expand_My_Documents_Tab();
            homePageSteps.expand_Approvals_Block();
            homePageSteps.open_Approve_a_Request_Page();
            requestsToApprovePageSteps.search_Request_By_ID(expectedID);
            requestsToApprovePageSteps.check_Search_Results(expectedID);
            requestsToApprovePageSteps.open_Request_Details_Page();
            approveRequestDetailsPageSteps.approve_Request();
        }
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.logout();
        // Admin part of the test case
        adminLoginPageSteps.open_Page();
        adminLoginPageSteps.enter_Credentials(adminLogin,adminPassword);
        adminLoginPageSteps.click_Login_Btn();
        dashboardPageSteps.check_That_Admin_Logged_In();
        dashboardPageSteps.click_Show_Menu_Button();
        dashboardPageSteps.expand_System_Menu_Block();
        dashboardPageSteps.open_REQ_Method_Report_Page();
        reqMethodReportPageSteps.findRequest("REQ");
        reqMethodReportPageSteps.findRequest(expectedID);
        reqMethodReportPageSteps.clickShowDataLink(expectedID);
        reqMethodReportPageSteps.displayData();
        Serenity.takeScreenshot();
        dashboardPageSteps.logout_From_Admin();

    }

    @Issue("AUT-59")
    @Test
    public void unit_price_of_item_more_than_5000_Req_total_does_not_matter () throws InterruptedException {
        if (homePageSteps.search_Product_By_SKU("G9683B") == true) {
            shopBySupplierPageSteps.add_Product_To_Cart();
        } else {
            homePageSteps.click_Main_Menu_Btn();
            homePageSteps.expand_Product_And_Services_Tab();
            homePageSteps.click_Shop_By_Supplier_Link();
            shopBySupplierPageSteps.find_supplier_with_products_that_have_price_higher_than("6000");
            shopBySupplierPageSteps.add_Product_To_Cart();
        }
        homePageSteps.open_Shopping_Cart();
        shoppingCartPageSteps.check_Is_Product_In_The_Cart();
        shoppingCartPageSteps.click_Proceed_To_Checkout_Button();
        checkoutPageSteps.enter_Order_Title("Robot test order");
        checkoutPageSteps.enter_Reason_To_Buy("Test reason to buy");
        checkoutPageSteps.continue_To_Shipping_And_Accounting();
        checkoutPageSteps.wait_Till_Shipping_Step_Is_Uploaded();
        checkoutPageSteps.click_Accounting_Edit_Link();
        checkoutPageSteps.enter_Accounting_Project("1095250");
        checkoutPageSteps.enter_Accounting_Task("205");
        checkoutPageSteps.enter_Accounting_Award("AABPU");
        checkoutPageSteps.enter_Accounting_Expenditure("55010");
        checkoutPageSteps.save_Accounting_Changes();
        checkoutPageSteps.select_Needed_By_Day();
        checkoutPageSteps.continue_To_Approval_Chain();
        checkoutPageSteps.wait_Till_Approval_Chain_Step_Is_Uploaded();
        List<String> approversNames = checkoutPageSteps.get_Approvers_Names();
        int approversQty = approversNames.size();
        System.out.println("Approvers qty: "+approversQty);
        checkoutPageSteps.continue_To_Review();
        checkoutPageSteps.wait_Till_Review_Step_Is_Uploaded();
        checkoutPageSteps.submit_Order();
        checkoutPageSteps.wait_Till_Success_Page_Is_Uploaded();
        String expectedID = checkoutPageSteps.get_Request_ID();
        for (int i=0; i<approversQty; i++){
            homePageSteps.click_Main_Menu_Btn();
            homePageSteps.expand_Select_Different_User_Block();
            homePageSteps.select_Different_User(approversNames.get(i));
            homePageSteps.click_Main_Menu_Btn();
            homePageSteps.check_Acting_User(approversNames.get(i));
            homePageSteps.expand_My_Documents_Tab();
            homePageSteps.expand_Approvals_Block();
            homePageSteps.open_Approve_a_Request_Page();
            requestsToApprovePageSteps.search_Request_By_ID(expectedID);
            requestsToApprovePageSteps.check_Search_Results(expectedID);
            requestsToApprovePageSteps.open_Request_Details_Page();
            approveRequestDetailsPageSteps.approve_Request();
        }
        homePageSteps.click_Main_Menu_Btn();
        homePageSteps.logout();
        // Admin part of the test case
        adminLoginPageSteps.open_Page();
        adminLoginPageSteps.enter_Credentials(adminLogin,adminPassword);
        adminLoginPageSteps.click_Login_Btn();
        dashboardPageSteps.check_That_Admin_Logged_In();
        dashboardPageSteps.click_Show_Menu_Button();
        dashboardPageSteps.expand_System_Menu_Block();
        dashboardPageSteps.open_REQ_Method_Report_Page();
        reqMethodReportPageSteps.findRequest("REQ");
        reqMethodReportPageSteps.findRequest(expectedID);
        reqMethodReportPageSteps.clickShowDataLink(expectedID);
        reqMethodReportPageSteps.displayData();
        Serenity.takeScreenshot();
        dashboardPageSteps.logout_From_Admin();

    }
}
