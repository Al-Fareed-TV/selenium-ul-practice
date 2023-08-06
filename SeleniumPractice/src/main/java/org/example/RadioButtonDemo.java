package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonDemo {
    public static void main(String[] args) {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to the test page with radio buttons
        driver.get("https://demoqa.com/radio-button");

        // Find the 'Yes' radio button and click it
        WebElement yesRadioButton = driver.findElement(By.id("yesRadio"));
        yesRadioButton.click();

        // Wait for a brief moment (you can adjust the sleep time if needed)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find the 'Impressive' radio button and click it
        WebElement impressiveRadioButton = driver.findElement(By.id("impressiveRadio"));
        impressiveRadioButton.click();

        // Wait for a brief moment (you can adjust the sleep time if needed)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}
