package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Scroll extends Basic{

    @Test
    public void Scroll() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement button = driver.findElement(By.xpath("//li[@class = \"item\"]/a[contains(text(), \"Contact us\")]"));
        js.executeScript("arguments[0].click();", button);

        Thread.sleep(2000);

        WebElement text = driver.findElement(By.xpath("//h1[@class = \"page-heading bottom-indent\"]"));
        String valueText = (String) js.executeScript("return arguments[0].innerText;", text);

        String ExpectedTitle = "Customer service - Contact us";
        String ExpectedupperCase = ExpectedTitle.toUpperCase();

        if(ExpectedupperCase.equals(valueText)){
            System.out.println("Pass");
        }
        else {
            System.out.println(valueText);
        }

    }



}
