package com.task.automation.testtwo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class testfirefox {
	

	@Test
	public void firefox() throws MalformedURLException, InterruptedException {
		
		FirefoxOptions dcc = new FirefoxOptions();
		//dcc.setCapability("browserName", "firefox");
		dcc.setCapability("OS", "Windows");
		WebDriver driver = new RemoteWebDriver(new URL("https://localhost:4446/wd/hub"),dcc);
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		driver.quit();
	
}}
