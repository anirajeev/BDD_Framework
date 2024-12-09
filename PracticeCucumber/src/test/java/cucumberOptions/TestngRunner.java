package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/GreenkartPage.feature",glue= "stepdefinitions",
monochrome=true,tags="@smokeTesting",
plugin= {"pretty","html:target/report.html"})
public class TestngRunner extends AbstractTestNGCucumberTests{

}
