package com.dzmitrykamarou.app.ta.test.api.accounts;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import com.dzmitrykamarou.app.ta.business.account.Account;
import com.dzmitrykamarou.app.ta.business.account.AccountFactory;
import com.dzmitrykamarou.app.ta.config.AppConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PostAccountTest {

  private Response response;
  private Account account;

  @BeforeClass(description = "Set up")
  public void setUp() {
    response = given()
        .baseUri(AppConfig.config.host())
        .port(AppConfig.config.port())
        .basePath("/accounts")
        .contentType(ContentType.JSON)
        .body(account = AccountFactory.randomAccount())
        .when()
        .post();
  }

  @Test(description = "Response code test")
  public void responseCodeTest() {
    response.then()
        .statusCode(200);
  }

  @Test(description = "Response body test")
  public void responseBodyTest() {
    response.then()
        .body("firstName", equalTo(account.getFirstName()))
        .body("lastName", equalTo(account.getLastName()))
        .body("id", greaterThan(0));
  }

  @AfterClass
  public void tearDown() {
    given()
        .baseUri(AppConfig.config.host())
        .port(AppConfig.config.port())
        .basePath("/accounts/")
        .pathParam("id", response
            .body()
            .jsonPath()
            .get("id"))
        .when()
        .delete("/{id}");
  }
}
