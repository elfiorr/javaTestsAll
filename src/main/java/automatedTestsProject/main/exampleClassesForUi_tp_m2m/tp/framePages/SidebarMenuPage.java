package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.framePages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidebarMenuPage extends AbstractPage {

    @FindBy(xpath = "//section[@class='sidebar']//span[contains(.,'Zarządzanie panelem')]")
    private WebElement coreSidebar;

    @FindBy(xpath = "//section[@class='sidebar']//span[contains(.,'Multiformularze')]")
    private WebElement multiformSidebar;

    @FindBy(xpath = "//section[@class='sidebar']//span[contains(.,'CMS Produktowy')]")
    private WebElement omsSidebar;

    @FindBy(xpath = "//section[@class='sidebar']//span[contains(.,'Rozliczenia')]")
    private WebElement settlementsSidebar;

    @FindBy(xpath = "//section[@class='sidebar']//span[contains(.,'Raporty')]")
    private WebElement reportsSidebar;

    @FindBy(xpath = "//section[@class='sidebar']//span[contains(.,'Afiliacja')]")
    private WebElement affiliationSidebar;

    @FindBy(xpath = "//section[@class='sidebar']//span[contains(.,'Panel RODO')]")
    private WebElement rodoSidebar;

    public SidebarMenuPage(WebDriver driver) {

        super(driver);
    }

    protected void clickAffiliationSidebarMenu(){

        click(affiliationSidebar);
    }

    protected void clickCoreSidebarMenu() {

        click(coreSidebar);
    }

    protected void clickSettlementsSidebarMenu() {

        click(settlementsSidebar);
    }

    protected void clickMultiformSidebarMenu() {

        click(multiformSidebar);
    }

    protected void clickOmsSidebarMenu() {

        click(omsSidebar);
    }

    protected void clickReportsSidebarMenu() {

        click(reportsSidebar);
    }

    protected void clickRodoSidebarMenu() {

        click(rodoSidebar);
    }
}
