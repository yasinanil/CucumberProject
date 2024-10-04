package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utilities.ConfigReader;
import utilities.Driver;

public class CommonStepDefinitions {

    @Given("go to {string}")
    public void go_to(String url) {
        Driver.getDriver().get(url);
    }

    @And("close the driver")
    public void closeTheDriver() {
        Driver.closeDriver();
    }


    @Given("set the browser type {string}")
    public void setTheBrowserType(String browserType) {

        ConfigReader.setProperty("browser", browserType);

    }
}
