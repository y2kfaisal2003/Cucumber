package com.api.runnerClasses;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/main/java/com/api/featureFiles/APIGetMethod.feature"},
		glue = {"com.api.stepDefinitions"},
		dryRun = false,
		monochrome = true
		)
public class APIGetMethodRunner {

}
