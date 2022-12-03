package config;

import java.io.IOException;
import java.util.Properties;

import io.cucumber.java.Before;

public class ConfigProperties {

	private Readconfig readconfig;
	public static Properties prop;

	@Before(order = 0)
	public void getProperty() throws IOException {
		readconfig = new Readconfig();
		prop = readconfig.init_prop();
	}
}
