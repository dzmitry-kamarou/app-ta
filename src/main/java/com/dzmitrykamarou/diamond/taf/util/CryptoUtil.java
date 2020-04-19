package com.dzmitrykamarou.diamond.taf.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CryptoUtil {

  private static final String PD = "mhzmdd2xko17";
  private static final String STRING_OUTPUT_TYPE = "base64";
  private static final String ALGORITHM = "PBEWITHMD5ANDDES";
  private static final StandardPBEStringEncryptor ENCRYPTOR = new StandardPBEStringEncryptor();
  private static final Pattern ENCRYPTED_PATTERN = Pattern.compile("^ENC\\((.+)\\)$");
  private static final Logger LOGGER = LoggerFactory.getLogger(CryptoUtil.class);
  private static boolean isInitialized = false;

  private static void init() {
    ENCRYPTOR.setAlgorithm(ALGORITHM);
    ENCRYPTOR.setPassword(PD);
    ENCRYPTOR.setStringOutputType(STRING_OUTPUT_TYPE);
    isInitialized = true;
  }

  public static void main(String[] args) {
    if (args == null || args.length != 1) {
      LOGGER.info("Please pass exactly one parameter - string that require encryption.");
      System.exit(1);
    }
    String encrypted = encrypt(args[0]);
    LOGGER.info("Encrypted string: {}", encrypted);
    String decrypted = decrypt(String.format("ENC(%s)", encrypted));
    LOGGER.info("Decrypted string: {}", decrypted);
    LOGGER.info("To add this encrypted value to .properties file use: ENC({})", encrypted);
  }

  private static String encrypt(String plain) {
    if (!isInitialized) {
      init();
    }
    return ENCRYPTOR.encrypt(plain);
  }

  public static String decrypt(String encrypted) {
    if (!isInitialized) {
      init();
    }
    Matcher matcher = ENCRYPTED_PATTERN.matcher(encrypted);
    if (matcher.matches()) {
      return ENCRYPTOR.decrypt(matcher.group(1));
    } else {
      throw new NotMatchedEncryptionPatternException();
    }
  }

  private static class NotMatchedEncryptionPatternException extends RuntimeException {

    NotMatchedEncryptionPatternException() {
      super("Encrypted string doesn't match the encryption pattern");
    }
  }
}
