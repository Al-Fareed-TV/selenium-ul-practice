package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserOptionsExample {
    public static void main(String[] args) {
        // Set up Chrome Options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        // Initialize WebDriver with Chrome Options
        WebDriver driver = new ChromeDriver(options);

        // Load a URL to test the setup
        driver.get("https://web-playground.ultralesson.com/");

        driver.quit(); // Close the driver at the end of the program
    }
}
