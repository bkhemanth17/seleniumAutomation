package handlings;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class screenShots {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        //screenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        String folderPath = System.getProperty("user.dir")+"\\src\\test\\java\\capturedScreenShots\\";

        //full screenshot
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        //File targetFile = new File("D:\\automation\\selenium automation\\seleniumAutomation\\seleniumTesting\\src\\test\\java\\capturedScreenShots\\ss.png");
        File targetFile = new File(folderPath + "ss.png");
        sourceFile.renameTo(targetFile);
        System.out.println("✅ Screenshot saved successfully at: "+targetFile.getAbsolutePath());

        //specific element(section) screenshot
        WebElement staticWebTable = driver.findElement(By.xpath("//div[@id='HTML1']"));
        File source = staticWebTable.getScreenshotAs(OutputType.FILE);
        //File target = new File("D:\\automation\\selenium automation\\seleniumAutomation\\seleniumTesting\\src\\test\\java\\capturedScreenShots\\ss1.png");
        File target = new File(folderPath + "ss1.png");
        source.renameTo(target);
        System.out.println("✅ Screenshot saved successfully at: " + target.getAbsolutePath());

        //specific web element
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        File sourceDrop = drop.getScreenshotAs(OutputType.FILE);
        File targetDrop = new File(folderPath+"ss2.png");
        sourceDrop.renameTo(targetDrop);
        System.out.println("✅ Screenshot saved successfully at: " + targetDrop.getAbsolutePath());

    }
}