package testRunner;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.platform.engine.Constants;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("Features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "stepDefinitions")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@activity3")
@ConfigurationParameter(
	key = Constants.PLUGIN_PROPERTY_NAME,
	value = "pretty, html:Reports/HTML_Report.html, junit:Reports/XML_Report.xml, json:Reports/JSON_Report.json"
)


//@RunWith(Cucumber.class)
//@CucumberOptions(
//		features="src/test/java/features/Activity5.feature",
//		glue= {"stepDefinitions"}
//		//, dryRun=true	
//		)


public class Activity7_ActivitiesRunner {
	

}
