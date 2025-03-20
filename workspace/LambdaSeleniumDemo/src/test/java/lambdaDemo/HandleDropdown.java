package lambdaDemo;

import java.util.HashMap;
import java.util.List;

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

public class HandleDropdown {
	RemoteWebDriver driver;

	@BeforeTest
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build", "DropDown");
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
	public void selectDropDown() {
		driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
		WebElement dayDropDown = driver.findElement(By.id("select-demo"));
		Select sel = new Select(dayDropDown);
		sel.selectByVisibleText("Friday");
		WebElement firstSelectedOption = sel.getFirstSelectedOption();
		System.out.println("Select dropdown value: " +firstSelectedOption.getText());
//		sel.selectByIndex(0);
//		sel.selectByValue("Sunday");
		
		// multiple dropdown
		
		WebElement multiDropdown = driver.findElement(By.id("multi-select"));
		Select countries = new Select(multiDropdown);
		countries.selectByIndex(2);
		countries.selectByValue("Texas");
		List<WebElement> allSelectedOptions = countries.getAllSelectedOptions();
		for (WebElement country : allSelectedOptions) {
			System.out.println("valitut asetukset: " + country.getText());
		}
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
