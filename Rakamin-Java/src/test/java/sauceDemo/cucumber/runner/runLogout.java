package sauceDemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/sauceDemo/cucumber/features/logout.feature",
        glue = "sauceDemo.cucumber.stepDef",
        plugin = {"html:target/HTML_report-4.html"}
)
public class runLogout {
}
