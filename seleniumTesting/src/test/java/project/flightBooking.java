package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class flightBooking {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://blazedemo.com/reserve.php");
        int rows = driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();

        String lowStr = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[6]")).getText().replace("$","").trim();
        Double lowFare = Double.valueOf(lowStr);

        // low price validator
        int roWw = 0;
        for(int i=1; i<=rows; i++){
            String element = driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+i+"]/td[6]")).getText();
            String elemt = element.replace("$","").trim();
            Double val = Double.valueOf(elemt);
            if(val<lowFare){
                lowFare = val;
                roWw = i;
            }
        }

        // low ticket fare booking
        WebElement webElement = driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+roWw+"]/td[1]/input"));
        webElement.click();

        // flight details
        System.out.println(driver.findElement(By.xpath("//div[@class = 'container']/h2")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@class = 'container']/p[contains(text(), 'Airline')]")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@class = 'container']/p[contains(text(), 'Flight Number')]")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@class = 'container']/p[contains(text(), 'Total Cost')]")).getText());

        //form filling
        driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Jacob");
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Near Times Square, NYC");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Albany");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("New York");
        driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("12201");

        //payment
        Select select = new Select(driver.findElement(By.xpath("//select[@id='cardType']")));
        select.selectByValue("visa");
        driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("10");
        driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2035");
        driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Jacob Matthews");
        driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

        //Booking successful
        System.out.println(" <-------------------> Booking successful <-------------------> ");

        System.out.println(driver.findElement(By.xpath("//div[@class = 'container hero-unit']/h1")).getText());
        System.out.println(driver.findElement(By.xpath("//table[@class = 'table']/tbody/tr[1]/td[2]")).getText());
        System.out.println("code: "+driver.findElement(By.xpath("//table[@class = 'table']/tbody/tr[6]/td[2]")).getText());
        System.out.println("date: "+driver.findElement(By.xpath("//table[@class = 'table']/tbody/tr[7]/td[2]")).getText());
        String api = driver.findElement(By.xpath("//table[@class = 'table']/following-sibling::pre")).getText();
        

        driver.quit();
    }
}
