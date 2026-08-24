package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class autoSuggestionDropdowns {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bjs.com/search/hp%20laptop/q?template=clp");
        driver.findElement(By.xpath("//input[contains(@placeholder, 'What are you looking for today?')]")).sendKeys("laptop");
        //options
        List<WebElement> options= driver.findElements(By.xpath("//div[@class='list list-group']//b"));
        for (WebElement option: options){
            String text = option.getText();
            if(text.equals("hp laptop")){
                option.click();
            }
        }
        driver.quit();
    }
}
