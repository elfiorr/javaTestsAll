package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.settlementsPages.prepaymentsPages;

import automatedTestsProject.main.core.commonPages.LoadersPage;
import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PrepaymentsFiltersPage extends AbstractPage {

    @FindBy(id = "select2-chosen-1")
    private WebElement prepaymentFormSaleTypeSelect;

    @FindBy(xpath = "//div[contains(@id, 'select2-result-label') and contains(.,'Sprzedaż')]")
    private WebElement saleTypeSelect;

    @FindBy(xpath = "//div[contains(@id, 'select2-result-label') and contains(.,'Leady')]")
    private WebElement leadTypeSelect;

    @FindBy(id = "prepayment_options_form_file")
    private WebElement csvFileFormButton;

    @FindBy(id = "s2id_prepayment_options_form_offerer")
    private WebElement prepaymentFormOffererTypeSelect;

    @FindBy(id = "s2id_autogen2_search")
    private WebElement offererTypeSelect;

    @FindBy(xpath = "//ul[contains(@id,'select2-result')]//li[1]")
    private WebElement offererTypeSelectResultSelect;

    @FindBy(xpath = "//div[contains(@class, 'select2-container-disabled')]")
    private List<WebElement> notEditablePrepaymentFormProductTypeSelect;

    @FindBy(id = "s2id_prepayment_options_form_product")
    private WebElement prepaymentFormProductTypeSelect;

    @FindBy(id = "s2id_autogen3_search")
    private WebElement productTypeSelect;

    @FindBy(xpath = "//ul[contains(@id,'select2-result')]//li[2]")
    private WebElement productTypeSelectResultSelect;

    @FindBy(id = "prepayment_options_form_date")
    private WebElement prepaymentFormDateInput;

    @FindBy(id = "prepayment_options_form_submit")
    private WebElement prepaymentSearchFormButton;

    public PrepaymentsFiltersPage(WebDriver driver) {
        super(driver);

        new LoadersPage(driver).waitToListSpinnerLoaderDisappear();
    }

    public void setPrepaymentFormSaleTypeSelect(
            PrepaymentTypes prepaymentTypes
    ) {
            click(prepaymentFormSaleTypeSelect);

            switch (prepaymentTypes) {

                case SPRZEDAZ:
                    click(saleTypeSelect);
                    break;

                case LEADY:
                    click(leadTypeSelect);
                    break;

                default:
                    throw new IllegalArgumentException("Given prepayment type is not exist");
            }
    }

    public void uploadCsvFile(String csvFileName) {

        sendKeys(csvFileFormButton, csvFileName);
    }

    public void setPrepaymentFormOffererSelect(String value) {

        click(prepaymentFormOffererTypeSelect);

        sendKeys(offererTypeSelect, value);

        click(offererTypeSelectResultSelect);
    }

    public void chooseFirstFromTheListPrepaymentFormProductSelect() {

        waitToWebElementListDisappear(notEditablePrepaymentFormProductTypeSelect);

        click(prepaymentFormProductTypeSelect);

        click(productTypeSelectResultSelect);
    }

    public void setPrepaymentFormDateInput(String value) {

        sendKeys(prepaymentFormDateInput, value);
    }

    public void submitSearchForm() {

        click(prepaymentSearchFormButton);
    }
}
