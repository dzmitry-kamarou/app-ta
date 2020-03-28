package com.dzmitrykamarou.app.ta.config;

import com.dzmitrykamarou.app.ta.config.AppConfig.Decryptor;
import com.dzmitrykamarou.app.ta.util.CryptoUtil;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.DecryptorClass;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.crypto.AbstractDecryptor;

@Sources("classpath:${env}/app.properties")
@DecryptorClass(Decryptor.class)
public interface AppConfig extends Config {

  @Key("host")
  String host();

  @Key("port")
  int port();

  AppConfig config = ConfigFactory.create(AppConfig.class, System.getProperties(), System.getenv());

  final class Decryptor extends AbstractDecryptor {

    @Override
    public String decrypt(String value) {
      return CryptoUtil.decrypt(value);
    }
  }
}
