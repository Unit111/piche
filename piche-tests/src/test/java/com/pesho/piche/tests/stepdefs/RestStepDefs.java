package com.pesho.piche.tests.stepdefs;

import com.google.inject.Inject;
import com.pesho.piche.core.rest.HttpBinTasks;
import cucumber.api.java.en.Given;
import org.junit.Assert;

/**
 * Created by Unit 1 on 02-Jul-17.
 */
public class RestStepDefs {

    HttpBinTasks httpBinTasks;

    @Inject
    public RestStepDefs(final HttpBinTasks httpBinTasks) {
        this.httpBinTasks = httpBinTasks;
    }


    @Given("^an user can make a GET request$")
    public void userCanMakeGetRequest() {
        final String responseString = httpBinTasks.getMethodResponse().readEntity(String.class);
        Assert.assertTrue("Response does not contain the expected URL", responseString.contains("http://httpbin.org/get"));
    }

    @Given("^an user can make a POST request$")
    public void userCanMakePostRequest() {
    }

    @Given("^an user can make a PUT request$")
    public void userCanMakePutRequest() {
    }

    @Given("^an user can make a DELETE request$")
    public void userCanMakeDeleteRequest() {
    }
}
