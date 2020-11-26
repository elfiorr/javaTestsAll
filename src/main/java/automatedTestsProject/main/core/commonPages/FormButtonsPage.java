package automatedTestsProject.main.core.commonPages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormButtonsPage extends AbstractPage {

    @FindBy(name = "btn_create_and_create")
    private WebElement createAndCreateButton;

    @FindBy(name = "btn_create_and_edit")
    private WebElement createAndEditButton;

    @FindBy(name = "btn_create_and_list")
    private WebElement createAndListButton;

    @FindBy(linkText = "Dodaj")
    private WebElement addSmallButton;

    public FormButtonsPage(WebDriver driver) {

        super(driver);
    }

    public boolean isCreateAndCreateButtonDisplayed() {

        return createAndCreateButton.isDisplayed();
    }

    public boolean isCreateAndEditButtonDisplayed() {

        return createAndEditButton.isDisplayed();
    }

    public boolean isCreateAndListButtonDisplayed() {

        return createAndListButton.isDisplayed();
    }

    public boolean isAddSmallButtonDisplayed() {

        return addSmallButton.isDisplayed();
    }


    public void submitForm(
            SubmitFormButtonsTypes buttonType
    ) {

        switch (buttonType) {

            case CREATE_AND_CREATE:
                click(createAndCreateButton);
                break;

            case CREATE_AND_EDIT:
                click(createAndEditButton);
                break;

            case CREATE_AND_LIST:
                click(createAndListButton);
                break;
        }
    }
}
