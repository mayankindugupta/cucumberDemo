package com.nxtgenai.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "FeatureFiles",
glue = "com.nxtgenai.stepdefinition")
public class RunnerClass {

}


//./FeatureFiles/parabankLoginDataDriven.feature
//https://www.toolsqa.com/cucumber/cucumber-options/
/*@CucumberOptions(features = "FeatureFiles",
glue = "com.nxtgenai.stepdefinition",
dryRun = false,
monochrome = false,
plugin= {"html:reports/cucumber-report.html","json:reports/cucumberJsonReport.json"},
tags = "@smoke"
)
*/