package com.ite.cadence;

import com.uber.cadence.worker.Worker;

public class Main {

  public static void main(String[] args) {
    Worker.Factory factory = new Worker.Factory("samples-domain");
    Worker worker = factory.newWorker("sale");
    worker.registerWorkflowImplementationTypes(SaleWorkflowImpl.class);
    factory.start();
  }
}
