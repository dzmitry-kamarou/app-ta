package com.dzmitrykamarou.app.ta.api.service;

import static io.restassured.http.ContentType.JSON;

import com.dzmitrykamarou.app.ta.business.account.Account;
import io.restassured.response.Response;

public class AccountsService extends BaseApiService {

  private static final String ACCOUNTS_ENDPOINT = "/accounts";

  public Response getAccount(long id) {
    logger.info("RETRIEVE ACCOUNT");
    return appSpecification()
        .basePath(ACCOUNTS_ENDPOINT)
        .pathParam("id", id)
        .when()
        .get("/{id}");
  }

  public Response getAccounts() {
    logger.info("RETRIEVE ACCOUNTS");
    return appSpecification()
        .basePath(ACCOUNTS_ENDPOINT)
        .when()
        .get();
  }

  public Response deleteAccount(long id) {
    logger.info("REMOVE ACCOUNT");
    return appSpecification()
        .basePath(ACCOUNTS_ENDPOINT)
        .pathParam("id", id)
        .when()
        .delete("/{id}");
  }

  public Response postAccount(Account account) {
    logger.info("CREATE ACCOUNT");
    return appSpecification()
        .basePath(ACCOUNTS_ENDPOINT)
        .contentType(JSON)
        .body(account)
        .when()
        .post();
  }
}
