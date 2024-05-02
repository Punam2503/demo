package POM_Mahadiscom_Solar_Webpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page 
{
	@FindBy(id="useremail")
	private WebElement UserTextfield;
	
	@FindBy(id="password")
	private WebElement PassTextfield;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement lgnbtn;
	

	public WebElement getUserTextfield() {
		return UserTextfield;
	}

	public WebElement getPassTextfield() {
		return PassTextfield;
	}

	public WebElement getLgnbtn() {
		return lgnbtn;
	}
	
	

}
