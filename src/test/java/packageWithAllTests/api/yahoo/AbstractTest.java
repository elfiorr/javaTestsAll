package packageWithAllTests.api.yahoo;

import automatedTestsProject.main.core.driverConfigs.WebDriverConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class AbstractTest {

    protected WebDriver driver;
    public final String YAHOO_URL_TO_CODE = "https://api.login.yahoo.com/oauth2/request_auth?client_id=dj0yJmk9Sk11QTEzTHA4QzVYJnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PTc3&redirect_uri=https://exemplary2.redirect.uri.com&response_type=code";
    public final String YAHOO_URL_TO_CODE2 = new StringBuilder(
            "https://api.login.yahoo.com/oauth2/request_auth?client_id=dj0yJmk9Sk11QTEzTHA4QzVYJnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PTc3&response_type=code&redirect_uri=" + "https" + ":" + "//")
            .append("exemplary2.redirect.uri.com")
            .toString();

    public static final String FILE_NOT_FOUND_EXCEPTION_MESSAGE =
            "Correct resources env file name not provided";

    public AbstractTest() {

        String featureName = "";

        try {
            this.driver = WebDriverConfig.getWebDriver(featureName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        driver.manage()
                .window()
                .setSize(new Dimension(1920, 1020));
    }

    public void runDriver() {

        driver.get("https://google.com");
        driver.navigate().to("https://api.login.yahoo.com/oauth2/request_auth?client_id=dj0yJmk9Sk11QTEzTHA4QzVYJnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PTc3&redirect_uri=https://exemplary2.redirect.uri.com&response_type=code");
        String x = driver.getCurrentUrl();
        System.out.println(x);
//
//        String partOfUrl = x.substring(x.indexOf(".") + 1);
//        String partOfUrl2 = x.contains();
//        System.out.println(partOfUrl.substring(0, (partOfUrl.indexOf(".") + 2)));
//        System.out.println(partOfUrl2.substring(0, (partOfUrl.indexOf(".") + 2)));

    }
}
