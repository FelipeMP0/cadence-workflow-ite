package com.ite.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
class LogisticsController {

    @GetMapping()
    ResponseEntity<String> startProcess() {
        return ResponseEntity.ok("Processo de entrega iniciado");
    }
}
