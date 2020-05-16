package com.dzmitrykamarou.diamond.taf.config;

import com.dzmitrykamarou.diamond.taf.config.DiamondConfig.Decryptor;
import com.dzmitrykamarou.diamond.taf.util.CryptoUtil;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.DecryptorClass;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.crypto.AbstractDecryptor;

@Sources("classpath:${env}/diamond.properties")
@DecryptorClass(Decryptor.class)
public interface DiamondConfig extends Config {

  @Key("host")
  String host();

  @Key("port")
  int port();

  DiamondConfig config = ConfigFactory
      .create(DiamondConfig.class, System.getProperties(), System.getenv());

  final class Decryptor extends AbstractDecryptor {

    @Override
    public String decrypt(String value) {
      return CryptoUtil.decrypt(value);
    }
  }
}
