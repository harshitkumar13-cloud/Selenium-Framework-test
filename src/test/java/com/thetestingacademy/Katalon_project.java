package com.thetestingacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Katalon_project {

    @Test
    public void MakeAppointment() throws InterruptedException
    {
        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        //<a id="btn-make-appointment" href="./profile.php#login" class="btn btn-dark btn-lg">Make Appointment</a>
        WebElement AppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        AppointmentButton.click();
        Thread.sleep(5000);

        WebElement username = driver.findElement(By.id("txt-username"));
        WebElement password = driver.findElement(By.id("txt-password"));
        username.sendKeys("John Doe");
        password.sendKeys("ThisIsNotAPassword");


        WebElement Login = driver.findElement(By.id("btn-login"));
        Login.click();
        Thread.sleep(5000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
        String h2 = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(h2,"Make Appointment");
        Thread.sleep(5000);

        driver.quit();
    }
}
