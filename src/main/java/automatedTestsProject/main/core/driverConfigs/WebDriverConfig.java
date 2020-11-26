package automatedTestsProject.main.core.driverConfigs;

import org.apache.log4j.Logger;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverConfig {

    private static final Logger logger = Logger
            .getLogger(WebDriver.class);

    /**
     * Sets WebDriver. If REMOTE_RUN_MODE is null sets it as local and remote otherwise.
     *
     * @return WebDriver with is customised
     * @throws MalformedURLException
     * @throws FileNotFoundException
     */
    public static WebDriver getWebDriver(
            String featureName
    ) throws MalformedURLException, FileNotFoundException {

        if(System.getProperty("REMOTE_RUN_MODE") == null) {

            logger.info("Run WebDriver locally.");
            return LocalWebDriverManagerConfig
                    .getLocalWebDriver();

        } else if(System.getProperty("REMOTE_RUN_MODE").equals("grid")) {

            String gridUrl = System.getProperty("GRID_URL");

            if(gridUrl == null) {

                throw new IllegalArgumentException("Nie podano parametru GRID_URL, działanie programu zostało przerwane");
            }

            Proxy proxy = new Proxy();
            proxy.setHttpProxy("w3cache.adm.wp-sa.pl:8080");
            proxy.setSslProxy("w3cache.adm.wp-sa.pl:8080");
            ChromeOptions caps = new ChromeOptions();
            caps.setCapability(
                    CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
                    UnexpectedAlertBehaviour.IGNORE);
            caps.setCapability("proxy", proxy);
            caps.addArguments("--headless");
            caps.addArguments("--no-sandbox");
            caps.addArguments("--disable-dev-shm-usage");

            logger.info("Run WebDriver remotely from Selenium Grid.");

            return new RemoteWebDriver(
                    new URL(gridUrl), caps);
        }

        logger.info("Run WebDriver remotely form BrowserStack.");

        return RemoteWebDriverCapabilitiesConfig
                .getRemoteWebDriver(
                        System.getProperty("AUTOMATE_KEY"),
                        featureName);
    }

}
