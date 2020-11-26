package automatedTestsProject.main.core.driverConfigs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalWebDriverManagerConfig {

    private static final Logger logger = Logger
            .getLogger(LocalWebDriverManagerConfig.class);
    private static final String BROWSER = System
            .getProperty("BROWSER");

    /**
     * Sets local WebDriver as ChromeDriver
     *
     * @return ChromeDriver
     */
    private static WebDriver getChromeDriver() {

        WebDriverManager
                .chromedriver()
                .setup();

        logger.info("Selected browser: CHROME");

        return new ChromeDriver();

    }

    /**
     * Sets local WebDriver as ChromeDriver using chromedriver from drivers package
     *
     * @return ChromeDriver
     */
    private static WebDriver getLocalChromeDriver() {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");

        logger.info("Selected browser: CHROME FROM drivers/chromedriver");

        return new ChromeDriver();
    }

    /**
     * Sets local WebDriver as ChromeDriver in headless mode
     *
     * @return ChromeDriver
     */
    private static WebDriver getHeadlessChromeDriver() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");

        logger.info("Selected browser: CHROME HEADLESS");


        return new ChromeDriver(options);

    }

    /**
     * Sets local WebDriver as FirefoxDriver
     *
     * @return FirefoxDriver
     */
    private static WebDriver getFirefoxDriver() {

        WebDriverManager
                .firefoxdriver()
                .setup();

        logger.info("Selected browser: FIREFOX");

        return new FirefoxDriver();

    }

    /**
     * Sets local WebDriver based on given parameter BROWSER. If parameter is not provided, sets it
     * on CHROME.
     *
     * @return desired local WebDriver
     */
    private static WebDriver setLocalWebDriver(){

        if(BROWSER == null || BROWSER.equals("CHROME")) {
            return getChromeDriver();
        }

        else if(BROWSER.equals("FIREFOX")) {
            return getFirefoxDriver();
        }

        else if (BROWSER.equals("CHROMEDRIVER")) {
            return getLocalChromeDriver();
        }

        else {
            return getHeadlessChromeDriver();
        }

    }

    protected static WebDriver getLocalWebDriver() {

        return setLocalWebDriver();
    }
}
