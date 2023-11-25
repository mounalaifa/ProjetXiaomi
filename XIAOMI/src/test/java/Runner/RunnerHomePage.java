package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions (
		features = "src/test/resources/Features/HomePage.feature",
		glue="TestSuites",
		plugin= {"pretty","html:target/cucumber-report.html"}
		
		)

public class RunnerHomePage {
	

}
