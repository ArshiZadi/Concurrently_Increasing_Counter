package com.concurrent.increamentcounter.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

public interface CounterService {
	
	public void setInitialCounterValue(Long counterValue);
	
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void increaseCounterValue(Long counterValue);

}
