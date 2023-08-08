package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static java.lang.Thread.sleep;

public class PlaceOrderScript {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();

            driver.get("https://web-playground.ultralesson.com/");
            driver.findElement(By.cssSelector("#shopify-section-header > sticky-header > header > div > a.header__icon.header__icon--account.link.focus-inset.small-hide")).click();
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Create account")));
            element.click();
            driver.findElement(By.id("RegisterForm-FirstName")).sendKeys("Al");
            driver.findElement(By.id("RegisterForm-LastName")).sendKeys("Fareed");
            driver.findElement(By.id("RegisterForm-email")).sendKeys("alfareed@testvagrant.com");
            driver.findElement(By.id("RegisterForm-password")).sendKeys("alfareed78@testvagrant.com");
            driver.findElement(By.cssSelector("#create_customer > button")).click();
            sleep(2000);
        } catch (Exception e) {
            System.out.println("Error...! : " + e.getMessage());
        } finally {
            driver.quit();

        }
    }
}
