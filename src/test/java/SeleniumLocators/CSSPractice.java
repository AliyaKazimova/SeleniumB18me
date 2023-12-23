package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.etsy.com/");

        WebElement searchBox = driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        searchBox.sendKeys("Watch");
        WebElement searchButton = driver.findElement(By.cssSelector(".wt-nudge-r-1"));
        searchButton.click();
        System.out.println(driver.getCurrentUrl());


    }
}
