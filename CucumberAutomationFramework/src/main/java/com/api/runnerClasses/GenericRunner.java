package com.api.runnerClasses;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features={"src/main/java/com/api/featureFiles/APIGetMethod.feature"},
		glue = {"com.api.stepDefinitions"},
		dryRun = false,
		monochrome = true
		)
public class GenericRunner extends AbstractTestNGCucumberTests{

}
