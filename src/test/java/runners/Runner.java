package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/reports/html-report.html",
                "json:target/reports/json-report.json",
                "junit:target/reports/xml-report.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "pretty",
                "rerun:target/failedScenarios.txt"
        },
        features = "src/test/resources/features", // Path to the feature files
        glue = {"stepdefinitions","hooks"},                 // Path to the step definitions package
        tags = "@Practice05",                       // Tags to specify which scenarios to run
        dryRun = false                             // Set to true to verify if all steps are defined
)
public class Runner {
    // No additional code is required in the runner class
}