package org.sagun.opinion.repository;

import org.sagun.opinion.entity.Chats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatsRepository extends JpaRepository<Chats, Long> {
}