package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class webDriverMethods {
    
    /*
          5 different categories of methods
    1. get methods -can be accessed using web driver instance
  used in Web driver level
        get(url) -> driver.get("https://www.google.com/");
        getTitle() -> driver.getTitle();
        getCurrentUrl() -> getCurrentUrl();
        getPageSource() -> driver.getPageSource();
        getWindowHandle() -> driver.getWindowHandle();
        getWindowHandles() -> driver.getWindowHandles();

        close() to close some of the browsers/windows partially
        quit() closes all the browser tab/windows completely

    2. conditional methods
    used in web element level not on web driver level
    return boolean value

        isDisplayed() ->check that element displayed on page or not
        isEnabled() -> to see some elements were enabled otr not
        isSelected() -> radio button and check boxes

    3. browser methods
    4. navigational methods
    5. wait methods
    implicit, explicit, fluent (similar to explicit) has polling frequency and ignores exception (noSuchElementException)


     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //title
        String title = driver.getTitle();
        System.out.println(title);

        //url
        String url = driver.getCurrentUrl();
        System.out.println(url);

        //source code
        String pgSource = driver.getPageSource();
        System.out.println(pgSource);

        //window handle
        String windowHandle = driver.getWindowHandle();
        System.out.println("1: "+windowHandle); // previous page

        /*
        //if the below fails use this
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'OrangeHRM, Inc']")));
        element.click();
         */

        driver.findElement(By.xpath("//a[text() = 'OrangeHRM, Inc']")).click();

        //window handles(multiple)
        Set<String> handles = driver.getWindowHandles();
        for (String handle: handles) {
            System.out.println(handle);
        }

        //conditional methods displayed, enabled, selected
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class, 'orangehrm-login-forgot-header')]")));
        boolean displayed = elt.isDisplayed();
        boolean enabled = elt.isEnabled();
        boolean selected = elt.isSelected();
        System.out.println(displayed);
        System.out.println(enabled);
        System.out.println(selected);

        driver.quit();


    }
}
