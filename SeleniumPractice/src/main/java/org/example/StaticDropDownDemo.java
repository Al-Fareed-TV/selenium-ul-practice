package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class StaticDropDownDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu");

        // Find the static dropdown using its locator
        WebElement staticDropdown = driver.findElement(By.cssSelector("#post-2646 > div.twelve.columns > div > div > div > p > select"));

        // Create an instance of the Select class
        Select select = new Select(staticDropdown);

        // Select an option from the dropdown menu
        select.selectByVisibleText("India");
        sleep(2000);
        driver.close();
    }
}
