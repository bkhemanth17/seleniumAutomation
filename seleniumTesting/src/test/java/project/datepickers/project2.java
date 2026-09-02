package project.datepickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.time.Duration;

public class project2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
        Calendar calendar = Calendar.getInstance();

        String date = "25-January-2029";
        Calender(driver,date,calendar);

    }
    static void Calender(WebDriver driver, String date, Calendar calendar){
        SimpleDateFormat targetFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date targetted_date;
        try {
            targetFormat.setLenient(false);
            targetted_date = targetFormat.parse(date);
            calendar.setTime(targetted_date);
            int targetDate = calendar.get(Calendar.DAY_OF_MONTH);
            int targetMonth = calendar.get(Calendar.MONTH);
            int targetYear = calendar.get(Calendar.YEAR);

            driver.findElement(By.xpath("//input[@id='fourth_date_picker']")).click();

            //month
            WebElement element1 = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
            Select select1 = new Select(element1);
            select1.selectByValue(targetMonth+"");

            //year
            WebElement element2 = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
            Select select2 = new Select(element2);
            select2.selectByValue(targetYear+"");

            //date
            driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class, 'ui-datepicker-other-month'))]/a[text()='"+targetDate+"']")).click();

        }catch (ParseException parseException){
            System.out.println("invalid date...");
        }
    }
}
