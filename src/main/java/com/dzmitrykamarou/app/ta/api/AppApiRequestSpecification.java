package com.dzmitrykamarou.app.ta.api;

import static java.util.Arrays.asList;

import com.dzmitrykamarou.app.ta.api.filter.CustomCookieFilter;
import com.dzmitrykamarou.app.ta.api.filter.CustomFilter;
import com.dzmitrykamarou.app.ta.config.AppConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class AppApiRequestSpecification {

  private static final String BASE_URI = AppConfig.config.host();
  private static final int PORT = AppConfig.config.port();
  private static final ThreadLocal<RequestSpecification> THREAD_LOCAL_INSTANCE = new ThreadLocal<>();

  public static synchronized RequestSpecification getRequestSpecification() {
    if (THREAD_LOCAL_INSTANCE.get() == null) {
      THREAD_LOCAL_INSTANCE.set(new RequestSpecBuilder()
          .setBaseUri(BASE_URI)
          .setPort(PORT)
          .addFilters(asList(new CustomCookieFilter(), new CustomFilter()))
          .setContentType(ContentType.JSON)
          .setUrlEncodingEnabled(false)
          .build());
    }
    return THREAD_LOCAL_INSTANCE.get();
  }
}
