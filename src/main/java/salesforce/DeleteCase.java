package salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCase {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		driver.get("https://login.salesforce.com");
		driver.findElementById("username").sendKeys("matschie@testleaf.com");
		driver.findElementById("password").sendKeys("SelBootcamp$123");
		driver.findElementById("Login").click();
		Thread.sleep(15000);
		driver.findElementByClassName("slds-icon-waffle").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//button[text()='View All']").click();
		Thread.sleep(4000);
		driver.findElementByXPath("//p[text()='Sales']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//span[text()='More']").click();
		Thread.sleep(3000);
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver; js.executeScript(
		 * "window.document.getElementByxpath('(//span[text()='Cases'])[2]').click()");
		 */
		driver.findElementByXPath("(//span[text()='Cases'])[2]").click();
		Thread.sleep(4000);
		driver.findElementByClassName("oneActionsDropDown").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[text()='Delete']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//span[@class='photoContainer forceSocialPhoto']//span[@class='uiImage']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[text()='Log Out']").click();
		Thread.sleep(3000);
		driver.close();
	}

}
