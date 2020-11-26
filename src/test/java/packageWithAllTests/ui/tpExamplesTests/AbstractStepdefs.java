package packageWithAllTests.ui.tpExamplesTests;

import automatedTestsProject.main.core.dataMappingConfig.DataConfig;
import automatedTestsProject.main.core.dataMappingConfig.ResourcesPathFactory;
import automatedTestsProject.main.core.driverConfigs.WebDriverConfig;
import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.loginPages.LoginPage;
import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Timestamp;

import static automatedTestsProject.main.core.dataMappingConfig.ResourcesPathFactory.TOTALPANEL_TARGET_SCREENSHOTS_RESOURCES_PATH;

public class AbstractStepdefs {

    public static final String CHECK_URL_ASSERT_MESSAGE
            = "URL is not correct.";
    public static final String CHECK_MAIN_TAB_TITLE_MESSAGE
            = "Tab title is not correct.";
    public static final String CHECK_ELEMENT_DISPLAY_MESSAGE
            = "Element is not correctly displayed.";
    public static final String RETURN_VALUE_MESSAGE
            = "Return value is not correct";
    private static final String RESOURCES_PATH = "src/main/resources/totalpanel/envs/";

    protected WebDriver driver;
    private static final Logger logger = Logger
            .getLogger(AbstractStepdefs.class);

    public AbstractStepdefs() throws FileNotFoundException {
    }

    public void loginToM2m(String login, String password) {

//        driver.get(M2M_LOGIN_URL);

        new LoginPage(driver)
                .logIn(login, password);
    }

    public void startBrowser(String featureName) {

        try {
            this.driver = WebDriverConfig.getWebDriver(featureName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        driver.manage().window().setSize(new Dimension(1920, 1020));
    }

    public WebDriver getDriver(){
        return driver;
    }

    private String createPathToFileWithFailedTestScreenshots(
            Scenario scenario
    ) {

        String directoryName = TOTALPANEL_TARGET_SCREENSHOTS_RESOURCES_PATH
                .concat(scenario.getName())
                .replace(" ", "_");
        String fileName =  new Timestamp(System.currentTimeMillis())
                .toString()
                .replace(" ", "_");

        File directory = new File(directoryName);

        if (!directory.exists()){
            directory.mkdir();
        }

        return directoryName
                .concat("/")
                .concat(fileName)
                .concat(".png");
    }

    public void after(Scenario scenario) {

        if (driver != null) {

            if (scenario.isFailed()) {

                File file = ((TakesScreenshot)driver)
                        .getScreenshotAs(OutputType.FILE);

                String pathToFile = createPathToFileWithFailedTestScreenshots(scenario);

                try {
                    FileUtils.copyFile(
                            file,
                            new File(pathToFile));

                    logger.info(String.format(
                            "File with screenshot of failed test was saved in path %s.",
                            pathToFile));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        driver.quit();
        driver = null; // <----- DZIĘKI TEJ LINIJCE, @After odpala się już tylko raz.

        }
    }

}
