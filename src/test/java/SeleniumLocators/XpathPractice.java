package SeleniumLocators;

import com.sun.deploy.net.proxy.pac.PACFunctions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractice {
    public static void main(String[] args) throws InterruptedException {
   /*
    1-Navigate to the website http://tutorialsninja.com/demo/index.php?route=account/register
    2-Provide First name,LastName,Email,Telephone,password,confirm password
    and click privacy policy button.(isDisplayed and notSelected then click)
    3-Click Continue Button

    4-Validate message (Your Account Has Been Created!) -->if statement
    5-Click Continue Button
    6-Validate the url https://tutorialsninja.com/demo/index.php?route=account/account
    7-Close your browser
    NOTE:Please USE ALL XPATH TO LOCATE THE ELEMENT
    */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Joey");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Jordison");
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("jojmmo@lolommveve.gmail.com");
        WebElement phone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        phone.sendKeys("11111111111111");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("fubeam");
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        confirmPassword.sendKeys("fubeam");
        WebElement privacyPolicy = driver.findElement(By.xpath("//input[@name='agree']"));
        if (privacyPolicy.isDisplayed() && !privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
        WebElement continueButton = driver.findElement(By.xpath("//input[@type='submit']"));
        continueButton.click();

        //h1[contains(text(),'Your Account Has Been Created!')]  I WAS STRUGGLING WITH THIS ELEMENT

        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader) ? "account created woooho" : "account not created damnnn");

        WebElement continueButton2 = driver.findElement(By.xpath("//a[@class='btn btn-primary']")); // //a[.='Continue']
        continueButton2.click();

        String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/account";
        String actualURL = driver.getCurrentUrl().trim();
        System.out.println(actualURL.equals(expectedURL) ? "URL PASSED" : "URL FAILED");
        Thread.sleep(1000);
        driver.quit();




    }
}
