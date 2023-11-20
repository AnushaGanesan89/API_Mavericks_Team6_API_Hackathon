package api.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".\\src\\test\\resources\\Features"},
		glue = {"api.StepDefinitions"},
		plugin =  {"pretty", "json:target/CucumberTestReport.json", "html:target/CucumberTestReport.html",
		
				"junit:target/cucumber-reports/cucumber.xml",
			"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun=false
		
		
		)
public class Runner {

}
