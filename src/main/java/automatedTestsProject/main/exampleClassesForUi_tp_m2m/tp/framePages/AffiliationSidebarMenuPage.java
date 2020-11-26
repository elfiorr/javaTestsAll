package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.framePages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AffiliationSidebarMenuPage extends AbstractPage {

    @FindBy(xpath = "//section[@class='sidebar']//span[contains(.,'Administracja Partnerami')]")
    private WebElement panelAdministrationSidebar;

    @FindBy(xpath = "//a[@href='/affiliation/partner-information']")
    private WebElement partnerInformationSidebar;

    @FindBy(xpath = "//a[@href='/affiliation/partner-history']")
    private WebElement partnerHistorySidebar;

    public AffiliationSidebarMenuPage(WebDriver driver) {
        super(driver);

        new SidebarMenuPage(driver)
                .clickAffiliationSidebarMenu();
    }

    private AffiliationSidebarMenuPage clickPartnerAdministrationSidebarMenu() {

        click(panelAdministrationSidebar);

        return this;
    }

    public void clickPartnerInformation() {

        clickPartnerAdministrationSidebarMenu();
        click(partnerInformationSidebar);
    }

    public void clickPartnerHistory() {

        clickPartnerAdministrationSidebarMenu();
        click(partnerHistorySidebar);
    }
}
