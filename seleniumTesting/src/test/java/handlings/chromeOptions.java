package handlings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class chromeOptions {

    //headless testing -> chromeOptions.addArguments("--headless=new");

    //SSL handling -> chromeOptions.setAcceptInsecureCerts(true);

    /*
    remove "chrome is being controlled by automated test software"
    chromeOptions.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
     */

    //incognito mode -> chromeOptions.addArguments("--incognito");


    public static void main(String[] args) {

        ChromeOptions chromeOptions = new ChromeOptions();

        //headless testing
        chromeOptions.addArguments("--headless=new");

        //SSL
        chromeOptions.setAcceptInsecureCerts(true);

        //remove chrome is being controlled by automation test software
        chromeOptions.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});

        //incognito
        chromeOptions.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String title = driver.getTitle();

        if (title.equals("OrangeHRM")){
            System.out.println("that's correct");
        }else {
            System.out.println("that's wrong");
        }

        //for SSL issues
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://expired.badssl.com/");
        System.out.println("title: "+driver.getTitle());

        driver.quit();
    }
}
