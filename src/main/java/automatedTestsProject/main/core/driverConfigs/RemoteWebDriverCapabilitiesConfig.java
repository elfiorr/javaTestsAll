package automatedTestsProject.main.core.driverConfigs;

import automatedTestsProject.main.core.dataMappingConfig.DataConfig;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebDriverCapabilitiesConfig {

    private static final Logger logger = Logger
            .getLogger(RemoteWebDriverCapabilitiesConfig.class);

    /**
     * Generate Browserstack URL based on given username and automate key
     *
     * @param automateKey Browserstack user key
     * @return Browserstack URL
     */
    private static String generateBrowserstackUrl(
            String automateKey
    ) throws FileNotFoundException {

        return new StringBuilder()
                .append("https://")
                .append(new DataConfig()
                        .getStringParamFromResourcesFile(
                                "src/main/resources",
                                "config",
                                "browserstack_api_username"))
                .append(":")
                .append(automateKey)
                .append("@hub-cloud.browserstack.com/wd/hub")
                .toString();
    }

    private static DesiredCapabilities setCustomCapabilities(
            String featureName
    ) {

        DesiredCapabilities customCapabilities = new DesiredCapabilities();

        customCapabilities.setCapability("os", OsConfig.getOSName());
        customCapabilities.setCapability("os_version", OsConfig.getOSVersion());
        customCapabilities.setCapability("browser", BrowserConfig.getBrowserName());
        customCapabilities.setCapability("browser_version", BrowserConfig.getBrowserVersion());
        customCapabilities.setCapability("resolution", ResolutionConfig.getBrowserResolution());
        customCapabilities.setCapability("project", BuildConfig.getProjectName());
        customCapabilities.setCapability("build", BuildConfig.getBuildName());
        customCapabilities.setCapability("name", featureName);
        customCapabilities.setCapability("browserstack.local", "true");

        return customCapabilities;
    }

    private static DesiredCapabilities setDefaultCapabilities(
            String featureName
    ) {

        DesiredCapabilities defaultCapabilities = new DesiredCapabilities();

        defaultCapabilities.setCapability("os", OsConfig.getOSName());
        defaultCapabilities.setCapability("os_version", OsConfig.getOSVersion());
        defaultCapabilities.setCapability("browser", BrowserConfig.getBrowserName());
        defaultCapabilities.setCapability("browser_version", BrowserConfig.getBrowserVersion());
        defaultCapabilities.setCapability("resolution", ResolutionConfig.getBrowserResolution());
        defaultCapabilities.setCapability("project", BuildConfig.getProjectName());
        defaultCapabilities.setCapability("build", BuildConfig.getBuildName());
        defaultCapabilities.setCapability("name", featureName);
        defaultCapabilities.setCapability("browserstack.local", "true");

        return defaultCapabilities;
    }

    /**
     * Sets remote WebDriver with custom capabilities based on given parameters.
     * If desired capabilities cannot work together, returns default values.
     *
     * @param automateKey Browserstack user key
     * @return remote WebDriver
     * @throws MalformedURLException
     */
    private static WebDriver setRemoteWebDriver(
            String automateKey,
            String featureName
    ) throws MalformedURLException, FileNotFoundException {

        logger.info(String
                .format("Setting up RemoteWebDriver capabilities base on given parameters."));

        try {

            return new RemoteWebDriver(new URL(
                    generateBrowserstackUrl(automateKey)),
                    setCustomCapabilities(featureName));

        } catch (WebDriverException e) {

            logger.warn(String
                    .format("Given RemoteWebDriver capabilities cannot work together."));
            logger.warn(String
                    .format("Reason: \n%s", e));
            logger.warn(String
                    .format("Starts setting up RemoteWebDriver capabilities based on default parameters."));

            return new RemoteWebDriver(new URL(
                    generateBrowserstackUrl(automateKey)),
                    setDefaultCapabilities(featureName));

        }
    }

    /**
     * Gets remote WebDriver DesiredCapabilities() config
     *
     * @param automateKey Browserstack user key
     * @param featureName tests feature name
     * @return remote WebDriver with custom caps config
     * @throws MalformedURLException
     */
    protected static WebDriver getRemoteWebDriver(
            String automateKey,
            String featureName
    ) throws MalformedURLException, FileNotFoundException {

        return setRemoteWebDriver(
                automateKey,
                featureName);

    }

}
