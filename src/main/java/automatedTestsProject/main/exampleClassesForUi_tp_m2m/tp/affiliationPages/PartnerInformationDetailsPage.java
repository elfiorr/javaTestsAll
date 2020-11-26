package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.affiliationPages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PartnerInformationDetailsPage extends AbstractPage {
    
    @FindBy(xpath = "//li[@data-url='getBasicInformationUrl']")
    private WebElement basicInformationTab;

    @FindBy(xpath = "//li[@data-url='getContactInformationUrl']")
    private WebElement contactInformationTab;

    @FindBy(xpath = "//li[@data-url='getMlmInformationUrl']")
    private WebElement mlmInformationUrlTab;

    @FindBy(xpath = "//li[@data-url='getHistoryInformationUrl']")
    private WebElement historyInformationTab;

    @FindBy(xpath = "//li[@data-url='getAccessGroupsUrl']")
    private WebElement accessGroupsTab;

    @FindBy(xpath = "//li[@data-url='getPartnerAccessGroupUrl']")
    private WebElement partnerAccessGroupTab;

    @FindBy(xpath = "//li[@data-url='getPartnerPrivateAccessUrl']")
    private WebElement partnerPrivateAccessUrlTab;

    public PartnerInformationDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBasicInformationTabDisplay() {

        return basicInformationTab.isDisplayed();
    }

    public boolean isContactInformationTabDisplay() {

        return contactInformationTab.isDisplayed();
    }

    public boolean isMlmInformationUrlTabDisplay() {

        return mlmInformationUrlTab.isDisplayed();
    }

    public boolean isHistoryInformationTabDisplay() {

        return historyInformationTab.isDisplayed();
    }

    public boolean isAccessGroupsTabDisplay() {

        return accessGroupsTab.isDisplayed();
    }

    public boolean isPartnerAccessGroupTabDisplay() {

        return partnerAccessGroupTab.isDisplayed();
    }

    public boolean isPartnerPrivateAccessUrlTabDisplay() {

        return partnerPrivateAccessUrlTab.isDisplayed();
    }
}
