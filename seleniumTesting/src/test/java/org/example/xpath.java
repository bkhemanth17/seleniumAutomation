package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpath {

    /*
    to get the address of the element
    DOM- Document object model  (2 types of xpath)
    1. Absolute (full) - /html/body/main/div[2]/form/fieldset/div/div[1]/div/select
    2. Relative (partial) - //select[@name = 'language']

    relative starts with /, works with attributes, directly jump and find elements using attributes
     */

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");

        //attributes @id,@name,@classname,@attribute //tagName[@attribute='value']
        //xpath
        driver.findElement(By.xpath("//img[@alt='MacBook']"));

        //xpath with single attribute
        driver.findElement(By.xpath("//input[@placeholder = 'Search']")).sendKeys("macbook");

        //xpath with multiple attributes
        driver.findElement(By.xpath("//input[@name='search'][@placeholder = 'Search']"));

        //operators
        // AND operator -> both should true
        driver.findElement(By.xpath("//input[@name='search' and @placeholder = 'Search']"));

        //OR operator -> atleast one should true
        driver.findElement(By.xpath("//input[@name='search' or @placeholder = 'Search']"));

        //functions xpath with inner text
        //text() -> for some anchor tag elements no inner text so we cann't use and for some elements with no attributes may contains inner text, at that case text() will be used
        driver.findElement(By.xpath("//a[text() = 'iPhone']"));
        driver.findElement(By.xpath("//h3[text()='Featured']"));

        //contains() method
        //for attributes -> enter partial value it will fetch the result
        //input[contains(@placeholder, 'Sear')]
        //h3[contains(text() , 'Featured')]
        driver.findElement(By.xpath("//input[contains(@placeholder, 'Sear')]"));
        driver.findElement(By.xpath("//h3[contains(text() , 'Featured')]"));

        //starts-with() method
        driver.findElement(By.xpath("//input[starts-with(@placeholder, 'Sea')]"));

        //chained xpath -it's a combination of relative and absolute xpath
        //sometimes we couldn't able to find any attributes, locators, inner texts we use chained xpath
        //div[contains(@class, 'row justify')]/div/a/img
        driver.findElement(By.xpath("//div[contains(@class, 'col-12')]/a/img"));

        //axes

        driver.quit();
    }
}
