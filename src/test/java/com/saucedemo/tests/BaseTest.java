package com.saucedemo.tests;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.saucedemo.utils.ConfigReader;

public class BaseTest {

    protected ConfigReader readConfig = new ConfigReader();
    protected String baseURL = readConfig.getURL();
    protected String username = readConfig.getUsername();
    protected String password = readConfig.getPassword();
    
    protected WebDriver driver; 
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String br) {
        logger.info("Initializing browser automation session for: {}", br);

        driver = switch (br.toLowerCase().trim()) {
            case "chrome" -> new ChromeDriver(); // Native Selenium Manager automatically configures this binary!
            case "edge"   -> new EdgeDriver();
            default -> throw new IllegalArgumentException("Bailing out! Unsupported browser parameter: " + br);
        };

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get(baseURL);
        driver.manage().window().maximize();
        logger.info("Successfully navigated to base URL: {}", baseURL);
    }

    @AfterClass(alwaysRun = true) // alwaysRun ensures browser closes even if previous test configurations crash
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Automation browser session closed smoothly.");
        }
    }
}