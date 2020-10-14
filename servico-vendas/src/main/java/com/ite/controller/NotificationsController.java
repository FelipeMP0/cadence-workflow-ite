package com.ite.controller;

import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notifications")
class NotificationsController {

  @GetMapping()
  ResponseEntity<String> sendNotification(
      @RequestHeader final UUID saleId, @RequestHeader final String message) {
    return ResponseEntity.ok(
        "Notificação enviada sobre a venda = " + saleId + "\n mensagem = " + message);
  }
}
