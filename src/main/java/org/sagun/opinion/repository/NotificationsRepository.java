package org.sagun.opinion.repository;

import org.sagun.opinion.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
}