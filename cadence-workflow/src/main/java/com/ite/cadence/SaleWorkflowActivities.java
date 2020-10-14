package com.ite.cadence;

import com.uber.cadence.activity.ActivityMethod;
import java.util.UUID;

public interface SaleWorkflowActivities {

  @ActivityMethod(scheduleToCloseTimeoutSeconds = 100)
  String verifyInventory(UUID saleId);

  @ActivityMethod(scheduleToCloseTimeoutSeconds = 100)
  String validatePayment(UUID saleId);

  @ActivityMethod(scheduleToCloseTimeoutSeconds = 100)
  String startShipmentProcess(UUID saleId);

  @ActivityMethod(scheduleToCloseTimeoutSeconds = 100)
  String notifyCustomer(UUID saleId, String message);
}
