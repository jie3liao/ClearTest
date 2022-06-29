package cc.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.junit.annotations.Concurrent;

@Concurrent
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/cc",
				 glue="cc.step"
				)
public class RunnerIT {}
