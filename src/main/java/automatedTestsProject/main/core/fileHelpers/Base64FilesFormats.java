package automatedTestsProject.main.core.fileHelpers;

public enum Base64FilesFormats {

    PNG("png");

    private String fileFormat;

    Base64FilesFormats(
            String fileFormat
    ) {
        this.fileFormat = fileFormat;
    }

    public String getFileFormat() {
        return fileFormat;
    }
}
