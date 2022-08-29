package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumSwagLabs {
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
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        submit.click();
        System.out.println("Logged in");

        System.out.println();

        System.out.println("Site title is : " + driver.getTitle() + " URL : " + driver.getCurrentUrl());
        WebElement products = driver.findElement(By.xpath("//span[@class='title']"));
        boolean producth = products.isDisplayed();
        if (producth) {
            System.out.println("Element " + products.getText() + " ----- is displayed");
        } else {
            System.out.println("Element " + products.getText() + " ----- is not displayed");
        }

        WebElement cart = driver.findElement(By.xpath("(//a[@class='shopping_cart_link'])[1]"));
        boolean cartl = cart.isDisplayed();
        if (cartl) {
            System.out.println("Element cart, type = " + cart.getAriaRole() + " ----- is displayed");
        } else {
            System.out.println("Element cart, type = " + cart.getAriaRole() + " ----- is not displayed");
        }

        WebElement burgerButton = driver.findElement(By.className("bm-burger-button"));
        boolean burgerBtn = burgerButton.isDisplayed();
        if (burgerBtn) {
            System.out.println("Element  burger menu, type = " + burgerButton.getAriaRole() + " ----- is displayed");
        } else {
            System.out.println("Element burger menu, type = " + burgerButton.getAriaRole() + " ----- is not displayed");
        }

        WebElement twitter = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a"));
        boolean tl = twitter.isDisplayed();
        if (tl) {
            System.out.println("Element  twitter link, type = " + twitter.getAriaRole() + " ----- is displayed");
        } else {
            System.out.println("Element twitter link, type = " + twitter.getAriaRole() + " ----- is not displayed");
        }
        WebElement facebook = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a"));
        boolean fl = facebook.isDisplayed();
        if (fl) {
            System.out.println("Element  facebook link, type = " + facebook.getAriaRole() + " ----- is displayed");
        } else {
            System.out.println("Element facebook link, type = " + facebook.getAriaRole() + " ----- is not displayed");
        }

        WebElement linkedin = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a"));
        boolean ll = linkedin.isDisplayed();
        if (ll) {
            System.out.println("Element  linkedin link, type = " + linkedin.getAriaRole() + " ----- is displayed");
        } else {
            System.out.println("Element linkedin link, type = " + linkedin.getAriaRole() + " ----- is not displayed");
        }
        burgerButton.click();
        Thread.sleep(2000);
        WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
        boolean outl = logout.isDisplayed();
        if (outl) {
            System.out.println("Element  logout, type = " + logout.getAriaRole() + " ----- is displayed");
        } else {
            System.out.println("Element logout, type = " + logout.getAriaRole() + " ----- is not displayed");
        }
    }
}
