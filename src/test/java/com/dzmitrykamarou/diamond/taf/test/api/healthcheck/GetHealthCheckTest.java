package com.dzmitrykamarou.diamond.taf.test.api.healthcheck;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import com.dzmitrykamarou.diamond.taf.api.service.HealthCheckService;
import io.restassured.response.Response;
import java.util.HashMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(suiteName = "GET /healthcheck test suite", groups = {"api", "regression", "smoke"})
public class GetHealthCheckTest {

  private HealthCheckService healthCheckService = new HealthCheckService();
  private HashMap<String, String> healthy = new HashMap<>();

  @BeforeClass(description = "Set healthy")
  public void setUp() {
    healthy.put("API", "UP");
    healthy.put("DB", "UP");
  }

  @Test(description = "GET /healthcheck test")
  public void getHealthCheckTest() {
    Response response = healthCheckService.getHealthCheck();
    HashMap<String, String> received = response.body().as(HashMap.class);
    assertThat("Status code should be 200", response.statusCode(), is(200));
    assertThat("Body should contains valid data", received.entrySet(), equalTo(healthy.entrySet()));
  }
}
