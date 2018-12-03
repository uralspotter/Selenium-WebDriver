import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) {

        final String site = "http://github.com";

        System.setProperty("WebDriver.gecko.driver","C:\\Windows\\System32\\geckodriver.exe");
        System.setProperty("WebDriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
        System.setProperty("WebDriver.microsoft.driver", "C:\\Windows\\System32\\MicrosoftWebDriver.exe");

//        WebDriver driver_firefox = new FirefoxDriver();
        WebDriver driver_chrome = new ChromeDriver();
        driver_chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver_chrome.manage().window().maximize();
//        driver_firefox.get(site);
        driver_chrome.get(site);
        System.out.println(driver_chrome.getTitle());
        System.out.println(driver_chrome.getCurrentUrl());
        driver_chrome.findElement(By.xpath("//input[@id='user[login]']")).sendKeys("userLogin");
        driver_chrome.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("userEmail");
        driver_chrome.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("userPassword");
        WebElement link = driver_chrome.findElement(By.xpath("//button[@type='submit']"));
        link.click();
        System.out.println(driver_chrome.getTitle());
        System.out.println(driver_chrome.getCurrentUrl());
        driver_chrome.quit();
//        driver_firefox.quit();
    }
}
