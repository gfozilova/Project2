package april7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class SeleniumDemo {


    public static void main(String[] args) throws ParseException {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gfozi\\Desktop\\Selenium\\browserDriver\\chromedriver.exe.exe");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        driver.findElement(By.linkText("Order")).click();


        Random r = new Random();
        int low = 0;
        int high = 100;
        int result = r.nextInt(high - low) + low;


        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).clear();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("" + result);


        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        StringBuilder sb = new StringBuilder();

        Random random = new Random();

        int length = 5;

        for (int i = 0; i < length; i++) {

            int index = random.nextInt(alphabet.length());

            char randomChar = alphabet.charAt(index);

            sb.append(randomChar);
        }

        String randomString = sb.toString();

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(randomString);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("8607 Westwood Center Dr");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Vienna");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Virginia");

        int n = 10000 + new Random().nextInt(90000);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("" + n);


        List<WebElement> options = driver.findElements(By.xpath("//input[@name = 'ctl00$MainContent$fmwOrder$cardList']"));
        Random ran = new Random();
        int index = ran.nextInt(options.size());
        options.get(index).click();

        long first14 = (long) (Math.random() * 100000000000000L);
        long first15 = (long) (Math.random() * 1000000000000000L);
        long number = 0;

        if (index == 2) {
            number = 300000000000000L + first14;
        } else if (index == 0) {
            number = 4000000000000000L + first15;
        } else if (index == 1) {
            number = 5000000000000000L + first15;

        }
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("" + number);


        String input = "11/24";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
        simpleDateFormat.setLenient(false);
        Date expiry = simpleDateFormat.parse(input);
        boolean expired = expiry.before(new Date());

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("" + input);
        driver.findElement(By.linkText("Process")).click();

        if (driver.getPageSource().contains("New order has been successfully added")) {
            System.out.println("Text is present");
        } else {
            System.out.println("Text is absent");

        }


    }
}
















