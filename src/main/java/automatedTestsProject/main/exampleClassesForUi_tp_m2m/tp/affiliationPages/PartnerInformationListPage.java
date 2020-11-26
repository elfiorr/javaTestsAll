package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.affiliationPages;

import automatedTestsProject.main.core.commonPages.LoadersPage;
import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PartnerInformationListPage extends AbstractPage {

    private LoadersPage loadersPage;

    @FindAll(@FindBy(xpath = "//table[@id='dtVerticalScrollExample']/tbody/tr"))
    private List<WebElement> partnerListTable;

    @FindAll(@FindBy(xpath = "//table[@id='dtVerticalScrollExample']/thead/tr/th"))
    private List<WebElement> tableHeaderFields;

    @FindBy(xpath = "//th[@data-sort-column='id']")
    private WebElement idDataSortColumn;

    @FindBy(xpath = "//th[@data-sort-column='name']")
    private WebElement partnerNameDataSortColumn;

    @FindBy(xpath = "//th[@data-sort-column='login']")
    private WebElement loginDataSortColumn;

    @FindBy(xpath = "//th[@data-sort-column='specialization']")
    private WebElement specializationDataSortColumn;

    @FindBy(xpath = "//th[@data-sort-column='email']")
    private WebElement emailDataSortColumn;

    @FindBy(xpath = "//th[@data-sort-column='phoneNumber']")
    private WebElement phoneNumberDataSortColumn;

    @FindBy(xpath = "//th[@data-sort-column='pesel']")
    private WebElement peselDataSortColumn;

    @FindBy(xpath = "//th[@data-sort-column='nip']")
    private WebElement nipDataSortColumn;

    @FindBy(xpath = "//th[@data-sort-column='registrationNumber']")
    private WebElement registrationNumberDataSortColumn;

    @FindBy(xpath = "//th[@data-sort-column='created']")
    private WebElement createdDataSortColumn;

    @FindBy(xpath = "//th[@data-sort-column='isActive']")
    private WebElement isActiveDataSortColumn;

    @FindBy(xpath = "//th[@data-sort-column='autoSignIn']")
    private WebElement autoSigmInDataSortColumn;

    @FindAll(@FindBy(xpath = "//table[@id='dtVerticalScrollExample']/tbody/tr/td[2]/a"))
    private List<WebElement> elementOfListByPartnerInformationField;

    @FindBy(xpath = "//table[@id='dtVerticalScrollExample']/tbody/tr/td[1]")
    private WebElement partnerIdResultField;

    @FindBy(xpath = "//table[@id='dtVerticalScrollExample']/tbody/tr/td[2]")
    private WebElement partnerNameResultField;

    @FindBy(xpath = "//table[@id='dtVerticalScrollExample']/tbody/tr/td[5]")
    private WebElement emailResultField;

    @FindBy(xpath = "//table[@id='dtVerticalScrollExample']/tbody/tr/td[6]")
    private WebElement phoneNumberResultField;

    @FindBy(xpath = "//table[@id='dtVerticalScrollExample']/tbody/tr/td[8]")
    private WebElement nipResultField;

    @FindBy(xpath = "//table[@id='dtVerticalScrollExample']/tbody/tr/td[7]")
    private WebElement peselResultField;

    @FindBy(xpath = "//table[@id='dtVerticalScrollExample']/tbody/tr/td[9]")
    private WebElement registrationNumberResultField;

    public PartnerInformationListPage(WebDriver driver) {
        super(driver);

        this.loadersPage = new LoadersPage(driver);
        loadersPage.waitToListSpinnerAffiliationLoaderDisappear();
    }

    public void selectSpecifiedElementOfList(int numberOfPartner) {

        elementOfListByPartnerInformationField.get(numberOfPartner).click();
    }

    public boolean isIdColumnDisplayed() {

        return idDataSortColumn.isDisplayed();
    }

    public boolean isPartnerNameColumnDisplayed() {

        return partnerNameDataSortColumn.isDisplayed();
    }

    public boolean isLoginColumnDisplayed() {

        return loginDataSortColumn.isDisplayed();
    }

    public boolean isSpecializationColumnDisplayed() {

        return specializationDataSortColumn.isDisplayed();
    }

    public boolean isEmailColumnDisplayed() {

        return emailDataSortColumn.isDisplayed();
    }

    public boolean isPhoneNumberColumnDisplayed() {

        return phoneNumberDataSortColumn.isDisplayed();
    }

    public boolean isPeselColumnDisplayed() {

        return peselDataSortColumn.isDisplayed();
    }

    public boolean isNipColumnDisplayed() {

        return nipDataSortColumn.isDisplayed();
    }

    public boolean isRegistrationNumberColumnDisplayed() {

        return registrationNumberDataSortColumn.isDisplayed();
    }

    public boolean isCreatedColumnDisplayed() {

        return createdDataSortColumn.isDisplayed();
    }

    public boolean isIsActiveColumnDisplayed() {

        return isActiveDataSortColumn.isDisplayed();
    }

    public boolean isAutoSignInColumnDisplayed() {

        return autoSigmInDataSortColumn.isDisplayed();
    }

    public int sizeOfPartnerList() {

        return partnerListTable.size();
    }

//    public String getTextFrom(ListOfInputs inputs) {
//
//        switch (inputs) {
//            case ID:
//                return getTextFromElement(partnerIdResultField);
//
//            case PARTNER:
//                return getTextFromElement(partnerNameResultField);
//
//            case EMAIL:
//                return getTextFromElement(emailResultField);
//
//            case PHONE_NUMBER:
//                return getTextFromElement(phoneNumberResultField);
//
//            case PESEL:
//                return getTextFromElement(peselResultField);
//
//            case NIP:
//                return getTextFromElement(nipResultField);
//
//            case REGISTRATION_NUMBER:
//                return getTextFromElement(registrationNumberResultField);
//
//            default:
//                throw new InvalidParameterException("Given string is not available in specific list");
//        }
//    }
}
