package org.sagun.opinion.repository;

import org.sagun.opinion.entity.ThoughtsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThoughtsCategoryRepository extends JpaRepository<ThoughtsCategory, Long> {
}
