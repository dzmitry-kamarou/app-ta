package com.dzmitrykamarou.diamond.taf.test.api.healthcheck;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasEntry;

import com.dzmitrykamarou.diamond.taf.api.flow.HealthcheckFlow;
import java.util.HashMap;
import org.testng.annotations.Test;

@Test(suiteName = "Healthcheck suite", groups = {"smoke", "regression", "healthcheck"})
public class HealthcheckStatusesUpTest {

  private static final String EXPECTED_STATUS = "UP";
  private final HealthcheckFlow healthcheckFlow = new HealthcheckFlow();

  @Test(description = "Healthcheck statuses test")
  public void healthcheckStatusesUpTest() {
    HashMap<String, String> statuses = healthcheckFlow.allStatuses();
    assertThat("DB and API statuses should be UP", statuses,
        allOf(hasEntry("API", EXPECTED_STATUS), hasEntry("DB", EXPECTED_STATUS)));
  }
}
