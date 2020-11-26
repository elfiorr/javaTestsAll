package automatedTestsProject.main.core.generators;

public class MailGenerator {

    private MailFormat mailFormat;

    public MailGenerator(
            MailFormat mailFormatValue
    ) {
        this.mailFormat = mailFormatValue;
    }

    /**
     * Creates String of current date in different formats.
     *
     * @return date in String
     */
    private String generateMail() {

        String currentDate = new DateGenerator(DateFormat.WITHOUT_SEPARATOR).getCurrentDate();
        String currentTime = new TimeGenerator(TimeFormat.WITHOUT_SEPARATOR).getCurrentTime();
        String domain = "@totalmoney.pl";

        switch (mailFormat) {

            case DATE_TIME:
                return new StringBuilder()
                        .append(currentDate)
                        .append(currentTime)
                        .append(domain)
                        .toString();

            default:
                throw new IllegalArgumentException();
        }
    }

    public String getMail() {

        return generateMail();
    }
}
