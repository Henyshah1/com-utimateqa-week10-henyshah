package browsertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowserTest {
    public static void main(String[] args) throws InterruptedException {


        String baseUrl = "https://courses.ultimateqa.com/";

        //launch the Chrome Browser
        WebDriver driver = new ChromeDriver();

        //Open the URL into browser
        driver.get(baseUrl);

        //Maximize the Browser
        driver.manage().window().maximize();
        Thread.sleep(5000);

        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(5000);
        //Get the tittle of the page
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(5000);

        String signinUrl = "https://courses.ultimateqa.com/users/sign_in";

        driver.navigate().to(signinUrl);
        System.out.println("Get current Url " + driver.getCurrentUrl());


        //Get page Source
        System.out.println(driver.getPageSource());

        //click on sign in link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        Thread.sleep(4000);
        //Get current URL
        driver.navigate().to(signinUrl);
        System.out.println("Get current Url " + driver.getCurrentUrl());


        //find email feild element and type the email
        WebElement emailFeild = driver.findElement(By.id("user[email]"));
        emailFeild.sendKeys("abc123@gmail.com");
        Thread.sleep(5000);

        WebElement passwordFeild = driver.findElement(By.name("user[password]"));
        passwordFeild.sendKeys("abc123");
        Thread.sleep(5000);

        //login
        //click on to login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(4000);


        //forward
        Thread.sleep(5000);
        driver.navigate().forward();
        System.out.println("Get current Url " + driver.getCurrentUrl());


        //navigate backward
        Thread.sleep(5000);
        driver.navigate().back();
        System.out.println("Get current Url " + driver.getCurrentUrl());

        //refresh
        Thread.sleep(5000);
        driver.navigate().refresh();

        //close
        driver.quit();

    }
}




