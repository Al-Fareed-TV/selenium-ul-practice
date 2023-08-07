package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class AlertBoxDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.automationtesting.in/Alerts.html");


        // Scenario 1: Alert with just OK
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/button")).click();
        sleep(2000);
        Alert alertWithOK = driver.switchTo().alert();
        alertWithOK.accept();

        driver.findElement(By.cssSelector("body > div.container.center > div > div > div > div.tabpane.pullleft > ul > li:nth-child(2) > a")).click();
        // Scenario 2: Alert with OK and Cancel
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/button")).click();
        sleep(2000);
        Alert alertWithOKAndCancel = driver.switchTo().alert();
        alertWithOKAndCancel.accept();

        // After checking the accept, comment the accept and check the dismiss functionality
        // driver.findElement(By.cssSelector("Your Locator Here to Trigger Alert with OK and Cancel")).click();
        // alertWithOKAndCancel.dismiss();

        driver.findElement(By.cssSelector("body > div.container.center > div > div > div > div.tabpane.pullleft > ul > li:nth-child(3) > a")).click();

        // Scenario 3: Alert with Text Input Prompt
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[3]/button")).click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("James");
        sleep(2000);
        promptAlert.accept();

        sleep(2000); // Used only to observe the change, but in real projects should not be used

        driver.close();
    }
}
