package nz.ac.auckland.se754.web.stepdefs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;


import java.util.concurrent.TimeUnit;

public class SharedDriver {
    private static SharedDriver sharedDriver;
    private WebDriver driver;

    public static SharedDriver getSharedDriverInstance(){
        if (sharedDriver == null) {
            sharedDriver = new SharedDriver();
        }
        return sharedDriver;
    }

    private SharedDriver() {
        driver = setupDriver();
    }

    public WebDriver setupDriver() {
//        System.setProperty("webdriver.chrome.driver", "webdrivers/macos/chromedriver");
        System.setProperty("webdriver.chrome.driver", "webdrivers/win/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        if (System.getenv().getOrDefault("headless", "false").equals("true")) {
            options.addArguments("--headless");
        }

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1200");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-extensions");
        options.addArguments("--whitelisted-ips");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        return driver;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = setupDriver();
        }

        return driver;
    }

    public void quitAndResetDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
