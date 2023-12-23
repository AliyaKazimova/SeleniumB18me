package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class BankLoginTest {

    public void validateHeader(){
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
  //     BankLoginPage bankLoginPage = new BankLoginPage(driver);
   //   Assert.assertEquals(bankLoginPage.headerFromLoginPage(),"XYZ Bank");
    }
}
