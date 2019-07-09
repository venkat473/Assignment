package programs;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

        public class Bigbasket 
        {
	    @Test
	    public void bigBasket() throws Exception   
	    {
		//Launchsite
		System.setProperty("webdriver.chrome.driver","D:\\driverz\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bigbasket.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@qa='searchBar']")).sendKeys("Beauty & Grooming");
		driver.findElement(By.xpath("//*[@qa='searchBtn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@qa='searchBar']")).sendKeys("Lakme - Nail Colour Remover");
		driver.findElement(By.xpath("//*[@qa='searchBtn']")).click();
		Thread.sleep(2000);
		WebElement e=driver.findElement(By.xpath("//a[contains(text(),'Nail Colour Remover')]"));
		JavascriptExecutor ja=(JavascriptExecutor)driver;
		ja.executeScript("arguments[0].scrollIntoView();",e);
		
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		Thread.sleep(3000);
		//(//a[text()='Continue'])[1]
		driver.findElement(By.xpath("(//a[text()='Continue'])[1]")).click();
		Thread.sleep(2000);
		WebElement e1=driver.findElement(By.xpath("//span[contains(text(),'My Basket')]"));
		Actions a=new Actions(driver);
		a.moveToElement(e1).build().perform();
		Thread.sleep(2000);
		String x=driver.findElement(By.xpath("//span[contains(text(),'items')]")).getText();
		System.out.println(x);
		
		
	    }
        }
