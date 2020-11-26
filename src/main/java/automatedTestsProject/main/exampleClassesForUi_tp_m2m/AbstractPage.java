package automatedTestsProject.main.exampleClassesForUi_tp_m2m;

import org.openqa.selenium.WebDriver;

public class AbstractPage extends automatedTestsProject.main.core.webpages.AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {

        super(driver, 30);
        this.driver = driver;
    }
}
