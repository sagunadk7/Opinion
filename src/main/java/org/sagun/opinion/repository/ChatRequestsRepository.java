package org.sagun.opinion.repository;

import org.sagun.opinion.entity.ChatRequests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRequestsRepository extends JpaRepository<ChatRequests, Long> {
}