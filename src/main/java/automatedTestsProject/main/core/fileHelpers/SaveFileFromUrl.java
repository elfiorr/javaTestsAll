package automatedTestsProject.main.core.fileHelpers;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * This class is responsible for downloading images from the internet and saving them to a file
 */
public class SaveFileFromUrl {

    final static Logger logger = Logger.getLogger(SaveFileFromUrl.class);

    /**
     * Saves in custom path file downloaded from url.
     *
     * @param fileUrl image url
     * @param pathName path to file generated from url
     * @throws IOException
     */
    public static void saveFileFromUrl(
            String fileUrl,
            String pathName
    ) throws IOException {

        logger.info(String
                .format("Getting file from: %s", fileUrl));

        URL url = new URL(fileUrl);
        InputStream in = url.openStream();

        Files.copy(
                in,
                Paths.get(pathName),
                StandardCopyOption.REPLACE_EXISTING
        );
    }

}
