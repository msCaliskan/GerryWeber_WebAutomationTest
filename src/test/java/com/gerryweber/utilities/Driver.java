package com.gerryweber.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;

public class Driver {
    private Driver() {}

    private static ChromeDriver driver1;
    private static WebDriver driver;

    public static WebDriver get() {

        if (ConfigurationReader.get("browser").equals("mobile")) {

            if (driver1 == null) {
                String browser = ConfigurationReader.get("browser");

                WebDriverManager.chromedriver().setup();
                driver1 = new ChromeDriver();
                DevTools devTools = driver1.getDevTools();
                devTools.createSession();

                Map<String, Object> deviceMetrics = new HashMap<>();
                deviceMetrics.put("width", 375);
                deviceMetrics.put("height", 812);
                deviceMetrics.put("deviceScaleFactor", 100);
                deviceMetrics.put("mobile", true);

                driver1.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);

            }
            return driver1;
        }else{
            if (driver == null) {
                String browser = ConfigurationReader.get("browser");
                switch (browser) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    case "chrome-headless":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    case "firefox-headless":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                        break;
                    case "ie":
                        if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                            throw new WebDriverException("Your OS doesn't support Internet Explorer");
                        WebDriverManager.iedriver().setup();
                        driver = new InternetExplorerDriver();
                        break;

                    case "edge":
                        if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                            throw new WebDriverException("Your OS doesn't support Edge");
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;

                    case "safari":
                        if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                            throw new WebDriverException("Your OS doesn't support Safari");
                        WebDriverManager.getInstance(SafariDriver.class).setup();
                        driver = new SafariDriver();
                        break;
                }
            }
            return driver;
        }

    }

    public static void closeDriver() {
        if (ConfigurationReader.get("browser").equals("mobile")){
            if (driver1 != null) {
                driver1.quit();
                driver1 = null;
            }
        }else{
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
    }
}