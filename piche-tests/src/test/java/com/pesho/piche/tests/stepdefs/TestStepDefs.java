package com.pesho.piche.tests.stepdefs;

import com.google.inject.Inject;
import com.pesho.piche.core.env.Environment;
import cucumber.api.java.en.Given;

/**
 * Created by Unit 1 on 02-Jul-17.
 */
public class TestStepDefs {

    Environment env;

    @Inject
    public TestStepDefs(final Environment env) {
        this.env = env;
    }

    @Given("^a test$")
    public void aTest() {
        System.out.printf("Pesho!\t" + env.getProperty("testString"));
    }
}
