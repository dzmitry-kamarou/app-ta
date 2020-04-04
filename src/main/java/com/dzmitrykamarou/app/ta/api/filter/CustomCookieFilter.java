package com.dzmitrykamarou.app.ta.api.filter;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import java.util.HashMap;
import java.util.Map;

public class CustomCookieFilter implements Filter {

  private Map<String, String> cookies = new HashMap<>();

  @Override
  public Response filter(FilterableRequestSpecification requestSpec,
      FilterableResponseSpecification responseSpec, FilterContext ctx) {
    for (Map.Entry<String, String> cookie : cookies.entrySet()) {
      requestSpec.cookie(cookie.getKey(), cookie.getValue());
    }
    final Response response = ctx.next(requestSpec, responseSpec);
    cookies.putAll(response.getCookies());
    return response;
  }
}
