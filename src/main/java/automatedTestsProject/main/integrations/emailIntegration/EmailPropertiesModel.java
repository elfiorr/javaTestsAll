package automatedTestsProject.main.integrations.emailIntegration;

public enum EmailPropertiesModel {

    GMIAL("pop3s", "mail.pop3.starttls.enable", "pop.gmail.com"),
    OUTLOOK("imap","mail.imap.ssl.enable", "poczta.grupawp.pl");


    private String mailProtocol;
    private String mailConfig;
    private String mailHost;

    EmailPropertiesModel(
            String mailProtocol,
            String mailConfig,
            String mailHost
    ) {
        this.mailProtocol = mailProtocol;
        this.mailConfig = mailConfig;
        this.mailHost = mailHost;
    }

    public String getMailProtocol() {
        return mailProtocol;
    }

    public String getMailConfig() {
        return mailConfig;
    }

    public String getMailHost() {
        return mailHost;
    }

}
