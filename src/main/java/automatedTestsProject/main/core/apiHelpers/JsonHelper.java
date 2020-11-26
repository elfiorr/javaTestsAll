package automatedTestsProject.main.core.apiHelpers;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonHelper {

    /**
     * Convert to JSONObject given .json file.
     *
     * @param jsonName name of .json file in jsons package to convert to JSONObject
     * @param pathToJsonFile path to .json file
     * @return JSONObject from .json file
     * @throws IOException
     */
    public static JSONObject readJSONtoJSONObject(
            String pathToJsonFile,
            String jsonName) throws IOException {

        String jsonFileLocation = new StringBuilder()
                .append(pathToJsonFile)
                .append(jsonName)
                .append(".json")
                .toString();

        Logger.getLogger(JsonHelper.class).info("############# Lokalizacja pliku do wysyłki " + jsonFileLocation);

        return new JSONObject(
                new String(Files.readAllBytes(Paths
                        .get(jsonFileLocation)))
        );
    }
}
