package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertyTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.automationtesting.in/Windows.html");

        WebElement button = driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button"));
        System.out.println(button.isDisplayed());
        System.out.println(button.isEnabled());


        driver.close();
    }
}
