package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class experimentJSexecutor extends Basic {

    @Test
    public void SuccessLogin() throws InterruptedException {
        driver.findElement(By.xpath("//div/input[@id = \"email_create\"]")).sendKeys(validEmail);

        WebElement button = driver.findElement(By.xpath("//div/button[@name = \"SubmitCreate\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", button);


        Thread.sleep(2000);

        WebElement value = driver.findElement(By.xpath("//div/h1[@class = \"page-heading\"]"));

        String valueText = (String) js.executeScript("return arguments[0].innerText;", value);
        String ExpectedTitle = "CREATE AN ACCOUNT";


        if(ExpectedTitle.equals(valueText)){
            System.out.println("Pass");
        }
        else {
            System.out.println(valueText);
        }



    }
}
