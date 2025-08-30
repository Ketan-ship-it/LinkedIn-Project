package com.codingShuttle.LinkedIn.Notification_Service.service;

import com.codingShuttle.LinkedIn.Notification_Service.entity.Notification;
import com.codingShuttle.LinkedIn.Notification_Service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(Long userId , String message) {

        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setMessage(message);

        notificationRepository.save(notification);

    }
}
