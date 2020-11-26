package automatedTestsProject.main.core.generators;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeGenerator {

    private LocalTime currentLocalTime = LocalTime.now();
    private TimeFormat timeFormat;

    public TimeGenerator(TimeFormat timeFormatValue) {

        this.timeFormat = timeFormatValue;
    }

    /**
     * Creates String of current time in different formats.
     *
     * @return time in String
     */
    public String getCurrentTime() {

        switch (timeFormat) {

            case COLON:
                return currentLocalTime
                        .format(DateTimeFormatter
                                .ofPattern("HH:mm:ss"));

            case WITHOUT_SEPARATOR:
                return currentLocalTime
                        .format(DateTimeFormatter
                                .ofPattern("HHmmss"));

            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Creates String of current time in different formats.
     *
     * @return time in String
     */
    public String getCurrentTimeInMilli() {

        switch (timeFormat) {

            case COLON:
                return currentLocalTime
                        .format(DateTimeFormatter
                                .ofPattern("HH:mm:ss:AAAA"));

            case WITHOUT_SEPARATOR:
                return currentLocalTime
                        .format(DateTimeFormatter
                                .ofPattern("HHmmssAAAA"));

            default:
                throw new IllegalArgumentException();
        }
    }

    public LocalTime getCurrentLocalTime() {

        return currentLocalTime;
    }

}
