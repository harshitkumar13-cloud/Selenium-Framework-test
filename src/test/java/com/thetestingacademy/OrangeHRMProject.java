package com.thetestingacademy;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeHRMProject {

    @Owner("Harshit")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login is working")
    @Test

    public void DeleteRow() throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/hr/web/index.php");
        Thread.sleep(2000);

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement login = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

        username.sendKeys("admin");
        password.sendKeys("Hacker@4321");
        login.click();
        Thread.sleep(4000);

        WebElement TerminatedEmpName = driver.findElement(By.xpath("//div[text()='Terminated']/../preceding-sibling::div[3]"));
        String name = TerminatedEmpName.getText();
        System.out.println(name);

        WebElement Delete = driver.findElement(By.xpath("//div[text()='Terminated']/../following::i[1]"));
        Delete.click();
        Thread.sleep(3000);
        driver.quit();





    }
}
