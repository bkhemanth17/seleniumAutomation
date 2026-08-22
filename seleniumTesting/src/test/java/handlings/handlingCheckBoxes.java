package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class handlingCheckBoxes {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        //finding specific checkbox
        driver.findElement(By.xpath("//input[@id = 'sunday']")).click();

        //locating all elements
        List<WebElement> elements = driver.findElements(By.xpath("//input[@class ='form-check-input' and @type='checkbox']"));
        for(WebElement element: elements){
            element.click();
        }

        //actions on last 3 check boxes
        //total 7 - elements - 6, need last 3 7-3: 4(start from)
        for(int i=4; i< elements.size(); i++){
            elements.get(i).click();
        }

        //actions on first 3 checkboxes
        for (int i=0; i<3; i++){
            elements.get(i).click();
        }

        //select all checkboxes and validate
        for(WebElement element: elements){
            if(element.isSelected()){
                element.click();
            }
        }
        driver.quit();
    }
}
