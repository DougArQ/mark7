package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager {
	
	public WebDriver selectBrowser(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
			return new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");
			return new FirefoxDriver();
		}
		if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\webdrivers\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		return null;
	}

}
