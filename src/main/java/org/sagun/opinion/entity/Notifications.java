package org.sagun.opinion.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.sagun.opinion.enums.NotificationTypeEnum;

import java.time.Instant;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Users user;
    @Enumerated(EnumType.STRING)
    @JoinColumn(nullable = false)
    private NotificationTypeEnum notificationTypeEnum;

    @Column(nullable = false)
    private Boolean isRead = false;
    @Column(nullable = false)
    @CreationTimestamp
    private Instant createdAt;
}
