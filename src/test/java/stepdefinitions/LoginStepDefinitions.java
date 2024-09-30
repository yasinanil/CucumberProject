package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CLContactsPage;
import pages.CLHomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginStepDefinitions {

    CLHomePage clHomePage;
    CLContactsPage clContactsPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("clHomePage"));
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {

        clHomePage = new CLHomePage();

        clHomePage.email.sendKeys(ConfigReader.getProperty("username"));
        clHomePage.password.sendKeys(ConfigReader.getProperty("password"));

    }

    @When("the user clicks on submit button")
    public void the_user_clicks_on_submit_button() {

        clHomePage.submit.click();

    }

    @Then("the user should be redirected to the contact list")
    public void the_user_should_be_redirected_to_the_contact_list() {

        clContactsPage = new CLContactsPage();
        assert clContactsPage.logout.isDisplayed();
    }

    @And("close the driver")
    public void closeTheDriver() {
        Driver.closeDriver();
    }
}
