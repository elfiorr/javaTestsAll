package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.affiliationPages;

import automatedTestsProject.main.core.commonPages.LoadersPage;
import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PartnerHistoryListPage extends AbstractPage {

    private LoadersPage loadersPage;

    @FindBy(xpath = "//th[@data-sort-column='partnerName']")
    private WebElement partnerNameDateSortColumn;

    @FindBy(xpath = "//th[@data-sort-column='eventName']")
    private WebElement eventNameDateSortColumn;

    @FindBy(xpath = "//th[@data-sort-column='executor']")
    private WebElement executorDateSortColumn;

    @FindBy(xpath = "//th[@data-sort-column='datetime']")
    private WebElement datetimeDateSortColumn;

    @FindBy(xpath = "//th[@data-sort-column='ipAddress']")
    private WebElement ipAddressDateSortColumn;

    @FindBy(xpath = "//th[@data-sort-column='data']")
    private WebElement dataDateSortColumn;

    public PartnerHistoryListPage(WebDriver driver) {
        super(driver);

        this.loadersPage = new LoadersPage(driver);
        loadersPage.waitToListSpinnerAffiliationLoaderDisappear();
    }

    public boolean isPartnerNameColumnDisplayed() {

        return partnerNameDateSortColumn.isDisplayed();
    }

    public boolean isEventNameColumnDisplayed() {

        return eventNameDateSortColumn.isDisplayed();
    }

    public boolean isExecutorColumnDisplayed() {

        return executorDateSortColumn.isDisplayed();
    }

    public boolean isDateTimeColumnDisplayed() {

        return datetimeDateSortColumn.isDisplayed();
    }

    public boolean isIpAddressColumnDisplayed() {

        return ipAddressDateSortColumn.isDisplayed();
    }

    public boolean isDataColumnDisplayed() {

        return dataDateSortColumn.isDisplayed();
    }
}
