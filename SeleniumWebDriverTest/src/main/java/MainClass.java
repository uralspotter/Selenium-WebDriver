import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver_chrome;
    static WebDriver driver_firefox;

    public static void main(String[] args) {

//        final String site = "https://passport.yandex.ru/auth";
        System.setProperty("WebDriver.gecko.driver","C:\\Windows\\System32\\geckodriver.exe");
        System.setProperty("WebDriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
        System.setProperty("WebDriver.microsoft.driver", "C:\\Windows\\System32\\MicrosoftWebDriver.exe");



    }

    public static void enterText(String name, String text) {
        String inputXPath = String.format("//input[@name='%s']", name);
        driver_chrome.findElement(By.xpath(inputXPath)).sendKeys(text);
    }

    public static void selectedCheckbox() {
        String cbXpath = "//label[@class='passport-Checkbox']";
        if (!driver_chrome.findElement(By.xpath(cbXpath + "/input[@name='twoweeks']")).isSelected()) {
            driver_chrome.findElement(By.xpath(cbXpath + "/span[@class='passport-Checkbox-View']")).click();
        }
    }

    public static void unselectedCheckbox() {
        String cbXpath = "//label[@class='passport-Checkbox']";
        if (driver_chrome.findElement(By.xpath(cbXpath + "/input[@name='twoweeks']")).isSelected()) {
            driver_chrome.findElement(By.xpath(cbXpath + "/span[@class='passport-Checkbox-View']")).click();
        }
    }

    public static void selectOption(String listName, String option) {
        String listXPath = String.format("$s", listName);
        String optionXPath = String.format("$s", option);
    }
}
