package com.dzmitrykamarou.diamond.taf.business.account;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class AccountFactory {

  private static final int DEFAULT_LENGTH = 10;

  private AccountFactory() {
  }

  public static Account existsAccount() {
    Account account = new Account();
    account.setFirstName("Dzmitry");
    account.setLastName("Kamarou");
    return account;
  }

  public static Account randomAccount() {
    Account account = new Account();
    account.setFirstName(randomAlphabetic(DEFAULT_LENGTH));
    account.setLastName(randomAlphabetic(DEFAULT_LENGTH));
    return account;
  }
}
