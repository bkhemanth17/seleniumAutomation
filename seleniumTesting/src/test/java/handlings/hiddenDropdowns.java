package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class hiddenDropdowns {
    /*
    To handle hidden dropdowns
    1. there are some ways event listeners we can remove blur framework

    2. go to source create a snippet (debugger;) and run the script the screen freeze in to debugger mode we can inspect those hidden elements/dropdowns
    once our work is done resume the debugger

    3. run a command (ctrl+shift+p) and type "emulate a focused page"
    once it's done run the command and type "Do not emulate a focused page"

     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //login
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[contains(@class, 'orangehrm-login-button')]")).click();

        //locating pim
        driver.findElement(By.xpath("//span[text() ='PIM']")).click();

        //clcking on job title dropdown (elements are hidden)
        //label[text() = 'Job Title']/parent::div/following-sibling::div//div[contains(text(),'Select')]
        driver.findElement(By.xpath("//label[text() = 'Job Title']/parent::div/following-sibling::div//div[contains(text(),'Select')]")).click();

        //selecting an option
        driver.findElement(By.xpath("//div[contains(@class, 'oxd-select-option')]/span[text() = 'Automaton Tester']")).click();


        //all options
        List<WebElement> options = driver.findElements(By.xpath("//div[@class = 'oxd-select-option']/span"));

        //printing all options
        for(WebElement option: options){
            String optText = option.getText();
            System.out.println(optText);
        }

        //selecting one from all options
        for(WebElement option: options){
            String optText = option.getText();
            if(optText.equals("Software Engineer") || optText.equals("QA Engineer")){
                option.click();
            }
        }

        driver.quit();
    }
}
