package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class windowHandles {
    /*
    getWindowHandle()
    getWindowHandles()
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'OrangeHRM, Inc')]")));
        element.click();

        Set<String>handles = driver.getWindowHandles();


        //approach 1
        /*
        //switch to parent
        List<String> handlesList = new ArrayList<>(handles);
        String parent = handlesList.get(0);
        System.out.println(driver.switchTo().window(parent).getTitle());
        System.out.println(driver.switchTo().window(parent).getCurrentUrl());

        //switch to child
        String child = handlesList.get(1);
        System.out.println(driver.switchTo().window(child).getTitle());
        System.out.println(driver.switchTo().window(child).getCurrentUrl());

         */

        //approach 2
        for(String handle: handles){
            String title = driver.switchTo().window(handle).getTitle();
            if(title.equals("OrangeHRM")){
                System.out.println(driver.getTitle());
                System.out.println(driver.getCurrentUrl());
                driver.close();
            }else {
                System.out.println(driver.getTitle());
            }
        }
    }
}
