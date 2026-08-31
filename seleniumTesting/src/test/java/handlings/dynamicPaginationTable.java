package handlings;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class dynamicPaginationTable {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/TlbeVW/");

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.clear();
        userName.sendKeys("demo");

        WebElement passwd = driver.findElement(By.xpath("//input[@name='password']"));
        passwd.clear();
        passwd.sendKeys("demo");

        driver.findElement(By.xpath("//button[contains(text(), ' Login')]")).click();

        driver.findElement(By.xpath("//li[@id='menu-customer']/a[contains(text(), ' Customers')]")).click();
        driver.findElement(By.xpath("//li[@id='menu-customer']//li/a[contains(text(), 'Customers')]")).click();

        String text = driver.findElement(By.xpath("//div[contains(text(), 'Pages')]")).getText();
        int total_pages = Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));

        for(int p=1; p<=total_pages; p++){
            if(p>1){
                WebElement element = driver.findElement(By.xpath("//li[@class = 'page-item']/a[text() ="+p+"]"));
                element.click();
            }
            int rows = driver.findElements(By.xpath("//table[contains(@class, 'table-hover')]/tbody/tr")).size();

            for(int r = 1; r<=rows; r++){
                String cust_name = driver.findElement(By.xpath("//table[contains(@class, 'table-hover')]/tbody/tr["+r+"]/td[2]")).getText();
                String email = driver.findElement(By.xpath("//table[contains(@class, 'table-hover')]/tbody/tr["+r+"]/td[3]")).getText();
                String cust_group = driver.findElement(By.xpath("//table[contains(@class, 'table-hover')]/tbody/tr["+r+"]/td[4]")).getText();
                String date = driver.findElement(By.xpath("//table[contains(@class, 'table-hover')]/tbody/tr["+r+"]/td[5]")).getText();

                System.out.println(cust_name + "    "+email+"   "+cust_group+"   "+date);
            }
        }
    }
}
