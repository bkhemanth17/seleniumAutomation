package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class fileUpload {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");

        //single file upload
        driver.findElement(By.xpath("//input[@name='filesToUpload']")).sendKeys("D:\\temp\\temp1.txt");

        if (driver.findElement(By.xpath("//ul[@id='fileList']/li")).isDisplayed()){
            System.out.println(driver.findElement(By.xpath("//ul[@id='fileList']/li")).getText());
            System.out.println("file is uploaded...");
        }else{
            System.out.println("upload failed...");
        }

        //refresh
        driver.navigate().refresh();

        //multiple file upload
        //approach 1
        String file1 = "D:\\temp\\temp1.txt";
        String file2 = "D:\\temp\\temp2.txt";
        driver.findElement(By.xpath("//input[@name='filesToUpload']")).sendKeys(file1+"\n"+file2);
        List<WebElement> files = driver.findElements(By.xpath("//ul[@id='fileList']/li"));
        System.out.println(files.size());
        for(WebElement file: files){
            if (file.isDisplayed()){
                String txt = file.getText();
                System.out.println(txt);
            }
            else {
                System.out.println("no files uploaded...");
            }
        }
        //approach 2
        driver.navigate().refresh();
        driver.findElement(By.xpath("//input[@name='filesToUpload']")).sendKeys("D:\\temp\\temp1.txt"+"\n"+"D:\\temp\\temp2.txt"+"\n"+"D:\\temp\\temp3.xlsx");
        List<WebElement> files1 = driver.findElements(By.xpath("//ul[@id='fileList']/li"));
        int uploaded = files1.size();

        for(WebElement file: files1){
            if (file.isDisplayed()){
                String txt = file.getText();
                System.out.println(txt);
            }
            else {
                System.out.println("no files uploaded...");
            }
        }

        //validating by file (number of files)
        if(uploaded == 3){
            System.out.println("all files uploaded successfully...");
        }else{
            System.out.println("files are not uploaded or incorrect files are uploaded or required number of files not uploaded");
        }

        //validating files and file names
        for(WebElement file: files1){
            String txt = file.getText();
            if(txt.equals("temp1.txt")|| txt.equals("temp2.txt")|| txt.equals("temp3.xlsx")){
                System.out.println("file is matching: "+txt);
            }else{
                System.out.println("files are not matching...");
            }
        }
        
        driver.quit();
    }
}
