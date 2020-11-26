package automatedTestsProject.main.core.fileHelpers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class ReadPdfFile {

    private String pathToFile;

    public ReadPdfFile(
            String pathToFileValue
    ) {
        this.pathToFile = pathToFileValue;
    }

    public String readPdfFromFileToString() throws IOException {

        PDDocument pdfFile = PDDocument
                .load(new File(pathToFile));

        String pdfInString = new PDFTextStripper()
                .getText(pdfFile);

        pdfFile.close();

        System.out.println(pdfInString);

        return pdfInString;

    }
}
