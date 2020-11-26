package automatedTestsProject.main.integrations.googleIntegration;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;

import java.util.ArrayList;

/**
 * WIP
 */
public class GmailIntegration extends GoogleIntegrationConfig {

    final static Logger logger = Logger.getLogger(GmailIntegration.class);
    private static final String APPLICATION_NAME = "Gmail Integration";

    private static final List<String> SCOPES = Arrays
            .asList(GmailScopes.GMAIL_MODIFY);

    /**
     * Gets gmail credentials.
     *
     * @return gmail credentials
     * @throws GeneralSecurityException
     * @throws IOException
     */
    protected static Gmail getGmailCredentials() throws GeneralSecurityException, IOException {

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport
                .newTrustedTransport();

        return new Gmail.Builder(
                HTTP_TRANSPORT,
                JACKSON_FACTORY,
                getCredentials(HTTP_TRANSPORT, SCOPES))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    /**
     *
     * @param query
     * @return
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public static List<Message> listMessagesMatchingQuery(
            String query
    ) throws IOException, GeneralSecurityException {

        ListMessagesResponse response = getGmailCredentials()
                .users()
                .messages()
                .list(USER_ID)
                .setQ(query)
                .execute();

        List<Message> messages = new ArrayList<Message>();

        while (response.getMessages() != null) {

            messages.addAll(response.getMessages());

            if (response.getNextPageToken() != null) {

                String pageToken = response.getNextPageToken();
                response = getGmailCredentials()
                        .users()
                        .messages()
                        .list(USER_ID)
                        .setQ(query)
                        .setPageToken(pageToken)
                        .execute();
            } else {
                break;
            }
        }

        for (Message message : messages) {
            System.out.println(message.toPrettyString());
        }

        return messages;
    }

    public static void main(String... args) throws IOException, GeneralSecurityException {

        listMessagesMatchingQuery("is:unread");
    }
}
