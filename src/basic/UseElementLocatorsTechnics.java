package basic;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UseElementLocatorsTechnics {
	
	WebDriver driver;
	
	public void invokeBrowser(String url) {
		try {
			System.setProperty("webdriver.chrome.driver","E:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void elementLocatorsTechnicsUsingAmazon() {
		invokeBrowser("https://www.amazon.in/");
		driver.findElement(By.linkText("Customer Service")).click();
		driver.navigate().back();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lenovo Laptops");
		driver.findElement(By.className("nav-input")).click();
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Customer")).click();
		driver.findElement(By.xpath("//a[@id='nav-link-accountList']/div/span")).click();
	}
	
	public void elementLocatorsTechnicsUsingFacebook() {
		try {
			invokeBrowser("https://www.facebook.com/");
			driver.findElement(By.name("firstname")).sendKeys("Vladimir");
			//driver.findElement(By.tagName("input[name='firstname']")).sendKeys("Vladimir");
			driver.findElement(By.cssSelector("input#email")).sendKeys("abc@gmail.com");
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public void additionalFacebookTests() {
		try {
			invokeBrowser("https://www.facebook.com/");
			driver.findElement(By.cssSelector("a[title='Go to Facebook Home']"));
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
	
	
	public void testTrailers(){
		try {
			invokeBrowser("http://www.imdb.com");
			String trailerForTest = "Furious 7";
			//Type “Furious 7” in search box
			driver.findElement(By.id("suggestion-search")).sendKeys(trailerForTest);
			driver.findElement(By.id("suggestion-search-button")).click();
			String result = driver.findElement(By.xpath("//table/tbody/tr/td[@class=\"result_text\"]/a[1]")).getText();
			
			// Print a Log In message to the screen
		    System.out.println("The actual output is: " + result);
		    
		    if (result.contains(trailerForTest)) {
		    	System.out.println("The trailer " + trailerForTest + " exists and is going to start");
		    	//driver.findElement(By.xpath("//table/tbody/tr/td[@class=\"result_text\"]/a[1]")).click();
		    	// Play the trailer
		    	//driver.findElement(By.cssSelector(".videoPreview__videoContainer > .slate_button")).click();
		    	driver.findElement(By.linkText(trailerForTest)).click();
		        //driver.findElement(By.cssSelector(".videoPreview__videoContainer > .slate_button")).click();
		    	//*[@id="videoPreviewEmbedIframe"]
		    	//driver.findElement(By.xpath("//*[@id=\"videoPreviewEmbedIframe\"]")).click();
		    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    	js .executeScript("document.getElementByXpath(\"video\").play()");
		    	
		    }
		    else {
		    	System.out.println("No such trailer " + trailerForTest);
		    	return;
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
		    
		    // Enter value 10 in the first number of the percent Calculator
		    driver.findElement(By.id("cpar1")).sendKeys("10");
		    
		    // Enter value 50 in the second number of the percent Calculator
		    driver.findElement(By.id("cpar2")).sendKeys("50");
		    
		    // Click Calculate Button
		    driver.findElement(By.xpath(".//*[@id = 'content']/table/tbody/tr[2]/td/input[2]")).click();
		    
		    // Get the Result Text based on its xpath
		    String result = driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]")).getText();
		    
		    // Print a Log In message to the screen
		    System.out.println("The actual output is: " + result);
		      
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UseElementLocatorsTechnics obj = new UseElementLocatorsTechnics();
		//obj.elementLocatorsTechnicsUsingAmazon();
		//obj.elementLocatorsTechnicsUsingFacebook();
		//obj.additionalFacebookTests();
		//obj.checkBursa();
		//obj.checkCalculators();
		obj.testTrailers();
		//obj.closeBrowser();
	}

}
