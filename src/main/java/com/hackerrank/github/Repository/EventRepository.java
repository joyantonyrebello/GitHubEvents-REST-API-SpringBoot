package com.hackerrank.github.Repository;

import com.hackerrank.github.model.Event;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event,Long> {

    List<Event> findByActorIdOrderByIdAsc(Long actorID);

    List<Event> findByRepoIdOrderByIdAsc(Long repoID);

    List<Event> findByRepoIdAndActorIdOrderByIdAsc(Long repoID,Long actorId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Event")
    void deleteAll();
}
