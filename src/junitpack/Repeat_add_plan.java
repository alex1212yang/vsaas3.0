package junitpack;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.extensions.RepeatedTest;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Repeat_add_plan extends TestCase{

	
	public Repeat_add_plan(String name)  
    {  
        super(name);  
    }  
  
    public static TestSuite suite()  
    {  
        TestSuite suite = new TestSuite();  
      //run times
        suite.addTest(new RepeatedTest(new Repeat_add_plan("test"), 3));  
        return suite;  
    }
	
	//@Test
	public void test() throws Exception {
		//Driver
				System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver.exe");
		//Language	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=en");
		WebDriver driverChrome = new ChromeDriver(options);
				
				driverChrome.manage().window().maximize();
		//Web URL
				driverChrome.navigate().to("https://st-qa-vsaas.kalay.us/");
		
		//Login
				
				Thread.sleep(5000);
				driverChrome.findElement(By.cssSelector("span[data-reactid='.0.1.0.2.1']")).click();
				Thread.sleep(5000);
				driverChrome.findElement(By.id("id_email")).clear();
				driverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driverChrome.findElement(By.id("id_email")).sendKeys("c24571111@gmail.com");
				driverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driverChrome.findElement(By.id("id_password")).clear();
				driverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driverChrome.findElement(By.id("id_password")).sendKeys("Alex2457");
				driverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driverChrome.findElement(By.xpath("//*[@id='submit']")).click();
				Thread.sleep(5000);
			
				
		//Add plan
				
				driverChrome.findElement(By.xpath("//div[@id='header']/div/ul/li[2]/span/span[2]")).click();
				driverChrome.findElement(By.xpath("//*[@id=\"add_card_box\"]/a/div")).click();
				driverChrome.findElement(By.xpath("//*[@id='card_list']/li[2]/div/ul/li/a")).click();
				driverChrome.findElement(By.id("checkoutBtn")).click();
				Thread.sleep(15000);
				driverChrome.switchTo().defaultContent();
				driverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driverChrome.findElement(By.xpath("//*[@id='loadLogin']")).click();
				driverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    driverChrome.findElement(By.id("login_email")).clear();
			    driverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    driverChrome.findElement(By.id("login_email")).sendKeys("wr-qa-buyer@tutk.com");
			    driverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    driverChrome.findElement(By.id("login_password")).clear();
			    driverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    driverChrome.findElement(By.id("login_password")).sendKeys("demo1234");
			    driverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    driverChrome.findElement(By.id("submitLogin")).click();
			    driverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    driverChrome.findElement(By.id("continue")).click();
			    System.out.println("Add plan = pass");
			    
		//sleep 1 min
			    Thread.sleep(60000);
			    
			    driverChrome.close();  
			    driverChrome.quit();
		  		
			}
		}    
