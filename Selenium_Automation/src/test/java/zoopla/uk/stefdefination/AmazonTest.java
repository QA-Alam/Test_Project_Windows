package zoopla.uk.stefdefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonTest {
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	Actions action = new Actions(driver);
	WebElement mousHover =driver.findElement(By.id("nav-link-accountList"));
	action.moveToElement(mousHover);//.build().perform();
	action.click().build().perform();
	//action.doubleClick(mousHover).build().perform();
	
	
	
}
	
}
