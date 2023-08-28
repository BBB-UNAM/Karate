package com.company.ejercicio1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebdriverQuickStudy {

    public WebDriver chromeConfig(){

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-extensions");

        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

    public void explicitWait(WebDriver driver, int time){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    public void click(WebDriver driver, String xpath){
        //driver.findElement(By.xpath(xpath)).click();
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2));
        // es posoble agregar expeciones a ignorar
        WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element.click();
    }
    public void sendKeys(WebDriver driver, String xpath,String text){
        //driver.findElement(By.xpath(xpath)).sendKeys(text);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2));
        // es posoble agregar expeciones a ignorar
        WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element.sendKeys(text);
    }
    public static void main(String[] args) throws InterruptedException {
        //System.out.println("Hola ");

        //WebdriverQuickStudy steps = new WebdriverQuickStudy();
        //WebDriverManager.edgedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        File rootPath = new File("src/main/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver", rootPath.getPath());
        WebDriver driver = new ChromeDriver();
        //steps.explicitWait(driver,10);

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/");
        //steps.click(driver, "//a[text()='Key Presses']");
        Thread.sleep(3000);
        driver.quit();
        driver.close();


    }
}
