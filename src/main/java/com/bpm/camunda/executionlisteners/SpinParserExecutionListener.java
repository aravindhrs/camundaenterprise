package com.bpm.camunda.executionlisteners;

import static org.camunda.spin.Spin.JSON;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.spin.plugin.variable.value.JsonValue;
import org.springframework.stereotype.Component;

import com.bpm.camunda.dto.TenantActivationStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SpinParserExecutionListener implements ExecutionListener {

  @Override
  public void notify(DelegateExecution execution) throws Exception {

    JsonValue jsonValue = execution.getVariableTyped("tenantActivationStatus");

    log.info("value:{}", jsonValue.getValueSerialized());

    TenantActivationStatus tenantActivationStatus = JSON(jsonValue.getValueSerialized())
        .mapTo(TenantActivationStatus.class);

    log.info("tenantActivationStatus:{}", tenantActivationStatus.getActivationStatus());

    execution.setVariable("tenantActivationStatus", tenantActivationStatus);

  }

}
