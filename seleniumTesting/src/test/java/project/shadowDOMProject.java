package project;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class shadowDOMProject {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://letcode.in/shadow/");

        //fist name
        SearchContext shadowRoot = driver.findElement(By.cssSelector("#open-shadow")).getShadowRoot();
        WebElement firstName = shadowRoot.findElement(By.cssSelector("#fname"));
        firstName.sendKeys("first name");

        //Second (last name)
        // shadow root is closed we can use actions class or javaScript executor
        //approach 1
        Actions actions = new Actions(driver);
        actions.click(firstName)
                .sendKeys(Keys.TAB)
                .sendKeys("last name")
                .perform();

        // third (email)
        /* -> wont work because shadow root closed
        SearchContext emailContext = driver.findElement(By.cssSelector("#close-shadow")).getShadowRoot();
        emailContext.findElement(By.cssSelector("#email")).sendKeys("email@email.com");
         */
        actions.click(firstName)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("temp@tempmail.com")
                .perform();

        driver.quit();
    }
}
