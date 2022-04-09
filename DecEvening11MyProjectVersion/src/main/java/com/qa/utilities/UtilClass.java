package com.qa.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class UtilClass extends TestBase {
	
	public UtilClass()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	private WebElement addToCart;
	
	public void clickOnAddToCart()
	{
		addToCart.click();
		logger.info("Clicked AddToCart");
	}
	
	//screenshot code
	public static void takeScreenShot()
	{	
		try 
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			File source=ts.getScreenshotAs(OutputType.FILE);
			
			File des = new File("C:\\Users\\232338\\eclipse-workspace\\DecEvening11MyProjectVersion\\Screenshot\\"+System.currentTimeMillis()+".png");
			FileHandler.copy(source, des);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("Exception while Screenshot");
		}
	}

}
