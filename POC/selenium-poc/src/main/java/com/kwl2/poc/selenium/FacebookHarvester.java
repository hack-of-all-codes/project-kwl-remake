package com.kwl2.poc.selenium;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class FacebookHarvester implements Runnable {
	
	private static final Logger logger = Logger.getLogger(FacebookHarvester.class.getName());

	@Override
	public void run() {
		String username = "test@test.com";
		String password = "temppass123";
		
		String website = "https://www.facebook.com/";
		
		String driverLocation = "/mnt/c/Users/KWL/Desktop/phantomjs-2.1.1-linux-x86_64/bin/phantomjs";
		String screenshotLocation = "/mnt/c/Users/KWL/Desktop/screenshot.png";
		//String driverLocation = "C:\\Users\\KWL\\Desktop\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe";
		//String screenshotLocation = "C:\\Users\\KWL\\Desktop\\screenshot.png";

		System.setProperty("phantomjs.binary.path", driverLocation);
		
		PhantomJSDriver driver = new PhantomJSDriver();
		driver.manage().window().setSize(new Dimension(1024, 768));
		
		driver.get(website);
		
		driver.findElementByCssSelector("input[name=email]").sendKeys(username);
		driver.findElementByCssSelector("input[name=pass]").sendKeys(password);
		driver.findElementByCssSelector("input[name=pass]").sendKeys(Keys.ENTER);
		try {
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElementByCssSelector("button[type=submit]").click();
		try {
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File(screenshotLocation));
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("screenshot login:" + screenshotLocation);
		
		logger.info("form: " + driver.findElementByCssSelector("html").getAttribute("innerHTML"));

	}

}
