package com.refactorizando.websocket.controller;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.refactorizando.websocket.dto.MessageDto;
import com.refactorizando.websocket.service.SocketService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatController {

  private final SocketService socketService;

  @MessageMapping("/chat")
  @SendTo("/topic/messages")
  public MessageDto sendMessage(MessageDto message, @Header("simpSessionId") String sessionId) {

    socketService.saveSession(sessionId, message.getName());

    return new MessageDto("Message with text : " + message.getText()
        + " received ", " from " + message.getName());
  }

}
