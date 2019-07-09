package programs1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddContactPage1 
{
	//Page Elements
		@FindBy(name="Username")
		public WebElement uname;
		
		@FindBy(name="Password")
		public WebElement pword;
		
		
		@FindBy(id="sign-up-button")
		public WebElement signin;
		

		//Methods
		
		public void login(String x,String y)
		{
			uname.sendKeys(x);
			pword.sendKeys(y);
			signin.click();
		}


	
	

}
