package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLocators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement abTesting = driver.findElement(By.partialLinkText("Testing"));
        abTesting.click();
        WebElement header = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
        System.out.println(header.getText().trim());
        WebElement paragraph = driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        System.out.println(paragraph.getText());

        System.out.println(" testing trim method  ");
        System.out.println(" testing trim method  ".trim());
//      WebElement selenium = driver.findElement(By.xpath("//a[contains(text(),'Elemental')]"));
        WebElement selenium = driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        selenium.click();


//
//        WebElement abTesting= driver.findElement(By.partialLinkText("Testing"));
//        abTesting.click();
//        WebElement header= driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
//        System.out.println(header.getText().trim());
//        WebElement paragraph= driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
//        System.out.println(paragraph.getText());

//        System.out.println(" testing trim method  ");
//        System.out.println(" testing trim method  ".trim());
//
//        // WebElement selenium= driver.findElement(By.xpath("//a[contains(text(),'Selenium')]"));
//        WebElement selenium= driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
//        selenium.click();

    }
}
