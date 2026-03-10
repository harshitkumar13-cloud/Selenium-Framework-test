package com.thetestingacademy;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class BookingDotCom {

    @Owner("Harshit")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Booking dot com demo")
    @Test

    public void booking() throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label = 'Dismiss sign in information.']")));
        WebElement closeModal = driver.findElement(By.xpath("//button[@aria-label = 'Dismiss sign in information.']"));
        closeModal.click();

        WebElement flight = driver.findElement(By.xpath("//a[@id = 'flights']"));
        flight.click();
        WebElement goingTo = driver.findElement(By.xpath("//button[@data-ui-name='input_location_to_segment_0']"));
        goingTo.click();
        WebElement inputBox = driver.findElement(By.xpath("//input[@data-ui-name='input_text_autocomplete']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(inputBox).click();
        Thread.sleep(2000);
        actions.sendKeys("DEL");
        Thread.sleep(2000);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.RETURN).build().perform();


        WebElement explore = driver.findElement(By.xpath("//button[@data-ui-name='button_search_submit']"));
        explore.click();


        Thread.sleep(3000);
        driver.quit();

    }
}
