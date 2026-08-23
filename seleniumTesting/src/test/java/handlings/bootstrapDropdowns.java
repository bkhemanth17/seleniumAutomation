package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.sound.midi.Soundbank;
import java.time.Duration;
import java.util.List;

public class bootstrapDropdowns {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.jqueryscript.net/demo/Bootstrap-4-Select-Dropdown/");

        WebElement button = driver.findElement(By.xpath("//button[@id='bsd1-button']"));
        button.click();
        WebElement deSelect = driver.findElement(By.xpath("//div[contains(@class, 'dropdown-menu dropdown-menu-right')]/a[@id = 'bsd1-deselect']"));
        WebElement selectedItems = driver.findElement(By.xpath("//div[contains(@class, 'dropdown-menu dropdown-menu-right')]/a[@id = 'bsd1-selected']"));

        //all options
        List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class, 'dropdown-menu dropdown-menu-right')]/div/a[@class = 'dropdown-item']"));

        //printing all options
        System.out.println(".............................all options.............................");

        for(WebElement option: options){
            System.out.println(option.getText());
        }


        //selecting some options
        for(WebElement option: options){
            String optText = option.getText();
            if (optText.equals("India") || optText.equals("Canada") || optText.equals("France") || optText.equals("Israel") || optText.equals("Luxembourg")){
                option.click();
            }
        }
        System.out.println(".............................selected some options.............................");

        // viewing all selected options
        selectedItems.click();
        //div[contains(@class, 'dropdown-menu dropdown-menu-right')]/div/a[not(@class = 'dropdown-item')]
        System.out.println(".............................selected items.............................");
        List<WebElement> SelectedOnes = driver.findElements(By.xpath("//div[contains(@class, 'dropdown-menu dropdown-menu-right')]/div/a[not(@class = 'dropdown-item')]"));
        for(WebElement selector: SelectedOnes){
            String text = selector.getText();
            System.out.println(text);
        }

        //printing selected items
        //System.out.println(button.getText());

        //deselecting some items
        for(WebElement option: options){
            String optText = option.getText();
            if (optText.equals("Canada") || optText.equals("France")){
                option.click();
            }
        }

        System.out.println(".............................removed some options.............................");
        // viewing all selected items
        selectedItems.click();
        //printing selected items
        System.out.println(".............................selected items.............................");
        List<WebElement> SelectedOnes1 = driver.findElements(By.xpath("//div[contains(@class, 'dropdown-menu dropdown-menu-right')]/div/a[not(@class = 'dropdown-item')]"));
        for(WebElement selector: SelectedOnes1){
            String text = selector.getText();
            System.out.println(text);
        }

        //deselecting all
        deSelect.click();

        System.out.println(".............................removed all.............................");

        //overiew
        System.out.println(button.getText());

        driver.quit();
    }

}
