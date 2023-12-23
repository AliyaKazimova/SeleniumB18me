package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsMethod {
    public static void main(String[] args) throws InterruptedException {

        //when we are going through elements we choose attribute which is unique for this elements
        //meaning that's a limitations in which elements will be iterating
        //like checkbox --> only 4 of them in this example (for java, selenium, testng, cucumber )

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/alinamars/Downloads/Techtorialhtml(1).html");
        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']")); //4
        for (WebElement box : allBoxes) {
            if (box.isDisplayed() && !box.isSelected()) {
                Thread.sleep(2000); //just to see how process is happening
                box.click();
            }
            System.out.println(box.isSelected() ? "SELECTED" : "NOT SELECTED");

        }
    }
}
