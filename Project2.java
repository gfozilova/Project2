package april7;

import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Project2 {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gfozi\\Desktop\\Selenium\\browserDriver\\chromedriver.exe.exe");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.carfax.com/");

        driver.findElement(By.linkText("Find a Used Car")).click();


        if (driver.getPageSource().contains("Used Cars")) {
            System.out.println("Text is present");
        } else {
            System.out.println("Text is absent");

        }

      Select model = new Select(driver.findElement(By.xpath("//*[@id=\"makeModelPanel\"]/form/div[1]/div/select")));
        driver.findElement(By.name("make")).click();

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", model);
        model.selectByValue("Tesla");
        driver.findElement(By.id("make_Tesla")).click();

        Thread.sleep(1000);


        driver.findElement(By.name("model")).click();
        List<WebElement> l= driver.findElements(By.xpath("//*[contains(text(),'Model X')]"));

        if ( l.size() > 0){
            System.out.println("Text is present. ");
        } else {
            System.out.println("Text is not present. ");
        }


       Select make = new Select(driver.findElement(By.xpath("//*[@id=\"makeModelPanel\"]/form/div[2]/div/select")));
        driver.findElement(By.name("model")).click();

       ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", make);
       make.selectByValue("Model S");
       driver.findElement(By.id("model_Model-S")).click();

        driver.findElement(By.name("zip")).sendKeys("22182 ");
        driver.findElement(By.id("make-model-form-submit")).click();

        if (driver.getPageSource().contains("Step 2 - Show me cars with")) {
            System.out.println("Text is present");
        } else {
            System.out.println("Text is absent");

        }
        driver.findElement(By.xpath("//*[@id=\"react-app-main\"]/div/div[2]/div/div/main/div[3]/div[1]/div/div[2]/ul/li[1]/label/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"react-app-main\"]/div/div[2]/div/div/main/div[3]/div[1]/div/div[2]/ul/li[2]/label/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"react-app-main\"]/div/div[2]/div/div/main/div[3]/div[1]/div/div[2]/ul/li[3]/label/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"react-app-main\"]/div/div[2]/div/div/main/div[3]/div[1]/div/div[2]/ul/li[4]/label/span[2]")).click();

        String result = driver.findElement(By.xpath("//*[@id=\"react-app-main\"]/div/div[2]/div/div/main/div[3]/div[1]/div/div[2]/footer/div/div/button/span")).getText();
        driver.findElement(By.xpath("//*[@id=\"react-app-main\"]/div/div[2]/div/div/main/div[3]/div[1]/div/div[2]/footer/div/div/button")).click();

        WebElement element = driver.findElement(By.xpath("//*[@id=\"totalResultCount\"]"));
        String strng = element.getText();
        System.out.println(strng);
        System.out.println(result);
        Assert.assertEquals(result, strng);


        String bodyText = driver.findElement(By.xpath("//*[@id=\"ucl-microapp-srp-content\"]")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains("Model S"));



        List<WebElement> spans = driver.findElements(By.xpath("(//span[@class='srp-list-item-price'])"));

        List<Double> actualValues = new ArrayList<Double>();

        for (WebElement webElement : spans) {

            actualValues.add(Double.parseDouble(webElement.getText().replace("Price: $", "").replace(",", "")));


        }

        List<Double> expectedValues = new ArrayList<Double>(actualValues);

        Collections.sort(expectedValues);

        Collections.reverse(expectedValues);
        System.out.println(expectedValues);

        if (!expectedValues.equals(actualValues)) {

            System.out.println("PASS");
        } else {
            System.out.println("FAIL");


        }

        driver.findElement(By.id("mileageAsc")).click();

        for (int i = 1; i <= 37; i += 4) {

            List<WebElement> actualMileage = driver
                    .findElements(By.xpath("(//span[@class='srp-list-item-basic-info-value'])[" + i + "]"));

            List<Double> actualMileage1 = new ArrayList<Double>();

            for (WebElement webElement : actualMileage) {

                actualMileage1.add((Double.parseDouble(
                        webElement.getText().replace("Mileage:", "").replace(",", "").replace("miles", ""))));

            }
            List<Double> expectedMileage = new ArrayList<Double>(actualMileage1);


            Collections.sort(expectedMileage);

            System.out.print(expectedMileage);
        }

        System.out.println();

        driver.findElement(By.id("yearDesc")).click();

        List<WebElement> model1 = driver.findElements(By.xpath("//h4[@class='srp-list-item-basic-info-model'] "));

        List<Double> actualYear = new ArrayList<Double>();

        for (WebElement webElement : model1) {

            actualYear.add(Double.parseDouble(webElement.getText().substring(0, 4)));
        }

        List<Double> expectedYear = new ArrayList<Double>(actualYear);

        Collections.sort(expectedYear);

        Collections.reverse(expectedYear);

        System.out.println(expectedYear);

        if (expectedYear.equals(actualYear)) {

            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }


    }






}
