package com.hackerrank.github.Repository;

import com.hackerrank.github.model.Repo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoRepository extends CrudRepository<Repo,Long> {
}
