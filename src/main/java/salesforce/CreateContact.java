package salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

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
		driver.findElementByXPath("(//div[@class='headerTrigger  tooltip-trigger uiTooltip'])[1]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//span[text()='New Contact']").click();
		Thread.sleep(5000);
		driver.findElementByLinkText("--None--").click();
		driver.findElementByXPath("//a[@title='Ms.']").click();
		driver.findElementByXPath("//input[@placeholder='First Name']").sendKeys("MOHVIS4");
		driver.findElementByXPath("//input[@placeholder='Last Name']").sendKeys("MOHVIS4");
		driver.findElementByXPath("//input[@inputmode='email']").sendKeys("cc@gmail.com");
		driver.findElementByXPath("//div[@class='autocompleteWrapper slds-grow']/input").sendKeys("movis4");
		Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='New Account']").click();
		Thread.sleep(8000);
		driver.findElementByXPath("(//div[@class='uiInput uiInputText uiInput--default uiInput--input']//input[@class=' input'])[2]").sendKeys("movis4");
		Thread.sleep(2000);
		driver.findElementByXPath("(//span[text()='Save'])[3]").click();
		Thread.sleep(4000);
		driver.findElementByXPath("(//span[text()='Save'])[2]").click();
		Thread.sleep(3000);
		WebElement uniqueName = driver.findElementByXPath("//div[contains(text(),'MOHVIS4 MOHVIS4')]");
		String text = uniqueName.getText();
		String expectedText= "MOHVIS4 MOHVIS4";
		Assert.assertEquals(text, expectedText);
		Thread.sleep(4000);
		driver.findElementByXPath("//span[@class='photoContainer forceSocialPhoto']//span[@class='uiImage']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[text()='Log Out']").click();
		Thread.sleep(3000);
		driver.close();

	}

}
