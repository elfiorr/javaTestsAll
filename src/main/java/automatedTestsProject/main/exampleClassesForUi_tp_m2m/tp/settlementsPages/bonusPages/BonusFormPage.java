package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.settlementsPages.bonusPages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BonusFormPage extends AbstractPage {

    @FindBy(id = "select2-chosen-2")
    private WebElement partnerSelect;

    @FindBy(xpath = "//div[@class='select2-search']//input[@id='s2id_autogen2_search']")
    private WebElement partnerSelectInput;

    @FindAll(@FindBy(className = "select2-searching"))
    private List<WebElement> partnerSelectInputLoader;

    @FindBy(id = "select2-chosen-1")
    private WebElement bonusTypeSelect;

    @FindBy(xpath = "//input[contains(@id, 'value')]")
    private WebElement bonusValueInput;

    @FindBy(xpath = "//textarea[contains(@id, 'description')]")
    private WebElement bonusDescriptionTextarea;

    @FindBy(xpath = "//input[contains(@id, 'grantDate')]")
    private WebElement bonusDatePicker;

    @FindBy(xpath = "//div[contains(@id, 'select2-result') and contains(.,'Reklamacja')]")
    private WebElement bonusTypeComplaintSelect;

    @FindBy(xpath = "//div[contains(@id, 'select2-result') and contains(.,'Konkurs')]")
    private WebElement bonusTypeContestSelect;

    @FindBy(xpath = "//div[contains(@id, 'select2-result') and contains(.,'Wyrównanie stawek')]")
    private WebElement bonusTypeRateAdjustmentSelect;

    @FindBy(xpath = "//div[contains(@id, 'select2-result') and contains(.,'Inne')]")
    private WebElement bonusTypeOthersSelect;

    public BonusFormPage(WebDriver driver) {

        super(driver);
    }

    public boolean isPartnerSelectDisplayed() {

        return partnerSelect.isDisplayed();
    }

    public boolean isBonusTypeSelectDisplayed() {

        return bonusTypeSelect.isDisplayed();
    }

    public boolean isBonusValueInputDisplayed() {

        return bonusValueInput.isDisplayed();
    }

    public boolean isBonusDescriptionTextareaDisplayed() {

        return bonusDescriptionTextarea.isDisplayed();
    }

    public boolean isBonusDatePickerDisplayed() {

        return bonusDatePicker.isDisplayed();
    }

    public void setPartnerSelect(
            String partner
    ) {

        if(!(partner.isEmpty())) {
            click(partnerSelect);

            sendKeys(partnerSelectInput, partner);

            waitToWebElementListDisappear(partnerSelectInputLoader);

            sendKeys(partnerSelectInput, Keys.RETURN);
        }
    }

//    public void setBonusTypeSelect(
//            String bonusType
//    ) {
//
//        try {
//
//            BonusTypes bonusTypes = BonusTypes.valueOf(bonusType);
//
//            click(bonusTypeSelect);
//
//            switch (bonusTypes) {
//
//                case REKLAMACJA:
//                    click(bonusTypeComplaintSelect);
//                    break;
//
//                case KONKURS:
//                    click(bonusTypeContestSelect);
//                    break;
//
//                case WYROWNANIE_STAWEK:
//                    click(bonusTypeRateAdjustmentSelect);
//                    break;
//
//                case INNE:
//                    click(bonusTypeOthersSelect);
//                    break;
//            }
//
//        } catch (IllegalArgumentException e) {
//
//            System.out.println(e);
//        }
//    }
//
//
//    public void setBonusValueInput(
//            String bonusValue
//    ) {
//
//        sendKeys(bonusValueInput, bonusValue);
//    }
//
//    public void setBonusDescriptionTextarea(
//            String bonusDescription
//    ) {
//
//        sendKeys(bonusDescriptionTextarea, bonusDescription);
//    }
//
//    public void setBonusDatePicker(
//            String date
//    ) {
//
//        sendKeys(bonusDatePicker, date);
//    }
//
//    public boolean addBonus(
//            String partner,
//            String bonusType,
//            String bonusValue,
//            String bonusDescription,
//            String date,
//            SubmitFormButtonsTypes buttonType
//    ) {
//
//        setPartnerSelect(partner);
//
//        setBonusTypeSelect(bonusType);
//
//        setBonusValueInput(bonusValue);
//
//        setBonusDescriptionTextarea(bonusDescription);
//
//        setBonusDatePicker(date);
//
//        new FormButtonsPage(driver).submitForm(buttonType);
//
//        return new AlertsPage(driver).isSuccessAlertDisplayed();
//    }
}
