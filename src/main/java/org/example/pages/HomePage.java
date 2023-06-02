package org.example.pages;

import org.example.properties.ConfigurationManager;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHome() {
        String homePage = String.valueOf(ConfigurationManager.getProperties("baseUrl"));
        driver.navigate().to(homePage);
    }
}
