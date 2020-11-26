package automatedTestsProject.main.core.dataMappingConfig;

import java.io.FileNotFoundException;
import java.util.List;

public class DataConfig extends MappingConfig {

    /**
     * Takes name of parameter key from configs file in connection section
     * and returns its value in String.
     *
     * @param resourcesConfigsPath path to configs file in resources
     * @param connectionDataName name of connection parameter to get from configs file
     * @return value of given key from configs file
     * @throws FileNotFoundException
     */
    public static String getConnectionData(
            String resourcesConfigsPath,
            String connectionDataName
    ) {

        return String.valueOf(getPathToResourcesConfigsFile(resourcesConfigsPath)
                .get("connection")
                .get(connectionDataName));
    }

    /**
     * Takes name of parameter key from configs file in connection section
     * and returns its value in String.
     *
     *
     * @param resourcesConfigsPath path to configs file in resources
     * @param connectionDataName   name of connection parameter to get from configs file
     * @param environment name of environment
     * @return value of given key from configs file
     * @throws FileNotFoundException
     */
    public static String getCustomConnectionData(
            String resourcesConfigsPath,
            String connectionDataName, String environment
    ) throws FileNotFoundException {
        return String.valueOf(getPathToCustomResourcesConfigsFile(resourcesConfigsPath, environment)
                .get("connection")
                .get(connectionDataName));
    }

    /**
     * Takes name of parameter key from configs file in users section
     * and returns its value in String.
     *
     * @param resourcesConfigsPath path to configs file in resources
     * @param usersDataName name of users parameter to get from configs file
     * @return value of given key from configs file
     * @throws FileNotFoundException
     */
    public static String getUsersData(
            String resourcesConfigsPath,
            String usersDataName
    ) {

        return String.valueOf(getPathToResourcesConfigsFile(resourcesConfigsPath)
                .get("users")
                .get(usersDataName));
    }

    /**
     * Takes name of parameter key from configs file in chosen section
     * and returns its value in String.
     *
     * @param resourcesConfigsPath path to configs file in resources
     * @param dataType name of sections in configs file
     * @param variableName name on variable in dataType to get value of
     * @return value of given key from configs file
     * @throws FileNotFoundException
     */
    public static String getConfigData(
            String resourcesConfigsPath,
            String dataType,
            String variableName
    ) throws FileNotFoundException {

        return String.valueOf(getPathToResourcesConfigsFile(resourcesConfigsPath)
                .get(dataType)
                .get(variableName));
    }

    /**
     * Takes name of parameter key from configs file in chosen section
     * and returns its value in String.
     *
     * @param resourcesConfigsPath path to configs file in resources
     * @param dataType name of sections in configs file
     * @param variableName name on variable in dataType to get value of
     * @param environment name of environment
     * @return value of given key from configs file
     * @throws FileNotFoundException
     */
    public static String getCustomConfigData(
            String resourcesConfigsPath,
            String dataType,
            String variableName,
            String environment
    ) throws FileNotFoundException {

        return String.valueOf(getPathToCustomResourcesConfigsFile(resourcesConfigsPath, environment)
                .get(dataType)
                .get(variableName));
    }

    /**
     * Takes name of file and gets parameter value based on given key.
     *
     * @param resourcesPath path to resources
     * @param fileName name of file
     * @param variableName name on variable to get value of
     * @return value of given key from file in String
     * @throws FileNotFoundException*
     */
    public static String getStringParamFromResourcesFile(
            String resourcesPath,
            String fileName,
            String variableName
    ) throws FileNotFoundException {

        return (String) getPathToResourcesFile(resourcesPath, fileName)
                .get(variableName);
    }

    /**
     * Takes name of file and gets parameters list value based on given key.
     *
     * @param resourcesPath path to resources
     * @param fileName name of file
     * @param variableName name on variable to get value of
     * @return value of given key from file as list of Strings
     * @throws FileNotFoundException*
     */
    public static List getListParamFromResourcesFile(
            String resourcesPath,
            String fileName,
            String variableName
    ) throws FileNotFoundException {

        return (List) getPathToResourcesFile(resourcesPath, fileName)
                .get(variableName);
    }

}
