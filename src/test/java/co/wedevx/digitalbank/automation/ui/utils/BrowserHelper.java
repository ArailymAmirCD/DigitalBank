package co.wedevx.digitalbank.automation.ui.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * WebDriver Helper Extensions is designed to simplify Java based Selenium/WebDriver tests.
 * It’s built on top of Selenium/WebDriver to make your tests more readable, reusable and
 * maintainable by providing easy handling towards browser and advance identifiers.
 */
public class BrowserHelper {

    //wait until the element is visible
    public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element, int timeToWaitInSec) {

        WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //wait until the element is clickable and click on it
    public static WebElement waitUntilElementClickableAndClick(WebDriver driver, WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        clickableElement.click();

        return clickableElement;
    }


    //scroll to view
    public static void scrollIntoView(WebDriver driver, WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.out.println("Unable to scroll element into view: " + e.getMessage());
        }
    }


    // click element with specified text
    public static void clickElementWithText(WebDriver driver, String text, int timeToWaitInSec) {
        try {
            By elementLocator = By.xpath("//*[contains(text(), '" + text + "')]");
            WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            element.click();
        } catch (Exception e) {
            // handle exceptions gracefully and provide clear error messages
            e.printStackTrace();
        }
    }


    // fill text input element after scrolling into view and checking interactability
    public static void fillTextInput(WebDriver driver, WebElement textInput, String value) {
        try {
            // Scroll to the text input element to ensure it is in view
            scrollIntoView(driver, textInput);

            // Check if the text input element is interactable (visible and enabled)
            if (textInput.isDisplayed() && textInput.isEnabled()) {
                // Clear any existing value
                textInput.clear();

                // Fill the input with the provided value
                textInput.sendKeys(value);
            } else {
                // Provide appropriate error messages or handling for scenarios where the element is not interactable
                System.out.println("Text input element is not interactable.");
            }
        } catch (Exception e) {
            // Handle exceptions gracefully and provide clear error messages
            e.printStackTrace();
        }
    }


}
