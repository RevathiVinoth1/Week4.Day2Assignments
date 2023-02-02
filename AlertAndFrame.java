package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertAndFrame {

	public static void main(String[] args) throws IOException {
ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		
		driver.switchTo().frame(frame);
		
		WebElement click = driver.findElement(By.xpath("//button[text()='Try it']"));
		click.click();
		Alert try1= driver.switchTo().alert();
				String text = try1.getText();
				System.out.println(text);
				try1.accept();
		 String text2 = driver.findElement(By.id("demo")).getText();
		if (text2.contains("You pressed")) {
			System.out.println("Action is performed successfully");
		}
		File source=click.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/frame.png");
		FileUtils.copyFile(source, dest);
		System.out.println("The ScreenShot ");
			
		
	}

}


/*
	ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// handle the frame
		WebElement element = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(element);
		// Click Try It Button
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		// handle the alert
		Alert alert = driver.switchTo().alert();// ctrl+2+1
		String text = alert.getText();
		System.out.println(text);// print text in the alert box
		// Click OK/Cancel in the alert
		alert.accept();

		// Confirm the action is performed correctly by verifying the text !!
		String text2 = driver.findElement(By.id("demo")).getText();
		if (text2.contains("You pressed")) {
			System.out.println("Action is performed successfully");
		}
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/frame.png");
		FileUtils.copyFile(src, dst);

	}




*/