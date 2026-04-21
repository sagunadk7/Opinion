package org.sagun.opinion.repository;

import org.sagun.opinion.entity.Thought;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThoughtRepository extends JpaRepository<Thought, Long> {
}
