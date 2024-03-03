package libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class ConfigFile {

	 Properties prop;
	
	public ConfigFile() throws IOException {
		
		File src = new File("./configs/Config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);	
		
	}

	public String getBrowser() {
		return prop.getProperty("Browser");
	}
	
	public  String getURL() {
		return prop.getProperty("URL");
	}
	
}
