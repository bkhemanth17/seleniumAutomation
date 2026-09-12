package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class svgElements {
    /*
    to handle svg elements like logos we need to *[local-name()='svg'] or *[name()='svg']
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[contains(normalize-space(), 'Login')]")).click();

        WebElement admin =driver.findElement(By.xpath("//span[text()='Admin']/preceding-sibling::*[local-name()='svg']"));
        admin.click();

        WebElement PIM = driver.findElement(By.xpath("//span[text()='PIM']/preceding-sibling::*[local-name()='svg']"));
        PIM.click();

        WebElement Leave = driver.findElement(By.xpath("//span[text()='Leave']/preceding-sibling::*[local-name()='svg']"));
        Leave.click();

        WebElement Time = driver.findElement(By.xpath("//span[text()='Time']/preceding-sibling::*[local-name()='svg']"));
        Time.click();

        WebElement Recruitment = driver.findElement(By.xpath("//span[text()='Recruitment']/preceding-sibling::*[local-name()='svg']"));
        Recruitment.click();

        WebElement MyInfo = driver.findElement(By.xpath("//span[text()='My Info']/preceding-sibling::*[local-name()='svg']"));
        MyInfo.click();

        WebElement Performance = driver.findElement(By.xpath("//span[text()='Performance']/preceding-sibling::*[local-name()='svg']"));
        Performance.click();

        WebElement Dashboard = driver.findElement(By.xpath("//span[text()='Dashboard']/preceding-sibling::*[local-name()='svg']"));
        Dashboard.click();

        WebElement Directory = driver.findElement(By.xpath("//span[text()='Directory']/preceding-sibling::*[local-name()='svg']"));
        Directory.click();

        //WebElement Maintenance = driver.findElement(By.xpath("//span[text()='Maintenance']/preceding-sibling::*[local-name()='svg']"));
        //Maintenance.click();

        WebElement Claim = driver.findElement(By.xpath("//span[text()='Claim']/preceding-sibling::*[local-name()='svg']"));
        Claim.click();

        WebElement Buzz = driver.findElement(By.xpath("//span[text()='Buzz']/preceding-sibling::*[local-name()='svg']"));
        Buzz.click();

        driver.quit();

    }
}
