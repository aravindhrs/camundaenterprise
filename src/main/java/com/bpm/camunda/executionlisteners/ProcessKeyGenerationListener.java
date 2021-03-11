package com.bpm.camunda.executionlisteners;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.impl.persistence.StrongUuidGenerator;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component(value = "processKeyGenerationListener")
public class ProcessKeyGenerationListener implements ExecutionListener {

  @Override
  public void notify(DelegateExecution execution) throws Exception {
    log.info("Business Key will be generated here....");
    String processBusinessKey = new StrongUuidGenerator().getNextId();
    log.info("Genertaed time based processBusinessKey:{}", processBusinessKey);
    execution.setProcessBusinessKey(processBusinessKey);
    execution.setVariable("businessKey", processBusinessKey);
  }

}
