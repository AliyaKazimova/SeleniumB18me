package SeleniumIntro;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {

        //First step: Setting up the automation
        WebDriverManager.chromedriver().setup();

        //Second step: Creating driver to make connection with website
        WebDriver driver = new ChromeDriver();

        //Third step: Navigating to website
        driver.get("https://www.amazon.com");     //the get() method waits until the web page is considered fully loaded and ready to return control
        System.out.println(driver.getTitle());

        //Fourth step: Validation
        String actualTitle = driver.getTitle(); // comes from website
        String expectedTitle = "Amazon.com. Spend less. Smile more."; //comes from documentation, we are providing it

        //command+F opes search bar HTML
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title is passing");
        } else {
            System.out.println("Title is failing");
        }
        String actualUrl = driver.getCurrentUrl(); //it gets url from website
        String expectedUrl = "https://www.amazon.com/";
        System.out.println(actualUrl.equals(expectedUrl) ? "URL PASSED" : "URL FAILED");
        driver.close(); //closes opened browser


    }
}
