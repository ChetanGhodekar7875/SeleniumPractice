package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SampleClass {
    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriver webDriver=new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        main5(webDriver);

    }

    public static void main5(WebDriver webDriver) throws InterruptedException, AWTException {
        webDriver.get("https://www.bing.com/");
        Actions actions=new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.id("sb_form_q"))).click().perform();
        Thread.sleep(5000);
        webDriver.findElement(By.id("sb_form_q")).sendKeys("selenium");

        List<WebElement> webElement=webDriver.findElements(By.xpath("//span[@class='sa_tm_text']/ancestor::ul[@class='sa_drw']//li"));


        for(WebElement actualOption:webElement){
            if((actualOption.getText()).contains("question")){
                actualOption.click();
                webDriver.findElement(By.id("sb_form_q")).sendKeys(Keys.ENTER);

                break;
            }
        }
        Thread.sleep(15000);
        webDriver.close();
    }

    public static void main4(WebDriver webDriver) throws InterruptedException {
        webDriver.get("https://www.twoplugs.com/newsearchserviceneed");

        WebElement webElement=webDriver.findElement(By.name("category_id"));
        Select select=new Select(webElement);

        List<WebElement> actualOption = select.getOptions();
        actualOption.remove(0);
        List<String> tempList=new ArrayList<>();
        List<String> originalList=new ArrayList<>();
        for(WebElement data:actualOption){
            tempList.add(data.getText());
            originalList.add(data.getText());
        }

        Collections.sort(tempList);

        if(tempList.equals(originalList)){
            System.out.println("SORTED");
        }else {
            System.out.println("UN-SORTED");
        }

        webDriver.close();

    }

    public static void main3(WebDriver webDriver) throws InterruptedException {
        //HOW TO HANDLE BOOTSTRAP DROP DOWN
        String productType="Accounts",product="Savings Accounts";
        webDriver.get("https://www.hdfcbank.com/");
        webDriver.findElement(By.xpath("//div[@class='drp1']")).click();

        WebDriverWait wait=new WebDriverWait(webDriver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//div[@class='drp1']"))));

        List<WebElement> firstWebElements=webDriver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
        for(WebElement webElement:firstWebElements){
            if(webElement.getText().equals(productType)){
                webElement.click();
                break;
            }
        }

        webDriver.findElement(By.xpath("//div[@class='drp2']")).click();

        List<WebElement> secondWebElements=webDriver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));
        for(WebElement webElement:secondWebElements){
            if(webElement.getText().equals(product)){
                webElement.click();
                break;
            }
        }

        Thread.sleep(5000);
        webDriver.close();
    }

    public static void main2(WebDriver webDriver) throws InterruptedException {
        webDriver.get("https://www.google.com/");
        WebElement webElement =webDriver.findElement(By.id("APjFqb"));
        webElement.sendKeys("Selenium");
        String attributeValueIs=webElement.getAttribute("value");
        System.out.println("ATTRIBUTE VALUE IS ->"+attributeValueIs);
        String webElementTextIs=webElement.getText();
        System.out.println("WEB ELEMENT TEXT IS "+webElementTextIs);
        webElement.clear();
        Thread.sleep(6000);
        webDriver.close();
    }

    public static void main1(WebDriver webDriver) throws InterruptedException {
        //I WANT TO SEARCH SOMETHING ON GOOGLE WITHOUT CLICKING ON GOOGLE SEARCH BUTTON IS IT POSSIBLE.
        // IF YES THEN HOW ITS POSSIBLE IF NOT TELL ME THE REASON
        webDriver.get("https://www.google.com/");
        webDriver.findElement(By.id("APjFqb")).sendKeys("Selenium", Keys.ENTER);
        Thread.sleep(5000);
        webDriver.close();
    }
}
