package org.sagun.opinion.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.sagun.opinion.enums.ChatRequestStatusEnum;

import java.time.Instant;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ChatRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Users senderId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users receiverId;

    @Enumerated(EnumType.STRING)
    private ChatRequestStatusEnum status = ChatRequestStatusEnum.PENDING;

    @Column(updatable = false)
    @CreationTimestamp
    private Instant sentAt;

    @Column(updatable = false)
    @CreationTimestamp
    private Instant respondedAt;

}
