package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class LoginHandling {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://web-playground.ultralesson.com/account/login");

        driver.findElement(By.xpath("//*[@id=\"CustomerEmail\"]")).sendKeys("alfareed@testvagrant.com");
        driver.findElement(By.xpath("//*[@id=\"CustomerPassword\"]")).sendKeys("alfareed@TV781");
        driver.findElement(By.xpath("//*[@id=\"customer_login\"]")).submit();

        sleep(3000);

        driver.close();
    }
}
