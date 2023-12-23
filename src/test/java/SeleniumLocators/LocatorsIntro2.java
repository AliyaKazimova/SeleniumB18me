package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/alinamars/Downloads/Techtorialhtml(2).html");

        //TAG NAME LOCATOR: PURPLE TAG NAMES SLASH SLASH // <-- WE LOOK FOR TAGNAME
        //<u>Use Java Version</u>  --> u is tag name
        WebElement javaVersion = driver.findElement(By.tagName("u"));
        System.out.println(javaVersion.getText());

        //LINK TEXT LOCATOR:
        //<a href="https://www.oracle.com/java/">Java</a>   it's a link text    / like:  <a and also text -->>Java<
        WebElement java = driver.findElement(By.linkText("Java"));
        java.click();
        WebElement header = driver.findElement(By.tagName("h1"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "Java";
        System.out.println(actualHeader.equals(expectedHeader) ? "Java Passed " : "Java Failed");

       /*
        1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
        2-Go back to the main page
        3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
        4-Go back to the main page
        5-Click TestNG and validate(ternary) header -->TestNG
        6-Go back to the main page
        7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
         */
        Thread.sleep(1000);

        driver.navigate().back();
        WebElement selenium = driver.findElement(By.linkText("Selenium"));
        selenium.click();
        WebElement seleniumHeader = driver.findElement(By.tagName("h1"));
        System.out.println(seleniumHeader.getText().trim().equals("Selenium automates browsers. That's it!") ? "Selenium header passed " : "Selenium header failed");
        Thread.sleep(1000);

        driver.navigate().back();
        WebElement cucumber = driver.findElement(By.linkText("Cucumber"));
        cucumber.click();
        WebElement cucumberHeader = driver.findElement(By.tagName("h1"));
        System.out.println(cucumberHeader.getText().trim().equals("Tools & techniques that elevate teams to greatness") ? "Cucumber header passed " : "Cucumber header failed");
        driver.navigate().back();

        WebElement testNG = driver.findElement(By.linkText("TestNGConcept"));
        testNG.click();
        WebElement testNGHeader = driver.findElement(By.tagName("h2"));
        System.out.println(testNGHeader.getText().trim().equals("TestNGConcept") ? "TestNG header passed " : "TestNG header failed");
        Thread.sleep(1000);
        driver.navigate().back();

        String expectedUrl = "file:///Users/alinamars/Downloads/Techtorialhtml(2).html";
        System.out.println(expectedUrl.trim().equals("file:///Users/alinamars/Downloads/Techtorialhtml(2).html") ? "Url passed " : "Url failed");

        System.out.println();
//      driver.quit();

        //PARTIALLINKTEXT:
        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();

        //CSS:
        //# is for id
        //#techtorial1 in search bar will show --> <h1 name="tech" id="techtorial1">Techtorial Academy</h1>      and value will be 1/1
        // . is for class in search -->     .btn-primary    out of next line
        // --> <a class="btn btn-lg btn-primary" role="button" href="/thanks">Submit</a>     and .btn-primary will show us unique value 1/1
        WebElement techtorialHeader = driver.findElement(By.cssSelector("#techtorial1"));
        System.out.println(techtorialHeader.getText());

        WebElement allTools = driver.findElement(By.cssSelector(".group_checkbox"));
        System.out.println(allTools.getText().trim());


    }
}
