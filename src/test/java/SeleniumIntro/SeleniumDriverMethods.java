package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriverMethods {
    /*
    driver.get()
    driver.manage.window.maximize()
    driver.getTitle()
    driver.getCurrentUrl()
    driver.navigate.to()
    driver.navigate.refresh()
    driver.navigate.forward()
    driver.getPageSource()
    driver.close()
    driver.quit()
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(1000);


        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(1000);

        driver.navigate().back(); // --> google
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(1000);

        driver.navigate().forward(); // --> facebook
        System.out.println(driver.getTitle());
        Thread.sleep(1000);

        driver.navigate().refresh(); // --> refresh
        System.out.println(driver.getPageSource()); //html of page
        Thread.sleep(1000);
        driver.quit();

    /*
    HOMEWORK:  done
    GO TO 3 DIFFERENT WEBSITES (URL, TITLE)
    AND APPLY ALL METHODS
    AND AT THE END QUIT BROWSER
     */


    }
}
