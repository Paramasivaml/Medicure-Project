package com.seleniumAutomation.automation_practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.h2.store.fs.FileUtils;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
        System.out.println( "Hello World!" );
        
        

        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--headless");
        chromeoptions.addArguments("--no-sandbox");
        chromeoptions.addArguments("--disable-dev-shm-usage");
        chromeoptions.addArguments("--remote-allow-origins=*");
        
          //initialize the web driver with Chrome
        
        ChromeDriver driver = new ChromeDriver(chromeoptions);
        
        System.out.println("Execution starts here");
        
       //open the url
        String ipAddress = "REPLACE_WITH_IP_ADDRESS";
        driver.get("http://" + ipAddress + ":8084/");

        //driver.get("http://localhost:8084/");
        
        //wait for the application page to load
        
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        
        driver.findElement(By.id("name")).sendKeys("Saranya Sreedharan");
        driver.findElement(By.id("regNo")).sendKeys("9999999999");
        driver.findElement(By.id("specialization")).sendKeys("optometry");

        driver.findElement(By.xpath("//*[@id=\"doctorForm\"]/button")).click();

        
        //locate web element and interact
      
        
        //enter the details in the form
        
        
        
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File Screenshot = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile= new File("screenshot.png");
        FileUtils.copyFile(Screenshot,destFile);
        System.out.println("reports stored at : " + destFile.getAbsolutePath().toString());
        
        
        
        System.out.println("Execution ends here");
        
        driver.quit();
        
    }
}
