package lambdaDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchBrowser {

	@Test
	public void myTest() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();
	}

}
