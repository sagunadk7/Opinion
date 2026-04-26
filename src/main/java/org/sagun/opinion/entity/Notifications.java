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
    @Column(nullable = false)
    private NotificationTypeEnum notificationTypeEnum;

    @ManyToOne(fetch =FetchType.LAZY)
    private Users triggeredBy;

    @ManyToOne(fetch = FetchType.LAZY)
    private Thought relatedThought;

    @Column(nullable = false)
    private Boolean isRead = false;
    @Column(nullable = false)
    @CreationTimestamp
    private Instant createdAt;
}
