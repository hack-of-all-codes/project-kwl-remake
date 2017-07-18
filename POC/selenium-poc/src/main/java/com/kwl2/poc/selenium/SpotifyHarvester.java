package com.kwl2.poc.selenium;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class SpotifyHarvester implements Runnable {
	
	private static final Logger logger = Logger.getLogger(SpotifyHarvester.class.getName());

	@Override
	public void run() {
		String website = "https://spotifycharts.com/regional/us/daily/latest";
		
		String driverLocation = "C:\\Users\\KWL\\Desktop\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe";
		String screenshotLocation = "C:\\Users\\KWL\\Desktop\\screenshot.png";

		System.setProperty("phantomjs.binary.path", driverLocation);
		
		PhantomJSDriver driver = new PhantomJSDriver();
		driver.manage().window().setSize(new Dimension(1024, 768));
		
		driver.get(website);
		
		try {
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File(screenshotLocation));
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("screenshot login:" + screenshotLocation);
		
		try (PrintWriter writer = new PrintWriter("C:\\Users\\KWL\\Desktop\\spotify_us_top_200.html")){
			writer.println(driver.findElementByCssSelector("html").getAttribute("innerHTML"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}

}
