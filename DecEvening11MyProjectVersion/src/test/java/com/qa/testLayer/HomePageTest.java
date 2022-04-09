package com.qa.testLayer;

import org.testng.annotations.Test;

import com.qa.pageLayer.HomePage;
import com.qa.testBase.TestBase;

public class HomePageTest extends TestBase {
	
	
	@Test
	public void verifyOnSamsungGalaxyS6()
	{
		
		h.clickOnPhones();
		h.clickOnSamsungGalaxyS6();
		util.clickOnAddToCart();
	}
	
	@Test
	public void verifyOnNokiaLumia1520()
	{
		h.clickOnPhones();
		h.clickOnNokiaLumia1520();
		util.clickOnAddToCart();
	}
	@Test
	public void verifyOnNexus6()
	{
		h.clickOnPhones();
		h.clickOnNexus6();
		util.clickOnAddToCart();
	}
}
