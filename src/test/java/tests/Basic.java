package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import java.time.Duration;

public class Basic {
    protected WebDriver driver;
    protected WebDriverWait wait;

    String URL = "http://prestashop.qatestlab.com.ua/en/authentication?back=my-account#account-creation";
    String validEmail = "o.samoilenko95@gmail.com";
    String invalidEmail = "o.samoilenko9gmail.com";



    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @BeforeMethod
    public void Chrome(){
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void CloseBrowser() {
        driver.close();
    }
}
