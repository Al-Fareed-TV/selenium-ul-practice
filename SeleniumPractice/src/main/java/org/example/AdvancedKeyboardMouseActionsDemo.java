package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class AdvancedKeyboardMouseActionsDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://web-playground.ultralesson.com");

        WebElement searchIcon = driver.findElement(By.cssSelector("#shopify-section-header > sticky-header > header > div > details-modal > details > summary"));
        WebElement searchBar = driver.findElement(By.cssSelector("#shopify-section-header > sticky-header > header > div > details-modal > details > div > div.search-modal__content > predictive-search"));
        WebElement searchSubmit = driver.findElement(By.cssSelector("#shopify-section-header > sticky-header > header > div > details-modal > details > div > div.search-modal__content > predictive-search > form > div.field > button > svg"));

        Actions actions = new Actions(driver);

        // Use click() method for mouse interaction
        actions.moveToElement(searchIcon).click().perform();

        // Use the sendKeys() method for keyboard interaction
        actions.sendKeys(searchBar, "shoes").perform();

        // Use click() method to initiate the search
        actions.moveToElement(searchSubmit).click().perform();
        sleep(2000);
        driver.close();
    }
}
