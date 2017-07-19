package Selenium.chooseBrowser;

import Selenium.logging.screenShot;
import Selenium.variablesNadzor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by noise on 12.07.17.
 */
public abstract class testingBrowser {

    public static WebDriver driver;

    public static String driverForBrowser;
    public static String wayToDriverForBrowser;
    public static File profileForBrowser;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {

//драйвер для firefox
        driverForBrowser = "webdriver.gecko.driver";
//путь к драйверу firefox
        wayToDriverForBrowser =  "/home/noise/geckodriver";
//путь до профиля firefox
        profileForBrowser = new File("/home/noise/.mozilla/firefox/l6itpyq2.SeleniumTestNadzor");
//указываю где лежит драйвер для браузера9736491
        
        System.setProperty(driverForBrowser, wayToDriverForBrowser);
//указываю путь к профилю с настройками браузера
        FirefoxProfile profile = new FirefoxProfile(profileForBrowser);
//запуск браузера
        driver = new FirefoxDriver(profile);
//развернуть во весь экран
        driver.manage().window().maximize();
//устанавливаю время ожидания для окон
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//уточнить
//переход на нужную ссылку
        driver.get(variablesNadzor.URL);




        /*
        * Необходимо отключить скачивание адднонов
        * addons.productaddons
        */
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

    int nomerPhoto = 0;

    @AfterMethod(alwaysRun = true)
    public void getScreen() throws Exception {
//
//        screenShot.screen(new Exception().getStackTrace()[0].getMethodName());
        nomerPhoto++;

        screenShot.screen(nomerPhoto + ") screenshot");

    }

}
