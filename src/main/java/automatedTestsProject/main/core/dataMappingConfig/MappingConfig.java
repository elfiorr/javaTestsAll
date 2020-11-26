package automatedTestsProject.main.core.dataMappingConfig;

import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class MappingConfig {

  private static final String FILE_EXTENSION_YML = ".yml";
  private static final Yaml YAML = new Yaml();
  public static String ENVIRONMENT_TYPE = System.getProperty("ENV");

  /**
   * Manage selection of environment by loading connections based on given parameter ENV.
   * If parameter is not provided, sets environment on dev.
   *
   * @return environment connections data file name
   */
  private static String getEnvironment() {

    if (ENVIRONMENT_TYPE == null || ENVIRONMENT_TYPE.isEmpty()) {
      ENVIRONMENT_TYPE = "stage";
    }
    return ENVIRONMENT_TYPE;
  }


  /**
   * Creates path to file in configs folder with testing data and mapping it
   *
   * @return path to environment testing data file
   * @throws FileNotFoundException
   */
  protected static Map<String, Map<String, Double>> getPathToResourcesConfigsFile(
          String resourcesConfigsPath
  ) {

            InputStream input = null;
            try {
              input = new FileInputStream(new File(
                      resourcesConfigsPath + FILE_EXTENSION_YML));
            } catch (FileNotFoundException e) {
              e.printStackTrace();
            }

            return (Map<String, Map<String, Double>>) YAML.load(input);
  }

  /**
   * Creates path to custom environment file in configs folder with testing data and mapping it
   *
   * @return path to environment testing data file
   * @throws FileNotFoundException
   */
  protected static Map<String, Map<String, Double>> getPathToCustomResourcesConfigsFile(
          String resourcesConfigsPath, String environment
  )
          throws FileNotFoundException {
    InputStream input = new FileInputStream(new File(
            resourcesConfigsPath + environment + FILE_EXTENSION_YML));
    return (Map<String, Map<String, Double>>) YAML.load(input);
  }

  /**
   * Creates path to file in resources folder and mapping it
   *
   * @param fileName
   * @return path to file
   * @throws FileNotFoundException
   */
  protected static LinkedHashMap<String, Object> getPathToResourcesFile(
          String resourcesPath,
          String fileName
  ) throws FileNotFoundException {

    InputStream input = new FileInputStream(new File(
            resourcesPath + "/" + fileName + FILE_EXTENSION_YML));

    return (LinkedHashMap<String, Object>) YAML.load(input);
  }

}
