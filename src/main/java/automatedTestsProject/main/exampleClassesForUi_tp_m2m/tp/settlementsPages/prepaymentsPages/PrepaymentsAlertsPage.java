package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.settlementsPages.prepaymentsPages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrepaymentsAlertsPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
    private WebElement successAlert;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissable']")
    private WebElement dangerAlert;

    @FindBy(xpath = "//div[@class='alert alert-warning alert-dismissable']")
    private WebElement warningAlert;

    public PrepaymentsAlertsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSuccessAlertDisplayed() {

        return successAlert.isDisplayed();
    }

    public boolean isDangerAlertDisplayed() {

        return dangerAlert.isDisplayed();
    }

    public boolean isWarningAlertDisplayed() {

        return warningAlert.isDisplayed();
    }
}
