package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {
	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.leafground.com/alert.xhtml");
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[1]")).click();
	    
		org.openqa.selenium.Alert a1 = driver.switchTo().alert();//ctrl+2+l
		
		String text = a1.getText();
		System.out.println(text);
		a1.accept();
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[6]")).click();
	    org.openqa.selenium.Alert alert2 = driver.switchTo().alert();
		alert2.sendKeys("Testleaf chennai");
		String text2 = alert2.getText();
		System.out.println(text2);
		alert2.accept();
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
		org.openqa.selenium.Alert alert3 = driver.switchTo().alert();
		String text3 = alert3.getText();
		System.out.println(text3);
		alert3.accept();
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
		
		//org.openqa.selenium.Alert alert4 = driver.switchTo().alert();
		//String text4 = alert4.getText();
		//System.out.println(text4);
		//alert4.dismiss();
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[4]")).click();
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[5]")).click();
		
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]")).click();
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[7]")).click();
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[9]")).click();
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[8]")).click();
		
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-minus']")).click();
		
	}



	}

