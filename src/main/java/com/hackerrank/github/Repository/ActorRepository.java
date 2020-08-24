package com.hackerrank.github.Repository;

import com.hackerrank.github.model.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository<Actor,Long> {
}
