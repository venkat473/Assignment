package programs1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class PomExe 
{
	 @Test
	 public void withpomExcecution() throws Exception
	 {
		System.setProperty("webdriver.chrome.driver","D:\\driverz\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://growthzonedev.com/auth");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		AddContactPage1  ac1=PageFactory.initElements(driver,AddContactPage1 .class);
		ac1.login("ravi.kiran@mailinator.com","qwerty123");
		AddContactPage2  gwp=PageFactory.initElements(driver, AddContactPage2 .class);
		gwp.contactsClick();
		gwp.clickActions();
		gwp.addIndividual("Dr","John","Danny","Boyic","Jr","Danny","4751117777","Main","station1","Line street","Londun","521227","United kingdom","Mailing","Shipping","Jonh Secu","Micus");
		gwp.validation();                                                                                                                                   
	}

}
