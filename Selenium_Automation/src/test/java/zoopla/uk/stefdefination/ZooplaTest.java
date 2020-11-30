package zoopla.uk.stefdefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZooplaTest {

		public void tc() throws IOException, InterruptedException {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.zoopla.co.uk");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//button[@class='ui-button-primary ui-cookie-accept-all-medium-large']")).click();		
			driver.findElement(By.linkText("Sign in")).click();
			ArrayList<String> userName = readExcelData(0);
			ArrayList<String> password = readExcelData(1);
			for (int i = 0; i < userName.size(); i++) {
			driver.findElement(By.id("signin_email")).sendKeys(userName.get(i));
			driver.findElement(By.id("signin_password")).sendKeys(password.get(i));
			driver.findElement(By.id("signin_submit")).click();
			Thread.sleep(5000);
			//driver.close();
			//driver.quit();
		}
		}
		
		public ArrayList<String> readExcelData(int cloNo) throws IOException {
			FileInputStream file = new FileInputStream("C:\\Users\\alamm\\git\\Selenium_Automation\\Selenium_Automation\\PMCTestData\\TestData.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("testData");
			Iterator<Row> rowiterator = sheet.iterator();
			rowiterator.next();
			
			ArrayList<String> list = new ArrayList<String>();
			while (rowiterator.hasNext()) {
				list.add(rowiterator.next().getCell(cloNo).getStringCellValue());
			}
			System.out.println("List ::: " + list);
	        return list;
		}

		
		public static void main(String[] args) throws IOException, InterruptedException {
			ZooplaTest data = new ZooplaTest();
			data.readExcelData(0);
			data.readExcelData(1);
			data.tc();
		}
	}

