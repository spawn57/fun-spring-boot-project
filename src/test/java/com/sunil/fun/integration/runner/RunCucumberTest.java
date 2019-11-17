package com.sunil.fun.integration.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
    glue = {"classpath:com.sunil.fun.integration.steps", "com.foreach.cuke"},
    plugin = {"pretty"}, strict = true)
public class RunCucumberTest {
}
