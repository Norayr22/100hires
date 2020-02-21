package com.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {
    public static DriverFactory get() {
        return new DriverFactory();
    }

    private static final String BROWSER = System.getProperty("selenium.browser", "chrome");
    public WebDriver driver;
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    private final Supplier<WebDriver> chromeSupplier = () -> {
        if(driverThread.get() == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driverThread.set(driver);
        }
        return driverThread.get();
    };

    private final Supplier<WebDriver> firefoxSupplier = () -> {
        if(driverThread.get() == null) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driverThread.set(driver);
        }
        return driverThread.get();
    };

    private final Map<String,Supplier<WebDriver>> MAP = new HashMap<>();

     {
        MAP.put("chrome",chromeSupplier);
        MAP.put("firefox",firefoxSupplier);
    }

    public WebDriver getDriver(){
        return MAP.get(BROWSER).get();
    }

    public void quitDriver(WebDriver driver){
         driver.quit();
         driverThread.remove();
    }
}
