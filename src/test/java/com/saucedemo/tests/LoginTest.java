package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.ReportListener;

@Listeners(ReportListener.class)
public class LoginTest extends BaseTest {

    private final String expectedTitle = "Swag Labs";
    private LoginPage loginPage;
    private HomePage homePage;

    @Test
    public void loginTest() {
        logger.info("Executing loginTest configuration sequence.");
        
        loginPage = new LoginPage(driver);
        
        loginPage.setUserName(username);
        logger.info("Credentials payload injected: Username");
        
        loginPage.setPassword(password);
        logger.info("Credentials payload injected: Password");
        
        homePage = loginPage.clickSubmit();
        logger.info("Authentication request submitted.");
        
        String actualTitle = homePage.getTitle();
        logger.info("Validating landing page metadata security title.");

        Assert.assertEquals(
            actualTitle.trim(), 
            expectedTitle.trim(), 
            "Authentication checkpoint failed! Portal landing page title mismatch."
        );
        
        logger.info("Login authentication validated successfully.");
    }
}