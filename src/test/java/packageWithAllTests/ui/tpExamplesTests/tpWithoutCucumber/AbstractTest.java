package packageWithAllTests.ui.tpExamplesTests.tpWithoutCucumber;

import automatedTestsProject.main.core.driverConfigs.WebDriverConfig;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class AbstractTest {

    protected WebDriver driver;
//    public final String TP_USERNAME = DataConfig
//            .getUsersData(ResourcesPathFactory.PATH_TO_URL, "tp_username");
//    public final String TP_PASSWORD = DataConfig
//            .getUsersData(ResourcesPathFactory.PATH_TO_URL, "tp_password");
//    public final String TP_LOGIN_URL = DataConfig
//            .getConnectionData(ResourcesPathFactory.PATH_TO_URL, "tp_url");
//    protected final static String UPLOAD_FILE_EXCEPTION_RESPONSE =
//            "Test has not been started remotely. Network folder doesn't exist on remote environment yet, " +
//                    "so all tests which require csv files upload cannot be executed fully. " +
//                    "It's necessary to execute these tests on local environment @Tag(TP_CSV)";
//    public static final String[] SALES_CSV_HEADERS = {"Id application", "External Id", "Status"};
//    public static final String FILE_NAME = new Timestamp(System.currentTimeMillis())
//            .toString()
//            .replace(" ", "_")
//            .concat(".csv");
//    public static final String DISTRIBUTOR_ID_FOR_PARTNER_WITH_80_THOUSANDS_CLICKS = "45324";
//    public static final String SALE_CHANNEL_ID_FOR_MBANK = "1";

    public AbstractTest() throws FileNotFoundException {

        String featureName = "";

        try {
            this.driver = WebDriverConfig.getWebDriver(featureName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        driver.manage()
                .window()
                .setSize(new Dimension(1920, 1020));
    }
//
//    protected void logToTotalpanel() {
//
//        driver.get(TP_LOGIN_URL);
//
//        new LoginPage(driver)
//                .logIn(
//                        TP_USERNAME,
//                        TP_PASSWORD);
//    }
//
//    protected void logToTotalpanel(
//            String tpUsername,
//            String tpPassword
//    ) {
//
//        driver.get(TP_LOGIN_URL);
//
//        new LoginPage(driver)
//                .logIn(
//                        tpUsername,
//                        tpPassword);
//    }
}
