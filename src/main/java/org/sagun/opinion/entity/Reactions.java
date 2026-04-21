package org.sagun.opinion.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    private ReactionsTypeEnum reactionsType;

    @Enumerated(EnumType.STRING)
    private ReactionStrengthTypeEnum reactionStrenthType= ReactionStrengthTypeEnum.SLIGHT;

    @Column(updatable = false)
    private LocalDate createdAt;


}
