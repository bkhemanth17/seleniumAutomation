package project.datepickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class project1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");

        Calendar calendar = Calendar.getInstance();
        String customDate = "05-Aug-2028";
        Calender(driver,customDate,calendar);

        driver.quit();

    }
    static void Calender(WebDriver driver, String customDate,Calendar calendar){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date targettedDate;
        try {
            simpleDateFormat.setLenient(false);
            targettedDate = simpleDateFormat.parse(customDate);
            calendar.setTime(targettedDate);

            int targetDate = calendar.get(Calendar.DAY_OF_MONTH);
            int targetMonth = calendar.get(Calendar.MONTH);
            int targetYear = calendar.get(Calendar.YEAR);

            driver.findElement(By.xpath("//input[@id='second_date_picker']")).click();

            String cal_month_year = driver.findElement(By.xpath("//div[contains(@class, 'ui-datepicker-header')]//div[@class='ui-datepicker-title']")).getText();
            calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(cal_month_year));

            int actual_month = calendar.get(Calendar.MONTH);
            int actual_year = calendar.get(Calendar.YEAR);


            //previous button
            while (targetYear < actual_year || (targetYear == actual_year && targetMonth < actual_month)){
                driver.findElement(By.xpath("//div[contains(@class, 'ui-datepicker-header')]//span[text()='Prev']")).click();
                cal_month_year = driver.findElement(By.xpath("//div[contains(@class, 'ui-datepicker-header')]//div[@class='ui-datepicker-title']")).getText();
                calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(cal_month_year));
                actual_month = calendar.get(Calendar.MONTH);
                actual_year = calendar.get(Calendar.YEAR);
            }

            //next button
            while (targetYear > actual_year ||(targetYear == actual_year && targetMonth > actual_month)){
                driver.findElement(By.xpath("//div[contains(@class, 'ui-datepicker-header')]//span[text()='Next']")).click();
                cal_month_year = driver.findElement(By.xpath("//div[contains(@class, 'ui-datepicker-header')]//div[@class='ui-datepicker-title']")).getText();
                calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(cal_month_year));
                actual_month = calendar.get(Calendar.MONTH);
                actual_year = calendar.get(Calendar.YEAR);
            }

            driver.findElement(By.xpath("//table[@class= 'ui-datepicker-calendar']/tbody//td[not(contains(@class, 'ui-datepicker-other-month'))]/a[text()='"+targetDate+"']")).click();

        }catch (ParseException parseException){
            parseException.getStackTrace();
            System.out.println(parseException.getMessage());
            System.out.println("Invalid date");
        }
    }
}
