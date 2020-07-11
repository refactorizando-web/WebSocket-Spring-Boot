package com.refactorizando.websocket.controller;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.refactorizando.websocket.dto.MessageDto;

@Controller
public class ChatController {

  @MessageMapping("/chat")
  @SendTo("/topic/messages")
  public MessageDto sendMessage(MessageDto message, @Header("simpSessionId") String sessionId) {

    return new MessageDto("Message with text : " + message.getText()
        + " received ", " from " + message.getName());
  }

}
