package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class ScrollingTechniquesDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web-playground.ultralesson.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement footer = driver.findElement(By.cssSelector("#shopify-section-footer > footer > div.footer__content-bottom > div > div.footer__column.footer__localization"));
        js.executeScript("arguments[0].scrollIntoView();",footer);
        System.out.println("Scrolled to last point");
        sleep(2000);
        WebElement startPoint = driver.findElement(By.cssSelector("#shopify-section-template--15328405749981__featured_products > div > div.title-wrapper-with-link"));
        js.executeScript("arguments[0].scrollIntoView();",startPoint);
        System.out.println("Scrolled to top");
        sleep(2000);
        // Scroll up by a specific number of pixels
        js.executeScript("window.scrollBy(0, -500);");
        System.out.println("Successfully scrolled up by 500 pixels");
        sleep(2000);
        driver.close();



    }
}
