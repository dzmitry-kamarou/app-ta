package com.dzmitrykamarou.app.ta.api.service;

import static com.dzmitrykamarou.app.ta.api.AppApiRequestSpecification.getRequestSpecification;
import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseApiService {

  protected static final Logger logger = LoggerFactory.getLogger(BaseApiService.class);

  protected RequestSpecification appSpecification() {
    return given().spec(getRequestSpecification());
  }
}
