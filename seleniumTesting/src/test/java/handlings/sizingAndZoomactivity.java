package handlings;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sizingAndZoomactivity {
    /*
    to maximize -> driver.manage().window().maximize();
    to minimize -> driver.manage().window().minimize();
    to zoom by 30% -> js.executeScript("document.body.style.zoom='30%'");
    to zoom by 150% -> js.executeScript("document.body.style.zoom='150%'");
     */
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().maximize();

        //zoom by 30%
        js.executeScript("document.body.style.zoom='30%'");

        //zoom by 80%
        js.executeScript("document.body.style.zoom='80%'");

        //zoom by 150%
        js.executeScript("document.body.style.zoom='150%'");





    }
}
