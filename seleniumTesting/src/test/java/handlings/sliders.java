package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class sliders {
    //this is also mouse action only
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

        //min slider
        WebElement min_slider = driver.findElement(By.xpath("//div[contains(@class, 'ui-slider-range')]/following::span[1]"));
        System.out.println(min_slider.getLocation());
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(min_slider,122,246).perform();
        System.out.println(min_slider.getLocation());

        //max slider
        WebElement max_slider = driver.findElement(By.xpath("//div[contains(@class, 'ui-slider-range')]/following::span[2]"));
        System.out.println(max_slider.getLocation());
        actions.dragAndDropBy(max_slider,-120,246).perform();
        System.out.println(max_slider.getLocation());
        driver.quit();
    }
}
