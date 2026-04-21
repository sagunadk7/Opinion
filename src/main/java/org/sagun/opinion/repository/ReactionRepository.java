package org.sagun.opinion.repository;

import org.sagun.opinion.entity.Reactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepository extends JpaRepository<Reactions, Long> {
}
