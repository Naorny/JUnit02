package org.test;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class Task1Test {

    @Test
    void task1() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\huliaieva\\Downloads\\selenium webdriver\\ChromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.className("login_logo"));
        driver.findElement(By.className("error-message-container"));
        String expectedMessage = "Epic sadface: Sorry, this user has been locked out.";
        String actualMessage = driver.findElement(By.className("error-message-container")).getText();
        assertEquals(expectedMessage, actualMessage);
        driver.findElement(By.className("error-button")).click();

        driver.quit();
    }


}