package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features/registration.feature",
                "src/test/resources/features/login.feature",
                "src/test/resources/features/openNewAccount.feature"

        },
        glue = {"stepdefinitions","hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class TestRunners {

}
