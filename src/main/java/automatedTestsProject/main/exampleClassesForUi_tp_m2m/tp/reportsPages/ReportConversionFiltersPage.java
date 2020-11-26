package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.reportsPages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ReportConversionFiltersPage extends AbstractPage {

    @FindBy(id = "s2id_base_form_filters_offerer")
    private WebElement reportConversionFormOffererTypeSelect;

    @FindBy(xpath = "//input[@id='s2id_autogen10']")
    private WebElement offererTypeSelect;

    @FindAll(@FindBy(className = "select2-searching"))
    private List<WebElement> partnerSelectInputLoader;

    @FindBy(xpath = "//div[@id='select2-drop']//ul[contains(@class,'select2-result')]//li[1]")
    private WebElement typeFirstResultSelect;

    @FindBy(id = "s2id_base_form_filters_applicationsIds")
    private WebElement reportConversionFormApplicationsIdTypeSelect;

    @FindBy(xpath = "//input[@id='s2id_autogen12']")
    private WebElement applicationsIdTypeSelect;

    @FindAll(@FindBy(className = "select2-input select2-active"))
    private List<WebElement> applicationsIdSelectInputLoader;

    @FindBy(id = "base_form_filters_period_start")
    private WebElement reportConversionFormDateInput;

    @FindBy(id = "base_form_save")
    private WebElement submitButton;

    @FindBy(xpath = "//a[contains(@href, 'report/conversion/resetfilters')]")
    private WebElement clearButton;

    @FindBy(id = "s2id_base_form_filters_partner")
    private WebElement reportConversionFormPartnerTypeSelect;

    @FindBy(id = "s2id_autogen8")
    private WebElement partnerTypeSelect;

    public ReportConversionFiltersPage(WebDriver driver) {
        super(driver);
    }

    public void setReportConversionFormOffererSelect(String value) {

        click(reportConversionFormOffererTypeSelect);

        sendKeys(offererTypeSelect, value);

        waitToWebElementListDisappear(partnerSelectInputLoader);

        click(typeFirstResultSelect);
    }

    public void setReportConversionFormApplicationsIdsSelect(String value) {

        click(reportConversionFormApplicationsIdTypeSelect);

        sendKeys(applicationsIdTypeSelect, value);

        sendKeys(applicationsIdTypeSelect, Keys.SPACE);
    }

    public void setReportConversionFormDateInput(String value) {

        sendKeys(reportConversionFormDateInput, value);
    }


    public void setReportConversionFormPartnerSelect(String value) {

        click(reportConversionFormPartnerTypeSelect);

        sendKeys(partnerTypeSelect, value);

        waitToWebElementListDisappear(partnerSelectInputLoader);

        click(typeFirstResultSelect);
    }
}
