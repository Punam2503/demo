package BaseClass_POM_Mahadisc_solar_web;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.FileUtils;
import CommonUtils.WebdriverUtils;
import POM_Mahadiscom_Solar_Webpage.Home_Page;
import POM_Mahadiscom_Solar_Webpage.Login_Page;

public class Abstract_B_Report_SumMatched_Base 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		
		//DROPDOWN TABLE FOR B2 PM KUSUM ABSTRACT 
		
		final WebDriver driver;
		
		WebdriverUtils wutils = new WebdriverUtils();
		FileUtils futils = new FileUtils();
		
		
		String BROWSER  =  futils.getDataFromPropertiesFile("Browser");
		String URL      =  futils.getDataFromPropertiesFile("url");
		String USERNAME =  futils.getDataFromPropertiesFile("Username");
		String PASSWORD =  futils.getDataFromPropertiesFile("password");
		
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}else if(BROWSER.equals("Edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		
		wutils.Maximize(driver);
		
		wutils.ImplcitWait(driver);
		
		driver.get(URL);
		
		Login_Page l1 = new Login_Page();
		
		PageFactory.initElements(driver,l1);
		l1.getUserTextfield().sendKeys(USERNAME);
		l1.getPassTextfield().sendKeys(PASSWORD);
		l1.getLgnbtn().click();
		
		
		Home_Page h1 = new Home_Page();
		PageFactory.initElements(driver,h1);
		
		wutils.Action(driver, h1.getReport());
		Thread.sleep(1500);
		h1.getB_AbstractReport().click();
		Thread.sleep(5000);
		
		int actualSum = 0;
		int Expectedsum=0;
		WebElement data;
		for (int r = 1; r <= 1; r++) 
		{
		    for (int c = 3; c <=6; c++) 
		    {
		    	//xpath for all the rows and coloumn are selected
		       data  = driver.findElement(By.xpath("//table[@class='data_table table table-bordered']/tbody/tr[" + r + "]/td[" + c + "]"));
		       System.out.println("Row " + r + ", Column " + c + ": " + data.getText());
		        
		        if(c <= 5)
		        {
		       	    int number = Integer.parseInt(data.getText());
		       	    Expectedsum = Expectedsum + number;
		       	}
                 
		        if(c == 6)
		        {
		        int number = Integer.parseInt(data.getText());
		        actualSum += number;
		         
		        }  		 
		    }
		}
		
          System.out.println("Expectedsum" + Expectedsum);
          System.out.println("actualsum" + actualSum);
          
          if(Expectedsum == actualSum)
          {
        	  System.out.println("total sum matched");
          }
          else
          {
        	  System.out.println("total sum matched is not matched");
          }
      }
	}
