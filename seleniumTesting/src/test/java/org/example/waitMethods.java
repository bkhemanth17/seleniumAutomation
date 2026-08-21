package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class waitMethods {

    /*
    wait methods
    1. implicit wait -> wait till maximum time, if element located faster cuts the maximum time and show results
    throws noSuchElementfound exception
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    2. explicit wait -> wait till maximum time, if elements located it will cuts the maximum time and show results

    Common ExpectedConditions Methods:
    visibilityOfElementLocated(By locator): Element is present in DOM and visible on screen.
    presenceOfElementLocated(By locator): Element exists in the HTML DOM (may not be visible yet).
    elementToBeClickable(By locator): Element is visible and enabled (perfect for buttons/links).
    textToBePresentInElementLocated(By locator, String text): Waits for specific text to appear inside an element.
    alertIsPresent(): Waits for a browser pop-up alert to appear.
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        String temp = driver.findElement(By.xpath("//input[@name='username']")).getAttribute("value");
        System.out.println(temp);


        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        element.sendKeys("Admin");
        String temp1 = element.getAttribute("value");
        System.out.println(temp1);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        element1.sendKeys("admin123");
        String temp2 = element1.getAttribute("value");
        System.out.println(temp2);
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'orangehrm-login-button')]")));
        element2.click();

        
        //fluent wait
        FluentWait<WebDriver> myWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement userName = myWait.until(drivers -> drivers.findElement(By.xpath("//input[@name='username']")));
        userName.sendKeys("Admin");
        WebElement passwd = myWait.until(drivers -> drivers.findElement(By.xpath("//input[@name='password']")));
        passwd.sendKeys("admin123");
        WebElement btn = myWait.until(drivers -> drivers.findElement(By.xpath("//button[contains(@class, 'orangehrm-login-button')]")));
        btn.click();

        driver.quit();
    }
}
