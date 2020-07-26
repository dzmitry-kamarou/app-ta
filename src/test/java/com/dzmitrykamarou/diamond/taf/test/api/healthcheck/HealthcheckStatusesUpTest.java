package com.dzmitrykamarou.diamond.taf.test.api.healthcheck;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasEntry;

import com.dzmitrykamarou.diamond.taf.api.service.HealthcheckService;
import java.util.HashMap;
import org.testng.annotations.Test;

@Test(suiteName = "Healthcheck suite", groups = {"smoke", "regression", "healthcheck"})
public class HealthcheckStatusesUpTest {

  private final HealthcheckService healthcheckService = new HealthcheckService();
  String status = "UP";

  @Test(description = "Healthcheck statuses test")
  public void healthcheckStatusesUpTest() {
    HashMap<String, String> statuses = healthcheckService.getHealthCheck().as(HashMap.class);
    assertThat("DB status should be UP", statuses,
        allOf(hasEntry("API", status), hasEntry("DB", status)));
  }
}
