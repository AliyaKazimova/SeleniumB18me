package TestNGConcept;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {

    @Test
    public void validateSuccessfulLogin() throws InterruptedException {
        /*
        1-setup your automation
        2-Navigate to the website https://demo.opencart.com/admin/
        3-provide username=demo and password=demo
        4-Validate(assert) the title is "Dashboard"
        5-driver.close()
        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");


        WebElement username = driver.findElement(By.cssSelector("#input-username")); //or  By.xpath("//input[@id='input-username']")
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));  //or  By.xpath("//input[@id='input-password']")
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.cssSelector(".btn-primary"));
        loginButton.click();
        Thread.sleep(2000);

        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(3000);
        driver.close();
    }





    @Test
    public void validateNegativeLogin() throws InterruptedException {
             /*
         1-setup your automation
         2-Navigate to the website https://demo.opencart.com/admin/
         3-provide username=demo and password=asdasd
         4-Validate(assert) the message "No match for Username and/or Password."
         5-driver.close()
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");


        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("dqwertyuiop[cvbnmkjhgfdsxcvbnmkjhgfcvbno");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.cssSelector(".btn-primary"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement alertMessage = driver.findElement(By.cssSelector("#alert"));
        String actualMessage = alertMessage.getText().trim();
        String expectedMessage = "No match for Username and/or Password.";
        Assert.assertEquals(actualMessage, expectedMessage);
        driver.close();

    }




    @Test
    public void validateProductButton() throws InterruptedException {
            /*
        1-setup your automation
        2-Navigate to the website https://demo.opencart.com/admin/
        3-provide username=demo and password=demo
        4-Click X button from pop-up
        5-Click Catalog
        6-Validate Product button is displayed
        7-Validate Product button is enabled
        8-Click the button and validate the header is "Products"
        9-close your browser
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");


        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.cssSelector(".btn-primary"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement closePopUpMessage = driver.findElement(By.cssSelector(".btn-close"));
        closePopUpMessage.click();
        Thread.sleep(1000);

        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        Thread.sleep(1000);

        WebElement productsButtons = driver.findElement(By.linkText("Products"));
        Assert.assertTrue(productsButtons.isDisplayed() && productsButtons.isEnabled());
        Assert.assertTrue(productsButtons.isDisplayed() && productsButtons.isEnabled());
        //selected for box, enabled means visible
        productsButtons.click();

        WebElement productHeader = driver.findElement(By.tagName("h1"));
        String actualHeader = productHeader.getText().trim();
        String expectedHeader = "Products";
        Assert.assertEquals(actualHeader, expectedHeader);
        driver.quit();
    }



    @Test
    public void validateBoxesFunctionalityInProducts() throws InterruptedException {
    /*
         1-setup your automation
         2-Navigate to the website https://demo.opencart.com/admin/
         3-provide username=demo and password=demo
         4-Click X button from pop-up
         5-Click Catalog
         6-CLick product button
         7-Find the locations of all boxes(first page only) and test these
           >Use regular loop since first box is selecting all which I do not want. Start from index 1
           ->Assert the box is displayed,is not selected
           ->Click the box
           -->Assert the box is selected
           -->Arrow down the page(put inside of loop)
            8-Close the page
    */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.cssSelector(".btn-primary"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement closePopUpMessage = driver.findElement(By.cssSelector(".btn-close"));
        closePopUpMessage.click();
        Thread.sleep(1000);

        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        Thread.sleep(1000);

        WebElement productsButtons = driver.findElement(By.linkText("Products"));
        Assert.assertTrue(productsButtons.isDisplayed() && productsButtons.isEnabled());
        productsButtons.click();
        Thread.sleep(1000);

        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 1; i < allBoxes.size(); i++) {
            Assert.assertTrue(allBoxes.get(i).isDisplayed());
            Assert.assertFalse(allBoxes.get(i).isSelected());
            Thread.sleep(200);
            allBoxes.get(i).click();
            Assert.assertTrue(allBoxes.get(i).isSelected());
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }
    }

    @Test
    public void validateAscendingOrder() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement username=driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password=driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton=driver.findElement(By.cssSelector(".btn-primary"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement xButton=driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton=driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        WebElement productsButton=driver.findElement(By.linkText("Products"));
        productsButton.click();
        List<WebElement> allProductNames=driver.findElements(By.xpath("//td[@class='text-start']"));//11
        List<String> actualOrder=new ArrayList<>();
        List<String> expectedOrder=new ArrayList<>();

        for(int i=1;i<allProductNames.size();i++){
            actualOrder.add(allProductNames.get(i).getText().trim().toLowerCase());//to remove the confusion of ASCII TABLE
            expectedOrder.add(allProductNames.get(i).getText().trim().toLowerCase());
        }
        Collections.sort(expectedOrder);
        System.out.println(actualOrder);
        System.out.println(expectedOrder);
        Assert.assertEquals(actualOrder,expectedOrder);
    }
    @Test
    public void validateDescendingOrder() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement username=driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password=driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton=driver.findElement(By.cssSelector(".btn-primary"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement xButton=driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton=driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        WebElement productsButton=driver.findElement(By.linkText("Products"));
        productsButton.click();
        Thread.sleep(1000);
        WebElement productName=driver.findElement(By.linkText("Product Name"));
        productName.click();
        Thread.sleep(1000);
        List<WebElement> allProducts=driver.findElements(By.xpath("//td[@class='text-start']"));//11

        List<String> actualOrder=new ArrayList<>();
        List<String> expectedOrder=new ArrayList<>();

        for(int i=1;i<allProducts.size();i++){
            actualOrder.add(allProducts.get(i).getText().toLowerCase().trim());
            expectedOrder.add(allProducts.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(expectedOrder);
        Collections.reverse(expectedOrder);
        System.out.println(actualOrder);
        System.out.println(expectedOrder);
        Assert.assertEquals(actualOrder,expectedOrder);

        driver.close();
    }



}
