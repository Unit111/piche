package com.pesho.piche.tests.stepdefs;

import com.google.inject.Inject;
import com.pesho.piche.core.youTube.YouTubeTasks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by Unit 1 on 07-Jul-17.
 */
public class SeleniumStepDefs {

    private YouTubeTasks youTubeTasks;

    @Inject
    public  SeleniumStepDefs(final YouTubeTasks youTubeTasks) {
        this.youTubeTasks = youTubeTasks;
    }

    @Given("^a user opens Youtube$")
    public void userOpensYouTube() {
        Assert.assertTrue("Not on YouTube home page.", youTubeTasks.isYouTubeHomePage());
    }

    @When("^the user searches for \"([^\"]*)\"$")
    public void userSearchesForAVideo(final String searchQueue) {
//        System.out.printf("Pe6o 2");
        youTubeTasks.search(searchQueue);
    }

    @Then("^the user can open the first result$")
    public void userOpensFirstResult() {
        youTubeTasks.clickFirstYouTubeResult();
    }

    @Then("^the video is ran$")
    public void videoIsRan() {
        Assert.assertTrue("There is no video playing", youTubeTasks.isVideoRunning());
    }
}
