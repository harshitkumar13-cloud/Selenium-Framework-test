package com.thetestingacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class vwoDotCom {

    @Test
    public void vwoLogin() throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/settings/profile-details?accountId=1205031");

        WebElement email = driver.findElement(By.xpath("//input[@name='username']"));
        email.sendKeys("harshit0208@itdbe.com");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("@dL8CAR2981@");
        WebElement signIn = driver.findElement(By.xpath("//span[@data-qa='ezazsuguuy']"));
        signIn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='file']")));

        WebElement fileUpload = driver.findElement(By.xpath("//input[@name='file']"));
        fileUpload.sendKeys("/Users/harshitkumar/Desktop/vwo.png");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Upload')]")));
        WebElement upload = driver.findElement(By.xpath("//button[contains(text(),'Upload')]"));
        upload.click();

        driver.quit();

    }
}
