package Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;

import static Selenium.Sampler.driver;
import static Selenium.variablesNadzor.screenshotsWay;


/**
 * Created by noise on 15.06.17.
 */
public class screenShot {

    @Test
    public static void screen(String method) throws Exception {
//создание скриншота
        File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen, new File(screenshotsWay +
                method + ".png"));
    }
}
