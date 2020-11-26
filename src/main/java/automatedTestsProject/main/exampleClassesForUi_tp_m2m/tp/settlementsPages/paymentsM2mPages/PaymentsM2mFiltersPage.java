package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.settlementsPages.paymentsM2mPages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentsM2mFiltersPage extends AbstractPage {

    @FindBy(id = "s2id_payments_filter_form_partner")
    private WebElement paymentsFormPartnerTypeSelect;

    @FindBy(id = "s2id_autogen1_search")
    private WebElement partnerTypeSelect;

    @FindBy(xpath = "//ul[contains(@id,'select2-result')]//li[1]")
    private WebElement partnerTypeSelectResultSelect;

    @FindBy(id = "payments_filter_form_showPayments")
    private WebElement paymentsSearchFormButton;

    @FindBy(id = "payout")
    private WebElement paymentsPayoutFormButton;

    public PaymentsM2mFiltersPage(WebDriver driver) {
        super(driver);
    }

    public void setPrepaymentFormOffererSelect(String value) {

        click(paymentsFormPartnerTypeSelect);

        sendKeys(partnerTypeSelect, value);

        click(partnerTypeSelectResultSelect);
    }

    public void submitSearchForm() {

        click(paymentsSearchFormButton);
    }

    public void submitPayoutForm() {

        click(paymentsSearchFormButton);
    }
}
