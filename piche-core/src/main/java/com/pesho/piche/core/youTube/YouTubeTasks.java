package com.pesho.piche.core.youTube;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pesho.piche.core.ui.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Unit 1 on 07-Jul-17.
 */
@Singleton
public class YouTubeTasks {

    WebDriver driver;
    final String YOUTUBEURL = "https://www.youtube.com/";

    @Inject
    public YouTubeTasks (final SeleniumDriver seleniumDriver) {
        this.driver = seleniumDriver.getFirefoxDriver();
    }

    public void openYouTubeHomePage() {
        driver.get(YOUTUBEURL);
    }

    public void search(final String searchQueue) {
        WebElement searchBar = driver.findElement(By.cssSelector("#masthead-search-term"));
        searchBar.sendKeys(searchQueue, Keys.RETURN);
    }

    public void closeBrowser() {
        driver.close();
    }

    public boolean isYouTubeHomePage() {
        if (driver.getCurrentUrl().equals(YOUTUBEURL)) {
            return true;
        }
        return false;
    }

    public void clickFirstYouTubeResult() {
        final List<WebElement> results
                = driver.findElements(By.cssSelector(".yt-uix-tile-link.yt-ui-ellipsis.yt-ui-ellipsis-2.yt-uix-sessionlink.spf-link"));
        results.get(0).click();
    }

    public boolean isVideoRunning() {
        if (driver.getCurrentUrl().contains("/watch")) {
            return true;
        }
        return false;
    }
}
