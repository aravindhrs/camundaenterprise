package com.bpm.camunda.tasklisteners;

import java.util.ArrayList;
import java.util.Arrays;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

import com.bpm.camunda.dto.TenantActivationStatus;
import com.bpm.camunda.dto.TenantActivationStatus.ACTIVATION_STATUS;

@Component
public class TenantActivationListener implements TaskListener {

  @Override
  public void notify(DelegateTask delegateTask) {

    String tenantActivationStatus = ACTIVATION_STATUS.IN_PROGESS.getActivationStatus();

    if (delegateTask.getTaskDefinitionKey().equals("approveTenantActivation")) {
      tenantActivationStatus = ACTIVATION_STATUS.ACTIVATED.getActivationStatus();
    }

    TenantActivationStatus tenantActivationStatusValue = TenantActivationStatus.builder()
        .servicesList(Arrays.asList("Inventory service", "Order Management service", "Payments Service"))
        .activationStatus(tenantActivationStatus).compensatedActivites(new ArrayList<>())
        .tenantId(delegateTask.getVariable("tenant").toString()).build();

    delegateTask.setVariable("tenantActivationStatus", tenantActivationStatusValue);
  }

}
