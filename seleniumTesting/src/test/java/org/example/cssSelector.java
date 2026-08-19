package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class cssSelector {
    /*css selector
    tag id                -> tag#id
    tag class             -> tag.classname
    tag attribute         -> tag[attribute = value]
    tag class attribute   -> tag.classname[attribute=value]
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        //id
        //WebElement element = driver.findElement(By.cssSelector("input#small-searchterms"));
        WebElement element = driver.findElement(By.cssSelector("#small-searchterms"));
        element.sendKeys("iphone");

        //classname
        //WebElement element1 = driver.findElement(By.cssSelector("input.search-box-text"));
        WebElement element1 = driver.findElement(By.cssSelector("search-box-text"));
        element1.sendKeys("ipad");

        //attribute
        //WebElement element2 = driver.findElement(By.cssSelector("input[placeholder = 'Search store']"));
        WebElement element2 = driver.findElement(By.cssSelector("[placeholder = 'Search store']"));
        element2.sendKeys("macbook");

        //classname attribute
        //WebElement element3 = driver.findElement(By.cssSelector("input.search-box-text[placeholder = 'Search store']"));
        WebElement element3 = driver.findElement(By.cssSelector(".search-box-text[placeholder = 'Search store']"));
        element3.sendKeys("imac");

        driver.quit();

    }
}
