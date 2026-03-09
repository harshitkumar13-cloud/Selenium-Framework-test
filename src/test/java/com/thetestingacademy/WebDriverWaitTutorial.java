package com.thetestingacademy;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebDriverWaitTutorial {
   @Owner("Harshit")
   @Severity(SeverityLevel.CRITICAL)
   @Description("Verify the error message for incorrect credentials")
    @Test
    public void IncorrectCredentials()
   {
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://app.vwo.com/#/login");

       WebElement email = driver.findElement(By.name("username"));
       email.sendKeys("admin@admin.com");

       WebElement password = driver.findElement(By.name("password"));
       password.sendKeys("admin");

       WebElement signIn = driver.findElement(By.id("js-login-btn"));
       signIn.click();

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-notification-box-msg")));

       String error_message = driver.findElement(By.id("js-notification-box-msg")).getText();
       Assert.assertEquals(error_message, "Your email, password, IP address or location did not match");

       driver.quit();



   }
}
