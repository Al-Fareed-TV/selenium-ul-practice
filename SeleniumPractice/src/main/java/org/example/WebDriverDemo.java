package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); //setup of chrome driver
        WebDriver driver = new ChromeDriver(); //launches chrome browser
        driver.get("https://web-playground.ultralesson.com"); //opens the specified link
        try {
            Thread.sleep(5000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close(); // Close the browser
    }
}
