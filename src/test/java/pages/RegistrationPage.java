package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistrationPage {

    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ssn")
    public WebElement ssn;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "male")
    public WebElement male;

    @FindBy(id = "female")
    public WebElement female;

    @FindBy(id = "other")
    public WebElement other;

    @FindBy(id = "job")
    public WebElement job;

    @FindBy(id = "cv")
    public WebElement cv;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//*[.='Register']")
    public WebElement register;








}
