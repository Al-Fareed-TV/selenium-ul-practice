package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class WebElementInteractionsDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://web-playground.ultralesson.com");

        // Locate the search icon, search bar and search button
        WebElement searchIcon = driver.findElement(By.cssSelector("#shopify-section-header > sticky-header > header > div > details-modal > details > summary > span > svg.modal__toggle-open.icon.icon-search"));
        WebElement searchBar = driver.findElement(By.cssSelector("#Search-In-Modal"));

        // Interact with the search bar
        searchIcon.click();
        searchBar.click();
        sleep(600);
        searchBar.sendKeys("Shoe");
        sleep(600);

        searchBar.clear();
        searchBar.sendKeys("Shirt");
        sleep(600);

        driver.close();
    }
}
