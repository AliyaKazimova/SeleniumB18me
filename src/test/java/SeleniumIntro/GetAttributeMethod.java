package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeMethod {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        //Task is to print out value 'John Doe' and password 'ThisIsNotAPassword'
        // //input[@aria-describedby='demo_username_label'] --> element john doe
        //note: avoid using value itself since it can change but more general stuff like aria described by most likely will be here

        WebElement username = driver.findElement(By.xpath("//input[@aria-describedby='demo_username_label']"));
        System.out.println(username.getText());    //works only when we have text in the element
        System.out.println(username.getAttribute("value"));

        WebElement password = driver.findElement(By.xpath("//input[@aria-describedby='demo_password_label']"));
        System.out.println(password.getAttribute("value"));
        System.out.println(password.getAttribute("placeholder"));


    }
}
