package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandlingUsingForEach {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.leafground.com/window.xhtml");
		
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		System.out.println(driver.getTitle());
		
		
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		
		List<String>lstWindow=new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(lstWindow.get(1));
		//System.out.println(driver.getTitle());
		
		driver.close();
		driver.switchTo().window(lstWindow.get(0));
		//System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		System.out.println(windowHandles1.size());
		List<String>lstWindow1=new ArrayList<String>(windowHandles1);
		
		driver.switchTo().window(lstWindow1.get(2));
		//System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(lstWindow.get(0));
		//System.out.println(driver.getTitle());
		
		
		
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		
		
		driver.switchTo().window(lstWindow.get(0));
		Set<String> windowHandles2 = driver.getWindowHandles();
		System.out.println(windowHandles2.size());
		List<String>lstWindow2=new ArrayList<String>(windowHandles2);
		
		driver.switchTo().window(lstWindow2.get(4));
		//System.out.println(driver.getTitle());
		driver.switchTo().window(lstWindow2.get(3));
		//System.out.println(driver.getTitle());
		driver.switchTo().window(lstWindow2.get(2));
		//System.out.println(driver.getTitle());
		driver.switchTo().window(lstWindow2.get(1));
		//System.out.println(driver.getTitle());
		/*driver.switchTo().window(lstWindow.get(0));
		System.out.println(driver.getTitle());*/
		driver.close();
		driver.switchTo().window(lstWindow.get(0));
		//System.out.println(driver.getTitle());
		//driver.quit();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement delay = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[4]"));
		wait.until(ExpectedConditions.elementToBeClickable(delay));
		Set<String> windowHandles3 = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		List<String>lstWindow3=new ArrayList<String>(windowHandles3);
		
		Actions AC = new Actions(driver);
		AC.click(delay).perform();
		driver.switchTo().window(lstWindow3.get(2));
		//System.out.println(driver.getTitle());
		driver.switchTo().window(lstWindow3.get(1));
		//System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(lstWindow.get(0));	
		//System.out.println(driver.getTitle());
		
		
		for (String winid1: lstWindow)
		{
			String title1 = driver.switchTo().window(winid1).getTitle();
			System.out.println(title1);
			//System.out.println("The titles of lstwindow1 are: " +driver.getTitle());
		}
		
		for (String winid2: lstWindow1)
		{
			String title2 = driver.switchTo().window(winid2).getTitle();
			System.out.println(title2);
			//System.out.println("The titles of lstwindow1 are: " +driver.getTitle());
		}
		for (String winid3: lstWindow2)
		{
			String title3 = driver.switchTo().window(winid3).getTitle();
			System.out.println(title3);
			//System.out.println("The titles of lstwindow1 are: " +driver.getTitle());
		}
		for (String winid4: lstWindow3)
		{
			String title4 = driver.switchTo().window(winid4).getTitle();
			System.out.println(title4);
			//System.out.println("The titles of lstwindow1 are: " +driver.getTitle());
		}
		
		}
	

	}


