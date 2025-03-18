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
		capabilities.setCapability("build", "Toinen ajo");
		capabilities.setCapability("name", "Interact with input");
		capabilities.setCapability("browserName", "Safari");
		capabilities.setCapability("browserVersion", "18");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "djdreviz");
		ltOptions.put("accessKey", "LT_4dIDvGDwShj1CWwGJpI5hfFTmd2wyY11CAHFsnaavKKDhMs");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("platformName", "MacOS Sequoia");
		ltOptions.put("network", true);
		ltOptions.put("project", "Untitled");
		ltOptions.put("console", "true");
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
		String attribute = aInput.getAttribute("placeholder");
		System.out.println("Placeholder value: " + attribute);
		aInput.sendKeys("10");
		driver.findElement(By.id("sum2")).sendKeys("15");
		driver.findElement(By.xpath("//button[text()='Get Sum']")).click();
		String text = driver.findElement(By.id("addmessage")).getText();
		System.out.println("Result: " + text);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
