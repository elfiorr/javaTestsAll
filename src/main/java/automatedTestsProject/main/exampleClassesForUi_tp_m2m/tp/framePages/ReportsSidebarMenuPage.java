package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.framePages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportsSidebarMenuPage extends AbstractPage {

    @FindBy(xpath = "//a[@href='/report/conversion/report']")
    private WebElement reportConversionSidebar;

    public ReportsSidebarMenuPage(WebDriver driver) {
        super(driver);

        new SidebarMenuPage(driver)
                .clickReportsSidebarMenu();
    }

    public void clickReportConversionSidebarMenu() {

        click(reportConversionSidebar);
    }
}
