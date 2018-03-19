package junitpack;

import java.lang.annotation.Repeatable;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.extensions.RepeatedTest;  
import junit.framework.Test; 
import junit.framework.TestCase;  
import junit.framework.TestSuite;  
//import org.openqa.selenium.ie.InternetExplorerDriver;

import junit.extensions.RepeatedTest;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class junit_webpage_response_time_vtech2 extends TestCase{

	//次數
	public junit_webpage_response_time_vtech2(String name)  
    {  
        super(name);  
    }  
  
    public static Test suite()  
    {  
        TestSuite suite = new TestSuite();  
        suite.addTest(new RepeatedTest(new junit_webpage_response_time_vtech2("test"), 50));  
        return suite;  
    }

	int		i, count;
	String	strChromeDriver = "C:/ChromeDriver.exe", 
			strTargetURL = "https://stg-vsaas-f2e-vtech.kalayservice.com/";
			//strTargetURL = "https://myvtechcams.vtech.com/";
	String	xpathLoginOnWelcom = "//*[@id=\"root\"]/div/section/form/div[1]/span",
			xpathIconOnWelcome = "//*[@id=\"root\"]/div/section/form/div[2]/div[1]/div[1]", 
			xpathEmailOnOAuth = "//*[@id=\"id_email\"]", 
			xpathLoginOnOAuth = "//*[@id='submit']", 
			xpathPlanMgmt = "//*[@id=\"header\"]/div/ul/li[2]/span/span[2]", 
			xpathPlanAdd = "//*[@id=\"add_card_box\"]/a", 
			xpathPlanfirstbutton = "//*[@id=\"card_list\"]/li[1]/div/ul/li/a/div",
			xpathCheckoutBtn = "//*[@id=\"checkoutBtn\"]",
			//xpathSandbox_cancel_return = "//*[@id=\"cancel_return\"]",
			//xpathSandbox_cancel_return = "//a[@href='/webapps/hermes/']",
			
			xpathUserInfo = "//*[@id=\"header\"]/div/ul/li[3]/span/span[2]", 
			xpathViewInvoice = "//*[@id=\"root\"]/div/div[2]/div[2]/ul/li[1]/small/a", 
			xpathBuyInfo = "//*[@id=\"root\"]/div/div[2]/div[1]/h2/span", 
			xpathBack = "//*[@id=\"root\"]/div/div[2]/div[1]/h2/span[1]", 
			xpathLogout = "//*[@id=\"root\"]/div/div[2]/div[2]/ul/li[2]/small/a";
	long	t1,		// Start of test 
			t2, 	// time of clicking login button on Welcome Page
			t3, 	// time of finding email field on OAuth login Page
			t4, 	// Device List Page
			t5, 	// Plan Mgmt. Page
			t6,		// Add New Plan Page
			t7, 	// back from Checkout Page
			t8, 
			t9, 
			t10, 
			t11;

   // @Test
	public void test() throws Exception {
		//System.setProperty("webdriver.gecko.driver", "C:/Users/alexyang/Desktop/geckodriver.exe");
//		System.setProperty("webdriver.ie.driver", "D:/IEDriverServer.exe");
		//迴圈
		//for(int j = 0 ; j < 10; j++){
		System.setProperty("webdriver.chrome.driver", strChromeDriver);
		
//		IE
//		WebDriver driverChrome= new InternetExplorerDriver();
			
//		Firefox change language
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("intl.accept_languages", "en");
//		WebDriver driverChrome = new FirefoxDriver(profile);
		
		// Chrome change language		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=en");
		WebDriver driverChrome = new ChromeDriver(options);
		
		driverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//		driverChrome.manage().window().maximize();
		
		// navigate to Welcome page
		t1 = System.currentTimeMillis();
System.out.println("t1=" + t1);

		driverChrome.navigate().to(strTargetURL);
		
		
		{
			WebElement	weWelcome, 
						weEmail, 
						weOAuthLogin, 
						wePlanMgmt, 
						weAddPlan, 
						wePlanfirstbutton,
						weCheckoutBtn,
						weSandbox_cancel_return,
						weChooseMonthlyPlan, 
						weBack;
			
			for (i = 0; i < 50; i++) {
				weWelcome = driverChrome.findElement(By.xpath(xpathLoginOnWelcom));
				t2 = System.currentTimeMillis();
				if (weWelcome instanceof WebElement) {
					try {
						weWelcome.click();
						break;
					} catch (Exception ignored) {
						;
					}
				}
				Thread.sleep(200);
			}
			System.out.println("t2=" + t2);
			
//*[@id="root"]/div/div[2]/span

			// wait for 'Login' button on OAuth page
			for (i = 0; i < 50; i++) {
				weEmail = driverChrome.findElement(By.xpath(xpathEmailOnOAuth));
				t3 = System.currentTimeMillis();
				if (weEmail instanceof WebElement) {
					try {
						weEmail.click();
						break;
					} catch (Exception ignored) {
						;
					}
				}
				Thread.sleep(200);
			}
			System.out.println("t3=" + t3);
		
			// input 'Email', 'Password', and click 'Login' button
			driverChrome.findElement(By.id("id_email")).sendKeys("c24571111@gmail.com");
			//driverChrome.findElement(By.id("id_password")).clear();
			driverChrome.findElement(By.id("id_password")).sendKeys("Alex2457");
			weOAuthLogin = driverChrome.findElement(By.xpath(xpathLoginOnOAuth));
			weOAuthLogin.click();
			
			// wait for 'Plan Mgmt.' can be clicked
			for (i = 0; i < 50; i++) {		// wait maximum time is 10,000 milliseconds
				wePlanMgmt = driverChrome.findElement(By.xpath(xpathPlanMgmt));
				t4 = System.currentTimeMillis();
				if (wePlanMgmt instanceof WebElement) {
					try {
						wePlanMgmt.click();
						break;
					} catch (Exception ignored) {
						;
					}
				}
				Thread.sleep(200);
			}
			System.out.println("t4=" + t4);

			// wait 'Add Plan' element
			for (i = 0; i < 50; i++) {		// wait maximum time is 10,000 milliseconds
				weAddPlan = driverChrome.findElement(By.xpath(xpathPlanAdd));
				t5 = System.currentTimeMillis();
				if (weAddPlan instanceof WebElement) {
					try {
						weAddPlan.click();
						break;
					} catch (Exception ignored) {
						;
					}
				}
				Thread.sleep(200);
			}
			System.out.println("t5=" + t5);

			//wait 'xpathPlanfirstbutton' element
			for (i = 0; i < 50; i++) {		// wait maximum time is 10,000 milliseconds
				wePlanfirstbutton = driverChrome.findElement(By.xpath(xpathPlanfirstbutton));
				t6 = System.currentTimeMillis();
				if (wePlanfirstbutton instanceof WebElement) {
					try {
						wePlanfirstbutton.click();
						break;
					} catch (Exception ignored) {
						;
					}
				}
				Thread.sleep(200);
			}
			System.out.println("t6=" + t6);

			//wait 'xpathCheckoutBtn' element
			for (i = 0; i < 50; i++) {		// wait maximum time is 10,000 milliseconds
				weCheckoutBtn = driverChrome.findElement(By.xpath(xpathCheckoutBtn));
				t7 = System.currentTimeMillis();
				if (weCheckoutBtn instanceof WebElement) {
					try {
						weCheckoutBtn.click();
						break;
					} catch (Exception ignored) {
						;
					}
				}
				Thread.sleep(200);
			}
			System.out.println("t7=" + t7);
			
			
			WebDriverWait wait = new WebDriverWait(driverChrome, 60);
			//prd
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("取消並返回 Vtech Communications, Inc"))).click();
			//stg xpath
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cancel_return\"]"))).click();
			//wait 'xpathSandbox_cancel_return' element
//			for (i = 0; i < 50; i++) {		// wait maximum time is 10,000 milliseconds
//				weSandbox_cancel_return = driverChrome.findElement(By.xpath(xpathSandbox_cancel_return));
				t8 = System.currentTimeMillis();
//				if (weSandbox_cancel_return instanceof WebElement) {
//					try {
//						weSandbox_cancel_return.click();
//						break;
//					} catch (Exception ignored) {
//						;
//					}
//				}
//				Thread.sleep(200);
//			}
			System.out.println("t8=" + t8);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/h2/span")));
			t9 = System.currentTimeMillis();
			System.out.println("t9=" + t9);
			
//			// wait 'Plan List' element
//			for (i = 0; i < 50; i++) {		// wait maximum time is 10,000 milliseconds
//				weChooseMonthlyPlan = driverChrome.findElement(By.xpath("//*[@id=\"card_list\"]/li[4]/div/ul/li/a/div/span[2]"));
//				t6 = System.currentTimeMillis();
//				if (weChooseMonthlyPlan instanceof WebElement) {
//					try {
//						weChooseMonthlyPlan.click();
//						break;
//					} catch (Exception ignored) {
//						;
//					}
//				}
//				Thread.sleep(200);
//			}
//System.out.println("t6=" + t6);
//
//			// wait 'BACK' button on Checkout Page
//			for (i = 0; i < 50; i++) {		// wait maximum time is 10,000 milliseconds
//				weBack = driverChrome.findElement(By.xpath(xpathBack));
//				t7 = System.currentTimeMillis();
//				if (weBack instanceof WebElement) {
//					try {
//						weBack.click();
//						break;
//					} catch (Exception ignored) {
//						;
//					}
//				}
//				Thread.sleep(200);
//			}
//System.out.println("t7=" + t7);
//		}
//		
//		// time calculation of 'View Buy Invoice Info.' function
//		{
//			WebElement	weUserInfo, 
//						weViewInvoice, 
//						weLogout, 
//						weIconOnWelcome;
//
//			for (i = 0; i < 50; i++) {
//				weUserInfo = driverChrome.findElement(By.xpath(xpathUserInfo));
//				if (weUserInfo instanceof WebElement) {
//					try {
//						weUserInfo.click();
//						break;
//					} catch (Exception ignored) {
//						;
//					}
//				}
//				Thread.sleep(200);
//			}
//			
//			for (i = 0; i < 50; i++) {
//				weViewInvoice = driverChrome.findElement(By.xpath(xpathViewInvoice));
//				t8 = System.currentTimeMillis();
//				if (weViewInvoice instanceof WebElement) {
//					try {
//						weViewInvoice.click();
//						break;
//					} catch (Exception ignored) {
//						;
//					}
//				}
//				Thread.sleep(200);
//			}
//System.out.println("t8=" + t8);
//			
//			for (i = 0; i < 50; i++) {
//				weUserInfo = driverChrome.findElement(By.xpath(xpathUserInfo));
//				t9 = System.currentTimeMillis();
//				if (weUserInfo instanceof WebElement) {
//					try {
//						weUserInfo.click();
//						break;
//					} catch (Exception ignored) {
//						;
//					}
//				}
//				Thread.sleep(200);
//			}
//System.out.println("t9=" + t9);
//		
//			// time calculation of logout function
//			for (i = 0; i < 50; i++) {
//				weUserInfo = driverChrome.findElement(By.xpath(xpathUserInfo));
//				if (weUserInfo instanceof WebElement) {
//					try {
//						weUserInfo.click();
//						break;
//					} catch (Exception ignored) {
//						;
//					}
//				}
//				Thread.sleep(200);
//			}
//			
//			for (i = 0; i < 50; i++) {
//				weLogout = driverChrome.findElement(By.xpath(xpathLogout));
//				t10 = System.currentTimeMillis();
//				if (weLogout instanceof WebElement) {
//					try {
//						weLogout.click();
//						break;
//					} catch (Exception ignored) {
//						;
//					}
//				}
//				Thread.sleep(200);
//			}
//System.out.println("t10=" + t10);
//			
//			for (i = 0; i < 50; i++) {
//				weIconOnWelcome = driverChrome.findElement(By.xpath(xpathIconOnWelcome));
//				t11 = System.currentTimeMillis();
//				if (weIconOnWelcome instanceof WebElement) {
//					try {
//						weIconOnWelcome.click();
//						break;
//					} catch (Exception 	ignored) {
//						;
//					}
//				}
//				Thread.sleep(200);
//			}
//System.out.println("t11=" + t11);
//		}
//		
System.out.println("[" + count + "]===== Welcome Page: [" + (t2 - t1) + "]=====");
System.out.println("[" + count + "]===== OAuth Login Page: [" + (t3 - t2) + "]=====");
System.out.println("[" + count + "]===== Login completed: [" + (t4 - t3) + "]=====");
System.out.println("[" + count + "]===== Plan Mgmt.: [" + (t5 - t4) + "]=====");
System.out.println("[" + count + "]===== Add Plan: [" + (t6 - t5) + "]=====");
System.out.println("[" + count + "]===== Checkout Yearly Plan: [" + (t7 - t6) + "]=====");
System.out.println("[" + count + "]===== Back to Plan page: [" + (t8 - t7) + "]=====");
System.out.println("[" + count + "]===== Back Success: [" + (t9 - t8) + "]=====");
//System.out.println("[" + count + "]===== Logout: [" + (t11 - t10) + "]=====");
		}
		
		// end of test
		driverChrome.close();  
	    driverChrome.quit();
//}
	}
}