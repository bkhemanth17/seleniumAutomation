package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class paginationProject {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        int pages = driver.findElements(By.xpath("//ul[@id='pagination']/li/a")).size();
        for(int r = 1; r<=pages; r++){

            //page mover
            WebElement pointer = driver.findElement(By.xpath("//ul[@id='pagination']/li/a[text() ="+ r+"]"));
            pointer.click();

            int rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
            for(int i=1; i<=rows; i++){
                String id = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
                String name = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();
                String price = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[3]")).getText();

                System.out.println(id + "    "+ name+"   "+price);
            }

        }
        driver.quit();
    }
}
