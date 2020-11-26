package automatedTestsProject.main.integrations.googleIntegration;

import automatedTestsProject.main.core.fileHelpers.FileTypes;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

/**
 * This class is responsible for connecting to Google Drive.
 */
public class DriveIntegration extends GoogleIntegrationConfig {

    final static Logger logger = Logger.getLogger(DriveIntegration.class);
    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE_FILE);
    private static final String APPLICATION_NAME = "Drive Integration";

    /**
     * Uploading file from link to google drive.
     *
     * @param folderId id of folder to upload file
     * @param fileType type of file, eg. "image/png"
     * @param fileNameInDrive name to save file in drive
     * @param pathName path to file to upload to drive
     * @param args
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public static void uploadFile(
            String folderId,
            FileTypes fileType,
            String pathName,
            String fileNameInDrive,
            String... args) throws IOException, GeneralSecurityException {

        File file = getDriveCredentials()
                .files()
                .create(
                        new File()
                                .setParents(Collections.singletonList(folderId))
                                .setName(fileNameInDrive),
                        new FileContent(
                                fileType.getFileType(),
                                new java.io.File(pathName)))
                .setFields("id")
                .execute();

        logger.info(String
                .format(
                        "Saving file %s with ID: %s ",
                        fileNameInDrive,
                        file.getId()));
    }

    /**
     * Creating folder with custom name in drive.
     *
     * @param folderName name of creating folder
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public static String createFolder(
            String folderName
    ) throws GeneralSecurityException, IOException {

        File file = getDriveCredentials()
                .files()
                .create(
                        new File()
                                .setName(folderName)
                                .setMimeType("application/vnd.google-apps.folder"))
                .setFields("id")
                .execute();

        String folderId = file.getId();

        logger.info(String
                .format(
                        "Adding folder %s with ID: %s ",
                        folderName,
                        folderId));

        return folderId;
    }

    /**
     * Gets custom length list of files in drive.
     *
     * @param pageSize length of files list
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public static void getFilesList(
            int pageSize
    ) throws GeneralSecurityException, IOException {

        FileList result = getDriveCredentials()
                .files()
                .list()
                .setPageSize(pageSize)
                .setFields("nextPageToken, files(id, name)")
                .execute();

        List<File> files = result.getFiles();

        if (files == null || files.isEmpty()) {
            logger.info("No files found.");
        } else {
            logger.info("Files list:");
            for (File file : files) {
                logger.info(String
                        .format("%s (%s)%n", file.getName(), file.getId()));
            }
        }
    }

    /**
     * Gets drive credentials.
     *
     * VERY IMPORTANT! MUY IMPORTANTE! SŁUCHAJ CZŁOWIEKU!
     * If you see com.google.api.client.auth.oauth2.TokenResponseException with:
     * 400 Bad Request
     * error - invalid_grant
     * error_description - Bad Request
     * you probably needs delete folder tokens from main path with its content
     * and run this again, in order to generate new drive access token.
     *
     * @return drive credentials
     * @throws GeneralSecurityException
     * @throws IOException
     */
    private static Drive getDriveCredentials() throws GeneralSecurityException, IOException {

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport
                .newTrustedTransport();

        return new Drive.Builder(
                HTTP_TRANSPORT,
                JACKSON_FACTORY,
                getCredentials(HTTP_TRANSPORT, SCOPES))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

}
