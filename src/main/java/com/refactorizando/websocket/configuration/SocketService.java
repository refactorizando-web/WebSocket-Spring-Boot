package com.refactorizando.websocket.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class SocketService {

  private Map<String, String> nameSession = new HashMap<>();

  public String getNameBySession(String session) {
    return nameSession.get(session);
  }

  public void saveSession(String sessionId, String name) {
    nameSession.put(sessionId, name);
  }

  public void removeSession(String sessionId) {
    nameSession.remove(sessionId);
  }

}
