import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver_chrome;

    public static void main(String[] args) {

        final String site = "https://passport.yandex.ru/auth";

        System.setProperty("WebDriver.gecko.driver","C:\\Windows\\System32\\geckodriver.exe");
        System.setProperty("WebDriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
        System.setProperty("WebDriver.microsoft.driver", "C:\\Windows\\System32\\MicrosoftWebDriver.exe");

//        WebDriver driver_firefox = new FirefoxDriver();
        driver_chrome = new ChromeDriver();
        driver_chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver_chrome.manage().window().maximize();
//        driver_firefox.get(site);
        driver_chrome.get(site);
        System.out.println(driver_chrome.getTitle());
        System.out.println(driver_chrome.getCurrentUrl());
//        WebElement link = driver_chrome.findElement(By.xpath("//div[@class='desk-notif-card__card']/a[@class='desk-notif-card__login-enter-expanded']"));
//        link.click();
        driver_chrome.findElement(By.xpath("//input[@name='login']")).sendKeys("userLogin");
        driver_chrome.findElement(By.xpath("//input[@name='passwd']")).sendKeys("userPassword");
        selectedCheckbox();
        unselectedCheckbox();
        System.out.println(driver_chrome.getTitle());
        System.out.println(driver_chrome.getCurrentUrl());
//        driver_chrome.quit();
//        driver_firefox.quit();
    }

    public static void selectedCheckbox() {
        String cbXpath = "//input[@name='twoweeks']";
        if (!driver_chrome.findElement(By.xpath(cbXpath)).isSelected()) {
            driver_chrome.findElement(By.xpath(cbXpath)).click();
        }
    }

    public static void unselectedCheckbox() {
        String cbXpath = "//input[@name='twoweeks']";
        if (driver_chrome.findElement(By.xpath(cbXpath)).isSelected()) {
            driver_chrome.findElement(By.xpath(cbXpath)).click();
        }
    }
}
