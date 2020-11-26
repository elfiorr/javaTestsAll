package automatedTestsProject.main.core.fileHelpers;

public enum FileTypes {

    PNG("image/png");

    private String fileType;

    FileTypes(
            String fileType
    ) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }
}
