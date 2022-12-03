package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions( 
      
		features = {"src/test/resources/features/GET_Single_User.feature"},
		glue = { "userApi", "config" },
		
		plugin = { "pretty", "html:target/LmsBdd.html" },
		monochrome = true)
public class GET_singleUser_validID_Runner extends AbstractTestNGCucumberTests {
	
	 @Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }	

}
