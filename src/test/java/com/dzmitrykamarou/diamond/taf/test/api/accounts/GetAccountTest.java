package com.dzmitrykamarou.diamond.taf.test.api.accounts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;

import com.dzmitrykamarou.diamond.taf.api.service.AccountsService;
import com.dzmitrykamarou.diamond.taf.business.account.Account;
import com.dzmitrykamarou.diamond.taf.business.account.AccountFactory;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(suiteName = "GET /accounts/{id} test suite", groups = {"api", "regression", "accounts"})
public class GetAccountTest {

  private final AccountsService accountsService = new AccountsService();
  private final Account existAccount = AccountFactory.existAccount();
  private Response response;

  @BeforeClass(description = "Create account", alwaysRun = true)
  public void setUp() {
    response = accountsService.getAccount(existAccount.getId());
  }

  @Test(description = "GET /accounts/{id} returns code 200")
  public void getAccountCodeTest() {
    assertThat("Status code should be 200", response.statusCode(), is(200));
  }

  @Test(description = "GET /accounts/{id} returns exist account")
  public void getAccountBodyTest() {
    assertThat("Exist account should be returned", response.body().as(Account.class),
        allOf(notNullValue(), samePropertyValuesAs(existAccount, "updatedAt")));
  }
}
