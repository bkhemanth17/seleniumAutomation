package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class handlingFrames {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //frame1
        WebElement element1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(element1);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("first frame...");

        //switching back
        driver.switchTo().defaultContent();

        //frame2
        WebElement element2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(element2);
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("at second frame...");

        //switching back
        driver.switchTo().defaultContent();

        //frame3
        WebElement element3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(element3);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("at third frame...");

        //nested iframe
        //iframe[@src='https://docs.google.com/forms/d/e/1FAIpQLSf5WiH3jEQApYku0Rl_nreU6_YMuLKAH5ffHuASyykQSIBjmg/viewform?embedded=true']
        driver.switchTo().frame(0);

        WebElement button = driver.findElement(By.xpath("//span[contains(text(), 'Hi, I am the UI.Vision IDE')]"));
        JavascriptExecutor jsExe = (JavascriptExecutor) driver;
        jsExe.executeScript("arguments[0].click();",button);

        driver.findElement(By.xpath("//span[contains(text(), 'Web Testing')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'General Web Automation')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();

        //switching back
        driver.switchTo().defaultContent();

        //frame4
        WebElement element4 = driver.findElement(By.xpath("//frame[@src ='frame_4.html']"));
        driver.switchTo().frame(element4);
        driver.findElement(By.xpath("//input[@name ='mytext4']")).sendKeys("at fourth frame...");

        //switching back
        driver.switchTo().defaultContent();

        //frame5
        WebElement element5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
        driver.switchTo().frame(element5);
        driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("at fifth frame...");

        driver.findElement(By.xpath("//a[contains(text(), 'https://a9t9.com')]")).click();

        WebElement img = driver.findElement(By.xpath("//img[contains(@alt, 'Ui.Vision by a9t9 software - Image-Driven Automation')]"));
        if(img.isDisplayed()){
            System.out.println("yes it is...");
        }else {
            System.out.println("no it's not");
        }

        driver.quit();
    }
}
