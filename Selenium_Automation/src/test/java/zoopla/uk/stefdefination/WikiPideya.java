package zoopla.uk.stefdefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
	
	
   /* WebElement element = driver.findElement(By.id("searchLanguage"));
	  Select se = new Select(element);
	//se.selectByValue("ar");
	//se.selectByIndex(0);
	se.selectByVisibleText("العربية");
	*/
	
  /*List <WebElement> list = driver.findElements(By.xpath("//select[@id='searchLanguage']/option"));
    int count = list.size();
    System.out.println("Total languge : "+count); */
    
	/* WebElement element = driver.findElement(By.id("searchLanguage"));
	  Select se = new Select(element);
	  List <WebElement> list = se.getOptions();
	  for(int i =0; i<list.size();i++) {
		  System.out.println(list.get(i).getText());
	  } */
	
	
	List <WebElement> list = driver.findElements(By.xpath("//select[@id='searchLanguage']/option"));  
	  for (int i =0; i<list.size(); i++) {
		  if (list.get(i).getText().equals("Italiano")) {
			  System.out.println("Selected number : "+i+" languge :: "+list.get(i).getAttribute("text"));
			  list.get(i).click();
			  break;
		  }
	  }
    
	}
}
