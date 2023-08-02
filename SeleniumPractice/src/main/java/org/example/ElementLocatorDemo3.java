package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ElementLocatorDemo3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://web-playground.ultralesson.com");
        driver.manage().window().maximize();
        System.out.println("url of the current page is : "+driver.getCurrentUrl());
        System.out.println("Title  of the current page is : "+driver. getTitle());
        // Get text from an element (replace "elementLocator" with actual element locator)
        String elementLocator = "#shopify-section-header > sticky-header > header > nav";
        WebElement element = driver.findElement(By.cssSelector(elementLocator));
        String text = element.getText();
        System.out.println("Element Text: " + text);
        sleep(500);
        driver.close();
    }
}