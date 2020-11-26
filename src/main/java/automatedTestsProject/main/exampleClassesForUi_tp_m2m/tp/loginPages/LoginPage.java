package automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.loginPages;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "username")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){

        super(driver);
    }

    public void setUserName(
            String userName
    ){

        sendKeys(loginInput, userName);
    }

    public void setPassword(
            String password
    ){

        sendKeys(passwordInput, password);
    }

    public void clickLoginButton(){

        click(loginButton);
    }

    /**
     * This method will be exposed in test case to loginButton in the application
     *
     * @param userName LDAP name of application user
     * @param password password to LDAP
     */
    public void logIn(
            String userName,
            String password
    ){

        this.setUserName(userName);

        this.setPassword(password);

        this.clickLoginButton();
    }
}
