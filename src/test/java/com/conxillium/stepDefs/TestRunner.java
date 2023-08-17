package com.conxillium.stepDefs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/conxillium/stepDefs"},
        monochrome = true,
        plugin = {"pretty", "html:target/HtmlReports.html"},
        tags = "@Test"
)

public class TestRunner {

}
