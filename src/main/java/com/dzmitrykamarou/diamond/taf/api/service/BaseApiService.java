package com.dzmitrykamarou.diamond.taf.api.service;

import static com.dzmitrykamarou.diamond.taf.api.DiamondApiRequestSpecification.getRequestSpecification;
import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseApiService {

  protected static final Logger logger = LoggerFactory.getLogger(BaseApiService.class);

  protected RequestSpecification diamondSpecification() {
    return given().spec(getRequestSpecification());
  }
}
