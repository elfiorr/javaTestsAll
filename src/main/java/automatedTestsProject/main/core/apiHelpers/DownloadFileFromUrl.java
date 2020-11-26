package automatedTestsProject.main.core.apiHelpers;

import com.jayway.restassured.response.Response;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DownloadFileFromUrl {

    private Response response;
    private String filename;
    private String pathToFile;

    final static Logger logger = Logger.getLogger(DownloadFileFromUrl.class);


    public DownloadFileFromUrl(
            Response responseValue,
            String filenameValue,
            String pathToFileValue
    ) {
        this.response = responseValue;
        this.filename = filenameValue;
        this.pathToFile = pathToFileValue;

    }


    public void downloadFileFromUrlToChosenFolder() throws IOException {

        File outputPath = new File(pathToFile);

        File outputFile = new File(
                outputPath.getPath(),
                filename);

        if(!outputPath.exists()) {
            outputPath.mkdirs();
        }

        byte[] fileContents = response
                .andReturn()
                .getBody()
                .asByteArray();

        logger.info(String
                .format("Saving file: %s in path: %s.", filename, pathToFile));

        OutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(fileContents);
        outputStream.close();
    }
}