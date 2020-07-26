package com.dzmitrykamarou.diamond.taf.api.flow;

import com.dzmitrykamarou.diamond.taf.api.action.HealthcheckAction;
import com.dzmitrykamarou.diamond.taf.api.service.HealthcheckService;
import io.restassured.response.Response;
import java.util.HashMap;

public class HealthcheckFlow implements HealthcheckAction {

  private static final String DB = "DB";
  private static final String API = "API";
  private final HealthcheckService healthcheckService = new HealthcheckService();

  public String dbStatus() {
    return allStatuses().get(DB);
  }

  public String apiStatus() {
    return allStatuses().get(API);
  }

  public HashMap<String, String> allStatuses() {
    HashMap<String, String> statuses = new HashMap<>();
    Response response = healthcheckService.getHealthCheck();
    statuses.put(API, response.path(API));
    statuses.put(DB, response.path(DB));
    return statuses;
  }
}
