package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.affiliationPages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PartnerHistoryFiltersPage extends AbstractPage {

    @FindBy(id = "dp_partner_history_filter_datetime_start")
    private WebElement dateTimeStartInput;

    @FindBy(id = "dp_partner_history_filter_datetime_end")
    private WebElement dateTimeEndInput;

    @FindBy(id = "s2id_partner_history_filter_datetime_period")
    private WebElement periodSelect;

    @FindBy(id = "s2id_partner_history_filter_partner")
    private WebElement partnerInput;

    @FindBy(id = "s2id_partner_history_filter_executor")
    private WebElement executorInput;

    @FindBy(id = "s2id_partner_history_filter_eventName")
    private WebElement eventNameInput;

    @FindBy(id = "partner_history_filter_show")
    private WebElement submitButton;

    @FindBy(id = "partner_history_filter_clearSession")
    private WebElement clearButton;

    @FindBy(id = "partner_history_filter_csvExport")
    private WebElement exportCsvButton;

    public PartnerHistoryFiltersPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDateTimeStartInputDisplayed() {

        return dateTimeStartInput.isDisplayed();
    }

    public boolean isDateTimeEndInputDisplayed() {

        return dateTimeEndInput.isDisplayed();
    }

    public boolean isPeriodSelectDisplayed() {

        return periodSelect.isDisplayed();
    }

    public boolean isPartnerInputDisplayed() {

        return partnerInput.isDisplayed();
    }

    public boolean isExecutorInputDisplayed() {

        return executorInput.isDisplayed();
    }

    public boolean isEventNameInputDisplayed() {

        return eventNameInput.isDisplayed();
    }

    public boolean isSubmitButtonDisplayed() {

        return submitButton.isDisplayed();
    }

    public boolean isClearButtonDisplayed() {

        return clearButton.isDisplayed();
    }

    public boolean isExportCsvDisplayed() {

        return exportCsvButton.isDisplayed();
    }
}
