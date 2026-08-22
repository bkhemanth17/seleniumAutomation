package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class selectDropdowns {
    /*
    3 types of dropdowns
    1. Select dropdowns (it has select tag and options has options tag)

    WebElement selector = driver.findElement(By.xpath("//select[@id='country']"));
    Select select = new Select(selector);

    select.selectByValue();
    select.selectByVisibleText();
    select.selectByIndex();

    2. Bootstrap dropdowns (it has div elements buttons modern css style)
    3. hidden dropdowns
     */

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement selector = driver.findElement(By.xpath("//select[@id='country']"));
        Select select = new Select(selector);

        select.selectByVisibleText("India");
        select.selectByValue("china");
        select.selectByIndex(0);

        List<WebElement> options = select.getOptions();
        for(WebElement option:options){
            System.out.println(option.getText());
        }

        driver.quit();
    }
}
