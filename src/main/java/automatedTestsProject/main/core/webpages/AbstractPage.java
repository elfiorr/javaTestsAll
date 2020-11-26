package automatedTestsProject.main.core.webpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractPage {

    private WebDriver driver;
    private FluentWait wait;
    private static final Logger logger = Logger.getLogger(AbstractPage.class);

    public AbstractPage(
            WebDriver driverValue,
            int secTimeout
    ) {
        this.driver = driverValue;
        this.wait = new FluentWait<WebDriver>((WebDriver) driver)
                .withTimeout(Duration.ofSeconds(secTimeout))
                .pollingEvery(Duration.ofMillis(500))
                .withMessage("Waiting for element.")
                .ignoring(WebDriverException.class)
                .ignoring(NoSuchElementException.class);

        PageFactory.initElements(driver, this);
    }

    protected FluentWait getWait() {

        return wait;
    }

    protected void click(
            WebElement element
    ) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void sendKeys(
            WebElement element,
            String keys
    ) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(keys);
    }

    protected void sendKeys(
            WebElement element,
            Keys keys
    ) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(keys);
    }

    protected boolean waitToWebElementListDisappear(
            List<WebElement> webElementList
    ) {

        int counter = 0;

        while (counter < 301) {

            try {
                if (!webElementList.get(0).isDisplayed()) {
                    return true;
                }

            } catch (Exception e) {
                return true;
            }
            counter++;
        }
        throw new InvalidElementStateException("Element is still visible");
    }

    protected void waitToWebElementIsNotDisplayed(
            WebElement webElement
    ) {
        while (webElement.isDisplayed()) {

            waitToWebElementIsNotDisplayed(webElement);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    protected boolean isVisible(
            WebElement webElement
    ) {
        boolean isVisible = false;

        try {
            isVisible = webElement.isDisplayed();
        } catch (NoSuchElementException ex) {
            logger.info("Element not found.");
        }
        return isVisible;
    }

    protected void moveToElementAndClick(
            WebElement elementToMove,
            WebElement elementToCLick
    ) {
        wait.until(ExpectedConditions.visibilityOf(elementToMove));
        Actions builder = new Actions(driver);
        builder.moveToElement(elementToMove)
                .perform();
        wait.until(ExpectedConditions.visibilityOf(elementToCLick));
        builder.click(elementToCLick)
                .perform();
    }

    protected String getTextFromElement(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
}
