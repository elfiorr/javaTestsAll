package automatedTestsProject.main.core.driverConfigs;

import automatedTestsProject.main.core.generators.DateFormat;
import automatedTestsProject.main.core.generators.DateGenerator;
import automatedTestsProject.main.core.generators.TimeFormat;
import automatedTestsProject.main.core.generators.TimeGenerator;
import org.apache.log4j.Logger;

public class BuildConfig {

    private static final Logger logger = Logger
            .getLogger(BrowserConfig.class);
    private static final String PROJECT_NAME = System
            .getProperty("PROJECT_NAME");
    private static final String BUILD_NAME = System
            .getProperty("BUILD_NAME");

    /**
     * Sets name of testing project, to be displayed in Browserstack (e.g. Totalpanel, M2M)
     *
     * @return Project name, with is displayed on Browserstack
     */
    private static String setProjectName(){

        if (PROJECT_NAME == null) {

            return new DateGenerator(DateFormat.DASH).getCurrentDate();
        }

        return PROJECT_NAME;
    }

    /**
     * Sets name of testing build, to be displayed in Browserstack (e.g. Regression Version: 20.01.TP)
     *
     * @return Build name, with is displayed on Browserstack
     */
    private static String setBuildName(){

        if (BUILD_NAME == null) {

            return new TimeGenerator(TimeFormat.COLON).getCurrentTime();
        }

        return BUILD_NAME;
    }

    protected static String getProjectName(){

        String projectName = setProjectName();
        logger.info(String
                .format("Project name: %S", projectName));

        return projectName;
    }

    protected static String getBuildName(){

        String buildName = setBuildName();
        logger.info(String
                .format("Build name: %S", buildName));

        return buildName;
    }
}
