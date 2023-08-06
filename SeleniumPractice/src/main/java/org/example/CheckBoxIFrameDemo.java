package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.sleep;

class CheckBoxIframeDemo {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("https://htmldog.com/examples/inputcheckboxes/");

        // Explicit Wait setup
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Locate the iFrame on the page
        WebElement iframe = driver.findElement(By.id("allow-scripts allow-same-origin"));
        // Explicitly wait for the iFrame to be visible
        wait.until(ExpectedConditions.visibilityOf(iframe));

        // Switch to the iFrame
        driver.switchTo().frame(iframe);

        // Locate the checkboxes and store in a list
        List <WebElement> checkboxes = driver.findElements(By.id("drama"));

        // Iterate over the checkboxes and click each one
        for(WebElement checkbox : checkboxes){
            checkbox.click();
            sleep(2000);  // Used only to observe the changes
        }

        // Iterate over the checkboxes and click each one to uncheck
        for(WebElement checkbox : checkboxes){
            checkbox.click();
            sleep(2000);  // Used only to observe the changes
        }

        // Switch back to the main webpage
        driver.switchTo().defaultContent();

        // Close the browser
        sleep(5000);
        driver.close();
    }
}
