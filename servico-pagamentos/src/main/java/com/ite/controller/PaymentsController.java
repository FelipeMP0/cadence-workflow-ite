package com.ite.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payments")
class PaymentsController {

    @GetMapping()
    ResponseEntity<String> validatePayment() {
        return ResponseEntity.ok("Pagamentos validados");
    }
}
