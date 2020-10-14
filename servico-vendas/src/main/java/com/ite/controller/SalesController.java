package com.ite.controller;

import com.ite.cadence.SaleWorkflow;
import com.uber.cadence.client.WorkflowClient;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sales")
class SalesController {

  @GetMapping()
  ResponseEntity<String> createSale() {
    final UUID saleId = UUID.randomUUID();
    final WorkflowClient workflowClient = WorkflowClient.newInstance("samples-domain");
    final SaleWorkflow saleWorkflow = workflowClient.newWorkflowStub(SaleWorkflow.class);
    WorkflowClient.start(saleWorkflow::startWorkflow, saleId);
    return ResponseEntity.ok("Venda criada. Id = " + saleId);
  }
}
