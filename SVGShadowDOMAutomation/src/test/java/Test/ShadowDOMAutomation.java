package Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOMAutomation {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.get("https://books-pwakit.appspot.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Finding the shadow host element
		WebElement shadowHost=driver.findElement(By.tagName("book-app"));

		//Finding the shadow dom element
		JavascriptExecutor js=(JavascriptExecutor) driver;
		SearchContext shadowDomElement=(SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowHost);

		SearchContext appHeader=shadowDomElement.findElement(By.tagName("app-header"));

		SearchContext apptoolbar=appHeader.findElement(By.cssSelector("app-toolbar.toolbar-bottom"));

		SearchContext bookInputDecorator=apptoolbar.findElement(By.tagName("book-input-decorator"));

		//Passing some value in the search box
		bookInputDecorator.findElement(By.xpath("//input[@id='input']")).sendKeys("Hello World");
		/*WebElement searchBox=(WebElement)js.executeScript("return document.querySelector(\"book-app\").shadowRoot.querySelector(\"#input\")");

		String enterVal = "arguments[0].setAttribute('value', 'Hello World')";

		((JavascriptExecutor)driver).executeScript(enterVal, searchBox);*/

		Thread.sleep(3000);

		driver.quit();
	}

}
