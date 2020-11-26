package automatedTestsProject.main.core.commonPages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameButtonsPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(@href,'/create')]")
    private WebElement addNewButton;

    @FindBy(partialLinkText = "Filtry")
    private WebElement filtersButton;

    public FrameButtonsPage(WebDriver driver) {

        super(driver);
    }

    public boolean isAddNewButtonDisplayed(){

        return addNewButton.isDisplayed();
    }

    public boolean isFiltersButtonDisplayed(){

        return filtersButton.isDisplayed();
    }

    public void clickAddNewButton() {

        click(addNewButton);
    }

}
