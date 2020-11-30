package zoopla.uk.stefdefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WikiPideya {
	
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.wikipedia.org/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
/*	
    WebElement element = driver.findElement(By.id("searchLanguage"));
	  Select se = new Select(element);
	  //se.selectByValue("az");  // Using by value
	  //se.selectByVisibleText("Azərbaycanca"); // Using by text
	  se.selectByIndex(2); // Using by index
*/
	
   /* List <WebElement> list = driver.findElements(By.xpath("//select[@id='searchLanguage']/option"));
    int count = list.size();
    System.out.println("Total languge : "+count); */
    
 /*     WebElement element = driver.findElement(By.id("searchLanguage"));
	  Select se = new Select(element);
	  List <WebElement> list = se.getOptions();
	  for(int i =0; i<list.size();i++) {
		  System.out.println(list.get(i).getText());
	  } 
	*/
	
	List <WebElement> list = driver.findElements(By.xpath("//select[@id='searchLanguage']/option"));  
	 System.out.println(list.size());
	for (int i =0; i<list.size(); i++) {
		  if (list.get(i).getText().equals("Deutsch")) {
			  System.out.println("Selected number : "+i+" languge :: "+list.get(i).getAttribute("text"));
			  list.get(i).click();
			 
		  }
	  } 
/*	
	List<WebElement> list =  driver.findElements(By.xpath("//*[@class='other-project-link']"));
	System.out.println("Total webelement link count num : "+list.size());
	
	for(int i=0; i<list.size();i++) {
		if(i>5) {
		System.out.println(" Selected element number : " +i+"Name of the link : "+list.get(i).getAttribute("text"));
		list.get(i).click();
		break;		
	}		
	}
	
	WebElement obj = driver.findElement(By.id("searchInput"));
	obj.sendKeys("Bangladesh");
	obj.sendKeys(Keys.ENTER);
	
	
	//driver.findElement(By.id("searchInput")).sendKeys("Bangladesh");
	
	*/
    
	}
}
