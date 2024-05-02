package BaseClass_POM_Mahadisc_solar_web;

import java.io.IOException;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.FileUtils;
import CommonUtils.WebdriverUtils;
import POM_Mahadiscom_Solar_Webpage.Home_Page;
import POM_Mahadiscom_Solar_Webpage.Login_Page;

public class Stat_graph_Matched_with_ReportTotal_Base 
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
		Thread.sleep(10000);
		
	   
		String excep = driver.findElement(By.xpath("((//*[local-name()='svg']//*[@class=\"highcharts-label highcharts-data-label highcharts-data-label-color-0\"])[1]//*[name()='tspan'])[1]")).getText();
		Thread.sleep(2000);
		System.out.println(excep);
		Thread.sleep(5000);
		
		WebElement	Report = driver.findElement(By.xpath("(//a[@class='nav-item-hold'])[4]"));
		Actions act = new Actions(driver);
		act.moveToElement(Report).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='item-name'])[5]")).click();
		Thread.sleep(5000);
		String actualres =driver.findElement(By.xpath("(//table[@class='data_table table table-bordered']/tbody/tr[\" + r + \"]/td[\" + c + \"])[2249]")).getText();
		System.out.println(actualres);
		
		
		if(excep == actualres)
		{
			System.out.println("report total are matched");
		}
		else
		{
			System.out.println("report total are not matched");
		}
		

		
		
		
		
   	 
 		
//		Thread.sleep(3000);
//     	List<WebElement> dataLabels = driver.findElements(By.xpath("//*[local-name()='g' and contains(@class, 'highcharts-data-labels')]//*[name()='text']"));
//     	
//		Thread.sleep(3000);
//		System.out.println(dataLabels.size());
//		String labelText= " ";
//		for (WebElement label : dataLabels) 
//		{
//		     labelText = label.getText();
//		   
//		    System.out.println("Data label text: " + labelText);
//		}
	   
	
 		

 		


		
	}
}

