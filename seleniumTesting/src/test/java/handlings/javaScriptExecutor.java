package handlings;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class javaScriptExecutor {

    /*

                                                                        |JavaScriptExecutor|    (interface) implementation provided by Remote Web Driver along with web driver interface, screenshot interfacef
    Search context (parent, interface)-> WebDriver(parent, interface) -> Remote WebDriver (provides implementation for different browsers)
                                                                         |Screenshot|            (interface) implementation provided by Remote Web Driver

    sometimes we use click() and sendKeys() at that time we may get element intercepted exception to handle that we use javascript executor

    sendKeys() -> javascriptExecutor.executeScript("arguments[0].setAttribute('value', 'User1')",inputBox);
    click() -> javascriptExecutor.executeScript("arguments[0].click()",checkBox);

                        Scrolling Pages
    Scroll Down By pixels -> javascriptExecutor.executeScript("window.scrollBy(0,6000)","");
    to know the scroller location -> javascriptExecutor.executeScript("return window.pageYOffset");

    Scroll to Element -> javascriptExecutor.executeScript("arguments[0].scrollIntoView()",India);

    Scroll till End (bottom of the page) -> javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    scroll to Top of the page (Initial position) -> javascriptExecutor.executeScript("window.scrollBy(0,- document.body.scrollHeight)");


     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        //javascript executor
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        //send keys
        WebElement inputBox = driver.findElement(By.xpath("//input[@id='name']"));
        javascriptExecutor.executeScript("arguments[0].setAttribute('value', 'User1')",inputBox);

        //click()
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='male']"));
        javascriptExecutor.executeScript("arguments[0].click()",checkBox);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");

        //scroll down   by pixels
        javascriptExecutor.executeScript("window.scrollBy(0,6000)","");
        System.out.println(javascriptExecutor.executeScript("return window.pageYOffset"));

        //scroll to Element
        WebElement India = driver.findElement(By.xpath("//td[text()='India']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView()",India);
        System.out.println(javascriptExecutor.executeScript("return window.pageYOffset"));

        //scroll till End of the page
        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        System.out.println(javascriptExecutor.executeScript("return window.pageYOffset"));

        //scroll to Top of the page (Initial position)
        javascriptExecutor.executeScript("window.scrollBy(0,- document.body.scrollHeight)");
        System.out.println(javascriptExecutor.executeScript("return window.pageYOffset"));
    }
}
