package co.wedevx.digitalbank.automation.ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BrowserHelper {

    public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));

    }
    //wait until the element is clickable and click on it
    public static WebElement waitUntilElementClickableAndClickOnIt(WebDriver driver, WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSec));
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        clickableElement.click();

        return clickableElement;
    }

    public static WebElement fluentWaitForElementPresence(WebDriver driver, WebElement element, int timeToWaitInSec){
              Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeToWaitInSec))
                .pollingEvery(Duration.ofMillis(500));

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void scrollIntoView (WebDriver driver , WebElement element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static WebElement clickElementWithText(WebDriver driver , String text){
        List<WebElement> elements = driver.findElements(By.xpath("//*[text()='" + text + "']"));

        if (elements.isEmpty()) {
            throw new RuntimeException("Element with text '" + text + "' not found.");
        } else if (elements.size() > 1) {
            throw new RuntimeException("Multiple elements with text '" + text + "' found. Unable to determine which one to click.");
        } else {
            WebElement element = elements.get(0);
            try {
                element.click();
                return element;
            } catch (Exception e) {
                throw new RuntimeException("Failed to click element with text '" + text + "'.", e);
            }
        }
    }

    public static void fillTextInput(WebDriver driver , WebElement element, String str){
        scrollIntoView(driver, element);
        if (element.isDisplayed() && element.isEnabled()) {
            element.clear();
            element.sendKeys(str);
        } else {
            throw new RuntimeException("Text input element is not interactable.");
        }
    }
}
