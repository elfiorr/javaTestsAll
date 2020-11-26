package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.settlementsPages.statusPages;

import automatedTestsProject.main.core.commonPages.LoadersPage;
import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalesStatusListPage extends AbstractPage {

    @FindBy(xpath = "//tbody/tr[@class='summaryRow']")
    private WebElement summaryRow;

    public SalesStatusListPage(WebDriver driver) {
        super(driver);

        new LoadersPage(driver).waitToListSpinnerLoaderDisappear();
    }

    public boolean isSummaryRowIsDisplayed() {
        return summaryRow.isDisplayed();
    }
}
