package com.dzmitrykamarou.diamond.taf.api.action;

import java.util.HashMap;

public interface HealthcheckAction {

  String dbStatus();

  String apiStatus();

  HashMap<String, String> allStatuses();
}
