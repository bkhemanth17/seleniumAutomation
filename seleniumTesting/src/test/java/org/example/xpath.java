package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpath {

    /*
    to get the address of the element
    DOM- Document object model  (2 types of xpath)
    1. Absolute (full) - /html/body/main/div[2]/form/fieldset/div/div[1]/div/select
    2. Relative (partial) - //select[@name = 'language']

    relative starts with /, works with attributes, directly jump and find elements using attributes
     */

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");

        //attributes @id,@name,@classname,@attribute //tagName[@attribute='value']
        //xpath
        driver.findElement(By.xpath("//img[@alt='MacBook']"));

        //xpath with single attribute
        driver.findElement(By.xpath("//input[@placeholder = 'Search']")).sendKeys("macbook");

        //xpath with multiple attributes
        driver.findElement(By.xpath("//input[@name='search'][@placeholder = 'Search']"));

        //operators
        // AND operator -> both should true
        driver.findElement(By.xpath("//input[@name='search' and @placeholder = 'Search']"));

        //OR operator -> atleast one should true
        driver.findElement(By.xpath("//input[@name='search' or @placeholder = 'Search']"));

        //not operator -> (T becomes F, F becomes T)
        driver.findElement(By.xpath("//a[not(text() = 'iPhone')]"));

        //functions xpath with inner text
        //text() -> for some anchor tag elements no inner text so we cann't use and for some elements with no attributes may contains inner text, at that case text() will be used
        driver.findElement(By.xpath("//a[text() = 'iPhone']"));
        driver.findElement(By.xpath("//h3[text()='Featured']"));

        //contains() method
        //for attributes -> enter partial value it will fetch the result
        //input[contains(@placeholder, 'Sear')]
        //h3[contains(text() , 'Featured')]
        driver.findElement(By.xpath("//input[contains(@placeholder, 'Sear')]"));
        driver.findElement(By.xpath("//h3[contains(text() , 'Featured')]"));

        //starts-with() method
        driver.findElement(By.xpath("//input[starts-with(@placeholder, 'Sea')]"));

        //chained xpath -it's a combination of relative and absolute xpath
        //sometimes we couldn't able to find any attributes, locators, inner texts we use chained xpath
        //div[contains(@class, 'row justify')]/div/a/img
        driver.findElement(By.xpath("//div[contains(@class, 'col-12')]/a/img"));

        //axes
        /*
                                            ancestor
                                            parent
        preceding Sibling   <--------->     self      <--------->   following sibling
                                            child
                                            descendant
         */

        //parent
        //button[@title='Add to Cart']/parent::div
        //button[@title='Add to Cart']/parent::div[@class ='button-group']
        /*
        if there were more than one element than use indexation
        (//button[@title='Add to Cart']/parent::div)[1]
         */
        driver.findElement(By.xpath("//button[@title='Add to Cart']/parent::div"));
        driver.findElement(By.xpath("//button[@title='Add to Cart']/parent::div[@class ='button-group']"));


        //child
        //button[@title='Add to Cart']/child::i[contains(@class , 'fa-solid')]
        //button[@title='Add to Cart']/child::i
        //button[@title='Add to Cart']/i
        /*
        if there were more than one element than use indexation
        (//button[@title='Add to Cart']/child::i)[3]
        last() function also used
        (//button[@title='Add to Cart']/child::i[contains(@class , 'fa-solid')])[last()]

                            child shortcut(/)
        can directly use / instead of child::
        //button[@title='Add to Cart']/i
         */
        driver.findElement(By.xpath("//button[@title='Add to Cart']/child::i[contains(@class , 'fa-solid')]"));
        driver.findElement(By.xpath("//button[@title='Add to Cart']/i"));

        //ancestor
        //i[contains(@class, 'fa-solid')]/ancestor::div[@class = 'button-group']
        /* (//i[contains(@class, 'fa-solid')]/ancestor::div[@class = 'button-group'])[2]*/
        driver.findElement(By.xpath("//i[contains(@class, 'fa-solid')]/ancestor::div[@class = 'button-group']"));

        //descendant
        //div[@class ='nav float-start']/descendant::form
        //div[@class ='nav float-start']/descendant::form[@id='form-currency']
        /* (//div[@class ='nav float-start']/descendant::form)[1]
                        descendant shortcut (//)
        //div[@class ='nav float-start']/descendant::form
        //div[@class ='nav float-start']//form
         */
        driver.findElement(By.xpath("//div[@class ='nav float-start']/descendant::form"));
        driver.findElement(By.xpath("//div[@class ='nav float-start']//form"));

        //following siblings
        //div[@class = 'nav float-start']/following::div
        //div[@class = 'nav float-start']/following-sibling::div
        //div[@class = 'nav float-start']/following-sibling::div[@class = 'nav float-end']
        driver.findElement(By.xpath("//div[@class = 'nav float-start']/following-sibling::div"));

        //preceding siblings
        //div[@class = 'nav float-end']/preceding-sibling::div[@class ='nav float-start']
        //div[@class = 'nav float-end']/preceding::div
        //div[@class = 'nav float-end']/preceding-sibling::div
        driver.findElement(By.xpath("//div[@class = 'nav float-end']/preceding-sibling::div[@class ='nav float-start']"));

        //we can use last() functions
        /* (//button[@title='Add to Cart']/child::i[contains(@class , 'fa-solid')])[last()] */
        driver.findElement(By.xpath("(//button[@title='Add to Cart']/child::i[contains(@class , 'fa-solid')])[last()]"));

        /*
                                        shortcuts
        descendant (//)
        //div[@class ='nav float-start']/descendant::form
        //div[@class ='nav float-start']//form

        child(/)
        can directly use / instead of child::
        //button[@title='Add to Cart']/child::i
        //button[@title='Add to Cart']/i

        no shortcut for following,preceding siblings, ancestor
        can use / for following and child accordingly
         */



    }
}
