package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class IframeHandleDemo {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("https://demo.automationtesting.in/Frames.html");

        // Locate the iFrame on the page
        // Remember to replace "Your Locator Here for iFrame" with the actual locator of the iFrame
        WebElement iframe = driver.findElement(By.id("singleframe"));

        // Switch to the iFrame
        driver.switchTo().frame(iframe);

        // Within the iFrame, locate the input field
        // Replace "Your Locator Here for Input Field" with the actual locator of the input field
        WebElement textElement = driver.findElement(By.xpath("/html/body/section/div/div/div/input"));

        // Enter the text "Hello World" in the input field
        textElement.sendKeys("Hello World");

        // Switch back to the main webpage
        driver.switchTo().defaultContent();
        sleep(5000);
        // Close the browser
        driver.close();
    }
}
