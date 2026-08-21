package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserNavigationMethods {

    /*
    navigational commands
    driver.navigate().to("url");
    driver.navigate().back();
    driver.navigate().forward();
    driver.navigate().refresh();
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        //to
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.navigate().back(); //back
        System.out.println(driver.getCurrentUrl());

        driver.navigate().forward(); //forward
        System.out.println(driver.getCurrentUrl());

        driver.navigate().refresh(); //refresh
        driver.quit();
    }
}
