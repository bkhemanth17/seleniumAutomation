package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.*;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class brokenLinks {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.deadlinkcity.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        Set<String> brokenURL = new HashSet<>();
        Set<String> workingURLS = new HashSet<>();
        int brokenLinks = 0;
        for(WebElement link:links){
            String hrefLink = link.getAttribute("href");
            if(hrefLink.equals(null) || hrefLink.isEmpty()){
                continue;
            }
            try{
                URI uri = new URI(hrefLink);
                URL url = uri.toURL();

                /*
                //if we are using Proxy to connect into customers network
                client will provide proxy address (HTTP and SSL including & port numb)
                Proxy.Type.HTTP -> java tells what protocol the proxy server speaks communication (works with HTTP and HTTPS)
                new InetSocketAddress("proxy.client-network.com",8080) ->  java network class for hostname and port name together
                splits hosts name and port number but in the same class inetSocketAddress
                and then we use them to HttpURLConnection -> openConnection(proxy) -> when opening connection to the proxy server
                urlConnection.setRequestMethod("HEAD"); -> just check the status code unlike get request get will download all the info about links/pages whereas head will only see the status code and it will save bandwidth and speed, instead of downloading and checking using get request

                
                //proxy code
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.client-network.com",8080));
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection(proxy);//open connection to the server
                urlConnection.setRequestMethod("HEAD");
                urlConnection.connect(); //connect to the server and send the request to the server
                 */

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection(); //open connection to the server
                urlConnection.connect(); //connect to the server and send the request to the server
                if (urlConnection.getResponseCode() >= 400){
                    brokenLinks++;
                    brokenURL.add(hrefLink+" - "+urlConnection.getResponseCode()+" - "+urlConnection.getResponseMessage());
                }else{
                    workingURLS.add(hrefLink+" - "+urlConnection.getResponseCode()+" - "+urlConnection.getResponseMessage());
                }
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }

        driver.quit();
        System.out.println(":::::::::::::::::::::::::::::::::::::::::: Broken Links ::::::::::::::::::::::::::::::::::::::::::");
        //broken links
        System.out.println("total broken links: "+brokenLinks);
        for(String urls: brokenURL){
            System.err.println(urls);
        }
    }
}