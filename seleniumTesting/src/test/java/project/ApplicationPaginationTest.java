package project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationPaginationTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("Admin");

        WebElement passwd = driver.findElement(By.xpath("//input[@name='password']"));
        passwd.sendKeys("admin123");

        driver.findElement(By.xpath("//button[contains(., 'Login')]")).click();
        driver.findElement(By.xpath("//span[text() ='Recruitment']")).click();

        int pages = driver.findElements(By.xpath("//button[not(contains(@class, 'oxd-pagination-page-item--previous-next')) and contains(@class, 'oxd-pagination-page-item--page')]")).size();


        for(int p=1; p<=pages; p++){
            WebElement pgBtn = driver.findElement(By.xpath("//button[not(contains(@class, 'oxd-pagination-page-item--previous-next')) and contains(@class, 'oxd-pagination-page-item--page') and text() = '"+p+"']"));
            pgBtn.click();

            System.out.println("::::::::::::::::: ALL data :::::::::::::::::");

            //tables data
            int totTables = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card']")).size();
            for(int i=1; i<=totTables; i++){

//                WebElement checkbox = driver.findElement(By.xpath("(//div[@class='oxd-table-card']//div[contains(@class, 'oxd-padding-cell')][1]//span[contains(@class, 'oxd-checkbox-input')])["+i+"]"));
//                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//                jsExecutor.executeScript("arguments[0].click();",checkbox);

                String vacancy = driver.findElement(By.xpath("(//div[@class='oxd-table-card']//div[contains(@class, 'oxd-padding-cell')][2]//div)["+i+"]")).getText();
                String candidate = driver.findElement(By.xpath("(//div[@class='oxd-table-card']//div[contains(@class, 'oxd-padding-cell')][3]//div)["+i+"]")).getText();
                String hiringManager = driver.findElement(By.xpath("(//div[@class='oxd-table-card']//div[contains(@class, 'oxd-padding-cell')][4]//div)["+i+"]")).getText();
                String DateOfApplication = driver.findElement(By.xpath("(//div[@class='oxd-table-card']//div[contains(@class, 'oxd-padding-cell')][5]//div)["+i+"]")).getText();
                String Status = driver.findElement(By.xpath("(//div[@class='oxd-table-card']//div[contains(@class, 'oxd-padding-cell')][6]//div)["+i+"]")).getText();

                System.out.println(vacancy+"    |   "+candidate+"    |   "+hiringManager+"    |   "+DateOfApplication+"    |   "+Status);

            }
        }

        System.out.println("::::::::::::::::: shortlisted data :::::::::::::::::");
        //will print only shortlisted candidates
        for(int p=1; p<=pages; p++){
            WebElement pgBtn = driver.findElement(By.xpath("//button[not(contains(@class, 'oxd-pagination-page-item--previous-next')) and contains(@class, 'oxd-pagination-page-item--page') and text() = '"+p+"']"));
            pgBtn.click();

            //tables data
            int totTables = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card']")).size();
            for(int i=1; i<=totTables; i++){

                String Status = driver.findElement(By.xpath("(//div[@class='oxd-table-card']//div[contains(@class, 'oxd-padding-cell')][6]//div)["+i+"]")).getText();
                if(Status.equals("Shortlisted")){

                    WebElement checkbox = driver.findElement(By.xpath("(//div[@class='oxd-table-card']//div[contains(@class, 'oxd-padding-cell')][1]//span[contains(@class, 'oxd-checkbox-input')])["+i+"]"));

                    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                    jsExecutor.executeScript("arguments[0].click();",checkbox);

                    String vacancy = driver.findElement(By.xpath("(//div[@class='oxd-table-card']//div[contains(@class, 'oxd-padding-cell')][2]//div)["+i+"]")).getText();
                    String candidate = driver.findElement(By.xpath("(//div[@class='oxd-table-card']//div[contains(@class, 'oxd-padding-cell')][3]//div)["+i+"]")).getText();
                    String hiringManager = driver.findElement(By.xpath("(//div[@class='oxd-table-card']//div[contains(@class, 'oxd-padding-cell')][4]//div)["+i+"]")).getText();
                    String DateOfApplication = driver.findElement(By.xpath("(//div[@class='oxd-table-card']//div[contains(@class, 'oxd-padding-cell')][5]//div)["+i+"]")).getText();
                    //String Status = driver.findElement(By.xpath("(//div[@class='oxd-table-card']//div[contains(@class, 'oxd-padding-cell')][6]//div)["+i+"]")).getText();

                    System.out.println(vacancy+"    |   "+candidate+"    |   "+hiringManager+"    |   "+DateOfApplication+"    |   "+Status);
                }
            }
        }
        driver.quit();
    }
}
