package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class mouseActionsProject {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        //hover
        WebElement mouseHover = driver.findElement(By.xpath("//button[@class='dropbtn' and text()='Point Me']"));
        WebElement laptopHover = driver.findElement(By.xpath("//button[@class='dropbtn' and text()='Point Me']/parent::div/div/a[text()='Laptops']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mouseHover).moveToElement(laptopHover).click().perform();

        //double click
        WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
        field1.clear();
        field1.sendKeys("a test...");

        WebElement copyText = driver.findElement(By.xpath("//button[text()='Copy Text']"));
        actions.doubleClick(copyText).perform();

        String field2 = driver.findElement(By.xpath("//input[@id='field2']")).getAttribute("value");
        System.out.println("field2: "+field2);

        //drag and drop
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.dragAndDrop(drag,drop).perform();
        System.out.println(driver.findElement(By.xpath("//div[@id='droppable']/p")).getText());

        //navigate
        driver.navigate().to("https://demo.guru99.com/test/drag_drop.html");
        //debt
        WebElement Bank = driver.findElement(By.xpath("//a[text()=' BANK ']"));
        WebElement B5k = driver.findElement(By.xpath("(//li[@data-id='2']/a[contains(text(), '5000')])[1]"));
        WebElement debitSide = driver.findElement(By.xpath("//table[@id='table4']//td/div[@class='shoppingCart']//ol[@id='bank']"));
        WebElement amount = driver.findElement(By.xpath("//table[@id='table4']//td/div[@class='shoppingCart']//ol[@id='amt7']"));
        actions.dragAndDrop(Bank,debitSide).dragAndDrop(B5k,amount).perform();
        System.out.println(driver.findElement(By.xpath("//div[@id='bal3']/table//td[1]")).getText()+"   :   "+driver.findElement(By.xpath("//div[@id='bal3']/table//td[2]/div")).getText());

        //credit
        WebElement sales= driver.findElement(By.xpath("//a[contains(text(), 'SALES ')]"));
        WebElement anoth5K = driver.findElement(By.xpath("(//li[@data-id='2']/a[contains(text(), '5000')])[2]"));
        WebElement creditSide = driver.findElement(By.xpath("//ol[@id='loan']/li"));
        WebElement creditAmount = driver.findElement(By.xpath("//ol[@id='amt8']/li"));
        actions.dragAndDrop(sales,creditAmount).dragAndDrop(anoth5K,creditAmount).perform();
        System.out.println(driver.findElement(By.xpath("//div[@id='bal3']/table//td[3]")).getText()+"   :   "+driver.findElement(By.xpath("//div[@id='bal3']/table//td[4]/div")).getText());

        driver.navigate().back();
        driver.quit();



    }
}
