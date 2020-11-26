package automatedTestsProject.main.core.fileHelpers;

import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

/**
 * This class provides methods for decoding base64 to a file
 */
public class Base64Decoder {

    private String base64String;
    private String fileName;
    private String pathName;
    private Base64FilesFormats base64FilesFormat;

    /**
     *
     * @param base64String
     * @param fileName name of file created from decoded Base64 String
     * @param pathName path to place where file will be saved - needs to end with "/"
     * @param base64FilesFormat file after decoding format
     * @see <a href="https://en.wikipedia.org/wiki/Base64">Base64 - Wikipedia</a>
     */
    public Base64Decoder(
            String base64String,
            String fileName,
            String pathName,
            Base64FilesFormats base64FilesFormat
    ) {
        this.base64String = base64String;
        this.fileName = fileName;
        this.pathName = pathName;
        this.base64FilesFormat = base64FilesFormat;
    }

    /**
     * Decodes Base64 to file.
     */
    public void convertBase64ToFile() {

        Base64 decoder = new Base64();
        byte[] imgBytes = decoder
                .decode(base64String);

        BufferedImage bufImg = null;

        try {
            bufImg = ImageIO
                    .read(new ByteArrayInputStream(imgBytes));
        } catch (IOException e) {
            e.printStackTrace();
        }

        File imgOutFile = new File(
                pathName
                        .concat(fileName)
                        .concat(".")
                        .concat(base64FilesFormat.getFileFormat()));

        try {
            ImageIO.write(
                    bufImg,
                    base64FilesFormat.getFileFormat(),
                    imgOutFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
