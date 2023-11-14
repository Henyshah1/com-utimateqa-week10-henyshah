package browsertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {
    static String browser = "Firefox";
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        String baseUrl = "https://courses.ultimateqa.com/";
        //launch the Chrome Browser


        //open the URL into b
        driver.get(baseUrl);
        // Maximise the browser
        driver.manage().window().maximize();

        // we give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //Get the tittle of the page
        String title = driver.getTitle();
        System.out.println(title);


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