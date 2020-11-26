package automatedTestsProject.main.core.commonPages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoadersPage extends AbstractPage {

    @FindBy(xpath = "//i[contains(@class,'spinner')]")
    private List<WebElement> loadDataSiteSpinnerLoader;

    @FindBy(xpath = "//div[@id='report_table']//i[contains(@class,'fa-2x')]")
    private List<WebElement> listSpinnerLoaderAffiliation;

    public LoadersPage(WebDriver driver) {

        super(driver);
    }

    public void waitToListSpinnerLoaderDisappear() {
        waitToWebElementListDisappear(loadDataSiteSpinnerLoader);
    }

    public void waitToListSpinnerAffiliationLoaderDisappear(){
        waitToWebElementListDisappear(listSpinnerLoaderAffiliation);
    }
}
