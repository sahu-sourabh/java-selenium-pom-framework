package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    // Element attributes are encapsulated right here as private constants
    private static final String USERNAME_ID = "user-name";
    private static final String PASSWORD_ID = "password";
    private static final String LOGIN_BTN_ID = "login-button";

    // Clean, readable locator assignments
    private final By usernameField = By.id(USERNAME_ID);
    private final By passwordField = By.id(PASSWORD_ID);
    private final By loginButton = By.id(LOGIN_BTN_ID);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public HomePage clickSubmit() {
        driver.findElement(loginButton).click();
        return new HomePage(driver); // Returns the next page object seamlessly
    }
}