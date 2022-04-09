package com.qa.testBase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.qa.pageLayer.HomePage;
import com.qa.utilities.UtilClass;
import com.qa.utilities.WebDriverListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static WebDriverListener eventListener;
	public static EventFiringWebDriver e_driver;
	public static Logger logger;
	public HomePage h;
	public UtilClass util;
	
	@BeforeClass
	public void startLogger()
	{
		logger=Logger.getLogger("My Demo DemoBlaze Framework");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	@AfterClass
	public void endLogger()
	{
		logger.info("Automation script end");
	}
	@BeforeMethod
	public void start()
	{
		String br="firefox";
		if(br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome launch");
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			logger.info("firefox launch");
		}
		else if (br.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Browser not found, Please enter valid browser name");
		}
		
		driver.get("https://demoblaze.com/index.html");
		logger.info("Url launches in browser");
		driver.manage().window().maximize();
		logger.info("Maximized browser");
		driver.manage().deleteAllCookies();
		logger.info("Deleted all cookies");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		eventListener = new WebDriverListener();
	    e_driver=new EventFiringWebDriver(driver);
	    e_driver.register(eventListener);
	    driver=e_driver;
		
		h= new HomePage();
		util=new UtilClass();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
