package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class mouseActions {
    /*
    1. mouse hover -> moveToElement(element).build().perform();     ||  actions.moveToElement(hoverElement).build().perform();
    moveToElement(element).perform();           ||  actions.moveToElement(hoverElement).perform();

    we can skip build() and directly write perform() -> that also works
    moveToElement(element).perform();
    for click moveToElement(element).click().perform();
    for multiple moveToElement(element).moveToElement(element2).perform();

    2. right click -> actions.contextClick(rtButton).perform();

    3. double click -> actions.doubleClick(doubleButton).perform();

    4. drag and drop -> actions.dragAndDrop(draggable,dropZone).perform();

    Additional : scroll to element and click-> actions.scrollToElement(rstclick).click(rstclick).perform();

    Actions - predefined class provided in selenium
    build() -> create an action
    perform() -> complete an action

    we can start (create an action) and perform it later store them in Action class and perform(complete) next

    Action to store and complete after sometime
    Action myAction = actions.doubleClick(doubleButton).build();
    myAction.perform();

    actions directly (performs) actions.doubleClick(doubleButton).build().perform();  || actions.doubleClick(doubleButton).perform();

     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://vinothqaacademy.com/mouse-event/");

        //mouse hover action
        WebElement hoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Hover On Me')]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        String text = "";
        for(int i=0; i<3; i++){
            try{
                text = driver.findElement(By.xpath("//span[@id='tooltipStatus']")).getText();
                break;
            }catch (StaleElementReferenceException exception){
                try {
                    Thread.sleep(500);
                }catch (InterruptedException exception1){
                    exception1.printStackTrace();
                }
            }
        }
        System.out.println(text);


        //right click action
        WebElement rtButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='rightBtn']")));
        actions.contextClick(rtButton).perform();
        System.out.println(driver.findElement(By.xpath("//span[@id='rightStatus']")).getText());
        WebElement option1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='contextMenu']/button[text()='Edit']")));
        option1.click();
        System.out.println(driver.findElement(By.xpath("//span[@id='rightStatus']")).getText());
        actions.contextClick(rtButton).perform();
        WebElement option2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='contextMenu']/button[text()='Copy']")));
        option2.click();
        System.out.println(driver.findElement(By.xpath("//span[@id='rightStatus']")).getText());
        actions.contextClick(rtButton).perform();
        WebElement option3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='contextMenu']/button[text()='Delete']")));
        option3.click();
        System.out.println(driver.findElement(By.xpath("//span[@id='rightStatus']")).getText());

        //double click
        WebElement doubleButton = driver.findElement(By.xpath("//button[@id='doubleBtn']"));
        Action myAction = actions.doubleClick(doubleButton).build();
        myAction.perform();
        System.out.println(driver.findElement(By.xpath("//span[@id='doubleStatus']")).getText());

        //drag and drop
        WebElement draggable = driver.findElement(By.xpath("//div[@id='dragItem']"));
        WebElement dropZone = driver.findElement(By.xpath("//div[@id='dropZone']"));
        actions.dragAndDrop(draggable,dropZone).perform();
        System.out.println(driver.findElement(By.xpath("//span[@id='dragStatus']")).getText());

        WebElement rstclick = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id='resetBtn']"))));
        actions.scrollToElement(rstclick).click(rstclick).perform();
        System.out.println(driver.findElement(By.xpath("//span[@id='dragStatus']")).getText());

        //another one
        driver.navigate().to("https://www.globalsqa.com/demo-site/draganddrop/#Accepted%20Elements");
        driver.findElement(By.xpath("//ul[@class ='resp-tabs-list ']/li[text() ='Accepted Elements']")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@rel-title='Accepted Elements']//iframe")));
        WebElement dragElement = driver.findElement(By.xpath("//p[text()='Drag me to my target']/parent::div[@id='draggable']"));
        WebElement dropElement = driver.findElement(By.xpath("//p[contains(text(), 'accept')]/parent::div[@id='droppable']"));
        actions.dragAndDrop(dragElement,dropElement).perform();
        System.out.println(driver.findElement(By.xpath("//div[@id='droppable']/p")).getText());
        driver.switchTo().defaultContent();
        driver.navigate().back();

        driver.quit();
    }
}
