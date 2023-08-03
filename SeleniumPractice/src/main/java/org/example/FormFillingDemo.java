package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class FormFillingDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
         WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.get("https://web-playground.ultralesson.com/account/register");
            driver.findElement(By.xpath("//*[@id=\"RegisterForm-FirstName\"]")).sendKeys("Al");
            sleep(500);
            driver.findElement(By.xpath("//*[@id=\"RegisterForm-LastName\"]")).sendKeys("Fareed");
            sleep(500);
            driver.findElement(By.xpath("//*[@id=\"RegisterForm-email\"]")).sendKeys("alfareed@testvagrant.com");
            sleep(500);
            driver.findElement(By.xpath("//*[@id=\"RegisterForm-password\"]")).sendKeys("alfareed@TV781");
            sleep(500);
            driver.findElement(By.xpath("//*[@id=\"create_customer\"]")).submit();
            sleep(2000);

        }catch (Exception e){
            System.out.println("Browser not launched..!");
        }
    finally {
            System.out.println("Closing browser");
//            driver.close();
        }

    }
}
