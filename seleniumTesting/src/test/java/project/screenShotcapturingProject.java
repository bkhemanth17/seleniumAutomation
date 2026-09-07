package project;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class screenShotcapturingProject {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://vinothqaacademy.com/mouse-event/");
        try {
            driver.findElement(By.xpath("this-id-does-not-exist")).click();
        }catch (Exception exception){
            System.out.println("test failed, capturing screenshot!!!");
            CaptureScreenShot(driver,"File_failed");
        }finally {
            driver.quit();
        }
    }

    public static void CaptureScreenShot(WebDriver driver, String fileName){
        try {
            String folderPath = System.getProperty("user.dir") + "\\src\\test\\java\\capturedScreenShots\\";
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            SimpleDateFormat timestamp;
            timestamp = new SimpleDateFormat("yyyMMdd_HHmmss");
            //timestamp = new SimpleDateFormat("yyyMMdd");
            timestamp.format(new Date());
            File targetFile = new File(folderPath + fileName + "-" + timestamp + ".png");
            //sourceFile.renameTo(targetFile);
            FileHandler.copy(sourceFile, targetFile);
            System.out.println("✅ Screenshot saved at:"+targetFile.getAbsolutePath());
        }catch (IOException exception){
            System.out.println("failed to capture screenshot: "+exception.getMessage());
        }
    }
}
