package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils 
{
 
	public String getDataFromPropertiesFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("src\\test\\resources\\Solar_PropertiesFile\\Solar_LoginPage.properties.txt");
		
		Properties p = new Properties();
		
		p.load(fis);
		
	    String value =	p.getProperty(key);
	   
	    return value;
	}

}
