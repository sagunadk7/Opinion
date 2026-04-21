package org.sagun.opinion.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.sagun.opinion.enums.MessageStatusEnum;

import java.time.Instant;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Chats chats;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users sender;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users receiver;

    @Column(nullable = false)
    private String message;

    @Enumerated(EnumType.STRING)
    private MessageStatusEnum status = MessageStatusEnum.SENT;

    @Column(nullable = false)
    @CreationTimestamp
    private Instant sentAt;
}
