package org.sagun.opinion.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import java.time.Instant;
import java.util.ArrayList;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Chats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Users userFirst;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Users userSecond;

    @Column(nullable = false)
    @CreationTimestamp
    private Instant createdAt;

    @OneToMany(mappedBy = "chats",cascade = CascadeType.ALL,orphanRemoval = true)
    private ArrayList<Messages> messages;




}
