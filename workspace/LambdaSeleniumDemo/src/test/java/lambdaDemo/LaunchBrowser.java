package lambdaDemo;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.*;

public class LaunchBrowser {
	RemoteWebDriver driver;

	@BeforeTest
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build", "Eka nimi");
		capabilities.setCapability("name", "Interact with input");
		capabilities.setCapability("platform", "Windows 11");
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("browserVersion", "dev");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "djdreviz");
		ltOptions.put("accessKey", "LT_4dIDvGDwShj1CWwGJpI5hfFTmd2wyY11CAHFsnaavKKDhMs");
		ltOptions.put("platformName", "Windows 11");
		ltOptions.put("resolution", "1024x768");
		ltOptions.put("project", "Untitled");
		ltOptions.put("selenium_version", "3.13.0");
		ltOptions.put("driver_version", "130.0.6683.2");
		capabilities.setCapability("LT:Options", ltOptions);
		try {
			driver = new RemoteWebDriver(new URL(
					"https://djdreviz:LT_4dIDvGDwShj1CWwGJpI5hfFTmd2wyY11CAHFsnaavKKDhMs@hub.lambdatest.com/wd/hub"),
					capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void myTest() {
		/*
		 * System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 * WebDriver driver = new ChromeDriver();
		 */
		driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		String title = driver.getTitle();
		System.out.println(title);
		WebElement aInput = driver.findElement(By.id("sum1"));
		aInput.sendKeys("10");
		driver.findElement(By.id("sum2")).sendKeys("15");
		driver.findElement(By.xpath("//button[text()='Get Sum']")).click();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
