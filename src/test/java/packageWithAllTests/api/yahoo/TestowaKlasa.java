package packageWithAllTests.api.yahoo;

import automatedTestsProject.main.yahoo.CreateYahooRequest;
import org.junit.jupiter.api.Test;
import packageWithAllTests.api.AbstractTest;

public class TestowaKlasa extends AbstractTest {

    private packageWithAllTests.api.yahoo.AbstractTest abstractTest = new packageWithAllTests.api.yahoo.AbstractTest();

    @Test
    public void sss() {

        abstractTest.runDriver();

        CreateYahooRequest.createRequestSpecificationTokenToYahoo(
                "dj0yJmk9Sk11QTEzTHA4QzVYJnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PTc3",
                "739790006dcdf19ed99ed7954c3f8d3f39897d35")
        .log()
        .all();
    }
}
