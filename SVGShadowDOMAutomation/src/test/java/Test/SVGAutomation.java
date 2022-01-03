package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.get("https://www.tutorialspoint.com/index.htm");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Finding the jobs Icon present inside a svg element
		WebElement jobsIcon= driver.findElement(By.xpath("//*[local-name()='svg' and @data-icon='suitcase']/*[name()='path']"));
		
		System.out.println("The d value of the icon is:"+jobsIcon.getAttribute("d"));
		
		// Action class to move and click element
		Actions act = new Actions(driver);
		act.moveToElement(jobsIcon).
		click().build().perform();

		Thread.sleep(3000);
		
		driver.quit();

	}

}
