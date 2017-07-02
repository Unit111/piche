package com.pesho.piche.core.rest;

import com.google.inject.Inject;
import com.pesho.piche.core.env.Environment;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.core.Response;

/**
 * Created by Unit 1 on 02-Jul-17.
 */
public class HttpBinTasks {

    Environment env;
    HttpBinApi httpBinApi;

    @Inject
    public HttpBinTasks(final Environment env) {
        this.env = env;
        this.httpBinApi = getTarget().proxy(HttpBinApi.class);
    }

    public Response getMethodResponse() {
        return httpBinApi.getMethod();
    }

    private ResteasyWebTarget getTarget() {
        final ResteasyClient client = new ResteasyClientBuilder().build();
        return client.target(env.getProperty("apiUrl"));
    }
}
