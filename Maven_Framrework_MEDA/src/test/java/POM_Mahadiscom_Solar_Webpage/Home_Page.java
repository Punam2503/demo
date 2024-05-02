package POM_Mahadiscom_Solar_Webpage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page 
{
   @FindBy(xpath="(//a[@class='nav-item-hold'])[4]")
   private WebElement Report;
   
   @FindBy(xpath="(//span[@class='item-name'])[5]")
   private WebElement B_AbstractReport;
   
   
   @FindBy(xpath="//*[local-name()='svg']//*[name()='g']//*[@aria-hidden='true']")
   private String Statgraphvalue;
   

   public String getStatgraphvalue() {
	return Statgraphvalue;
}

public WebElement getReport() 
   {
	return Report;
   }

   public WebElement getB_AbstractReport() 
   {
	return B_AbstractReport;
   }
   

   
	
}
