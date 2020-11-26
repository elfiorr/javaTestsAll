package automatedTestsProject.main.core.commonPages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchButtonsPage extends AbstractPage {

    @FindBy(id = "base_form_save")
    private WebElement submitButton;

    @FindBy(id = "base_form_save")
    private WebElement clearButton;

    @FindAll(@FindBy(xpath = "//a[@class='btn btn-default' and contains(., 'Wyczyść')]")) // -> Button 1
    private List<WebElement> clearButtonAsLink;

    @FindBy(xpath = "//button[@class='btn-default tp-admin-clear-session btn' and contains(.,'Wyczyść')]")  // -> This button is the same like button 1 above, but with different selector
    private WebElement clearButtonAsButton;

    @FindBy(xpath = "//*[@id='partner_history_filter_csvExport']")
    private WebElement exportCsvButton;

    public SearchButtonsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSubmitButtonDisplayed() {

        return submitButton.isDisplayed();
    }

    public boolean isClearButtonDisplayed() {

        return clearButtonAsLink.size() != 0 || clearButtonAsButton.isDisplayed();
    }

    public boolean isExportCsvDisplayed() {

        return exportCsvButton.isDisplayed();
    }
}
