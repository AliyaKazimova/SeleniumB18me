package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");

//        List<WebElement> allLinkss = driver.findElements(By.xpath("//li//a")); //or  By.tagName("li")
//        int counterr0 = 0;
//        for(WebElement linkk: allLinkss){
//            System.out.println(linkk.getText());                                   //  MY PRACTICE
//           System.out.println(linkk.getAttribute("href"));
//            counterr0++;
//        }
//        System.out.println(counterr0);




        List<WebElement> allLinks = driver.findElements(By.xpath("//li//a"));
        int counter = 0;
        // int counterLetters = 0;

        for (WebElement link : allLinks) {
            //  if (link.getText().length() >= 12) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
            link.sendKeys(Keys.ARROW_DOWN);                                            // ACTUAL CODE FROM CLASS
            Thread.sleep(500);
            counter++;
            // counterLetters++;
        }
        System.out.println(counter);
        // System.out.println(counterLetters);


                int counter2 = 0;
                for (WebElement link : allLinks) {
                    if (link.getText().trim().length() >= 12) {
                        System.out.println(link.getText());
                        counter2++;
                    }
                }
                System.out.println(counter2);





    }

}
