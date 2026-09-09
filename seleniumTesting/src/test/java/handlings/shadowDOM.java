package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class shadowDOM {
    /*

    ------------------------------- |
    Document            ---------| :|-> Document Tree - (including document, shadow host, shadow root, elements(shadow tree))
    -*----------------------------- |
    shadow Host         ---------|:=|
    Shadow Root         ---------|:=|-> shadow Tree - (including Shadow Host, Shadow Root, elements)
    Elements            ---------|:=|
    ------------------------------- |

    Document contains shadow Host (inside the shadow host it will be shadow tree)
    shadow host contains shadow root and elements(called as shadow tree)
    the whole chain including document called as Document Tree

    elements inside shadow dom cann't be accessed using xpath, we use css selector
    We use searchcontext to store(hold) the shadowDom instead of webelement

    search context -> it's parent interface for both web element and web driver it's used for searching elements
    has findElement(), findElements()

    Web element has search and some actions like click(), sendkeys(), gettext()...

    if we store shadowDom in search context it's unnecesary we dont perform any actions and there's nothing to perform it's just for locating elements
    and if we need to locate shadow root from shadow host we use getShadowRoot() -> method this method returns searchcontext not web element so we use search context()
    as mostly operation is just locating elements/shadow DOMS and getShadowRoot();
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://dev.automationtesting.in/shadow-dom");

        //shadow Element
        SearchContext shadowRoot = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        String shadowElement = shadowRoot.findElement(By.cssSelector("#shadow-element")).getText();
        System.out.println(shadowElement);

        //nested Shadow Element
        SearchContext shadowRoot1 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        SearchContext shadowRoot2 = shadowRoot1.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
        String nestedShadowElement = shadowRoot2.findElement(By.cssSelector("#nested-shadow-element")).getText();
        System.out.println(nestedShadowElement);

        //multi nested Shadow element
        SearchContext shadowRoot11 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        SearchContext shadowRoot22 = shadowRoot11.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
        SearchContext shadowRoot33 = shadowRoot22.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
        String multiNestedElement = shadowRoot33.findElement(By.cssSelector("#multi-nested-shadow-element")).getText();
        System.out.println(multiNestedElement);

        driver.quit();
    }
}
