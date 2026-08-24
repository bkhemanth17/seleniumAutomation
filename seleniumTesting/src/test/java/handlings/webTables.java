package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class webTables {
    /*
    static table
    dynamic table
    dynamic pagination table
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html");

        System.out.println("<--------------------------------------------------------------------------->");

        //rows
        int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println("rows: "+rows);

        //cols
        int cols = driver.findElements(By.xpath("//table[@name='BookTable']//tr/th")).size();
        System.out.println("cols: "+cols);

        System.out.println("<--------------------------------------------------------------------------->");
        //printing the value of an element
        String val = driver.findElement(By.xpath("//table[@name='BookTable']//tr[6]/td[1]")).getText();
        System.out.println(val);
        System.out.println("<--------------------------------------------------------------------------->");

        //print all data from
        for(int i=2; i<=rows; i++){
            for(int j =1; j<=cols; j++){
                String text = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td["+j+"]")).getText();
                System.out.print(text+" ");
            }
            System.out.println();
        }
        System.out.println("<--------------------------------------------------------------------------->");
        //finding specific
        for(int r=2; r<=rows; r++){
            String optText = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[2]")).getText();
            if (optText.equals("Mukesh")){
                String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[1]")).getText();
                String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[2]")).getText();
                String subject = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[3]")).getText();
                String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[4]")).getText();

                System.out.println(bookName+" | "+author+" | "+subject+" | "+price);
            }
        }
        System.out.println("<--------------------------------------------------------------------------->");
        driver.quit();
    }
}
