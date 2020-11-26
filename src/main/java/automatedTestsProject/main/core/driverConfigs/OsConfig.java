package automatedTestsProject.main.core.driverConfigs;

import org.apache.log4j.Logger;

public class OsConfig {

    private static final Logger logger
            = Logger.getLogger(OsConfig.class);
    private static final String OS_NAME = System
            .getProperty("OS_NAME");
    private static final String OS_VERSION = System
            .getProperty("OS_VERSION");

    /**
     * Sets os name of Browserstack machine. List of all possible os names in
     * <a href="https://www.browserstack.com/automate/capabilities">Configure capabilities link</a>
     *
     * @return os name
     */
    private static String setOSName(){

        if (OS_NAME == null) {

            return "Windows";
        }

        return OS_NAME;

    }

    /**
     * Sets os version of Browserstack machine. List of all possible os version in
     * <a href="https://www.browserstack.com/automate/capabilities">Configure capabilities link</a>
     *
     * @return os version
     */
    private static String setOSVersion(){

        if (OS_VERSION == null) {

            return "10";
        }

        return OS_VERSION;

    }

    protected static String getOSName(){

        String oSName = setOSName();
        logger.info(String
                .format("OS name: %S", oSName));

        return oSName;
    }

    protected static String getOSVersion(){

        String oSVersion = setOSVersion();
        logger.info(String
                .format("OS version: %S", oSVersion));

        return oSVersion;
    }
}
