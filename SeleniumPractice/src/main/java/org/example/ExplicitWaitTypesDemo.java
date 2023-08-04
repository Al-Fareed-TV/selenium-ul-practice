package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTypesDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options  = new ChromeOptions();
        options.addArguments("start-maximize");


        WebDriver driver = new ChromeDriver(options);
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        WebDriverWait waitForTextToChange = new WebDriverWait(driver, 12);
        WebElement changeTextButton = driver.findElement(By.id("populate-text"));
        changeTextButton.click();
        waitForTextToChange.until(ExpectedConditions.textToBe(By.id("h2"), "Selenium Webdriver"));

        // Wait for element to display
        WebDriverWait waitForElementToDisplay = new WebDriverWait(driver, 13);
        WebElement displayButton = driver.findElement(By.id("display-other-button"));
        displayButton.click();
        waitForElementToDisplay.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidden")));

        // Wait for element to enable
        WebDriverWait waitForElementEnabled = new WebDriverWait(driver, 12);
        WebElement enableButton = driver.findElement(By.id("enable-button"));
        enableButton.click();
        waitForElementEnabled.until(ExpectedConditions.elementToBeClickable(By.id("disable")));

        // Wait for checkbox to be selected
        WebDriverWait waitForElementToBeChecked = new WebDriverWait(driver, 12);
        WebElement checkboxButton = driver.findElement(By.id("checkbox"));
        checkboxButton.click();
        waitForElementToBeChecked.until(ExpectedConditions.elementSelectionStateToBe(By.id("ch"), true));

        driver.close();
    }
}
