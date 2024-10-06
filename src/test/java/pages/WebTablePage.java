package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebTablePage {

    public WebTablePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "nameInput")
    public WebElement nameInput;

    @FindBy(id = "ageInput")
    public WebElement ageInput;

    @FindBy(id = "countrySelect")
    public WebElement countrySelect;

    @FindBy(xpath = "//*[.='Add Record']")
    public WebElement addRecord;

    @FindBy(xpath = "(//tbody/tr/td[1])[last()]")
    public WebElement lastRowName;




}
