package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    @Before("@Login")
    public void setUp(Scenario scenario) {
        System.out.println(scenario.getName()+" scenario starts.");
    }

    @After
    public void tearDown(Scenario scenario){
        // Check if the scenario has failed
        if (scenario.isFailed()) {
            // Log the scenario failure
            System.out.println("Scenario failed: " + scenario.getName());

            // Capture a screenshot of the failed scenario
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            // Attach the screenshot to the report
            scenario.attach(screenshot, "image/png", "Screenshot of the failed scenario");

            // Log the attachment action
            System.out.println("Screenshot attached for the failed scenario: " + scenario.getName());

            // The screenshot will be viewable in the report by clicking on the attached image.

            Driver.closeDriver();


        }

    }

}
