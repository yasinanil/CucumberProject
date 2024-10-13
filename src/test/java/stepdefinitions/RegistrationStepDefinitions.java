package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import pages.RegistrationPage;
import utilities.Driver;
import utilities.JavascriptUtils;

import static org.junit.Assert.assertEquals;

public class RegistrationStepDefinitions {

    RegistrationPage registrationPage = new RegistrationPage();

    @When("enter the ssn {string}")
    public void enter_the_ssn(String ssn) {
        registrationPage.ssn.sendKeys(ssn);
    }

    @When("enter the firstname {string} and lastname {string}")
    public void enter_the_firstname_and_lastname(String firstname, String lastname) {
        registrationPage.firstName.sendKeys(firstname);
        registrationPage.lastName.sendKeys(lastname);
    }

    @When("enter the gender {string} and job {string}")
    public void enter_the_gender_and_job(String gender, String job) {
        if (gender.equalsIgnoreCase("male")) {
            JavascriptUtils.clickElementByJS(registrationPage.male);
        } else if (gender.equalsIgnoreCase("female")) {
            JavascriptUtils.clickElementByJS(registrationPage.female);
        } else {
            JavascriptUtils.clickElementByJS(registrationPage.other);
        }

        new Select(registrationPage.job).selectByVisibleText(job);

    }

    @When("upload the CV")
    public void upload_the_cv() {
        registrationPage.cv.sendKeys(System.getProperty("user.dir")+"/CV.pdf");
    }

    @When("enter the username {string}, email {string} and password {string}")
    public void enter_the_username_email_and_password(String username, String email, String password) {
        registrationPage.username.sendKeys(username);
        registrationPage.email.sendKeys(email);
        registrationPage.password.sendKeys(password);
    }

    @When("click on register")
    public void click_on_register() {
        registrationPage.register.click();
    }

    @Then("validate registration message")
    public void validate_registration_message() {
        assertEquals("Form submitted!", Driver.getDriver().switchTo().alert().getText());
    }


    @Then("validate registration message did not appear")
    public void validateRegistrationMessageDidNotAppear() {
        try {
            Driver.getDriver().switchTo().alert();
            throw new Exception("Invalid SSN Accepted");
        } catch (Exception e) {
          assert  e.getMessage().contains("no such alert");
        }
    }
}
