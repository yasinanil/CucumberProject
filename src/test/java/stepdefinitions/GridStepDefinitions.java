package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.SignInPage;
import utilities.Driver;

public class GridStepDefinitions {
    SignInPage signInPage = new SignInPage();

    @Given("go to {string} via remote driver")
    public void go_to_via_remote_driver(String url) {
        Driver.getRemoteDriver().get(url);
    }

    @When("the user enters username {string} password {string} via remote driver")
    public void the_user_enters_username_password_via_remote_driver(String username, String password) {
        signInPage.username.sendKeys(username);
        signInPage.password.sendKeys(password);
    }

    @When("the user clicks on submit button via remote driver")
    public void the_user_clicks_on_submit_button_via_remote_driver() {
        signInPage.submitButton.click();
    }

}
