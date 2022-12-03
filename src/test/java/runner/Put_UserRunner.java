package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
		features = {"src/test/resources/features/PUT_User.feature"},
		glue = { "userApi", "config" },
		
		plugin = { "pretty", "html:target/LmsBdd.html" },
		monochrome = true)
public class Put_UserRunner extends AbstractTestNGCucumberTests {

	 @Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }	
}
