package basic;


import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UseElementLocatorsTechnics {
	
WebDriver driver;
	
	public void invokeBrowser(String url) {
		try {
			System.setProperty("webdriver.chrome.driver","E:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void elementLocatorsTechnicsUsingBBCNews() {
		try {
			invokeBrowser("https://www.bbc.com/");
			driver.findElement(By.linkText("Worklife")).click();
			Thread.sleep(2000);
			//WebElement element = driver.findElement(By.linkText("About the BBC"));
			//Actions actions = new Actions(driver);
			//actions.moveToElement(element).click().perform();		
			
			driver.navigate().back();
			//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lenovo Laptops");
			//driver.findElement(By.className("nav-input")).click();
			//driver.navigate().back();
			//driver.findElement(By.partialLinkText("Customer")).click();
			//driver.findElement(By.xpath("//a[@id='nav-link-accountList']/div/span")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void elementLocatorsTechnicsUsingAmazon() {
		try {
			invokeBrowser("https://www.amazon.in/");
			driver.findElement(By.linkText("Customer Service")).click();
			driver.navigate().back();
			Thread.sleep(2000);
			driver.findElement(By.partialLinkText("Deals")).click();
			Thread.sleep(2000);
			driver.navigate().back();			
			System.out.println("Searching test is started");
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lenovo Laptops");
			//driver.findElement(By.className("nav-input")).click();
			driver.findElement(By.cssSelector("#nav-search-submit-text > .nav-input")).click();
			Thread.sleep(2000);
			System.out.println("Searching test is finished");
			driver.navigate().back();
			driver.navigate().refresh();
			Thread.sleep(2000);
			System.out.println("Sign In test is started");
			driver.findElement(By.xpath("//a[@id='nav-link-accountList']/div/span")).click();
			Thread.sleep(2000);
			System.out.println("Sign In test is finished");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void elementLocatorsTechnicsUsingFacebook() {
		try {
			invokeBrowser("https://www.facebook.com/");
			//driver.findElement(By.name("firstname")).sendKeys("Vladimir");			
			driver.findElement(By.cssSelector("input#email")).sendKeys("abc@gmail.com");
			driver.findElement(By.cssSelector("input#pass")).sendKeys("123456");
			driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public void additionalFacebookTests() {
		try {
			invokeBrowser("https://www.facebook.com/");
			//invokeBrowser("https://www.instagram.com/");			
			System.out.println("Title is :"+ driver.getTitle());
			if (driver.getTitle().equals("Facebook - Log In or Sign Up")) {							
	            System.out.println("We are back at Facebook's homepage");					
	        } else {			
	            System.out.println("We are NOT in Facebook's homepage");
	        }
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public void checkCalculators() {
		try {
			invokeBrowser("https://www.calculator.net/");
			// Click on Math Calculators
		    driver.findElement(By.xpath("//*[@id=\"contentout\"]/table/tbody/tr/td[3]/div[1]/a")).click();
		      
		    // Click on Percent Calculators
		    driver.findElement(By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div/a[contains(text(),\"Percentage Calculator\")]")).click();		      
		    driver.findElement(By.id("cpar1")).sendKeys("10");		    
		    // Enter value 50 in the second number of the percent Calculator
		    driver.findElement(By.id("cpar2")).sendKeys("50");
		    
		    // Click Calculate Button
		    driver.findElement(By.xpath(".//*[@id = 'content']/table/tbody/tr[2]/td/input[2]")).click();		    
		    String result = driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]")).getText();		    
		    // Print a Log In message to the screen
		    System.out.println("The actual output is: " + result);
		      
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public void testTrailers(){
		try {
			invokeBrowser("http://www.imdb.com");
			//String trailerForTest = "Furious 7";
			String trailerForTest = "Peaky Blinders";
			//String trailerForTest = "Kuku";
			//Type “Furious 7” in search box
			driver.findElement(By.id("suggestion-search")).sendKeys(trailerForTest);
			driver.findElement(By.id("suggestion-search-button")).click();
			String result = driver.findElement(By.xpath("//table/tbody/tr/td[@class=\"result_text\"]/a[1]")).getText();
			
			// Print a Log In message to the screen
		    System.out.println("The actual output is: " + result);
		    
		    if (result.contains(trailerForTest)) {
		    	System.out.println("The trailer " + trailerForTest + " exists and is going to start");
		    	driver.findElement(By.xpath("//table/tbody/tr/td[@class=\"result_text\"]/a[1]")).click();
		    	
		    }
		    else {
		    	System.out.println("No such trailer " + trailerForTest);
		    	return;
		    }
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public void checkBursa() {
		try {
			invokeBrowser("https://www.tase.co.il/en");
			//Number of Columns
			List<WebElement>  columns = driver.findElements(By.xpath("//*[@id='trades_panel1']//table/thead/tr/th"));
			System.out.println("Number of columns are : " +columns.size());
			
			//Number of Rows
			List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='trades_panel1']//table/tbody/tr"));
			System.out.println("Number of rows are : " +rows.size()); 
			
			// To extract text data from raws
			Iterator<WebElement> row = rows.iterator();
			while(row.hasNext()) {
			    System.out.println(row.next().getText());
			}
				
			
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public void checkTopIndices() {
		try {
			invokeBrowser("https://www.tase.co.il/en");			
			//String topIndiceName = driver.findElement(By.xpath("//*[@id=\"trades_panel1\"]/article/div[1]/top-indices/table/tbody/tr[1]//a/text()")).getText();
			String topIndiceName = driver.findElement(By.xpath("//*[@id=\"trades_panel1\"]/article/div[1]/top-indices/table/tbody/tr[1]//a")).getText();
			String topIndiceValue = driver.findElement(By.xpath("//*[@id=\"trades_panel1\"]/article/div[1]/top-indices/table/tbody/tr[1]/td[2]")).getText();
			System.out.println("topIndiceName = " + topIndiceName);
			System.out.println("topIndiceValue = " + topIndiceValue);
			String indexesAfterSplit[] = topIndiceName.split("\\r?\\n");
			System.out.println("topIndiceName=" + indexesAfterSplit[1]);
			String valuesAfterSplit[] = topIndiceValue.split("\\r?\\n");
			System.out.println("topIndiceValue=" + valuesAfterSplit[1]);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		UseElementLocatorsTechnics obj = new UseElementLocatorsTechnics();		
		//obj.elementLocatorsTechnicsUsingAmazon();
		//obj.closeBrowser();
		//obj.elementLocatorsTechnicsUsingFacebook();
		obj.additionalFacebookTests();
		//obj.checkCalculators();
		//obj.testTrailers();
		//obj.checkBursa();
		//obj.checkTopIndices();
	}

}
