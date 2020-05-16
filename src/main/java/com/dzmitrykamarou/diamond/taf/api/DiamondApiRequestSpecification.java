package com.dzmitrykamarou.diamond.taf.api;

import static java.util.Arrays.asList;

import com.dzmitrykamarou.diamond.taf.api.filter.CustomCookieFilter;
import com.dzmitrykamarou.diamond.taf.api.filter.CustomFilter;
import com.dzmitrykamarou.diamond.taf.config.DiamondConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class DiamondApiRequestSpecification {

  private static final String BASE_URI = DiamondConfig.config.uri();
  private static final ThreadLocal<RequestSpecification> THREAD_LOCAL_INSTANCE = new ThreadLocal<>();

  public static synchronized RequestSpecification getRequestSpecification() {
    if (THREAD_LOCAL_INSTANCE.get() == null) {
      THREAD_LOCAL_INSTANCE.set(new RequestSpecBuilder()
          .setBaseUri(BASE_URI)
          .addFilters(asList(new CustomCookieFilter(), new CustomFilter()))
          .setContentType(ContentType.JSON)
          .setUrlEncodingEnabled(false)
          .build());
    }
    return THREAD_LOCAL_INSTANCE.get();
  }
}
