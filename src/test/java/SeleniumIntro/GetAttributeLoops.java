package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GetAttributeLoops {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");

        Thread.sleep(1000);
        WebElement collapseButton = driver.findElement(By.xpath("//button"));
        collapseButton.click();
        Thread.sleep(1000);

        List<WebElement> allCheckboxes = driver.findElements(By.xpath("//li//div"));   // //div[@role='checkbox']

        for (WebElement checkbox : allCheckboxes){
            if(checkbox.getAttribute("aria-checked").equals("false")){
                checkbox.click();
            }
        }

    }
}
