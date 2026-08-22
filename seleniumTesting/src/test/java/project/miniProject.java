package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class miniProject {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        //capturing parent window handle
        String parentHandle = driver.getWindowHandle();
        System.out.println(parentHandle);

        //locating search box and entering selenium
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")));
        search.sendKeys("selenium");
        //click on the search box
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='wikipedia-search-button']")));
        checkbox.click();

        //count of the total search results found
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='wikipedia-search-result-link']")));
        int tot = elements.size();
        System.out.println(tot);

        //clicking on all links
        for(WebElement element : elements){
            element.click();
        }

        //capturing all window handles
        Set<String> handles = driver.getWindowHandles();
        for(String handle:handles){
            if(!handle.equals(parentHandle)){
                driver.switchTo().window(handle);
                System.out.println(driver.getTitle());
                System.out.println(driver.getCurrentUrl());
                driver.close();
            }
        }
        driver.quit();
    }
}
