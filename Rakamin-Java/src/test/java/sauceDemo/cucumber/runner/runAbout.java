package sauceDemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/sauceDemo/cucumber/features/about.feature",
        glue = "sauceDemo.cucumber.stepDef",
        plugin = {"html:target/HTML_report-3.html"}
)
public class runAbout {
}
