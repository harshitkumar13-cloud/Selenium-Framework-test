package com.thetestingacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TTABankProject {

    @Test
    public void Transaction() throws InterruptedException
    {
        WebDriver driver = new EdgeDriver();
        driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");
        driver.manage().window().maximize();

        WebElement signup = driver.findElement(By.xpath("//button[normalize-space()='Sign Up']"));
        signup.click();

        WebElement Name = driver.findElement(By.xpath("//input[@placeholder = 'John Doe']"));
        Name.sendKeys("admin");

        WebElement email = driver.findElement(By.xpath("//input[@placeholder = 'you@example.com']"));
        email.sendKeys("admin@admin.com");

        WebElement password = driver.findElement(By.xpath("//input[@type = 'password']"));
        password.sendKeys("admin@1234");

        WebElement CreateAcc = driver.findElement(By.xpath("//button[text() = 'Create Account']"));
        CreateAcc.click();

        Thread.sleep(3000);

        WebElement TransferFunds = driver.findElement(By.xpath("//button[normalize-space()= 'Transfer Funds']"));
        TransferFunds.click();
        Thread.sleep(3000);

        WebElement Amount = driver.findElement(By.xpath("//input[@placeholder = '0.00']"));
        Amount.sendKeys("5000");

        WebElement Confirm = driver.findElement(By.xpath("//button[text()='Continue']"));
        Confirm.click();
        Thread.sleep(3000);

        WebElement Confirm2 = driver.findElement(By.xpath("//button[text()='Confirm Transfer']"));
        Confirm2.click();
        Thread.sleep(3000);

        WebElement Confirm3 = driver.findElement(By.xpath("//button[text()='Dashboard']"));
        Confirm3.click();
        Thread.sleep(3000);

        String RemainingAmount = driver.findElement(By.xpath("//h3[text()='$']")).getText();
        Assert.assertEquals(RemainingAmount, "$45,000.00");

        driver.quit();

    }
}
