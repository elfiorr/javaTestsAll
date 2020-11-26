package automatedTestsProject.main.core.generators;

public class PhoneNumberGenerator {

    private PhoneNumberFormat phoneNumberFormat;

    public PhoneNumberGenerator(PhoneNumberFormat phoneNumberFormatValue) {

        this.phoneNumberFormat = phoneNumberFormatValue;
    }

    public String phoneNumberGenerator() {

        switch (phoneNumberFormat) {

            case DEFAULT_NUMBER:
                return "537715481";

            case NINE_DIGIT_NUMBER:
                return new StringBuilder()
                        .append("999")
                        .append(new TimeGenerator(TimeFormat
                                .WITHOUT_SEPARATOR)
                                .getCurrentTime())
                        .toString();

            default:
                throw new IllegalArgumentException();
        }
    }

}
