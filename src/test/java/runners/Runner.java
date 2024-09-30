package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to the feature files
        glue = "stepdefinitions",                  // Path to the step definitions package
        tags = "@SmokeTest",                       // Tags to specify which scenarios to run
        dryRun = false                             // Set to true to verify if all steps are defined
)
public class Runner {
    // No additional code is required in the runner class
}
