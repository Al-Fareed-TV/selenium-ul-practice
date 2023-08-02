package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserNavigationDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://web-playground.ultralesson.com");

        // Click on any product on the page
        String productLocator = "#shopify-section-template--15328405749981__featured_products > div > slider-component > ul > li:nth-child(1) > div > div.card-information > div > h3 > a";
        WebElement product = driver.findElement(By.cssSelector(productLocator));
        product.click();

        // Navigate back
        driver.navigate().back();
        System.out.println("Navigated back to the previous page.");

        // Navigate forward
        driver.navigate().forward();
        System.out.println("Navigated forward to the next page.");

        // Refresh the page
        driver.navigate().refresh();
        System.out.println("Refreshed the current page.");

        driver.close();
    }
}
