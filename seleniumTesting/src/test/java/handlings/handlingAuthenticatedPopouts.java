package handlings;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class handlingAuthenticatedPopouts {
    /*
    for certain authenticated pop outs that cann't be handled with locators and switchTo().alerts()
    we use url and pass id and passwd in the url itself
    for https://the-internet.herokuapp.com/basic_auth
    (https://userID:passwd@the-internet.herokuapp.com/basic_auth)
    use -> https://admin:admin@the-internet.herokuapp.com/basic_auth
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        /*
        FAILS
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        Alert myalert = driver.switchTo().alert();
        myalert.sendKeys("admin");
        myalert.sendKeys("admin");
        myalert.accept();
         */

        /*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        Alert myalert1 = wait.until(ExpectedConditions.alertIsPresent());
        myalert1.sendKeys("admin");
        myalert1.sendKeys("admin");
        myalert1.accept();

         */
        driver.quit();
    }
}
