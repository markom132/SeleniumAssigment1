package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumSwaglabs2V2 {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\markodm\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void login() {
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.name("user-name"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submit = driver.findElement(By.name("login-button"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        submit.click();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login is not done right");
    }

    @Test(priority = 2)
    public void canGoToItem() throws InterruptedException {
        WebElement backpack = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        Thread.sleep(1000);
        backpack.click();
        String expected = "https://www.saucedemo.com/inventory-item.html?id=4";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected, "Item can't be opened");
    }

    @Test(priority = 3)
    public void isTitleOkay() {
        WebElement backpackTitle = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]"));
        String expected = "Sauce Labs Backpack";
        String actual = backpackTitle.getText();
        Assert.assertEquals(actual, expected, "Title is not okay");
    }

    @Test(priority = 4)
    public void isDescriptionOkay() {
        WebElement backpackDescription = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]"));
        String expected = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        String actual = backpackDescription.getText();
        Assert.assertEquals(actual, expected, "Description is not okay");
    }

    @Test(priority = 5)
    public void isPriceOkay() {
        WebElement backpackPrice = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]"));
        String expected = "$" + "29.99";
        String actual = backpackPrice.getText();
        Assert.assertEquals(actual, expected, "Price is not okay");
    }

    @Test(priority = 6)
    public void backToProducts() throws InterruptedException {
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        Thread.sleep(1000);
        addToCart.click();
        WebElement backToProduct = driver.findElement(By.xpath("//*[@id=\"back-to-products\"]"));
        Thread.sleep(1000);
        backToProduct.click();
        String actual = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actual, expectedUrl, "Back to products don't work");
    }

    @Test(priority = 7)
    public void goToCart() throws InterruptedException {
        WebElement addJacketToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]"));
        Thread.sleep(1000);
        addJacketToCart.click();
        WebElement cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        Thread.sleep(1000);
        cart.click();
        String actual = driver.getCurrentUrl();
        String expected = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(actual, expected, "Cart can't be open");
    }

    @Test(priority = 8)
    public void goToCheckout() throws InterruptedException {
        WebElement checkout = driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
        Thread.sleep(1000);
        checkout.click();
        String expected = "https://www.saucedemo.com/checkout-step-one.html";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual,expected, "Checkout don't work");
    }

    @Test(priority = 9)
    public void finishOrder() throws InterruptedException {
        WebElement inputFirstName = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        WebElement inputLastName = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
        WebElement inputZipCode = driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
        WebElement continueBtn = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        Thread.sleep(1000);
        inputFirstName.sendKeys("John");
        inputLastName.sendKeys("Doe");
        inputZipCode.sendKeys("11000");
        Thread.sleep(1000);
        continueBtn.click();
        String expected = "https://www.saucedemo.com/checkout-step-two.html";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected, "Finishing order failed");
    }

    @Test(priority = 10)
    public void finish() throws InterruptedException {
        WebElement finish = driver.findElement(By.xpath("//*[@id=\"finish\"]"));
        Thread.sleep(1000);
        finish.click();
        String expected = "https://www.saucedemo.com/checkout-complete.html";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected, "Finishing failed");
    }

    @Test(priority = 11)
    public void tnxForOrderMsg(){
        WebElement tnxForOrder = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
        String expected = "THANK YOU FOR YOUR ORDER";
        String actual = tnxForOrder.getText();
        Assert.assertEquals(actual, expected, "'Thanks for order' message is not displayed");
    }

    @Test(priority = 12)
    public void logout() throws InterruptedException {
        WebElement burgerButton = driver.findElement(By.className("bm-burger-button"));
        burgerButton.click();
        Thread.sleep(1000);
        WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
        logout.click();
        String expected = "https://www.saucedemo.com/";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected, "Logout can't be done");
    }

}
