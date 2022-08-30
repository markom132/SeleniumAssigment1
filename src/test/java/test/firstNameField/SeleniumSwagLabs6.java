package test.firstNameField;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

//Test case when user enter 10 or more characters for first name


public class SeleniumSwagLabs6 {
    WebDriver driver;
    String title;
    WebElement element;

    @BeforeTest
    public void se() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\markodm\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        title = driver.getTitle();
    }

    @Test(priority = 1)
    public void login() throws InterruptedException {

        System.out.println("Site title is : " + title + " URL : " + driver.getCurrentUrl());
        WebElement username = driver.findElement(By.name("user-name"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submit = driver.findElement(By.name("login-button"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        Thread.sleep(2000);
        submit.click();
        System.out.println("Logged in");
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void addingToCart() {
        element = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]"));
        element.click();
    }

    @Test(priority = 3)
    public void goToCart() throws InterruptedException {
        element = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        Thread.sleep(2000);
        element.click();
    }

    @Test(priority = 4)
    public void checkout() throws InterruptedException {
        element = driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
        Thread.sleep(2000);
        element.click();
    }

    public boolean haveLessThan10Chars(String fname) {
        int size = fname.length();
        if (size <= 10) {
            return true;
        } else {
            return false;
        }
    }


    @Test(priority = 5)
    public void continueOrder() throws InterruptedException {
        Thread.sleep(2000);
        element = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        WebElement fName = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        WebElement lName = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
        WebElement zip = driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
        String firstname = "ABCDEFGHJKIOOOOOKIsns";
        String lastName = "Doe";
        String zipCode = "11000";
        fName.sendKeys(firstname);
        lName.sendKeys(lastName);
        zip.sendKeys(zipCode);
        element.click();
        boolean actual = haveLessThan10Chars(firstname);
        boolean expected = true;
        Assert.assertEquals(actual, expected, "First name can't have more than 10 characters");
    }
}
