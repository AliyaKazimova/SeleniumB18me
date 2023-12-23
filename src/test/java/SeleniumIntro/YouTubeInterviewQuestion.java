package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class YouTubeInterviewQuestion {
     /*
    1-Navigate to the youtube
    2-Search for Justin Bieber
    3-Find the location of all links(i showed you)(go with a tagname)
    4-Once any of links equals to "Justin Bieber-Baby ft.Ludacris)
    5-Click the link and make sure the video is playing

    NOTE:Inside of loop you can ARROW DOWN like we did before if you get exception
    Thread
      */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");

        WebElement searchBar = driver.findElement(By.xpath("//input[@id='search']"));
        searchBar.sendKeys("Justin Bieber");
        WebElement searchButton = driver.findElement(By.cssSelector("#search-icon-legacy")); //By.xpath("//button[@id='search-icon-legacy']
        searchButton.click();
        Thread.sleep(1000);

        List<WebElement> headers = driver.findElements(By.xpath("//a[@id='video-title']"));
        String expectedTitle = "Justin Bieber - Baby ft. Ludacris";

        for (WebElement header : headers) {
            header.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1000);
            if (header.getAttribute("title").equals(expectedTitle)) {
                header.click();
                break;

            }

        }

    }
}


