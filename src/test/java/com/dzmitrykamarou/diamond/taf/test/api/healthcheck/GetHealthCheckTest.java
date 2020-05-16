package com.dzmitrykamarou.diamond.taf.test.api.healthcheck;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import com.dzmitrykamarou.diamond.taf.api.service.HealthCheckService;
import io.restassured.response.Response;
import java.util.HashMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(suiteName = "GET /healthcheck test suite", groups = {"smoke", "regression", "healthcheck"})
public class GetHealthCheckTest {

  private final HealthCheckService healthCheckService = new HealthCheckService();
  private final HashMap<String, String> healthy = new HashMap<>();
  private Response response;

  @BeforeClass(description = "Set healthy")
  public void setUp() {
    healthy.put("API", "UP");
    healthy.put("DB", "UP");
    response = healthCheckService.getHealthCheck();
  }

  @Test(description = "GET /healthcheck returns code 200", groups = "DIAM-1")
  public void getHealthCheckCodeTest() {
    assertThat("Status code should be 200", response.statusCode(), is(200));
  }

  @Test(description = "GET /healthcheck returns correct body", groups = "DIAM-1")
  public void getHealthCheckBodyTest() {
    assertThat("Body should contains valid data", response.body().as(HashMap.class)
        .entrySet(), equalTo(healthy.entrySet()));
  }
}
