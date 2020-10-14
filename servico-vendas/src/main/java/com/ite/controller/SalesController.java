package com.ite.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sales")
class SalesController {

    @GetMapping()
    ResponseEntity<String> createSale() {
        return ResponseEntity.ok("Venda criada");
    }
}
