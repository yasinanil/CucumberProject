package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavascriptUtils {

    // Utility class for executing JavaScript commands in Selenium WebDriver

    // Clicks on the specified web element using JavaScript
    public static void clickElementByJS(WebElement element) {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].click();", element);
    }

    // Clicks on the specified web element using JavaScript after the element is clickable
    public static void waitAndClick(WebElement element, int durationOfSec) {
        Wait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(durationOfSec));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        clickElementByJS(element);
    }

    // Retrieves the current page title using JavaScript
    public static String getTitleByJS() {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        return jsexecutor.executeScript("return document.title;").toString();
    }

    // Scrolls down to the bottom of the page using JavaScript
    public static void scrollDownByJS() {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    // Scrolls all the way up to the top of the page using JavaScript
    public static void scrollAllUpByJS() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    // Scrolls the specified element into view using JavaScript
    public static void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) Driver.getDriver();
        jsexecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    // Changes the background color of the specified element using JavaScript
    public static void changeBackgroundColorByJS(WebElement element, String color) {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) Driver.getDriver());
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
    }

    public static void hardWait(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Flash
    public static void flash(WebElement element, String color) {

        String backgroundcolor = element.getCssValue("backgroundcolor");

        for (int i = 0; i < 5; i++) {

            changeBackgroundColorByJS(element, color);
            hardWait(100);
            changeBackgroundColorByJS(element, backgroundcolor);
            hardWait(100);

        }

    }


    // Generates a JavaScript alert with the specified message
    public static void generateAlert(String message) throws InterruptedException {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) Driver.getDriver());
        javascriptExecutor.executeScript("alert('" + message + "')");
        Thread.sleep(3000); // Pause to allow the alert to be seen
    }

    // Executes a given JavaScript command on the specified web element
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command, element);
    }

    // Executes a given JavaScript command globally (not on a specific element)
    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command);
    }

    // Sets the value of the specified input element using JavaScript
    public static void setValueByJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    // Retrieves the value of an input element by its ID using JavaScript
    public static void getValueByJS(WebDriver driver, String idOfElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String value = js.executeScript("return document.getElementById('" + idOfElement + "').value").toString();
        System.out.println(value);
    }

    // Adds a CSS border to the specified element using JavaScript
    public static void addBorderWithJS(WebElement element, String borderStyle) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].style.border='" + borderStyle + "'", element);
    }

    // Retrieves the value of the specified element using JavaScript
    public static Object getElementValueJS(WebElement element) {
        return ((JavascriptExecutor) Driver.getDriver()).executeScript("return arguments[0].value", element);
    }
}
