package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.framePages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoreSidebarMenuPage extends AbstractPage {

    @FindBy(xpath = "//a[@href='/app/core/paneluser/list']")
    private WebElement panelUserSidebar;

    @FindBy(xpath = "//a[@href='/app/core/panelusergroup/list']")
    private WebElement panelUserGroupSidebar;

    @FindBy(xpath = "//a[@href='/app/core/emailtemplate/list']")
    private WebElement emailTemplateSidebar;

    @FindBy(xpath = "//a[@href='/app/core/eventsubscription/list']")
    private WebElement eventSubscriptionSidebar;

    @FindBy(xpath = "//a[@href='/app/core/panelsetting/list']")
    private WebElement panelSettingSidebar;

    public CoreSidebarMenuPage(WebDriver driver) {

        super(driver);

        new SidebarMenuPage(driver)
                .clickCoreSidebarMenu();
    }

    public void clickPanelUserSidebarMenu() {

        click(panelUserSidebar);
    }


    public void clickPanelUserGroupSidebarMenu() {

        click(panelUserGroupSidebar);
    }


    public void clickEmailTemplateSidebarMenu(){

        click(emailTemplateSidebar);
    }


    public void clickEventSubscriptionMenu() {

        click(eventSubscriptionSidebar);
    }


    public void clickPanelSettingSidebarMenu(){

        click(panelSettingSidebar);
    }

}
