package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import pages.WebTablePage;

import java.util.Map;

public class WebTableStepDefinitions {
    @When("user enters name and age")
    public void user_enters_name_and_age(DataTable dataTable) {

        WebTablePage webTablePage = new WebTablePage();
        Map<String, String> nameAge = dataTable.asMap();

        for (Map.Entry<String, String> w : nameAge.entrySet()) {
            String name = w.getKey();
            String age = w.getValue();

            webTablePage.nameInput.sendKeys(name);
            webTablePage.ageInput.sendKeys(age);
            new Select(webTablePage.countrySelect).selectByIndex(1);
            webTablePage.addRecord.click();
        }


    }
}
