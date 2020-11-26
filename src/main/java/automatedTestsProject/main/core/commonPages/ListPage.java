package automatedTestsProject.main.core.commonPages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ListPage extends AbstractPage {

    @FindAll(@FindBy(xpath = "//table"))
    private List<WebElement> listTableBox;

    @FindAll(@FindBy(xpath = "//div[@class='info-box']//span[contains(., 'Brak wyników')]"))
    private List<WebElement> addFirstListElementBox;

    public ListPage(WebDriver driver) {

        super(driver);
    }

    public boolean isListBoxDisplayed() {

        return !(listTableBox.size() == 0);
    }

    private boolean isAddFirstElementBoxDisplayed() {

        return !(addFirstListElementBox.size() == 0);
    }

    public boolean isListDisplayed() {

        return isListBoxDisplayed() || isAddFirstElementBoxDisplayed();
    }
}