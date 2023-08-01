package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ElementLocatorDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://web-playground.ultralesson.com");

        // Replace "element-id" and "element-name" with actual values
        String id = "shopify-section-template--15328405749981__1635852374581d2a7e";
        String name = "options[prefix]";

        // Locating element by ID
        WebElement elementById = driver.findElement(By.id(id));
        System.out.println("Text of the element located by ID: " + elementById.getText());

        // Locating element by Name
        WebElement elementByName = driver.findElement(By.name(name));
        System.out.println("Text of the element located by Name: " + elementByName.getText());

        driver.close();
    }
}