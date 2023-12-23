package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealLifeExample {
    public static void main(String[] args) {

        //    Test Case - Open Godaddy.com and validate it's Page title and the url.
        //    Steps to Automate:
        //            1. Launch browser of your choice say., Firefox, chrome etc.
        //            2. Open this URL - https://www.godaddy.com/
        //            3. Get Title of page and validate it.(if conditions) expected title from website
        //            3. Get URL of current page and validate it.          expected url from website
        //            4. Close browser.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.godaddy.com/");

        /*
        NOTE: While get() is easier to use, navigate() has two primary advantages.
        First, navigate() provides additional methods for navigating pages in history, as well as refreshing the current page.
        Second, it maintains state between each URL it navigates to,
        meaning cookies and other session data are persisted across each page load.
         */

        String expectedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        String actualTitle = driver.getTitle();
        System.out.println(expectedTitle.equals(actualTitle) ? "Title passed" : "Title failed");

        String expectedUrl = "https://www.godaddy.com/";
        String actualUrl = driver.getCurrentUrl();
        System.out.println(expectedUrl.equals(actualUrl) ? "Url passed" : "Url failed");

        driver.close();


    }
}
