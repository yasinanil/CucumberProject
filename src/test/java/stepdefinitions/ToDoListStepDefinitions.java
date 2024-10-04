package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.ToDoListPage;

import java.util.List;

public class ToDoListStepDefinitions {


    @When("enter todos")
    public void enter_todos(DataTable dataTable) {

        ToDoListPage toDoListPage = new ToDoListPage();
        List<String> toDos = dataTable.asList();

        for (String w : toDos) {
            toDoListPage.addToDo.sendKeys(w + Keys.ENTER);
        }

    }

}
