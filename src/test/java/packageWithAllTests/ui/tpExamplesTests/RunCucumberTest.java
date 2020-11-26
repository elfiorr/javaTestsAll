package packageWithAllTests.ui.tpExamplesTests;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@Category(value = CucumberTests.class)
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/pl.totalmoney.rd/", glue="pl.totalmoney.rd", plugin = {"pretty", "html" +
        ":target/Destination"})
public class RunCucumberTest {
}
