package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {
    public static void main(String[] args) throws InterruptedException {

        /*
    HOMEWORK:
    GO TO 3 DIFFERENT WEBSITES (URL, TITLE)
    AND APPLY ALL METHODS
    AND AT THE END QUIT BROWSER
     */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.pinterest.com/");
        Thread.sleep(1000);
        String expectedTitle = "Pinterest";
        String actualTitle = driver.getTitle();
        System.out.println(expectedTitle.equals(actualTitle) ? "Title Passed" : "Title Failed");
        Thread.sleep(1000);
        //COMAND + D to copy whole line
        String expectedUrlPinterest = "https://www.pinterest.com/";
        String actualUrlPinterest= driver.getCurrentUrl();
        System.out.println(expectedUrlPinterest.equals(actualUrlPinterest) ? "Url Passed" : "Url Failed");
        Thread.sleep(1000);


        driver.navigate().to("https://www.instagram.com/");
        String expectedTitleInstagram = "Instagram";
        String actualTitleInstagram = driver.getTitle();
        Thread.sleep(1000);
        System.out.println(expectedTitleInstagram.equals(actualTitleInstagram) ? "Title Passed" : "Title Failed");
        String expectedUrlInstagram = "https://www.instagram.com/";
        String actualUrlInstagram= driver.getCurrentUrl();
        System.out.println(expectedUrlInstagram.equals(actualUrlInstagram) ? "Url Passed" : "Url Failed");
        Thread.sleep(1000);
        driver.getPageSource();


        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().refresh();
        driver.quit();







    }
}
