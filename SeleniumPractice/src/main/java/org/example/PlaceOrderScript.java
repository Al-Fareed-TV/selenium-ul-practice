package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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
            driver.manage().timeouts().implicitlyWait(2, java.util.concurrent.TimeUnit.SECONDS);
            driver.get("https://web-playground.ultralesson.com/");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 500);");
            driver.findElement(By.cssSelector("#shopify-section-template--15328405749981__1635852374581d2a7e > div > slider-component > ul > li:nth-child(1) > div > div.card-information > div > h3 > a")).click();
            driver.findElement(By.cssSelector("#ProductInfo-template--15328405717213__main > variant-radios > fieldset > label:nth-child(15)")).click();
            WebElement quantity = driver.findElement(By.className("quantity__input"));
            quantity.click();
            quantity.sendKeys(Keys.DELETE);
            sleep(1000);
            quantity.sendKeys("4");
            driver.findElement(By.cssSelector("#product-form-template--15328405717213__main > div > button")).click();
            String itemCount = driver.findElement(By.cssSelector("#cart-icon-bubble > div > span:nth-child(1)")).getText();
            System.out.println("Item count in the cart is : " + itemCount);
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart-notification-form"))).click();
            driver.findElement(By.cssSelector("#shopify-section-header > sticky-header > header > div > a.header__icon.header__icon--account.link.focus-inset.small-hide")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Log out"))).click();


//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CustomerEmail"))).sendKeys("alfareed@testvagrant.com");
//            WebElement password = driver.findElement(By.id("CustomerPassword"));
//            password.sendKeys("alfareed@TV781");
//            password.sendKeys(Keys.ENTER);
//
//            sleep(20000);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sleep(4000);
            driver.quit();
        }


    }
}
