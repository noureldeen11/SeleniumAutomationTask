package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    public static ChromeOptions chromeOption() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--remote-allow-origins=*");

        options.addArguments("--no-sandbox"); // Bypass OS security model
        return options;
    }

    public static FirefoxOptions firefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        options.addArguments("--no-sandbox");// Bypass OS security model
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setAcceptUntrustedCertificates(true);
        options.setProfile(profile);

        return options;
    }

    @Parameters({"browser"})
    @BeforeTest
    public void openBrowser(@Optional("chrome") String browser) {

        if (browser.equalsIgnoreCase("firefox")) {
           driver= fireFoxBrowserSetup();
        }

        if (browser.equalsIgnoreCase("chrome")) {
            driver = chromiumBrowserSetup();
        }

        driver.manage().window().maximize();
        driver.get("https://practice.automationtesting.in/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    private WebDriver chromiumBrowserSetup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = chromeOption();
        driver = new ChromeDriver(options);

        return driver;
    }

    private WebDriver fireFoxBrowserSetup() {
        WebDriverManager.chromedriver().setup();
        FirefoxOptions options = firefoxOptions();
        driver = new FirefoxDriver(options);

        return driver;
    }


    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
