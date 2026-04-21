package org.sagun.opinion.repository;

import org.sagun.opinion.entity.Opinions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpinionsRepository extends JpaRepository<Opinions, Long> {
}