package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.settlementsPages.prepaymentsPages;

import automatedTestsProject.main.core.commonPages.LoadersPage;
import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PrepaymentsListPage extends AbstractPage {

    private String m2mValueSummaryValue;

    @FindBy(xpath = "//table[@class='table table-bordered table-striped sonata-ba-list']")
    private WebElement table;

    @FindBy(id = "prepayment_table_form_submit")
    private WebElement submitUploadFormButton;

    @FindBy(xpath = "//tbody/tr[@class='applications-tr']")
    private WebElement applicationsRow;

    @FindBy(xpath = "//tbody/tr[@class='summaryRow']/td[2]")
    private WebElement applicationCountSummaryRowResultField;

    @FindBy(xpath = "//tbody/tr[@class='summaryRow']/td[7]")
    private WebElement profitSummaryRowResultField;

    @FindBy(xpath = "//tbody/tr[@class='summaryRow']/td[8]")
    private WebElement m2mValueSummaryRowResultField;

    @FindBy(xpath = "//tbody/tr[@class='summaryRow']/td[9]")
    private WebElement directValueSummaryRowResultField;

    @FindBy(xpath = "//tbody/tr[@class='summaryRow']")
    private List<WebElement> summaryRowList;

    public PrepaymentsListPage(WebDriver driver) {
        super(driver);

        new LoadersPage(driver).waitToListSpinnerLoaderDisappear();
    }

    public boolean isSummaryRowDisplayed(){
        return !summaryRowList.isEmpty();
    }

    public boolean isApplicationsRowDisplayed(){
        return applicationsRow.isDisplayed();
    }

    public Double getM2mSummaryValue() {

        this.m2mValueSummaryValue = m2mValueSummaryRowResultField
                .getText();

        return Double.valueOf(m2mValueSummaryValue);
    }

    public void submitUploadForm() {

        click(submitUploadFormButton);
    }
}