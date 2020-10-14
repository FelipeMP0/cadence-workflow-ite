package com.ite.cadence;

import com.uber.cadence.workflow.WorkflowMethod;
import java.util.UUID;

public interface SaleWorkflow {

  @WorkflowMethod(executionStartToCloseTimeoutSeconds = 300)
  String startWorkflow(UUID saleId);
}
