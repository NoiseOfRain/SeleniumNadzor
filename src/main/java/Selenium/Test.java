package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Created by noise on 19.06.17.
 */
public class Test {

    @org.testng.annotations.Test
    public void LocalBrowser() {
        WebDriver driver;// = new RemoteWebDriver(DesiredCapabilities.firefox());
        System.setProperty(variablesNadzor.browserFirefox, variablesNadzor.geckodriver);
        FirefoxProfile profile = new FirefoxProfile(variablesNadzor.profile);
        driver = new FirefoxDriver(profile);
        driver.get("http://ya.ru");
        driver.quit();

    }
}
