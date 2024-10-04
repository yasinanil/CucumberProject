@DataTable @Parallel
Feature: Data Table

  @ToDoList
  Scenario: Data table as List
    Given go to "https://webdriveruniversity.com/To-Do-List/index.html"
    When enter todos
      | Prepare Breakfast        |
      | Wash the dishes          |
      | Take care of baby        |
      | Help your kid's homework |
      | Study Selenium           |
      | Sleep                    |
      | Get Up                   |
      | Go to Work               |

    Then close the driver


  @WebTableMap
  Scenario: Data table as Map
    Given go to "https://yasinanil67.github.io/addRecordWebTable"
    When user enters name and age
      | John   | 35 |
      | Mary   | 45 |
      | Tim    | 46 |
      | Tom    | 25 |
      | Hans   | 40 |
      | Stefen | 34 |
    Then close the driver