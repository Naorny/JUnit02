package org.test;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void task2() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\huliaieva\\Downloads\\selenium webdriver\\ChromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 1. Open the website https://www.saucedemo.com/
        // 2. in the login field enter login: 'standard_user',
        // in the password field enter 'secret_sauce', click the 'LOGIN' button.
        // 3. check that the user is on the product list page
        // (there is an element with attribute id = 'inventory_container')

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("inventory_container")).isDisplayed();

        // 4. change sorting to Price (Low to High)

        WebElement selectOption = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(selectOption);
        select.selectByValue("lohi");

        // 5. make sure that sorting is applied on the page (check that the location of items on the page by price)
        // --------------------------------

        // 6. add the item 'Sauce Labs Bolt T-Shirt' to cart,
        // check that the button on the product card has changed to 'Remove'

        WebElement item_1 =  driver.findElement(By.id("item_1_title_link"));
        item_1.isDisplayed();

        WebElement add_btn = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        add_btn.click();

        WebElement remove_btn = driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"));
        remove_btn.isDisplayed();
        assertEquals("Remove", remove_btn.getText());

        // 7. check that the counter of goods in the cart is displayed with the value 1

        WebElement goods_counter = driver.findElement(By.className("shopping_cart_badge"));
        assertEquals("1", goods_counter.getText());

        // 8. save all data about the product added to the cart

        String price_1 = driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(3) > div.inventory_item_description > div.pricebar > div")).getText();
        String description_1 = driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(3) > div.inventory_item_description > div.inventory_item_label > div")).getText();
        String item_name_1 = driver.findElement(By.cssSelector("#item_1_title_link > div")).getText();

        // 9. go to the cart and check that the data about the product corresponds to the data saved at step 8

        driver.findElement(By.className("shopping_cart_link")).click();
        String price_2 = driver.findElement(By.cssSelector("#cart_contents_container > div > div.cart_list > div.cart_item > div.cart_item_label > div.item_pricebar > div")).getText();
        String description_2 = driver.findElement(By.cssSelector("#cart_contents_container > div > div.cart_list > div.cart_item > div.cart_item_label > div.inventory_item_desc")).getText();
        String item_name_2 = driver.findElement(By.cssSelector("#item_1_title_link > div")).getText();

        assertEquals(price_1, price_2);
        assertEquals(description_1, description_2);
        assertEquals(item_name_1, item_name_2);

        //10. click Remove for the product, make sure that the goods counter in the cart is not displayed.
        //11. return to the product page by clicking the 'Continue Shopping' button. Memorize product data

        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
        //driver.findElement(By.id("cart_quantity")).isDisplayed();

        driver.findElement(By.id("continue-shopping")).click();

        //12. add 'Sauce Labs Backpack' to your cart

        driver.findElement(By.id("item_4_title_link")).isDisplayed();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //13. go to cart and click 'Checkout'

        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();

        //14. fill in the form and continue

        driver.findElement(By.id("first-name")).sendKeys("test");
        driver.findElement(By.id("last-name")).sendKeys("test");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();

        //15. on the Overview page check the Item total field to make sure it matches the price of the item.

        String inventory_item_price = driver.findElement(By.className("inventory_item_price")).getText();
        String item_total_price = driver.findElement(By.className("summary_subtotal_label")).getText();

        assertEquals("Item total: " + inventory_item_price, item_total_price);

        //16. click Finish

        driver.findElement(By.id("finish")).click();

        //17. on the Thank You check that there is an image with attribute alt = 'Pony Express'.

        driver.findElement(By.xpath("//img[@alt='Pony Express']")).isDisplayed();

        driver.quit();
    }
}

// 1. Open the website https://www.saucedemo.com/
// 2. in the login field enter login: 'standard_user',
// in the password field enter 'secret_sauce', click the 'LOGIN' button.
// 3. check that the user is on the product list page
// (there is an element with attribute id = 'inventory_container')
// 4. change sorting to Price (Low to High)
// 5. make sure that sorting is applied on the page (check that the location of items on the page by price)
// --------------------------------
// 6. add the item 'Sauce Labs Bolt T-Shirt' to cart,
// check that the button on the product card has changed to 'Remove'
// 7. check that the counter of goods in the cart is displayed with the value 1
// 8. save all data about the product added to the cart
// 9. go to the cart and check that the data about the product corresponds to the data saved at step 8
//10. click Remove for the product, make sure that the goods counter in the cart is not displayed.
//11. return to the product page by clicking the 'Continue Shopping' button. Memorize product data
//12. add 'Sauce Labs Backpack' to your cart
//13. go to cart and click 'Checkout'
//14. fill in the form and continue
//15. on the Overview page check the Item total field to make sure it matches the price of the item.
//16. click Finish
//17. on the Thank You check that there is an image with attribute alt = 'Pony Express'.

