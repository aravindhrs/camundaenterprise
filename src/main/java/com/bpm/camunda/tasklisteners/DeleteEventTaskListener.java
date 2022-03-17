/**
 * 
 */
package com.bpm.camunda.tasklisteners;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DeleteEventTaskListener implements TaskListener {

	@Override
	public void notify(DelegateTask delegateTask) {
		log.info("DeleteEventTaskListener was invoked for user task {} for event type {}", delegateTask.getName(),
				delegateTask.getEventName());
		delegateTask.setVariable("taskListenerEventName", delegateTask.getEventName());
	}

}
