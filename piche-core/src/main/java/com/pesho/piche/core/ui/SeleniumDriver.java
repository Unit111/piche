package com.pesho.piche.core.ui;

import com.google.inject.Inject;
import com.pesho.piche.core.exceptions.TestException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/**
 * Created by Unit 1 on 07-Jul-17.
 */
public class SeleniumDriver {

    @Inject
    public SeleniumDriver() {}

    public WebDriver getFirefoxDriver() {
        final DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        setGeckoDriver();
        FirefoxOptions options = new FirefoxOptions();
        options.setLogLevel(Level.OFF);
        final WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    private void setGeckoDriver() {
        String pathToDriver = null;

        final String osName = System.getProperty("os.name").toLowerCase();

        //TODO Add Linux and the expensive one later.
        if (osName.toLowerCase().contains("windows")) {
            pathToDriver = System.getProperty("user.dir") + "/../piche-core/binaries/geckodriver.exe";
        }
        if (pathToDriver == null) {
            throw new TestException("Gecko driver not found for OS: " + osName);
        }
        final File file = new File(pathToDriver);
        System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
    }
}
