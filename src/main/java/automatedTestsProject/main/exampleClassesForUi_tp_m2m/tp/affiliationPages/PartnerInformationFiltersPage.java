package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.affiliationPages;

import automatedTestsProject.main.core.commonPages.LoadersPage;
import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PartnerInformationFiltersPage extends AbstractPage {

    private LoadersPage loadersPage;

    @FindBy(id = "partner_information_filter_email")
    private WebElement emailInput;

    @FindBy(id = "partner_information_filter_phoneNumber")
    private WebElement phoneInput;

    @FindBy(id = "partner_information_filter_nip")
    private WebElement nipInput;

    @FindBy(id = "s2id_partner_information_filter_source")
    private WebElement sourceSelect;

    @FindBy(xpath = "//input[@id='s2id_autogen5']")
    private WebElement sourceSelectInput;

    @FindBy(id = "partner_information_filter_pesel")
    private WebElement peselInput;

    @FindBy(id = "s2id_partner_information_filter_specialization")
    private WebElement specializationSelect;

    @FindBy(id = "partner_information_filter_created_end")
    private WebElement dateFromInput;

    @FindBy(id = "s2id_partner_information_filter_created_period")
    private WebElement dateToInput;

    @FindBy(id = "s2id_partner_information_filter_created_period")
    private WebElement periodSelect;

    @FindBy(id = "s2id_partner_information_filter_recommendedBy")
    private WebElement registerFromRecommendationInput;

    @FindBy(id = "s2id_partner_information_filter_status")
    private WebElement statusMulti;

    @FindBy(id = "s2id_partner_information_filter_partner")
    private WebElement partnerSelect;

    @FindBy(xpath = "//input[@id='s2id_autogen4']")
    private WebElement partnerSelectInput;

    @FindBy(xpath = "//div[@id='select2-drop']/ul/li[1]")
    private WebElement selectFoundElement;

    @FindAll(@FindBy(className = "select2-searching"))
    private List<WebElement> selectInputLoader;

    @FindBy(id = "partner_information_filter_clearSession")
    private WebElement clearButton;

    @FindBy(id = "partner_information_filter_show")
    private WebElement submitButton;

    public PartnerInformationFiltersPage(WebDriver driver) {
        super(driver);

        this.loadersPage = new LoadersPage(driver);
        loadersPage.waitToListSpinnerLoaderDisappear();
    }

    public boolean isPartnerInputDisplayed() {

        return partnerSelect.isDisplayed();
    }

    public boolean isEmailInputDisplayed() {

        return emailInput.isDisplayed();
    }

    public boolean isPhoneNumberInputDisplayed() {

        return phoneInput.isDisplayed();
    }

    public boolean isPeselInputDisplayed() {

        return peselInput.isDisplayed();
    }

    public boolean isNipInputDisplayed() {

        return nipInput.isDisplayed();
    }

    public boolean isSourceInputDisplayed() {

        return sourceSelect.isDisplayed();
    }

    public boolean isSpecializationSelectDisplayed() {

        return specializationSelect.isDisplayed();
    }

    public boolean isDateFromInputDisplayed() {

        return dateFromInput.isDisplayed();
    }

    public boolean isDateToInputDisplayed() {

        return dateToInput.isDisplayed();
    }

    public boolean isPeriodSelectDisplayed() {

        return periodSelect.isDisplayed();
    }

    public boolean isRegisterFromRecommendationInputDisplayed() {

        return registerFromRecommendationInput.isDisplayed();
    }

    public boolean isStatusMultiSelectDisplayed() {

        return statusMulti.isDisplayed();
    }

    public boolean isClearButtonDisplayed() {

        return clearButton.isDisplayed();
    }

    public boolean isSubmitButtonDisplayed() {

        return submitButton.isDisplayed();
    }
//
//    public void submitSearchForm(ShowFormButtonsTypes buttonType) {
//
//        switch (buttonType) {
//            case SHOW:
//                click(submitButton);
//                break;
//
//            case CLEAR:
//                click(clearButton);
//                break;
//
//            default:
//                throw new IllegalArgumentException("Given button is not available in specific form");
//        }
//    }

    private void selectPartner(String value) {
        click(partnerSelect);

        sendKeys(partnerSelectInput, value);

        waitToWebElementListDisappear(selectInputLoader);

        click(selectFoundElement);
    }

    private void selectSource(String value) {
        click(sourceSelect);

        sendKeys(sourceSelectInput, value);

        waitToWebElementListDisappear(selectInputLoader);

        click(selectFoundElement);
    }

//    public void setInput(ListOfInputs inputs, String value) {
//
//        switch (inputs) {
//
//            case PARTNER:
//                selectPartner(value);
//                break;
//
//            case EMAIL:
//                sendKeys(emailInput, value);
//                break;
//
//            case PHONE_NUMBER:
//                sendKeys(phoneInput, value);
//                break;
//
//            case PESEL:
//                sendKeys(peselInput, value);
//                break;
//
//            case NIP:
//                sendKeys(nipInput, value);
//                break;
//
//            case SOURCE:
//                selectSource(value);
//                break;
//        }
//    }
}
