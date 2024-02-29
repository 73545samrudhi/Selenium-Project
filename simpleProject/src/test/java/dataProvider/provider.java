package dataProvider;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;







public class provider {
	WebDriver driver;
	@DataProvider(name="getdata")//anotation
	public Object[][] getdata() throws EncryptedDocumentException, IOException{
		
		Extract ext = new Extract(); //create object extract class
	Object[][] data = ext.getdatafromexcel(); //from extract class
		return data;	
	}
	@BeforeMethod
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fothers");
		driver.manage().window().maximize();
	}
	@Test(dataProvider = "getdata")
	  public void register(String FirstN, String LastN, String email, String password, String ConfirmPass) throws InterruptedException {
			
			//locate Register and click on it
			driver.findElement(By.xpath("//a[@class='ico-register']")).click();
					
			//locate FirstName element
			WebElement FirstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
					
			//locate LastName element
			WebElement LastName = driver.findElement(By.xpath("//input[@id='LastName']"));
					
			//locate Email element
			WebElement Email = driver.findElement(By.xpath("//input[@name='Email']"));
					
			//locate Password element
			WebElement Password = driver.findElement(By.xpath("//input[@name='Password']"));
					
			//locate ConfirmPassword element
			WebElement ConfirmPassword = driver.findElement(By.xpath("//input[@name='ConfirmPassword']"));
					
			FirstName.sendKeys(FirstN);
			LastName.sendKeys(LastN);
			Email.sendKeys(email);
			Thread.sleep(2000);
			Password.sendKeys(password);
			ConfirmPassword.sendKeys(ConfirmPass);
			driver.findElement(By.xpath("//button[@id='register-button']")).click();
			Thread.sleep(1000);
			
			
		}
		  
		  
	@AfterMethod
	  public void teardown() {
		  driver.close();
	  }
	  

}
  
  
  
  
  
  
  
  
  
 


