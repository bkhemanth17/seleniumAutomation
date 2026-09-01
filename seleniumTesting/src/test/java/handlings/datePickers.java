package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class datePickers {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jqueryui.com/datepicker/");

        WebElement frames = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frames);

        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        String year = "2025";
        String month = "September";
        int date = 15;

        //forFuture(driver,month,year,date);
        forPast(driver,month,year,date);

        driver.quit();

    }

    //for future date pickers
    static void forFuture(WebDriver driver, String month, String year, int date){
        //for month and year
        while(true){
            String cal_month = driver.findElement(By.xpath("//span[@class= 'ui-datepicker-month']")).getText();
            String cal_year = driver.findElement(By.xpath("//span[@class= 'ui-datepicker-year']")).getText();

            if(month.equalsIgnoreCase(cal_month) && year.equals(cal_year)){
                break;
            }
            //next button
            driver.findElement(By.xpath("//span[contains(@class, 'ui-icon-circle-triangle-e')]")).click();

        }
        //date picking
        WebElement date_pick = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[text()='"+date+"']"));
        date_pick.click();
    }

    // for past date pickers
    static void forPast(WebDriver driver, String month, String year, int date){
        //for month and year
        while(true){
            String cal_month = driver.findElement(By.xpath("//span[@class= 'ui-datepicker-month']")).getText();
            String cal_year = driver.findElement(By.xpath("//span[@class= 'ui-datepicker-year']")).getText();

            if(month.equalsIgnoreCase(cal_month) && year.equals(cal_year)){
                break;
            }
            //previous button
            driver.findElement(By.xpath("//span[contains(@class, 'ui-icon-circle-triangle-w')]")).click();

        }
        //date picking
        WebElement date_pick = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[text()='"+date+"']"));
        date_pick.click();
    }

}