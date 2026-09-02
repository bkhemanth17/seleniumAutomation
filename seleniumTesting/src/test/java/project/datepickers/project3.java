package project.datepickers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;


public class project3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        //dates
        String date1 = "12-October-2023";
        String date2 = "14-November-2032";
        String date3 = "1-April-2019";
        String date4 = "1-April-2027";

        calenderOne(driver,date1);
        calenderTwo(driver,date2);
        calenderThree(driver,date3);
        calenderFour(driver,date4);

        driver.quit();

    }
    static void calenderOne(WebDriver driver, String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Calendar calendar = Calendar.getInstance();
        Date targettedDate;
        try{
            simpleDateFormat.setLenient(false);
            targettedDate = simpleDateFormat.parse(date);
            calendar.setTime(targettedDate);
            int target_date = calendar.get(Calendar.DAY_OF_MONTH);
            int target_month = calendar.get(Calendar.MONTH);
            int target_year = calendar.get(Calendar.YEAR);

            driver.findElement(By.xpath("//input[@id='datepicker']")).click();

            String cal_title = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
            calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(cal_title));
            int cal_month = calendar.get(Calendar.MONTH);
            int cal_year = calendar.get(Calendar.YEAR);

            //previous button
            while(target_year < cal_year || (target_year == cal_year && target_month < cal_month)){
                driver.findElement(By.xpath("//span[contains(text(), 'Prev')]")).click();
                cal_title = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
                calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(cal_title));
                cal_month = calendar.get(Calendar.MONTH);
                cal_year = calendar.get(Calendar.YEAR);
            }

            //next button
            while(target_year > cal_year || (target_year == cal_year && target_month > cal_month)){
                driver.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();
                cal_title = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
                calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(cal_title));
                cal_month = calendar.get(Calendar.MONTH);
                cal_year = calendar.get(Calendar.YEAR);
            }

            //date
            driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//td[not(contains(@class, 'ui-datepicker-other-month'))]/a[text()='"+target_date+"']")).click();
        }catch (ParseException parseException){
            System.out.println("invalid");
        }
    }
    static void calenderTwo(WebDriver driver, String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Calendar calendar = Calendar.getInstance();
        Date targettedDate;
        try {
            simpleDateFormat.setLenient(false);
            targettedDate = simpleDateFormat.parse(date);
            calendar.setTime(targettedDate);
            int target_date = calendar.get(Calendar.DAY_OF_MONTH);
            int target_month = calendar.get(Calendar.MONTH);
            int target_year = calendar.get(Calendar.YEAR);

            driver.findElement(By.xpath("//input[@id='txtDate']")).click();

            //month
            WebElement element1 = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']"));
            Select monthSelect = new Select(element1);
            monthSelect.selectByValue(target_month+"");

            //year
            WebElement element2 = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']"));
            Select yearSelect = new Select(element2);
            yearSelect.selectByValue(target_year+"");

            //date
            driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//td[not(contains(@class, 'ui-datepicker-other-month'))]/a[text()='"+target_date+"']")).click();

        }catch (ParseException parseException){
            System.out.println("invalid");
        }
    }

    static void calenderThree(WebDriver driver, String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Calendar calendar = Calendar.getInstance();
        Date targettedDate;

        try {
            simpleDateFormat.setLenient(false);
            targettedDate = simpleDateFormat.parse(date);
            calendar.setTime(targettedDate);
            int target_date = calendar.get(Calendar.DAY_OF_MONTH);
            int target_month = calendar.get(Calendar.MONTH)+1;
            int target_year = calendar.get(Calendar.YEAR);

            //convert to string
            String passer = String.format("%04d-%02d-%02d",target_year, target_month, target_date);

            //passing date
            WebElement start_date = driver.findElement(By.xpath("//input[@id='start-date']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='"+passer+"';",start_date);

        }catch (ParseException parseException){
            System.out.println("invalid");
        }
    }

    static void calenderFour(WebDriver driver, String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Calendar calendar = Calendar.getInstance();
        Date targettedDate;

        try {
            simpleDateFormat.setLenient(false);
            targettedDate = simpleDateFormat.parse(date);
            calendar.setTime(targettedDate);
            int target_date = calendar.get(Calendar.DAY_OF_MONTH);
            int target_month = calendar.get(Calendar.MONTH)+1;
            int target_year = calendar.get(Calendar.YEAR);

            //convert to string
            String passer = String.format("%04d-%02d-%02d",target_year,target_month,target_date);

            //passing date
            WebElement end_date = driver.findElement(By.xpath("//input[@id='end-date']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='"+passer+"';",end_date);

        }catch (ParseException parseException){
            System.out.println("invalid");
        }
    }
}