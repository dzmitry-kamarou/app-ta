package com.dzmitrykamarou.diamond.taf.test.api.healthcheck;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.dzmitrykamarou.diamond.taf.api.flow.HealthcheckFlow;
import org.testng.annotations.Test;

@Test(suiteName = "Healthcheck suite", groups = {"smoke", "regression", "healthcheck"})
public class HealthcheckCanBeReceivedTest {

  String upStatus = "UP";

  @Test(description = "BD status test")
  public void dbStatusTest() {
    assertThat("DB status should be UP", HealthcheckFlow.dbStatus(), equalTo(upStatus));
  }

  @Test(description = "API status test")
  public void apiStatusTest() {
    assertThat("API status should be UP", HealthcheckFlow.apiStatus(), equalTo(upStatus));
  }
}
