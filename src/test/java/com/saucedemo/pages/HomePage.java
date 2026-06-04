package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Captures the page title to validate successful authentication.
    public String getTitle() {
        return driver.getTitle();
    }
}