package com.concurrent.increamentcounter.reporsitory;


import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.concurrent.increamentcounter.entity.Counter;

@Repository
public interface CounterRepository extends CrudRepository<Counter, Long>{
	
	@Modifying
	@Query("update Number n set n.counter =:counter where n.id =:id")
	void increaseCounter(int counter, Long id);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<Counter> findById(Long id);

}
