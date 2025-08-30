package com.codingShuttle.LinkedIn.Notification_Service.repository;

import com.codingShuttle.LinkedIn.Notification_Service.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification , Long> {
}
