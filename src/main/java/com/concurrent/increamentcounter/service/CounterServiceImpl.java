package com.concurrent.increamentcounter.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.concurrent.increamentcounter.entity.Counter;
import com.concurrent.increamentcounter.reporsitory.CounterRepository;

public class CounterServiceImpl implements CounterService{
	Logger logger = LoggerFactory.getLogger(CounterServiceImpl.class);
	@Autowired
	CounterRepository counterRepository;
	
	@Override
	public void setInitialCounterValue(Long id)
	{
		try {
			if (counterRepository.existsById(id)) {
				logger.info("Counter already exits as id : " + id);
			}else {
				Counter counter = new Counter();
				counter.setId(id);
				counterRepository.save(counter);
			}
		} catch (Exception e) {
			logger.error("Initial counter setting exception", e);
			throw e;
		}
	}
	
	@Override
	public void increaseCounterValue(Long id)
	{
		try {
			Optional<Counter> counterToIncrease = counterRepository.findById(id);
			if (counterToIncrease.isPresent()) {
				Counter counter = counterToIncrease.get();
				counter.setCounterValue(counter.getCounterValue()+1);
				counterRepository.save(counter);
			}
		} catch (Exception e) {
			logger.error("Counter increament exception", e);
			throw e;
		}
	}

}
