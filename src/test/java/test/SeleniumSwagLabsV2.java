package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumSwagLabsV2 {
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
        System.out.println();
    }

    @Test(priority = 2)
    public void isProductDisplayed() {
        WebElement products = driver.findElement(By.xpath("//span[@class='title']"));
        boolean actual = products.isDisplayed();
        boolean expected = true;
        Assert.assertEquals(actual, expected, "PRODUCTS is not displayed");
    }

    @Test(priority = 3)
    public void isCartDisplayed() {

        WebElement cart = driver.findElement(By.xpath("(//a[@class='shopping_cart_link'])[1]"));
        boolean actual = cart.isDisplayed();
        boolean expected = true;
        Assert.assertEquals(actual, expected, "Cart is not displayed");
    }

    @Test(priority = 4)
    public void isMenuButtonDisplayed() {
        WebElement burgerButton = driver.findElement(By.className("bm-burger-button"));
        boolean actual = burgerButton.isDisplayed();
        boolean expected = true;
        Assert.assertEquals(actual, expected, "Menu button is not displayed");
    }

    @Test(priority = 5)
    public void isTwitterDisplayed() {
        WebElement twitter = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a"));
        boolean actual = twitter.isDisplayed();
        boolean expected = true;
        Assert.assertEquals(actual,expected, "Twitter link is not displayed");
    }
    @Test(priority = 6)
    public void isFacebookDisplayed(){
        WebElement facebook = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a"));
        boolean actual = facebook.isDisplayed();
        boolean expected = true;
        Assert.assertEquals(actual,expected, "Facebook link is not displayed");
    }
    @Test(priority = 7)
    public void isLinkedinDisplayed(){
        WebElement linkedin = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a"));
        boolean actual = linkedin.isDisplayed();
        boolean expected = true;
        Assert.assertEquals(actual,expected, "Linkedin link is displayed");
    }
    @Test(priority = 8)
    public void isLogoutDisplayed() throws InterruptedException {
        WebElement burgerButton = driver.findElement(By.className("bm-burger-button"));
        burgerButton.click();
        Thread.sleep(2000);
        WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
        boolean actual = logout.isDisplayed();
        boolean expected = true;
        Assert.assertEquals(actual,expected, "Logout button is not displayed");
        Thread.sleep(5000);
        driver.quit();

    }
}
