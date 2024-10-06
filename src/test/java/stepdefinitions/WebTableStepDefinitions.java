package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import pages.WebTablePage;
import utilities.Driver;
import utilities.ExcelUtils;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertEquals;

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

    @When("user enters name, age and country using excel and assert it")
    public void userEntersNameAgeAndCountryUsingExcelAndAssertIt() {

        ExcelUtils excelUtils = new ExcelUtils("Users.xlsx", "Employees");

        Object[][] data = excelUtils.getExcelData();
        System.out.println("data = " + Arrays.deepToString(data));
        WebTablePage webTablePage = new WebTablePage();

        for (Object[] w : data) {

            String name = w[0].toString();
            String age = w[1].toString();
            String country = w[2].toString();

            webTablePage.nameInput.sendKeys(name);
            webTablePage.ageInput.sendKeys(age.substring(0, age.indexOf(".")));
            new Select(webTablePage.countrySelect).selectByVisibleText(country);
            webTablePage.addRecord.click();

            assertEquals(name, webTablePage.lastRowName.getText());

        }
    }
}
