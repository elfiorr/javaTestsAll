package automatedTestsProject.main.core.commonPages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FiltersPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@id, 'filter-container')]")
    private WebElement filtersBox;

    public FiltersPage(WebDriver driver) {

        super(driver);
    }

    public boolean isFiltersBoxDisplayed(){

        return filtersBox.isDisplayed();
    }
}
