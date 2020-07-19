package com.dzmitrykamarou.diamond.taf.api;

import static java.util.Arrays.asList;

import com.dzmitrykamarou.diamond.taf.api.filter.CustomCookieFilter;
import com.dzmitrykamarou.diamond.taf.api.filter.CustomFilter;
import com.dzmitrykamarou.diamond.taf.config.DiamondConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class DiamondApiRequestSpecification {

  private static final ThreadLocal<RequestSpecification> THREAD_LOCAL_INSTANCE = new ThreadLocal<>();
  private static final DiamondConfig DIAMOND_CONFIG = DiamondConfig.config;
  private static final String URI = DIAMOND_CONFIG.uri();
  private static final String API_ENDPOINT = "/api";
  private static final String API_VERSION = "/v1";

  public static synchronized RequestSpecification getRequestSpecification() {
    if (THREAD_LOCAL_INSTANCE.get() == null) {
      THREAD_LOCAL_INSTANCE.set(new RequestSpecBuilder()
          .setBaseUri(URI + API_ENDPOINT + API_VERSION)
          .addFilters(asList(new CustomCookieFilter(), new CustomFilter()))
          .setContentType(ContentType.JSON)
          .setUrlEncodingEnabled(false)
          .build());
    }
    return THREAD_LOCAL_INSTANCE.get();
  }
}
