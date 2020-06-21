package com.dzmitrykamarou.diamond.taf.api.service;

import io.restassured.response.Response;

public class HealthcheckService extends BaseApiService {

  private static final String HEALTH_CHECK_ENDPOINT = "/healthcheck";

  public Response getHealthCheck() {
    logger.info("RETRIEVE HEALTH CHECK");
    return diamondSpecification()
        .basePath(HEALTH_CHECK_ENDPOINT)
        .when()
        .get();
  }
}
