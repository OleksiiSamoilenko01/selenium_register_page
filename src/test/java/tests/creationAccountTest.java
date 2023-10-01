package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class creationAccountTest {
    private WebDriver driver;
    private WebDriverWait wait;

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

    @Test
    public void SuccessLogin(){
        driver.findElement(By.xpath("//div/input[@id = \"email_create\"]")).sendKeys(validEmail);

        driver.findElement(By.xpath("//div/button[@name = \"SubmitCreate\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h1[@class = \"page-heading\"]")));

        WebElement value = driver.findElement(By.xpath("//div/h1[@class = \"page-heading\"]"));


        String ActualTitle = value.getText();
        String ExpectedTitle = "CREATE AN ACCOUNT";

        if(ExpectedTitle.equals(ActualTitle)){
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
    }
    @Test
    public void UnuccessLogin(){
        driver.findElement(By.xpath("//div/input[@id = \"email_create\"]")).sendKeys(invalidEmail);

        driver.findElement(By.xpath("//div/button[@name = \"SubmitCreate\"]")).click();

        ////div[@id = "create_account_error"]
        WebElement value = driver.findElement(By.xpath("//div[@id = \"create_account_error\"]"));


        String ActualResult = value.getText();
        String ExpectedResult = "Invalid email address.";

        if(ExpectedResult.equals(ActualResult)){
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }

    }
}
