package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumSwagLabs2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\markodm\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        String title = driver.getTitle();
        System.out.println("Site title is : " + title + " URL : " + driver.getCurrentUrl());
        WebElement username = driver.findElement(By.name("user-name"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submit = driver.findElement(By.name("login-button"));
        Thread.sleep(500);
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        submit.click();
        System.out.println("Logged in");
        System.out.println();

        WebElement backpack = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        Thread.sleep(1000);
        backpack.click();
        System.out.println("Site title is : " + driver.getTitle() + " URL : " + driver.getCurrentUrl());
        WebElement backpackTitle = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]"));
        String expectedTitle = "Sauce Labs Backpack";
        String actualTitle = backpackTitle.getText();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title is okay. Like expected");
        } else {
            System.out.println("Title is not okay");
        }
        System.out.println();

        WebElement backpackDescription = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]"));
        String expectedDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        String actualDescription = backpackDescription.getText();

        if (actualDescription.equals(expectedDescription)) {
            System.out.println("Description is okay. Like expected");
        } else {
            System.out.println("Description is not okay");
        }
        System.out.println();

        WebElement backpackPrice = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]"));
        String expectedPrice = "$" + "29.99";
        String actualPrice = backpackPrice.getText();
        if (actualPrice.equals(expectedPrice)) {
            System.out.println("Price is okay. Like expected");
        } else {
            System.out.println("Price is not okay");
        }
        System.out.println();

        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        Thread.sleep(1000);
        addToCart.click();
        System.out.println("Item added to cart");

        WebElement backToProduct = driver.findElement(By.xpath("//*[@id=\"back-to-products\"]"));
        Thread.sleep(1000);
        backToProduct.click();
        System.out.println();


        System.out.println("You are in product list page");
        System.out.println("Site title is : " + driver.getTitle() + " URL : " + driver.getCurrentUrl());
        System.out.println();

        WebElement addJacketToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]"));
        Thread.sleep(1000);
        addJacketToCart.click();
        System.out.println("Added Jacket to cart");

        WebElement cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        Thread.sleep(1000);
        cart.click();
        System.out.println("You are in the cart");
        System.out.println("Site title is : " + driver.getTitle() + " URL : " + driver.getCurrentUrl());
        System.out.println();

        WebElement checkout = driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
        Thread.sleep(1000);
        checkout.click();
        System.out.println("You proceed to order page");
        System.out.println("Site title is : " + driver.getTitle() + " URL : " + driver.getCurrentUrl());
        System.out.println();

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
        System.out.println("You proceed to finishing order page");
        System.out.println("Site title is : " + driver.getTitle() + " URL : " + driver.getCurrentUrl());
        System.out.println();

        WebElement finish = driver.findElement(By.xpath("//*[@id=\"finish\"]"));
        Thread.sleep(1000);
        finish.click();
        System.out.println("You finished your order");
        System.out.println("Site title is : " + driver.getTitle() + " URL : " + driver.getCurrentUrl());
        System.out.println();


        WebElement tnxForOrder = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
        String expectedMessage = "THANK YOU FOR YOUR ORDER";
        String actualMessage = tnxForOrder.getText();

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Message is okay. Like expected");
        } else {
            System.out.println("Message is not okay");
        }
        System.out.println();

        WebElement burgerButton = driver.findElement(By.className("bm-burger-button"));
        burgerButton.click();
        Thread.sleep(1000);
        WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
        logout.click();
        System.out.println("You are logged out");
        System.out.println("Site title is : " + driver.getTitle() + " URL : " + driver.getCurrentUrl());

    }
}
