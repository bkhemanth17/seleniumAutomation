package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
public class locators {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        //find by name
        driver.findElement(By.name("animals")).isDisplayed();

        //find by id
        boolean val  = driver.findElement(By.id("datepicker")).isDisplayed();
        System.out.println(val);

        //find by link and partial link text
        driver.findElement(By.linkText("Udemy Courses")).click();

        //partial links
        driver.findElement(By.partialLinkText("Trainings")).click();

        //by class name
        List<WebElement> elementList = driver.findElements(By.className("form-control"));
        for(WebElement element: elementList){
            System.out.println(element);
        }
        System.out.println(elementList.size());

        //by tag name
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());

        //by xpath
        driver.findElement(By.xpath("//input[@class = 'wikipedia-search-input']")).sendKeys("iphone");

        //by css
        driver.findElement(By.cssSelector("input#name")).sendKeys("user1");


        //driver.close
        driver.quit();
    }
}