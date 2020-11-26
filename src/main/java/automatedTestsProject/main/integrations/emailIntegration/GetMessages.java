package automatedTestsProject.main.integrations.emailIntegration;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Store;
import java.io.IOException;

public class GetMessages extends EmailIntegrationConfig {

    private String host;
    private String emailAddress;
    private String emailPassword;
    private Message[] messages;
    private String folderName;

    public GetMessages(
            EmailPropertiesModel email,
            String emailAddress,
            String emailPassword,
            String folderName
    ) throws MessagingException {

        super(email);

        this.host = email.getMailHost();
        this.emailAddress = emailAddress;
        this.emailPassword = emailPassword;
        this.folderName = folderName;
        this.messages = getMessages();

    }

    private Message[] getMessages() throws MessagingException {

        Store store = createStore();
        store.connect(host, emailAddress, emailPassword);

        Folder emailFolder = store.getFolder(folderName);
        emailFolder.open(Folder.READ_ONLY);

        return emailFolder.getMessages();
    }

    public int getNumberOfMessages(){

        return messages.length;
    }

    public Message getNewestMessage(){

        return messages[getNumberOfMessages() - 1];
    }

    public String getSubjectOfNewestMessage() throws MessagingException {

        return getNewestMessage()
                .getSubject();
    }

    public String getFromOfNewestMessage() throws MessagingException {

        return getNewestMessage()
                .getFrom()[0]
                .toString();
    }

    public String getTextOfNewestMessage() throws MessagingException, IOException {

        return getNewestMessage()
                .getContent()
                .toString();
    }

    public String getDateOfNewestMessage() throws MessagingException {

        return getNewestMessage()
                .getSentDate()
                .toString();
    }

}
