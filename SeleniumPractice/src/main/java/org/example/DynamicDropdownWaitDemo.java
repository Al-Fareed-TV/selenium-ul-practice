package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

import static java.lang.Thread.sleep;

public class DynamicDropdownWaitDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://web-playground.ultralesson.com");

        // Find the search bar and search icon using their locators
        WebElement searchIcon = driver.findElement(By.cssSelector("#shopify-section-header > sticky-header > header > div > details-modal > details > summary"));
        WebElement searchBar = driver.findElement(By.cssSelector("#shopify-section-header > sticky-header > header > div > details-modal > details > div > div.search-modal__content > predictive-search"));
        WebElement searchSubmit = driver.findElement(By.xpath("/html/body/div[2]/sticky-header/header/div/details-modal/details/div/div[2]/predictive-search/form/div[1]/button"));

        // Perform the search
        searchIcon.click();
        Actions builder = new Actions(driver);
        builder.sendKeys(searchBar,"chapli").perform();
        builder.moveToElement(searchSubmit).click().perform();


        // Create a WebDriverWait object
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Wait for the dynamic dropdown options to be loaded
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#SortBy")));

        // Get the dynamic dropdown options
        List<WebElement> dynamicDropDownOptions = driver.findElements(By.cssSelector("#SortBy"));

        // Loop through the options and select the desired one
        for (WebElement dynamicOption : dynamicDropDownOptions) {
            if (dynamicOption.getText().contains("Your Target Value Here")) {
                dynamicOption.click();
                break;
            }
        }
            sleep(5000);
                driver.quit();
    }
}