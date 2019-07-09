package programs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MultipleItems {
	@Test
	public void main() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\driverz\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com");

		WebDriverWait w = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement e = driver.findElement(By.xpath("//a[contains(text(),'Shop by Category')]"));

		Actions a = new Actions(driver);
		a.moveToElement(e).build().perform();

		a.moveToElement(driver.findElement(By.partialLinkText("Fruits & Vegetables"))).click().build().perform();
		Thread.sleep(2000);
		String count1 = driver.findElement(By.xpath("//h2[contains(text(),'(422)')]")).getText();
		System.out.println(count1);

		// scroll down
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(4000);

		WebElement e1 = driver.findElement(By.xpath("//button[text()='Show More']"));

		Thread.sleep(2000);
		do {
			js.executeScript("arguments[0].scrollIntoView();", e1);
			js.executeScript("arguments[0].click();", e1);
			if (!(e1).isDisplayed()) {
				break;
			}

		} while (2 > 1);

		List<WebElement> l = driver.findElements(
				By.xpath("//div[@class='items']/descendant::div[@class='col-sm-12 col-xs-7 prod-name']/a"));
		int size = l.size();
		System.out.println("actual fruits and vegitables (" + size + ")");

		if (count1.contains(Integer.toString(size))) {
			System.out.println("showed count is matched with the actual fruits and vegitables");
		} else {
			System.out.println("showed count is not matched with the actual fruits and vegitables");
		}

	}
}
