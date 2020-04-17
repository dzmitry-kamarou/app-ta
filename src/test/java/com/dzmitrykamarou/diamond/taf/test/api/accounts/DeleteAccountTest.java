package com.dzmitrykamarou.diamond.taf.test.api.accounts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.dzmitrykamarou.diamond.taf.api.service.AccountsService;
import com.dzmitrykamarou.diamond.taf.business.account.Account;
import com.dzmitrykamarou.diamond.taf.business.account.AccountFactory;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(suiteName = "DELETE /accounts/{id} test suite", groups = {"api", "regression"})
public class DeleteAccountTest {

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

  @Test(description = "DELETE /accounts/{id} test")
  public void deleteAccountTest() {
    Response response = accountsService.deleteAccount(account.getId());
    String received = response.body().jsonPath().get("message");
    assertThat("Status code should be 200", response.statusCode(), is(200));
    assertThat("Body should contains valid message", received, is("Success"));
  }
}
