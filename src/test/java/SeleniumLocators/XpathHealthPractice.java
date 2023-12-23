package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class XpathHealthPractice {
    public static void main(String[] args) throws InterruptedException {
    /*
    //THESE PARTS SHOULD BE DONE BY XPATH:
    1-Navigate to the https://katalon-demo-cura.herokuapp.com/
    2-Click Make an Appointment
    3-Login the username and password provided and Login successfully

    4-Choose the facility either HongKong or Seoul -->send keys
    5-Click apply for hospital admission box if it is displayed and validate it is selected
    6-Healthcare program 'Medicaid'
    7-Visit date should be provided -->send keys
    8-Put your comment for this box -->send keys
    9-Book your appointment

    THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
    10-Validate the header is "Appointment confirmation" (if statement)
    11-Print out the headers and values(only values) on your console.
    12)Click go to homepage and print out url
    13)Driver.quit or close.
    */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");

        WebElement clickAppoitmentButton = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        clickAppoitmentButton.click();
        WebElement userName = driver.findElement(By.xpath("//input[@id='txt-username']"));
        userName.sendKeys("John Doe");
        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement loginButton = driver.findElement(By.xpath("//button"));
        Thread.sleep(2000);
        loginButton.click();


        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Seoul CURA Healthcare Center");
        WebElement applyForHospitalReadmisson = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
//        if (applyForHospitalReadmisson.isDisplayed() && !applyForHospitalReadmisson.isSelected()) {      --> commenting this part in order to show TestNG logic
//            applyForHospitalReadmisson.click();
//        }
        Assert.assertTrue(applyForHospitalReadmisson.isDisplayed());
        Assert.assertFalse(applyForHospitalReadmisson.isSelected());
        applyForHospitalReadmisson.click();
        Assert.assertTrue(applyForHospitalReadmisson.isSelected());

        WebElement medicaid = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        medicaid.click();

        WebElement visitDate = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        visitDate.sendKeys("30/11/2023");
        WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("I love Selenium, it's so much fun, especially with Ahmet and his jokes. ONE DAY I WILL BE COOL AS HIM LOL");
        Thread.sleep(2000);
        WebElement bookAppointment = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        bookAppointment.click();

        WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'Appointment')]"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "Appointment Confirmation";
//      System.out.println(actualHeader.equals(expectedHeader) ? "Appointment created" : "Appointment not created");
        Assert.assertEquals(expectedHeader, actualHeader);


        WebElement facilityValidation = driver.findElement(By.xpath("//p[contains(text(),'Seoul CURA Healthcare Center')]"));
        System.out.println(facilityValidation.getText());
        WebElement readmissionValidation = driver.findElement(By.xpath("//p[contains(text(),'Yes')]"));
        System.out.println(readmissionValidation.getText());
        WebElement healthProgramValidation = driver.findElement(By.xpath("//p[contains(text(),'Medicaid')]"));
        System.out.println(healthProgramValidation.getText());
        WebElement visitDateValidation = driver.findElement(By.xpath("//p[contains(text(),'30/11/2023')]"));
        System.out.println(visitDateValidation.getText());
        WebElement commentValidation = driver.findElement(By.xpath("//p[@id='comment']"));
        System.out.println(commentValidation.getText());

        WebElement goToHomePage = driver.findElement(By.xpath("//a[contains(text(),'Go to Homepage')]"));
        goToHomePage.click();
        System.out.println(driver.getCurrentUrl());
        driver.quit();



    }
}
