package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ElementLocatorDemo2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://web-playground.ultralesson.com");

        // Replace "element-class" and "element-tag-name" with actual values
        String className = "header__heading";
        String tagName = "h1";

        // Locating element by Class
        WebElement elementByClass = driver.findElement(By.className(className));
        System.out.println("Text of the element located by Class: " + elementByClass.getText());

        // Locating element by Tag Name
        WebElement elementByTagName = driver.findElement(By.tagName(tagName));
        System.out.println("Text of the element located by Tag Name: " + elementByTagName.getText());

        driver.close();
    }
}
