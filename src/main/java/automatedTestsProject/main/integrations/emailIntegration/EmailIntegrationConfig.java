package automatedTestsProject.main.integrations.emailIntegration;

import javax.mail.*;
import java.util.Properties;

public class EmailIntegrationConfig {

    private EmailPropertiesModel email;

    public EmailIntegrationConfig(
            EmailPropertiesModel email
    ) {
        this.email = email;
    }

    protected Store createStore() throws MessagingException {

        Properties properties = new Properties();
        properties.setProperty(email.getMailConfig(), "true");

        return Session.getDefaultInstance(properties)
                .getStore(email.getMailProtocol());

    }

}
