package april7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class newww {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gfozi\\Desktop\\Selenium\\browserDriver\\chromedriver.exe.exe");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.amazon.com/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mouse");
        driver.findElement(By.id("nav-search-submit-button")).click();


    }
}
