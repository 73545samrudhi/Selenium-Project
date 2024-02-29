package nopcommers;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class shoes {
	WebDriver driver;
	 ExtentTest test;
	 ExtentReports report;
	 
	 
	 @BeforeClass
	   public void configreport() {
	  report = new ExtentReports(System.getProperty("user.dir")+"\\NopCommerce.html");
		      test = report.startTest("NopCommerceTest");
		    		
		}
	
	
	@BeforeMethod
	public void FirstStep() {
		
		WebDriverManager.chromedriver().setup();//cromedriver path
		
	    driver = new ChromeDriver();
	    test.log(LogStatus.PASS, "Chorme driver has opened successfully");
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
	}
	
	
	@Test(priority = 1)
	  public void FirstShoes() throws InterruptedException { 
		  //mouse over apparel 
	  Actions act = new  Actions(driver);
	  WebElement Apparel = driver.findElement(By.linkText("Apparel"));
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	  act.moveToElement(Apparel).build().perform();
	  
	  
	  //clicking on shoes
	  driver.findElement(By.linkText("Shoes")).click();
	  
	  
	  //Scroll down till products
  JavascriptExecutor js =(JavascriptExecutor)driver; 
	  js.executeScript("window.scrollBy(0,400)");
 
	  //Select first shoes 
	  WebElement addtocart = driver.findElement(By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[1]"));
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  wait.until(ExpectedConditions.elementToBeClickable(addtocart));
	  addtocart.click();
	  
  
  //Enter the size of shoes in size field box
	  driver.findElement(By.id("product_attribute_9")).sendKeys("8");
	  //Scroll down till add to cart button
	    JavascriptExecutor js1 =(JavascriptExecutor)driver; 
	  js1.executeScript("window.scrollBy(0,400)");
	  //click on add to Wishlist
	  driver.findElement(By.id("add-to-wishlist-button-25")).click();
	 
	  //Click on cancel button
	  driver.findElement(By.xpath("//span[@class='close']")).click();
	 Thread.sleep(2000);
	  //click on add to cart
     driver.findElement(By.xpath("//button[@id='add-to-cart-button-25']")).click() ;
       
     Thread.sleep(1000);	  	  
 }
	@Test(priority = 2)
	  public void secondShoes() throws InterruptedException { 
		  //mouse over apparel 
	  Actions act = new  Actions(driver);
	  WebElement Apparel = driver.findElement(By.linkText("Apparel"));
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	  act.moveToElement(Apparel).build().perform();
	  
	  
	  //clicking on shoes
	  driver.findElement(By.linkText("Shoes")).click();
	  
	  
	  //Scroll down till products
JavascriptExecutor js =(JavascriptExecutor)driver; 
	  js.executeScript("window.scrollBy(0,400)");

	  //Select second shoes
	  WebElement addtocart = driver.findElement(By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[2]"));
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  wait.until(ExpectedConditions.elementToBeClickable(addtocart));
	  addtocart.click();
	  

//Enter the size of shoes in size field box
	  driver.findElement(By.id("product_attribute_6")).sendKeys("9");
//	  Scroll down till add to cart button
	    JavascriptExecutor js1 =(JavascriptExecutor)driver; 
	  js1.executeScript("window.scrollBy(0,400)");
	  //enter the color of shoes
	  driver.findElement(By.id("product_attribute_7")).sendKeys("White/Blue");
	  Thread.sleep(1000);
	  //add to cart
     driver.findElement(By.id("add-to-cart-button-24")).click() ;
//      
    Thread.sleep(1000);	  	  
 }
	
	
	@Test(priority = 3)
	public void ThirdProduct() throws InterruptedException, IOException {
		Actions act = new Actions(driver);
		WebElement Apparel  = driver.findElement(By.linkText("Apparel"));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		act.moveToElement(Apparel).build().perform();
		
		//clicking on shoes
		driver.findElement(By.linkText("Shoes")).click();
		 test.log(LogStatus.PASS, "successfully clicked on clothing option");
		
		//Scroll down till products
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		
		//third product add to cart
		WebElement addtocart = driver.findElement(By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[3]"));
		 Thread.sleep(1000);	
	  //add to cart
	     driver.findElement(By.xpath("(//button[@class=\"button-2 add-to-wishlist-button\"])[3]")).click() ; 
		 
	     Thread.sleep(1000);	
	     TakesScreenshot ts = (TakesScreenshot)driver;
			File file1 = ts.getScreenshotAs(OutputType.FILE);
			File file2 = new File("C:\\Users\\OWNER\\Pictures\\project screenshot\\img1.png");
			FileUtils.copyFile(file1, file2);
	}
	
	 @AfterMethod
	 public void TearDown() {
		 driver.close();
	 }
	 
	 @AfterClass
	  public void last() {
		 report.endTest(test);
		 report.flush();
	  }

	}
	


