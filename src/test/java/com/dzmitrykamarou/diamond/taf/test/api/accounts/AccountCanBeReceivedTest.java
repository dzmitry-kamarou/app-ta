package com.dzmitrykamarou.diamond.taf.test.api.accounts;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;

import com.dzmitrykamarou.diamond.taf.api.service.AccountsService;
import com.dzmitrykamarou.diamond.taf.business.account.Account;
import com.dzmitrykamarou.diamond.taf.business.account.AccountFactory;
import org.testng.annotations.Test;

@Test(groups = {"smoke", "regression", "api"})
public class AccountCanBeReceivedTest {

  private final Account existsAccount = AccountFactory.existAccount();
  private final AccountsService accountsService = new AccountsService();

  @Test()
  public void accountCanBeReceivedTest() {
    Account actualAccount = accountsService.getAccount(existsAccount.getId()).as(Account.class);
    assertThat(actualAccount, samePropertyValuesAs(existsAccount, "updatedAt"));
  }
}
