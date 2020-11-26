package automatedTestsProject.main.core.generators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateGenerator {

    private LocalDate currentLocalDate;
    private DateFormat dateFormat;

    public DateGenerator(DateFormat dateFormatValue) {

        this.currentLocalDate = LocalDate.now();
        this.dateFormat = dateFormatValue;
    }

    /**
     * Creates String of current date in different formats.
     *
     * @return date in String
     */
    public String getCurrentDate() {

        switch (dateFormat) {

            case DASH:
                return currentLocalDate
                        .format(DateTimeFormatter
                                .ofPattern("yyyy-MM-dd"));

            case WITHOUT_SEPARATOR:
                return currentLocalDate
                        .format(DateTimeFormatter
                                .BASIC_ISO_DATE);

            default:
                throw new IllegalArgumentException();
        }
    }

    public LocalDate getCurrentLocalDate(){
        return currentLocalDate;
    }
}
