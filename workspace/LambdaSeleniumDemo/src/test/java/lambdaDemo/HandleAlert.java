package lambdaDemo;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.*;

public class HandleAlert {
	RemoteWebDriver driver;

	@BeforeTest
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build", "Alert");
		capabilities.setCapability("name", "Interact with input");
		capabilities.setCapability("browserName", "MicrosoftEdge");
		capabilities.setCapability("browserVersion", "97.0");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "djdreviz");
		ltOptions.put("accessKey", "LT_4dIDvGDwShj1CWwGJpI5hfFTmd2wyY11CAHFsnaavKKDhMs");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("platformName", "Windows 10");
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
	public void handleAlert() {
		driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
		driver.findElement(By.xpath("//div[text()='Java Script Alert Box']/following-sibling::button")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		driver.findElement(By.xpath("(//button[text()='Click Me'])[2]")).click();
		alert.dismiss();
		driver.findElement(By.xpath("(//button[text()='Click Me'])[3]")).click();
		alert.sendKeys("Koutsi");
		alert.accept();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
