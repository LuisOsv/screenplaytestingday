package org.testingday.bdd;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber/reports/dp3-tests.json"},
        features = {"classpath:features/search_wikipedia.feature"},
        glue = {"classpath:org.testingday.bdd.steps"},
        junit = {"--filename-compatible-names"}
)
public class TestRunnerBDD {
}
