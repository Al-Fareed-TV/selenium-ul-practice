package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ElementLocatorDemo3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://web-playground.ultralesson.com");

        // Replace "element-css-selector" and "element-xpath" with actual values
        String cssSelector = "element-css-selector";
        String xpath = "element-xpath";

        // Locating element by CSS Selector
        WebElement elementByCssSelector = driver.findElement(By.cssSelector(cssSelector));
        System.out.println("Text of the element located by CSS Selector: " + elementByCssSelector.getText());

        // Locating element by XPath
        WebElement elementByXpath = driver.findElement(By.xpath(xpath));
        System.out.println("Text of the element located by XPath: " + elementByXpath.getText());

        driver.close();
    }
}