package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://formy-project.herokuapp.com/form");

        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Joey");
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Jordison");
        Thread.sleep(2000);
        WebElement jobTitle = driver.findElement(By.id("job-title"));
        jobTitle.sendKeys("SDET WITH 200K SALARY A YEAR");
        WebElement highestLevelOfEducationButton = driver.findElement(By.id("radio-button-2"));
        highestLevelOfEducationButton.click();
        Thread.sleep(2000);

        WebElement male = driver.findElement(By.id("checkbox-1"));
        if (male.isDisplayed() && !male.isSelected()) {
            male.click();
        }

        WebElement experienceBox = driver.findElement(By.id("select-menu"));
        experienceBox.sendKeys("10+");
        Thread.sleep(2000);

        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("11/29/2023");
        Thread.sleep(2000);

        WebElement submitButton = driver.findElement(By.partialLinkText("Sub"));
        Thread.sleep(2000);
        submitButton.click();

        driver.navigate().forward();
        WebElement message = driver.findElement(By.className("alert-success"));
        System.out.println(message.getText().trim().equals("The form was successfully submitted!") ? "Submit was Successful" : "Submit Failed ");
        driver.quit();

    }
}
