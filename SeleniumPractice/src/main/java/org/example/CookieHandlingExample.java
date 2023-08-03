package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;

public class CookieHandlingExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https:electricity-billing-and-management.netlify.app");

        // Add a cookie
        Cookie newCookie = new Cookie("exampleCookie", "testValue");
        driver.manage().addCookie(newCookie);

        // Retrieve and print the cookie
        Cookie retrievedCookie = driver.manage().getCookieNamed("exampleCookie");
        System.out.println("Retrieved cookie: " + retrievedCookie);

        // Delete the cookie
        driver.manage().deleteCookieNamed("exampleCookie");

        // Try to retrieve the deleted cookie (this should return null)
        Cookie deletedCookie = driver.manage().getCookieNamed("exampleCookie");
        System.out.println("Deleted cookie: " + deletedCookie);

        driver.quit(); // Close the driver at the end of the program
    }
}