package com.ite.cadence;

import com.uber.cadence.workflow.WorkflowMethod;

public interface SaleWorkflow {

  @WorkflowMethod(executionStartToCloseTimeoutSeconds = 300)
  String startWorkflow();
}
