package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		
		driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
		
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(windows);
		
		driver.switchTo().window(handles.get(1));
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Hari");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(1000);
		
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		driver.switchTo().window(handles.get(0));
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		Set<String> windows2 = driver.getWindowHandles();
		List<String> handles2 = new ArrayList<String>(windows2);
		
		driver.switchTo().window(handles2.get(1));
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("babu");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(handles2.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
}
