package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

import static java.lang.Thread.sleep;

public class FluentWaitDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to the URL
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        // Click on the button to trigger the action
        WebElement triggerButton = driver.findElement(By.cssSelector("#display-other-button"));
        triggerButton.click();

        // Define FluentWait
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10)) // Maximum timeout duration
                .pollingEvery(Duration.ofSeconds(2)) // Polling interval
                .ignoring(NoSuchElementException.class); // Exception to ignore

        // Define the condition to wait for: the button to be visible
        WebElement hiddenElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidden")));

        // Print the success message
        System.out.println("The hidden element is now displayed: " + hiddenElement.isDisplayed());
        sleep(2000);
        // Close the browser
        driver.close();
    }
}
