package automatedTestsProject.main.core.commonPages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AlertsPage extends AbstractPage {

    @FindAll(@FindBy(xpath = "//div[contains(@class, 'alert-success')]"))
    private List<WebElement> alertSuccess;

    @FindAll(@FindBy(xpath = "//div[contains(@class, 'alert-danger')]"))
    private List<WebElement> alertDanger;

    public AlertsPage(WebDriver driver) {

        super(driver);
    }

    public boolean isSuccessAlertDisplayed(){

        return !(alertSuccess.isEmpty());
    }

    public boolean isDangerAlertDisplayed(){

        return !(alertDanger.isEmpty());
    }
}
