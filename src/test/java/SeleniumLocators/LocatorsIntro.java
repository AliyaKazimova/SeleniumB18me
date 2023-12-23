package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {

    //Locator is a way to locate the element and manipulate it

    public static void main(String[] args) {

        //ID LOCATOR:
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/alinamars/Downloads/Techtorialhtml(2).html");
        WebElement header = driver.findElement(By.id("techtorial1"));
        System.out.println(header.getText());
        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        //NAME LOCATOR:
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Joey number 1");
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Jordison");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("6468251813");
        //so while searching for this element I found it 1 out of 2 elements :
        //                        <b>Phone:</b>   and    <input maxlength="20" name="phone" size="15">
        //the trick is that one of them doesn't have an attribute -->  <b>Phone:</b>
        //so we can easily go with

        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("aliyakazimova95@gmail.com");
        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("198 28th Str");
        WebElement address2 = driver.findElement(By.name("address2"));
        address2.sendKeys("Brooklyn New York");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Iowa");
        //same case, a lot of elements for city but only one of them has name attribute

        WebElement stateProvince = driver.findElement(By.name("state"));
        stateProvince.sendKeys("Iowa");
        WebElement postalCode = driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("12345");

        //CLASS NAME LOCATOR:
        WebElement allTools = driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText().equals("All Tools") ? "PASSED" : "FAILED");
        String actualText = allTools.getText().trim();
        String expectedText = "All Tools";
        if (actualText.equals(expectedText)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        WebElement javaBox = driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed() && !javaBox.isSelected()) {
            javaBox.click();
            System.out.println(javaBox.isSelected() ? "JAVA BOX IS SELECTED " : "JAVA BOX IS NOT SELECTED");
        } else {
            System.out.println(javaBox.isSelected() ? "JAVA BOX IS SELECTED " : "JAVA BOX IS NOT SELECTED");
        }

        WebElement seleniumBox = driver.findElement(By.id("cond2"));
        if (seleniumBox.isDisplayed() && !seleniumBox.isSelected()) {
            seleniumBox.click();
            System.out.println(seleniumBox.isSelected() ? "SELENIUM BOX IS SELECTED " : "SELENIUM BOX IS NOT SELECTED");
        }
        System.out.println(seleniumBox.isSelected() ? "SELENIUM BOX IS SELECTED " : "SELENIUM BOX IS NOT SELECTED");


        WebElement testNGBox = driver.findElement(By.id("cond3"));
        if (testNGBox.isDisplayed() && !testNGBox.isSelected()) {
            testNGBox.click();
            System.out.println(testNGBox.isSelected() ? "TESTNG IS SELECTED " : "TESTNG IS NOT SELECTED");
        } else {
            System.out.println(testNGBox.isSelected() ? "TESTNG IS SELECTED " : "TESTNG IS NOT SELECTED");
        }

        WebElement cucumberBox = driver.findElement(By.id("cond4"));
        if (cucumberBox.isDisplayed() && !cucumberBox.isSelected()) {
            cucumberBox.click();
            System.out.println(cucumberBox.isSelected() ? "CUCUMBER IS SELECTED " : "CUCUMBER IS NOT SELECTED");
        } else {
            System.out.println(cucumberBox.isSelected() ? "CUCUMBER IS SELECTED " : "CUCUMBER IS NOT SELECTED");
        }
        driver.quit();

    }
}



