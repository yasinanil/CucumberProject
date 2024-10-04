package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.CLContactsPage;
import pages.CLHomePage;
import pages.ToDoListPage;
import pages.WebTablePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Map;

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
        clHomePage = new CLHomePage();
        clHomePage.submit.click();

    }

    @Then("the user should be redirected to the contact list")
    public void the_user_should_be_redirected_to_the_contact_list() {

        clContactsPage = new CLContactsPage();
        assert clContactsPage.logout.isDisplayed();
    }


    @When("the user enters invalid credentials")
    public void theUserEntersInvalidCredentials() {
        clHomePage = new CLHomePage();

        clHomePage.email.sendKeys("invalideusername");
        clHomePage.password.sendKeys(ConfigReader.getProperty("password"));
    }


    @Then("the user sees the error message")
    public void theUserSeesTheErrorMessage() throws InterruptedException {
        clHomePage = new CLHomePage();
        Thread.sleep(500);
        assert clHomePage.error.isDisplayed();
    }

    @When("the user enters username {string} password {string}")
    public void theUserEntersUsernamePassword(String username, String password) {
        clHomePage = new CLHomePage();

        clHomePage.email.sendKeys(username);
        clHomePage.password.sendKeys(password);

    }






}
