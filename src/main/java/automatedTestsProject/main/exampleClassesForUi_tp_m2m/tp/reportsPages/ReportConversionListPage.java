package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.reportsPages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportConversionListPage extends AbstractPage {

    @FindBy(xpath = "//tr[@class='sonata-ba-list-field-header']//th[1]/a")
    private WebElement firstExistingColumn;

    public ReportConversionListPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFirstExistingColumnDisplayed(){

        return firstExistingColumn.isDisplayed();
    }
}
