package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessModeExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        // Set up Chrome Options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        //in this testing will be done without opening browser

        // Initialize WebDriver with Chrome Options
        WebDriver driver = new ChromeDriver(options);

        // Load a URL to test the setup
        driver.get("https://web-playground.ultralesson.com/");

        driver.quit(); // Close the driver at the end of the program
    }
}
