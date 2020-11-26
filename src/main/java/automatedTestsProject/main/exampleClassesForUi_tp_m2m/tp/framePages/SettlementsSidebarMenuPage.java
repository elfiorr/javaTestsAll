package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.framePages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettlementsSidebarMenuPage extends AbstractPage {

    @FindBy(xpath = "//a[@href='/settlements/provision-rates']")
    private WebElement provisionRatesSidebar;

    @FindBy(xpath = "//a[@href='/app/direct/bonus/list']")
    private WebElement bonusSidebar;

    @FindBy(xpath = "//a[@href='/sales/prepayments/index']")
    private WebElement salesPrepaymentSidebar;

    @FindBy(xpath = "//a[@href='/settlements/payments']")
    private WebElement paymentsSidebar;

    @FindBy(xpath = "//a[@href='/sales/status/index']")
    private WebElement salesStatusSidebar;

    public SettlementsSidebarMenuPage(WebDriver driver) {

        super(driver);

        new SidebarMenuPage(driver)
                .clickSettlementsSidebarMenu();
    }

    public void clickBonusSidebarMenu() {

        click(bonusSidebar);
    }

    public void clickProvisionRatesSidebarMenu() {

        click(provisionRatesSidebar);
    }

    public void clickPaymentSidebarMenu() {

        click(paymentsSidebar);
    }

    public void clickSalesPrepaymentSidebarMenu() {

        click(salesPrepaymentSidebar);
    }

    public void clickSalesStatusSidebarMenu() {

        click(salesStatusSidebar);
    }
}
