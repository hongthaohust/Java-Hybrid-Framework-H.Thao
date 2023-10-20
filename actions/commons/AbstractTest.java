package commons;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	private WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	protected WebDriver getBrowserDriver(String browserName) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		if(browser == Browser.FIREFOX_UI) {
			WebDriverManager.firefoxdriver().driverVersion("0.32.2").setup();
			driver = new FirefoxDriver();
		} else if(browser == Browser.CHROME_UI) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browser == Browser.FIREFOX_HEADLESS) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless=new");
			options.addArguments("window-size=1920�1080");
			driver = new FirefoxDriver(options);
		} else if(browser == Browser.CHROME_HEADLESS) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			options.addArguments("window-size=1920�1080");
			driver = new ChromeDriver(options);
		} else if(browser == Browser.EDGE_CHROMIUM) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please input browser value");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		
		return driver;
	}
	
	
	public int random() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}
}
