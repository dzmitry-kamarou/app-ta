package com.dzmitrykamarou.diamond.taf.business;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.ConfigFactory;

@Sources("classpath:${env}/business.properties")
public interface BusinessConfig extends Config {

  @Key("exist.account.id")
  Long existAccountId();

  @Key("exist.account.username")
  String existAccountUsername();

  @Key("exist.account.firstname")
  String existAccountFirstName();

  @Key("exist.account.lastname")
  String existAccountLastName();

  @Key("exist.account.createdAt")
  String existAccountCreatedAt();

  BusinessConfig config = ConfigFactory
      .create(BusinessConfig.class, System.getProperties(), System.getenv());
}
