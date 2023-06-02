package org.example.webdrivermanager;

import org.example.properties.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalWebDriver {
    private static final String PATH_TO_RESOURCES = "src/main/resources/";
    private static final String PATH_TO_CHROME = PATH_TO_RESOURCES + "chromedriver.exe";
    private static final String PATH_TO_FIREFOX = PATH_TO_RESOURCES + "geckodriver.exe";
    public static WebDriver getLocalBrowserDriver() {
        String browserName = String.valueOf(ConfigurationManager.getProperties("browserName"));
        return switch (browserName.toLowerCase()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME);
                yield new ChromeDriver();
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", PATH_TO_FIREFOX);
                yield new FirefoxDriver();
            }
            case "headless" ->{
                System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME);
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--headless", "--window-size=1920x1080");
                yield new ChromeDriver(option);
            }
            default -> throw new IllegalArgumentException(
                    String.format("Incorrect browser name was provided: '%s'", browserName));
        };

    }

}

