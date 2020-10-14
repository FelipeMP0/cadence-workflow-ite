package com.ite.controller;

import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
class LogisticsController {

  @GetMapping()
  ResponseEntity<String> startProcess(@RequestHeader final UUID saleId) {
    return ResponseEntity.ok("Processo de entrega iniciado para a venda = " + saleId);
  }
}
