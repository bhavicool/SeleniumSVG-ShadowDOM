package Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGIndiaCovidCases {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.get("https://www.google.com/search?q=covid+cases+in+india&oq=covid+cases+in+india&aqs=chrome.0.0i131i433i512l7j69i61.3528j0j7&sourceid=chrome&ie=UTF-8");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Actions action=new Actions(driver);

		List<WebElement> webGraphList=driver.findElements(By.xpath("(//*[local-name()='svg' and @class='uch-psvg' ]/*[name()='g'])[1]/*[name()='rect']"));

		for(WebElement list:webGraphList)
		{
			action.moveToElement(list).perform();
			System.out.print("India covid case data is:"+driver.findElement(By.cssSelector("div.ExnoTd")).getText());
			System.out.println();
		}

		driver.quit();

	}

}
