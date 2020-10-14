package com.ite.controller;

import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
class InventoryController {

  @GetMapping
  ResponseEntity<String> validateInventory(@RequestHeader final UUID saleId) {
    return ResponseEntity.ok("Estoque verificado para a venda = " + saleId);
  }
}
