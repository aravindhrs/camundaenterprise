package com.bpm.camunda.executionlisteners;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserTaskEndEventListener implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		log.info("Executing UserTaskEndEventListener for user task {} for the event type {}", execution.getEventName());
		execution.setVariable("executionListenerEventName", execution.getEventName());
	}

}
