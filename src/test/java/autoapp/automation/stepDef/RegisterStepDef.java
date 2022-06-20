package autoapp.automation.stepDef;

import autoapp.automation.pages.PersonalInfoPage;
import autoapp.automation.pages.RegisterPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterStepDef {

    @Given("^Automation practice application is opened$")
    public void automation_practice_application_is_opened() {
        RegisterPage.openApplicaiton();
    }

    @When("^I click sign in$")
    public void i_click_sign_in() throws Exception {
        try {
            RegisterPage.clickSignIn();
        } catch (Exception e) {
            throw new Exception("Could not click 'sign in'");
        }
    }

    @And("^I create account with emailid \"([^\"]*)\"$")
    public void i_create_account_with_emailid(String emailId) throws Exception {
        try {
            RegisterPage.createAccount(emailId);
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new Exception("Could not sign up");
        }
    }


    @Then("^I should be able to register with my below details$")
    public void i_should_be_able_to_register_with_my_below_details(DataTable dataTable) throws Exception {
        try {
        PersonalInfoPage.enterPersonalInformation(dataTable);
        Thread.sleep(5000);
        } catch (Exception e) {
            throw new Exception("Could not register account");
        }
    }

    @When("^I click Summer Dresses$")
    public void iClickSummerDresses() throws Exception {
        try {
            RegisterPage.clickSummerDresses();
        } catch (Exception e) {
            throw new Exception("Could not Click Summer Dresses");
        }
    }

    @Then("^I am on the correct page$")
    public void correctPage() throws Exception {
        try {
            RegisterPage.checkSDHeading();
        } catch (Exception e) {
            throw new Exception("I am not on the correct page");
        }
    }

    @And("^I click the first Dress$")
    public void iClickTheFirstDress() throws Exception {
        try {
            RegisterPage.clickFirstDress();
            Thread.sleep(7000);
        } catch (Exception e) {
            throw new Exception("Couldn't click the first dress");
        }
    }

    @Then("^I am on the Printed Summer Dress Page$")
    public void iAmOnThePrintedSummerDressPage() throws Exception {
        try {
            RegisterPage.checkPSDHeading();
        } catch (Exception e) {
            throw new Exception("Not on the correct page");
        }
    }

    @When("^I click the blue colour$")
    public void iClickTheBlueColour() throws Exception {
        try {
            RegisterPage.clickBlue();
        } catch (Exception e) {
            throw new Exception("Couldn't click blue");
        }
    }

    @And("^I add to cart$")
    public void iAddToCart() throws Exception {
        try {
            RegisterPage.clickAddToCart();
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new Exception("Couldn't add to cart");
        }
    }

    @Then("^The correct details are on the summary page$")
    public void theCorrectDetailsAreOnTheSummaryPage() throws Exception {
        try {
            RegisterPage.checkDressDetails();
        } catch (Exception e) {
            throw new Exception("The dress details are different");
        }
    }
}
