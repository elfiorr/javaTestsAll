package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.settlementsPages.statusPages;

import automatedTestsProject.main.core.commonPages.LoadersPage;
import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalesStatusFiltersPage extends AbstractPage {


    @FindBy(id = "select2-chosen-1")
    private WebElement salesStatusFormOffererTypeSelect;

    @FindBy(id = "s2id_autogen1_search")
    private WebElement offererTypeSelect;

    @FindBy(xpath = "//ul[contains(@id,'select2-result')]//li[1]")
    private WebElement offererTypeSelectResultSelect;

    @FindBy(id = "sales_status_options_form_submit")
    private WebElement salesStatusSearchFormButton;

    @FindBy(id = "sales_status_options_form_file")
    private WebElement fileFormButton;

    public SalesStatusFiltersPage(WebDriver driver) {
        super(driver);

        new LoadersPage(driver).waitToListSpinnerLoaderDisappear();
    }

    public void setOffererSelect(String value) {

        click(salesStatusFormOffererTypeSelect);

        sendKeys(offererTypeSelect, value);

        click(offererTypeSelectResultSelect);
    }

    public void submitSearchForm() {

        click(salesStatusSearchFormButton);
    }

    public void uploadFile(String fileName) {

        sendKeys(fileFormButton, fileName);
    }
}
