package automatedTestsProject.main.core.driverConfigs;

import org.apache.log4j.Logger;

public class ResolutionConfig {

    final static Logger logger
            = Logger.getLogger(ResolutionConfig.class);

    private static final String RESOLUTION = System
            .getProperty("RESOLUTION");


    /**
     * Sets resolution of Browserstack machine. List of all possible resolutions in
     * <a href="https://www.browserstack.com/automate/capabilities">Configure capabilities link</a>
     *
     * @return resolution
     */
    private static String setResolution(){

        if (RESOLUTION == null) {

            return "1920x1080";
        }

        return RESOLUTION;

    }


    protected static String getBrowserResolution() {

        String resolution = setResolution();
        logger.info(String
                .format("Resolution of machine used in tests: %s", resolution));

        return resolution;
    }

}
