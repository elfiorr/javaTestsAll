package automatedTestsProject.main.core.driverConfigs;


import org.apache.log4j.Logger;

public class BrowserConfig {

    final static Logger logger = Logger
            .getLogger(BrowserConfig.class);
    private static final String BROWSER = System
            .getProperty("BROWSER");
    private static final String BROWSER_VERSION = System
            .getProperty("BROWSER_VERSION");

    /**
     * Sets browser of Browserstack machine. List of all possible browsers in
     * <a href="https://www.browserstack.com/automate/capabilities">Configure capabilities link</a>
     *
     * @return browser
     */
    private static String setBrowser(){

        if (BROWSER == null) {

            return "Chrome";
        }

        return BROWSER;
    }

    /**
     * Sets browser version of Browserstack machine. List of all possible browsers version in
     * <a href="https://www.browserstack.com/automate/capabilities">Configure capabilities link</a>
     *
     * @return browser version
     */
    private static String setBrowserVersion(){

        if (BROWSER_VERSION == null) {

            return "75.0";
        }

        return BROWSER_VERSION;
    }

    protected static String getBrowserName(){

        String browserName = setBrowser();
        logger.info(String
                .format("Browser name: %S", browserName));

        return browserName;
    }

    protected static String getBrowserVersion(){

        String browserName = setBrowserVersion();
        logger.info(String
                .format("Browser version: %S", browserName));

        return browserName;
    }

}
