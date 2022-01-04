package com.jet.framework.TestRunner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(  
	    features = "src/test/java/com/jet/framework/test/Features",
	    glue="com/jet/framework/stepDefinitions",
	    tags="@Regression",
	    monochrome=true,
	    plugin= {"pretty","html:target/cucumber","json:target/cucumber/cucumber.json","junit:target/cukes.xml"})

public class TestRunner {
	

}
