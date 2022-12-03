package utility;

	import java.io.File;
	import java.io.FileInputStream;
	import java.util.Properties;

	public class Readconfig {

		Properties pro;
		
		public Readconfig()
		{
			File src = new File("./Configurationfiles/Config.properties");

			try {
				FileInputStream fis = new FileInputStream(src);
				pro = new Properties();
				pro.load(fis);
			} catch (Exception e) {
				System.out.println("Exception is " + e.getMessage());
			}
		}
		
		public String getApplicationURL()
		{
			String url=pro.getProperty("baseurl");
			return url;
		}
		
		public String getUsername()
		{
		String username=pro.getProperty("username");
		return username;
		}
		public String getUsername1()
		{
		String username1=pro.getProperty("username1");
		return username1;
		}
		public String getPassword()
		{
		String password=pro.getProperty("password");
		return password;
		}
		public String getPassword1()
		{
		String password1=pro.getProperty("password1");
		return password1;
		}
		
		
	}




