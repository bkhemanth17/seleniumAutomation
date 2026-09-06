package handlings;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class keyBoardActions {

    /*

    Key Board Actions
    select (CTRL+A) -> actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
    copy (CTRL+C)-> actions.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
    TAB (TAB)-> actions.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
    paste (CTRL+V)-> actions.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

    (CTRL+Shift+A) -> actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
    (Enter) -> actions.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();

    // opens new tab -> driver.switchTo().newWindow(WindowType.TAB);
    //opens new window -> driver.switchTo().newWindow(WindowType.WINDOW);

     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://text-compare.com/");

        Actions actions = new Actions(driver);

        WebElement text1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
        text1.clear();
        text1.sendKeys("temp values for testing key board actions");

        //select
        actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();

        //copy
        actions.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

        //TAB
        actions.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

        //paste
        actions.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

        //navigate
        driver.navigate().to("https://testautomationpractice.blogspot.com/");
        WebElement udemyCourse = driver.findElement(By.xpath("//a[text()='Udemy Courses']"));
        actions.keyDown(Keys.CONTROL).click(udemyCourse).keyUp(Keys.CONTROL).perform();

        driver.switchTo().newWindow(WindowType.TAB); // opens new tab
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.switchTo().newWindow(WindowType.WINDOW); //opens new window
        driver.get("https://github.com/bkhemanth17/seleniumAutomation/tree/main");

        driver.quit();

    }
}