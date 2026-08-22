package handlings;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class handlingAlerts {
    //handling java script alerts

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


        //alert
        driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Alert')]")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());

        //alert with accept and dismiss -> confirm
        //accepting request
        driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]")).click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());
        alert1.accept();
        System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());

        //rejecting request
        driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]")).click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.dismiss();
        System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());

        //sending data -> prompt
        //accept
        driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Prompt')]")).click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("sent and accepted...");
        //System.out.println(alert3.getText());
        alert3.accept();
        System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());

        //dismissing
        driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Prompt')]")).click();
        Alert alert4 = driver.switchTo().alert();
        alert4.sendKeys("nothing...");
        //System.out.println(alert4.getText());
        alert4.dismiss();
        System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());

        //explicit wait
        //accept
        driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]")).click();
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(myAlert.getText());
        myAlert.accept();
        System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());

        //dismiss
        driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]")).click();
        Alert myAlert1 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(myAlert1.getText());
        myAlert1.dismiss();
        System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());


        driver.quit();
    }
}
