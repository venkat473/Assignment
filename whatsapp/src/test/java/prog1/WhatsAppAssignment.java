package prog1;

import java.io.BufferedWriter;
import java.io.FileWriter;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WhatsAppAssignment {

	public static WebDriver driver;

	@BeforeClass
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "D:\\driverz\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://web.whatsapp.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void execution() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Get notified of new messages']")));
		driver.findElement(By.xpath(
				"//body[@class='web']/div[@id='app']/div[@class='_1FPJ- _39gtr app-wrapper-web']/div[@class='app _3fUe9 two']/div[@class='_3HZor _3kF8H']/div[@id='side']/div[@id='pane-side']/div/div/div[@class='_3La1s']/div[1]/div[1]/div[1]/div[2] "))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='hnQHL'])[2]")));

		String message = driver
				.findElement(By.xpath(
						"(//*[@class='_1_q7u']/descendant::div[@class='_1zGQT _2ugFP message-in tail'])[last()]"))
				.getText();
		System.out.println(message);

		FileWriter fw = new FileWriter("F:\\output\\result.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(message);

		bw.newLine();
		bw.close();

	}

	@AfterClass
	public void closeSite() {
		driver.close();
	}

}
