package com.dzmitrykamarou.diamond.taf.test.api.accounts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;

import com.dzmitrykamarou.diamond.taf.api.service.AccountsService;
import com.dzmitrykamarou.diamond.taf.business.account.Account;
import com.dzmitrykamarou.diamond.taf.business.account.AccountFactory;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@Test(suiteName = "POST /accounts test suite", groups = {"api", "regression"})
public class PostAccountTest {

  private AccountsService accountsService = new AccountsService();
  private Account account = AccountFactory.randomAccount();

  @Test(description = "POST /accounts test")
  public void postValidAccountTest() {
    Response response = accountsService.postAccount(account);
    account.setId(response.body().jsonPath().getLong("id"));
    Account created = response.body().as(Account.class);
    assertThat("Status code should be 200", response.statusCode(), is(200));
    assertThat("Body should contains valid data", created, samePropertyValuesAs(account));
  }

  @AfterClass(description = "Delete created account")
  public void tearDown() {
    accountsService.deleteAccount(account.getId());
  }
}
