package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.leafground.com/frame.xhtml");
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("Click")).click();
		String text = driver.findElement(By.xpath("//button[text()='Hurray! You Clicked Me.']")).getText();
		System.out.println(text);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click")).click();
		String text2 = driver.findElement(By.xpath("//button[text()='Hurray! You Clicked Me.']")).getText();
		System.out.println(text2);
		
		//driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		
		driver.findElement(By.xpath("//button[text()='Count Frames']")).click();
		driver.switchTo().defaultContent();
		List<WebElement> lst = driver.findElements(By.xpath("//iframe"));
		System.out.println(lst.size());
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snapshot/frame.png");
		FileUtils.copyFile(source, dest);
	}

}
