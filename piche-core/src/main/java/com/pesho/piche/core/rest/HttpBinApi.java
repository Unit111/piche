package com.pesho.piche.core.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by Unit 1 on 02-Jul-17.
 */
public interface HttpBinApi {

    @GET
    @Path("/get")
    @Consumes("application/x-www-form-urlencoded")
    Response getMethod();
}
