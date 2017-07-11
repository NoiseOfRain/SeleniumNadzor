package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static Selenium.Sampler.driver;
import static org.junit.Assert.fail;

/**
 * Created by noise on 30.05.17.
 */
public class waitForTimeout {

    By firstThing;
    By secondThing;

    waitForTimeout() throws Exception {

        for (int second = 0; ; second++) {
            if (second >= 60) {
                screenShot.screen("fallScreen");
                fail("timeout to find: " + variablesNadzor.progressTime);
            }
            try {
                if (!driver.findElement(variablesNadzor.progressTime).isDisplayed()) break;
            } catch (Exception e) {}
            Thread.sleep(1000);
        }
    }

    waitForTimeout(By firstThing) throws Exception {
        this.firstThing = firstThing;

        for (int second = 0; ; second++) {
            if (second >= 60) {
                screenShot.screen("fallScreen");
                fail("timeout to find: " + variablesNadzor.progressTime + " + " + firstThing);
            }
            try {
                if (!driver.findElement(variablesNadzor.progressTime).isDisplayed()
                        && driver.findElement(firstThing).isEnabled()) break;
            } catch (Exception e) {}
            System.out.println(second);
            Thread.sleep(1000);
        }
    }

    waitForTimeout(By firstThing, By secondThing) throws Exception {
        this.firstThing = firstThing;
        this.secondThing = secondThing;

        for (int second = 0; ; second++) {
            if (second >= 60) {
                screenShot.screen("fallScreen");
                fail("timeout to find: " + variablesNadzor.progressTime +
                        " + " + firstThing + " + " + " " + secondThing);
            }
            try {
                if (!driver.findElement(variablesNadzor.progressTime).isDisplayed()
                        && driver.findElement(firstThing).isEnabled()
                        && driver.findElement(secondThing).isDisplayed()) break;
            } catch (Exception e) {}
            Thread.sleep(1000);
        }
    }

    public static boolean isElementPresent(By by) throws InterruptedException{
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

