package com.hackerrank.github.Repository;

import com.hackerrank.github.model.Event;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface EventRepository extends CrudRepository<Event,Long> {
    @Transactional
    @Modifying
    @Query("delete from event")
    void deleteAll();



}
