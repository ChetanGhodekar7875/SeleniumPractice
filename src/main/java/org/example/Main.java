package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws AWTException, InterruptedException {
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--disabled-notifications");

        WebDriver webDriver=new ChromeDriver(chromeOptions);
        Set<String> data=webDriver.getWindowHandles();
        webDriver.manage().window().maximize();
        test(webDriver);
    }
    public static void test4(WebDriver webDriver) throws InterruptedException {
        webDriver.get("https://www.nyse.com/ipo-center/ipo-pricing-stats");
        Thread.sleep(8000);
        webDriver.findElement(By.id("onetrust-close-btn-container")).click();
        String rowXpath="//thead//tr[3]//th";
        int column= webDriver.findElements(By.xpath(rowXpath)).size();
        List<WebElement> rows =webDriver.findElements(By.xpath("//table//tbody//tr"));
        Thread.sleep(3000);

        for(int i=1;i<=rows.size();i++){
            for(int j=1;j<=column;j++){
                if(j==4){
                    String xpath="//table//tbody//tr["+i+"]//td//div";
                    List<WebElement> webElements=webDriver.findElements(By.xpath(xpath));
                    for(WebElement data:webElements){
                        if(!data.getAttribute("title").isEmpty())
                        System.out.print(data.getAttribute("title")+"\t");
                    }
                }else {
                    String xptha = "//table//tbody//tr[" + i + "]//td[" + j + "]";
                    System.out.print("\t"+webDriver.findElement(By.xpath(xptha)).getText() + "\t");
                }
            }

            System.out.println();
        }
        webDriver.close();
    }
    public static void test2(WebDriver webDriver) throws InterruptedException {
        webDriver.get("https://www.makemytrip.com/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
        Actions actions=new Actions(webDriver);
        actions.click().perform();
        Thread.sleep(5000);
        WebElement webElement=webDriver.findElement(By.xpath("//span[@class='commonModal__close']"));
        actions.click(webElement).click().perform();
        Thread.sleep(5000);
       webDriver.findElement(By.id("fromCity")).click();
        Thread.sleep(5000);
       webDriver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Pune");
        Thread.sleep(5000);
       webDriver.findElement(By.xpath("//span[text()='PNQ']")).click();
    }

    public static void test1(WebDriver webDriver) throws InterruptedException {
        webDriver.get("https://demo.guru99.com/test/delete_customer.php");
        Thread.sleep(5000);
        webDriver.findElement(By.name("cusid")).sendKeys("CHETAN");
        Thread.sleep(5000);
        webDriver.findElement(By.name("submit")).click();
        webDriver.switchTo().alert().accept();
        Thread.sleep(5000);
        webDriver.switchTo().alert().accept();
        webDriver.quit();
    }

    public static void test(WebDriver webDriver) throws InterruptedException {
        webDriver.get(" https://demo.guru99.com/popup.php");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        String parentWindowId= webDriver.getWindowHandle();
        
        System.out.println(parentWindowId);

        webDriver.findElement(By.linkText("Click Here")).click();

        Set<String> allWindowIds=webDriver.getWindowHandles();
        System.out.println(allWindowIds);
        for(String data:allWindowIds){
            if(!parentWindowId.equals(data)){
                webDriver.switchTo().window(data);
                webDriver.findElement(By.name("emailid")).sendKeys("abcd@gmail.com");
                webDriver.close();
            }
        }
        Thread.sleep(5000);
        webDriver.close();
    }



}