package CommonUtils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebdriverUtils 
{
	public void Maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void Minimize(WebDriver driver)
	{
		driver.manage().window().maximize();

	}
	
	
	public void ImplcitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void Action(WebDriver driver, WebElement webelementname)
	{
		Actions act = new Actions(driver);
		act.moveToElement(webelementname).perform();
	}
	
   
	
	
	
	
	
	
	
}
