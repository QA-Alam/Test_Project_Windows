package com.usa.testNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {

	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void browserSetup(String br) throws Exception {	
		if(br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("I am a chrome browser ");			
		}
		else if (br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("I am a firefox browser ");
			
		}
		else if (br.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			System.out.println("I am a ie browser ");
			
		}
		
		else if (br.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./Driver/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			System.out.println("I am a ie browser ");
			
		}
		else {
			// This is a user define exceptions
			throw new Exception("Browser in not correct");
		}
		
	}
	@Test 
	public void browserTesting() {
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> list = driver.findElements(By.xpath("//select[@id='searchLanguage']/option"));
		System.out.println(list.size());
		System.out.println("I am number one ");
				driver.quit();

			}

}