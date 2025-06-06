package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = { "steps" }, monochrome = true, plugin = { "pretty",
		"html:target/HtmlReports/index.html" },

		tags = "@SmokeTest"

)

public class RunnerClass {

}
