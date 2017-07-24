package com.pesho.piche.testhooks;

import com.google.inject.Inject;
import com.pesho.piche.core.youTube.YouTubeTasks;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.java.guice.ScenarioScoped;

/**
 * Created by Unit 1 on 07-Jul-17.
 */
@ScenarioScoped
public class UiHooks {

    YouTubeTasks youTubeTasks;

    @Inject
    public  UiHooks(final YouTubeTasks youTubeTasks) {
        this.youTubeTasks = youTubeTasks;
    }

    @Before(value = "@YouTube")
    public void onYouTubeHomePage() {
        youTubeTasks.openYouTubeHomePage();
    }

    @After(value = "@YouTube")
    public void closeBrowser() {
        youTubeTasks.closeBrowser();
    }
}
