package com.kwl2.poc.selenium;

import java.io.File;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class SeleniumPOCApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SeleniumPOCApplication.class, args);
	}
	
	private static final Logger logger = Logger.getLogger(SeleniumPOCApplication.class.getName());

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
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
		Thread.sleep(5_000);
		
		driver.findElementByCssSelector("button[type=submit]").click();
		Thread.sleep(5_000);
		
		FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File(screenshotLocation));
		logger.info("screenshot login:" + screenshotLocation);
		
		logger.info("form: " + driver.findElementByCssSelector("html").getAttribute("innerHTML"));
	}
}
