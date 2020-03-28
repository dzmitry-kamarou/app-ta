package com.dzmitrykamarou.app.ta.test.api.accounts;

import com.dzmitrykamarou.app.ta.business.account.Account;
import com.dzmitrykamarou.app.ta.business.account.AccountFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetAccountTest {

  Account account = AccountFactory.existsAccount();

  @BeforeClass(description = "Set up")
  public void setUp() {
  }

  @Test(description = "Get account response code test")
  public void getAccountResponseCodeTest() {
  }
}
