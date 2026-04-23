package org.sagun.opinion.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.sagun.opinion.enums.ReactionStrengthTypeEnum;
import org.sagun.opinion.enums.ReactionsTypeEnum;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Reactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Users user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReactionsTypeEnum reactionsType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReactionStrengthTypeEnum reactionStrengthType= ReactionStrengthTypeEnum.SLIGHT;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Thought thought;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDate createdAt;


}
