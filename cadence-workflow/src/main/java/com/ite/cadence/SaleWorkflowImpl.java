package com.ite.cadence;

import com.uber.cadence.workflow.Workflow;
import java.util.UUID;
import org.slf4j.Logger;

public class SaleWorkflowImpl implements SaleWorkflow {

  private static final Logger LOGGER = Workflow.getLogger(SaleWorkflowImpl.class);

  private final SaleWorkflowActivities activities =
      Workflow.newActivityStub(SaleWorkflowActivities.class);

  @Override
  public String startWorkflow(final UUID saleId) {
    LOGGER.info("Workflow iniciado para venda = {}", saleId);

    this.activities.verifyInventory(saleId);
    LOGGER.info("Estoque verificado");

    this.activities.validatePayment(saleId);
    LOGGER.info("Pagamentos validados");

    this.activities.notifyCustomer(saleId, "Pagamentos validados");
    LOGGER.info("Notificação sobre pagamentos enviada");

    this.activities.startShipmentProcess(saleId);
    LOGGER.info("Processo de entrega iniciado");

    this.activities.notifyCustomer(saleId, "Processo de entrega iniciado");
    LOGGER.info("Notificação sobre processo de entrega enviada");

    return "Venda " + saleId + "finalizada";
  }
}
