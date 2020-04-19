package com.dzmitrykamarou.diamond.taf.test.api.accounts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;

import com.dzmitrykamarou.diamond.taf.api.service.AccountsService;
import com.dzmitrykamarou.diamond.taf.business.account.Account;
import com.dzmitrykamarou.diamond.taf.business.account.AccountFactory;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(suiteName = "GET /accounts/{id} test suite", groups = {"api", "regression"})
public class GetAccountTest {

  private AccountsService accountsService = new AccountsService();
  private Account account = AccountFactory.randomAccount();

  @BeforeClass(description = "Create account")
  public void setUp() {
    account.setId(accountsService
        .postAccount(account)
        .body()
        .jsonPath()
        .getLong("id"));
  }

  @Test(description = "GET /accounts/{id} test")
  public void getAccountTest() {
    Response response = accountsService.getAccount(account.getId());
    Account received = response.body().as(Account.class);
    assertThat("Status code should be 200", response.statusCode(), is(200));
    assertThat("Body should contains valid data", received, samePropertyValuesAs(account));
  }

  @AfterClass(description = "Delete created account")
  public void tearDown() {
    accountsService.deleteAccount(account.getId());
  }
}
