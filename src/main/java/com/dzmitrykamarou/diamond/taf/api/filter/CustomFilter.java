package com.dzmitrykamarou.diamond.taf.api.filter;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomFilter implements Filter {

  private static final String REQUEST_PATTERN = "[REQUEST]\n{} {}\nHeaders:\n{}\nBody: '{}'";
  private static final String RESPONSE_PATTERN = "[RESPONSE]\n{}\nBody: '{}'";
  private static final int INDENTATION_VALUE = 4;

  private static final Logger logger = LoggerFactory.getLogger(CustomFilter.class);

  @Override
  public Response filter(FilterableRequestSpecification requestSpec,
      FilterableResponseSpecification responseSpec, FilterContext ctx) {
    String body = requestSpec.getBody();
    String bodyString = body == null ? "" : new JSONObject(body).toString(INDENTATION_VALUE);
    logger.debug(REQUEST_PATTERN,
        requestSpec.getMethod(),
        requestSpec.getURI(),
        requestSpec.getHeaders(),
        bodyString);
    Response response = ctx.next(requestSpec, responseSpec);
    bodyString = response.getBody() == null ? "" : response.getBody().prettyPrint();
    logger.debug(RESPONSE_PATTERN, response.getStatusCode(), bodyString);
    return response;
  }
}
