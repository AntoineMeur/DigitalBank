package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.pages.RegistrationPage;
import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationSteps {

    RegistrationPage registrationPage = new RegistrationPage(getDriver());

    @Given("User navigates to Digital Bank signup page")
    public void user_navigates_to_digital_bank_signup_page() {
        getDriver().get(ConfigReader.getPropertiesValue("digitalbank-signupUrl"));

    }
    @When("user create account with following fields and with mocked email and ssn")
    public void user_create_account_with_following_fields_and_with_mocked_email_and_ssn(List<Map<String, String>> registrationTestDataMap) {
       registrationPage.fillOutRegistrationForm(registrationTestDataMap);
    }
    @Then("the user should be displayed {string}")
    public void the_user_should_be_displayed(String expectedSuccessMessage) {
        assertEquals(expectedSuccessMessage, registrationPage.getMessage(), "success message mismatch");
    }
    @Then("the user should see {string} required field error message {string}")
    public void the_user_should_see_required_field_error_message(String fieldName, String expectedErrorMessage) {
       String actualErrorMessage = registrationPage.getRequiredFieldErrorMessage(fieldName);
       assertEquals(expectedErrorMessage, actualErrorMessage, "error message mismatch");
    }
}
