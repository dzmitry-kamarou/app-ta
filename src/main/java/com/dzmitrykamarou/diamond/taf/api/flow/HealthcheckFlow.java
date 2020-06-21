package com.dzmitrykamarou.diamond.taf.api.flow;

import com.dzmitrykamarou.diamond.taf.api.service.HealthcheckService;
import java.util.HashMap;

public interface HealthcheckFlow {

  HealthcheckService healthcheckService = new HealthcheckService();

  static String dbStatus() {
    return (String) healthcheckService
        .getHealthCheck()
        .body()
        .as(HashMap.class)
        .get("DB");
  }

  static String apiStatus() {
    return (String) healthcheckService
        .getHealthCheck()
        .body()
        .as(HashMap.class)
        .get("API");
  }
}
