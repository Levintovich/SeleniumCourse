package basic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBrowserCommands {

	WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver","E:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get("https://www.instagram.com/");
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public void closeBrowser() {
		//driver.close();
		driver.quit();
	}
	 
	
	public static void main(String[] args) {
		
		TestBrowserCommands obj =  new TestBrowserCommands();
		obj.invokeBrowser();
		obj.closeBrowser();
		

	}

}
