package com.bpm.camunda.delegates;

import java.util.Arrays;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JobProducerDelegate implements JavaDelegate {

  private static final String JOB_LIST = "jobList";

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    String category = (String) execution.getVariable("category");
    log.info("VariableMap:{}", category);
    if ("inventory".equals(category)) {
      execution.setVariable(JOB_LIST, Arrays.asList("2000", "4000"));
    } else if ("order".equals(category)) {
      execution.setVariable(JOB_LIST, Arrays.asList("1000", "3000"));
    } else {
      execution.setVariable(JOB_LIST, Arrays.asList("0000"));
    }
  }

}
