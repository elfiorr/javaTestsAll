package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.framePages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainHeaderPage extends AbstractPage {

    @FindBy(xpath = "//header[@class='main-header']//ol")
    private WebElement tabTitle;

    @FindAll(@FindBy(xpath = "//li[contains(@class, 'user-menu')]"))
    private List<WebElement> userMenuButton;

    @FindAll(@FindBy(xpath = "//nav[contains(@class, 'navbar-static-top')]"))
    private List<WebElement> navigationTopBar;

    public MainHeaderPage(WebDriver driver) {

        super(driver);
    }

    public String getTabTitle() {

        return tabTitle.getText();
    }

    public boolean isUserMenuButtonDisplayed() {

        return !(userMenuButton.isEmpty());
    }

    public boolean isNavigationTopBarDisplayed() {

        return !(navigationTopBar.isEmpty());
    }
}
