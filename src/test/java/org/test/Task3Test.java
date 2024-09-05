package org.test;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {


    @Test
    void task3() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\huliaieva\\Downloads\\selenium webdriver\\ChromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        String price_t_shirt_list = driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(6) > div.inventory_item_description > div.pricebar > div")).getText();
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();

        String price_sauce_lab_fleece_jacket_list = driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(4) > div.inventory_item_description > div.pricebar > div")).getText();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();

        String price_sauce_lab_bike_light_list = driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(2) > div.inventory_item_description > div.pricebar > div")).getText();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        driver.findElement(By.className("shopping_cart_link")).click();

        String price_t_shirt_cart = driver.findElement(By.cssSelector("#cart_contents_container > div > div.cart_list > div:nth-child(3) > div.cart_item_label > div.item_pricebar > div")).getText();
        String price_sauce_lab_fleece_jacket_cart = driver.findElement(By.cssSelector("#cart_contents_container > div > div.cart_list > div:nth-child(4) > div.cart_item_label > div.item_pricebar > div")).getText();
        String price_sauce_lab_bike_light_cart = driver.findElement(By.cssSelector("#cart_contents_container > div > div.cart_list > div:nth-child(5) > div.cart_item_label > div.item_pricebar > div")).getText();

        assertEquals(price_t_shirt_list, price_t_shirt_cart);
        assertEquals(price_sauce_lab_fleece_jacket_list, price_sauce_lab_fleece_jacket_cart);
        assertEquals(price_sauce_lab_bike_light_list, price_sauce_lab_bike_light_cart);

        driver.findElement(By.className("bm-burger-button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("reset_sidebar_link")).click();
        driver.findElement(By.id("inventory_sidebar_link")).click();

        driver.quit();
    }
}

// Using the test parameterization annotation, add a test to check the price of a product in a shopping cart:
// 'Test.allTheThings() T-Shirt (Red)',
// 'Sauce Labs Fleece Jacket,
// 'Sauce Labs Bike Light'

// Steps:
// In @BeforeMethod, we log into the store
// remember the price of the item, add the item to the cart.
// go to cart and check if the price is correct
// in @AfterMethod reset App State (Located in the left sidebar).
