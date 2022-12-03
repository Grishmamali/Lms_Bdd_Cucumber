package config;

	import java.io.File;
	import java.io.FileInputStream;
	import java.util.Properties;

	public class Readconfig {

		Properties pro;
		
		public Properties init_prop()
		{
			File src = new File("./Configurationfiles/config.properties");

			try {
				FileInputStream fis = new FileInputStream(src);
				pro = new Properties();
				pro.load(fis);
			} catch (Exception e) {
				System.out.println("Exception is " + e.getMessage());
			}
			return pro;
		}
		
	}




