package com.dzmitrykamarou.diamond.taf.business.account;

import static com.dzmitrykamarou.diamond.taf.util.TimeUtil.stringToCalendar;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import com.dzmitrykamarou.diamond.taf.business.BusinessConfig;

public class AccountFactory {

  private static final BusinessConfig BUSINESS_CONFIG = BusinessConfig.config;
  private static final int DEFAULT_LENGTH = 10;

  private AccountFactory() {
  }

  public static Account existAccount() {
    Account account = new Account();
    account.setId(BUSINESS_CONFIG.existAccountId());
    account.setUserName(BUSINESS_CONFIG.existAccountUsername());
    account.setFirstName(BUSINESS_CONFIG.existAccountFirstName());
    account.setLastName(BUSINESS_CONFIG.existAccountLastName());
    account.setCreatedAt(stringToCalendar(BUSINESS_CONFIG.existAccountCreatedAt()));
    return account;
  }

  public static Account randomAccount() {
    Account account = new Account();
    account.setFirstName(randomAlphabetic(DEFAULT_LENGTH));
    account.setLastName(randomAlphabetic(DEFAULT_LENGTH));
    return account;
  }
}
